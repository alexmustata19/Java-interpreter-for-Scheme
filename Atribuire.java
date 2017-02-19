package tema1PP;

public class Atribuire extends Program {

	// = <cui i se atribuie> <ce i se atribuie>
	
	public Atribuire(){
		this.tipProgram = "=";
	}
	
	@Override
	public Integer evaluare(Context c, boolean test) throws OutOfScopeException {
		//Se evalueaza expresia care trebuie atribuita variabilei.
		Element deCalculat = instructions.get(1);
		Integer rez = deCalculat.evaluare(c, test);
		
		//Se obtine identitatea variabilei si se actualizeaza valoarea pe care o desemneaza.
		Element deSchimbat = instructions.get(0);
		c.add(deSchimbat.getIdentitate(), rez);
		
		//Atribuirea intoarce valoarea care s-a atribuit.
		return rez;
	}

	@Override
	public String getIdentitate() {
		//O atribuire nu are identitate.
		return null;
	}

}
