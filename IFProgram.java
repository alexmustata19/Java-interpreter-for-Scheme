package tema1PP;

public class IFProgram extends Program {

	// if <conditie> <program1> <program2>
	
	public IFProgram() {
		this.tipProgram = "if";
	}
	
	@Override
	public Integer evaluare(Context c, boolean test) throws OutOfScopeException {
		/*Caz verificare corectitudine (test==true) prin aruncare de exceptie.
		 *Se executa ambele ramuri pentru a se vedea daca se gasesc
		 *variabile ce nu sunt in scope-ul corespunzator.
		 */
		if(test){
			//Ramura "true" impreuna cu conditia.
			Context c1 = new Context(c);
			instructions.get(0).evaluare(c1, test);
			instructions.get(1).evaluare(c1, test);
			
			//Ramura "false" impreuna cu conditia.
			Context c2 = new Context(c);
			instructions.get(0).evaluare(c2, test);
			instructions.get(2).evaluare(c2, test);
			
			return new Integer(1);
		}
		
		/*Altef inseamna ca test==false deci este o executie normala.
		 *Se creaza un nou context local pornind de la cel primit ca parametru.
		 */
		Context con = new Context(c);
		
		Integer rez = null;
		
		//Se evalueaza conditia pentru a determina ce ramura din if se va executa.
		int conditie = instructions.get(0).evaluare(con, test);
		
		if(conditie != 0){
			//Daca conditia este adevarata (!=0) atunci se executa prima ramura.
			rez = instructions.get(1).evaluare(con, test);
		}else{
			//Altfel se executa a doua ramura.
			rez = instructions.get(2).evaluare(con, test);
		}
		
		//Se actualizeaza modificarile facute la variabilele din afara contextului local.
		c.update(con);
		
		//Se intoarce rezultatul obtinut in urma executarii ramurii corespunzatoare.
		return rez;
	}

	@Override
	public String getIdentitate() {
		//Un if nu are identitate.
		return null;
	}

}
