package tema1PP;

import java.util.LinkedList;
import java.util.List;

public class Main {

	/**
	 * IMPORTANT! Your solution will have to implement this method.
	 * @param exp - a string, which represents an expression (that
	 * follows the specification in the homework);
	 * @param c - the context (a one-to-one association between variables
	 * and values);
	 * @return - the result of the evaluation of the expression;
	 */
	public static Integer evalExpression(String exp, Context c){
		try{
			//Se parseaza si se evalueaza expresia si se intoarce rezultatul.
			return parseExpression(exp).evaluare(c, false);
		}catch(OutOfScopeException e){
			/*Daca se prinde aceasta exceptie inseamna ca metoda
			 *nu a primit un context bun (in care toate variabilele
			 *sa fie definte).
			 */
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * IMPORTANT! Your solution will have to implement this method.
	 * @param program - a string, which represents a program (that
	 * follows the specification in the homework);
	 * @return - the result of the evaluation of the expression;
	 */
	public static Integer evalProgram(String program){
		//Se creaza un context pentru executarea programului.
		Context c = new Context();
		try{
			//Se evalueaza programul si se intoarce rezultatul intors de acesta.
			return parseProgram(program).evaluare(c, false);
		}catch(OutOfScopeException e){
			/*Daca se prinde aceasta exceptie inseamna ca au existat variabile
			 *ce nu au fost in scope-ul corespunzator, deci progrumul este
			 *incorect.
			 */
			e.printStackTrace();
		}
		return null;
	}
	
	/*Metoda primeste un program sub forma unui String si
	 *realizeaza parsarea acestuia intr-un mod recursiv.
	 *Aceasta metoda intoarce un element(programul) care
	 *poate fi evaluat(executat).
	 */
	public static Element parseProgram(String program){
		//Elimin spatiile albe de la inceput si sfarsit.
		program = program.trim();
		
		//Elimin parantezele drepte de la inceput si sfarsit.
		program = program.substring(1, program.length()-1);
		
		//Obtin forma programului(tipul + parametrii).
		String[] subStringuri = splitList(program);
		
		if(subStringuri[0].equals(";")){
			
			//Caz program inlantuire/secventa
			Element a = parseProgram(subStringuri[1]);
			Element b = parseProgram(subStringuri[2]);
			Inlantuire rez = new Inlantuire();
			rez.addParameter(a);
			rez.addParameter(b);
			return rez;
			
		}else if(subStringuri[0].equals("=")){
			
			//Caz program atribuire
			Element a = parseExpression(subStringuri[1]);
			Element b = parseExpression(subStringuri[2]);
			Atribuire rez = new Atribuire();
			rez.addParameter(a);
			rez.addParameter(b);
			return rez;
			
		}else if(subStringuri[0].equals("if")){
			
			//Caz program if
			Element a = parseExpression(subStringuri[1]);
			Element b = parseProgram(subStringuri[2]);
			Element c = parseProgram(subStringuri[3]);
			IFProgram rez = new IFProgram();
			rez.addParameter(a);
			rez.addParameter(b);
			rez.addParameter(c);
			return rez;
			
		}else if(subStringuri[0].equals("while")){
			
			//Caz program while
			Element a = parseExpression(subStringuri[1]);
			Element b = parseProgram(subStringuri[2]);
			WHILEProgram rez = new WHILEProgram();
			rez.addParameter(a);
			rez.addParameter(b);
			return rez;
			
		}
		
		//Caz program return
		Element a = parseExpression(subStringuri[1]);
		RETURNProgram rez = new RETURNProgram();
		rez.addParameter(a);
		return rez;
	}
	
	/*Metoda care primeste o expresie sub forma de String si
	 *realizeaza parsarea acesteia intr-un mod recursiv.
	 *Aceasta metoda intoarce un element(expresia) care poate
	 *fi evaluat.
	 */
	private static Element parseExpression(String expresie){
		//Elimin spatiile albe de la inceput si sfarsit.
		expresie = expresie.trim();
		
		if(expresie.indexOf('[') == -1){
			/*Daca nu exista nicio paranteza dreapta deschisa in String
			 *inseamna ca am ajuns la nivelul unui simbol sau al unui numar.
			 */
			return TipPrimitivFactory.createTipPrimitiv(expresie);
		}
		
		/*Daca nu inseamna ca expresia trebuie descompusa recursiv
		 *in alte expresii, deoarece exista inca paranteze drepte
		 *deschise.
		 */
		
		//Elimin parantezele de la inceput si sfarsit.
		expresie = expresie.substring(1, expresie.length()-1);
		
		//Obtin operatorul si cei doi operanzi(cele doua noi expresii).
		String[] subExpresii = splitList(expresie);
		String operator = subExpresii[0];
		
		//Parsez recursiv cele doua expresii.
		Element rez1 = parseExpression(subExpresii[1]);
		Element rez2 = parseExpression(subExpresii[2]);
		
		/*Leg operatorul si cele doua expresii int-o noua expresie
		 *ce se va returna.
		 */
		Expresie expr = ExpresieFactory.createExpresie(operator);
		expr.addOperandStanga(rez1);
		expr.addOperandDreapta(rez2);
		
		return expr;
		
	}

	/**
	 * IMPORTANT! Your solution will have to implement this method.
	 * @param program - a string, which represents a program (that
	 * follows the specification in the homework);
	 * @return - whether the given program follow the syntax rules
	 * specified in the homework (always return a value and always
	 * use variables that are "in scope");
	 */

	public static Boolean checkCorrectness(String program){
		/*Daca in String-ul ce codifica programul nu se gaseste
		 *cuvantul "return" inseamna ca programul este incorect.
		 */
		if(program.indexOf("return") == -1) return false;
		
		//Daca programul contine return se creaza un context pentru executie.
		Context c = new Context();
		
		//Se parseaza programul ce trebuie verificat.
		Element deTestat = parseProgram(program);
		
		try{
			//Daca programul se executa normal atunci el este corect.
			deTestat.evaluare(c, true);
			return true;
		}catch(OutOfScopeException e){
			/*Daca se prinde acest tip de exceptie inseamna ca o variabila
			 *nu a fost in scope-ul corespunzator deci programul este incorect.
			 */
			return false;
		}
	}


	/**
	 *
	 * @param s - a string, that contains a list of programs, each
	 * program starting with a '[' and ending with a matching ']'.
	 * Programs are separated by the whitespace caracter;
	 * @return - array of strings, each element in the array representing
	 * a program;
	 * Example: "[* [+ 1 2] 3] [* 4 5]" -> "[* [+ 1 2] 3]" & "[* 4 5]";
	 */
	 public static String[] splitList(String s){
		String[] result = new String[0];
		List<String> l = new LinkedList<String>();
        int inside = 0;
        int start = 0, stop = 0;
        for (int i=0; i<s.length(); i++){
                if (s.charAt(i) == '['){
                    inside++;
                    stop++;
                    continue;
                }
                if (s.charAt(i) == ']'){
                    inside--;
                    stop++;
                    continue;
                }
                if (s.charAt(i) == ' ' && inside == 0){
                    l.add(s.substring(start,stop));
                    start = i+1; //starting after whitespace
                    stop = start;

                    continue;
                }
                stop++; //no special case encountered
        }
        if (stop > start) {
            l.add(s.substring(start, stop));
        }

        return l.toArray(new String[l.size()]);

	 }

	public static void main(String[] args) {
		/* Suggestion: use it for testing */
	}
}
