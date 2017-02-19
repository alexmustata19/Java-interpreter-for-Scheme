package tema1PP;

public class MaiMic extends Expresie {

	// < <operandStanga> <operandDreapta>
	
	public MaiMic(){
		this.operator = "<";
	}
	
	@Override
	public Integer evaluare(Context c, boolean test) throws OutOfScopeException {
		//Se evalueaza cei doi operanzi.
		int a = operandStanga.evaluare(c, test);
		int b = operandDreapta.evaluare(c, test);
		
		/*Se compara cei doi operanzi si se intoarce rezultatul corespunzator.
		 *Se considera 1->True si 0->False.
		 */
		return (a < b ? new Integer(1) : new Integer(0));
	}

	@Override
	public String getIdentitate() {
		//Un comparator de ordonare nu are identitate.
		return null;
	}

}
