package tema1PP;

public class Symbol extends TipPrimitiv{
	
	//Numele variabilei.
	private String simbol = null;
	
	public Symbol(String simbol){
		this.simbol = simbol;
	}

	@Override
	public Integer evaluare(Context c, boolean test) throws OutOfScopeException {
		/*Se intoarce valoarea unei variabile intr-un context primit
		 *ca parametru. (O variabila nu poate avea o valoare in afara
		 *unui context.)
		 */
		return c.valueOf(simbol);
	}

	@Override
	public String getIdentitate() {
		/*Identitatea unei variabile este numele sau.
		 *Acesta este necesar in cazul efectuarii unei atribuiri.
		 */
		return simbol;
	}

}
