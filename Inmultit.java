package tema1PP;

public class Inmultit extends Expresie {

	// * <operandStanga> <operandDreapta>
	
	public Inmultit(){
		this.operator = "*";
	}
	
	@Override
	public Integer evaluare(Context c, boolean test) throws OutOfScopeException {
		//Se evalueaza cei doi operanzi si se intoarce produsul lor.
		Integer rez = operandStanga.evaluare(c, test);
		rez *= operandDreapta.evaluare(c, test);
		return rez;
	}

	@Override
	public String getIdentitate() {
		//O operatie de inmultire nu are identitate.
		return null;
	}

}
