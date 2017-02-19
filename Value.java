package tema1PP;

public class Value extends TipPrimitiv{
	
	//Valoarea numarului.
	private Integer valoare = null;
	
	public Value(Integer valoare){
		this.valoare = valoare;
	}

	@Override
	public Integer evaluare(Context c, boolean test) {
		/*Se returneaza valoarea numarului
		 *(este o constanta care nu depinde de context).
		 */
		return new Integer(valoare);
	}

	@Override
	public String getIdentitate() {
		//Un numar nu are o identitate.
		return null;
	}

}
