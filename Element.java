package tema1PP;

public interface Element {
	//Metoda pentru a evalua un element.
	public Integer evaluare(Context c, boolean verificareCorectitudine) throws OutOfScopeException;
	
	//Metoda pentru a obtine identitatea unui element.
	public String getIdentitate();
}
