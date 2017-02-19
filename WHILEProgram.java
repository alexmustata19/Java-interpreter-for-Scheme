package tema1PP;

public class WHILEProgram extends Program{

	// while <conditie> <program>
	
	public WHILEProgram() {
		this.tipProgram = "while";
	}
	
	@Override
	public Integer evaluare(Context c, boolean test) throws OutOfScopeException {
		/*Caz verificare corectitudine (test==true) prin aruncare de exceptie.
		 *Se executa corpul buclei o data pentru a se vedea daca se gasesc
		 *variabile ce nu sunt in scope-ul corespunzator.
		 */
		if(test){
			//Conditia si corpul buclei.
			Context context =new Context(c);
			instructions.get(0).evaluare(context, test);
			instructions.get(1).evaluare(context, test);
			return new Integer(1);
		}
		
		/*Altef inseamna ca test==false deci este o executie normala.
		 *Se creaza un nou context local pornind de la cel primit ca parametru.
		 */
		Context con = new Context(c);
		
		//Se evalueaza conditia de intrare in while.
		int conditie = instructions.get(0).evaluare(con, test);
		
		int contor = 0;
		
		while(conditie != 0){
			//Se executa corpul programului while.
			instructions.get(1).evaluare(con, test);
			
			//Se reactualizeaza conditia pentru programul while.
			conditie = instructions.get(0).evaluare(con, test);
			
			contor++;
		}
		
		//Se actualizeaza modificarile facute la variabilele din afara contextului local.
		c.update(con);
		
		//Se intoarce numarul de executari al buclei while.
		return new Integer(contor);
	}

	@Override
	public String getIdentitate() {
		//Un while nu are identitate.
		return null;
	}

}
