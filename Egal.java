package tema1PP;

public class Egal extends Expresie{
	
	// == <operandStanga> <operandDreapta>
	
	public Egal(){
		this.operator = "=="; 
	}
	
	@Override
	public Integer evaluare(Context c, boolean test) throws OutOfScopeException {
		//Se evalueaza cei doi operanzi ai expresiei.
		int a = operandStanga.evaluare(c, test);
		int b = operandDreapta.evaluare(c, test);
		
		/*Se intoarce rezultatul compararii prin egalitate.
		 *Se considera 1->True si 0->False.
		 */
		return (a==b ? new Integer(1) : new Integer(0));
	}

	@Override
	public String getIdentitate() {
		//Un comparatorul de egalitate nu are identitate.
		return null;
	}

}
