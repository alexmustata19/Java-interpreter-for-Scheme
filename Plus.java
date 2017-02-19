package tema1PP;

public class Plus extends Expresie {

	// + <operandStanga> <operandDreapta>
	
	public Plus(){
		this.operator = "+";
	}
	
	@Override
	public Integer evaluare(Context c, boolean test) throws OutOfScopeException {
		//Se efectueaza evaluarea celor doi operanzi si se intoarce suma lor.
		Integer rez = operandStanga.evaluare(c, test);
		rez += operandDreapta.evaluare(c, test);
		return rez;
	}

	@Override
	public String getIdentitate() {
		//O operatie de adunare nu are identitate.
		return null;
	}

}
