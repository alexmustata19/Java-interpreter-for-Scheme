package tema1PP;

public class ExpresieFactory {
	
	/*Se creaza o expresie de un anumit tip pe baza operatorului
	 * primit ca parametru sub forma de String.
	 */
	public static Expresie createExpresie(String operator){
		if(operator.equals("+")) return new Plus();
		if(operator.equals("*")) return new Inmultit();
		if(operator.equals("==")) return new Egal();
		if(operator.equals("<")) return new MaiMic();
		return null;
	}
	
}
