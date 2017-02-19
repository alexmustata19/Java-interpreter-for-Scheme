package tema1PP;

public class TipPrimitivFactory {
	
	/*Se creaza un tip primitiv(numar sau variabila/simbol)
	 *in functie de String-ul primit ca parametru.
	 */
	public static TipPrimitiv createTipPrimitiv(String s){
		try{
			Integer rez = Integer.parseInt(s);
			return new Value(rez);
		}catch(NumberFormatException e){
			return new Symbol(s);
		}
	}
	
}
