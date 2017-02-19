package tema1PP;

import java.util.HashMap;
import java.util.Set;

public class Context {
	
	//"Tabelul" (mapul) unde se pastreaza asocierile dintre variabile si valorile lor.
	private HashMap<String, Integer> tabel = null;
	
	//Constructor pentru crearea unui context nou.
	public Context(){
		tabel = new HashMap<String, Integer>();
	}
	
	/*Constructor pentru crearea unui context pornind de la unul existent deja.
	 *Practic realizeaza o copie a contextului trimis ca parametru.
	 */
	public Context(Context c) {
		tabel = new HashMap<String, Integer>();
		Set<String> variabile = c.getVaraibile();
		for(String variabila : variabile){
			try{
				Integer valoare = c.valueOf(variabila);
				tabel.put(variabila, valoare);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//Metoda pentru adaugarea unei variablile cu valoarea ei asociata in context.
    public void add (String v, Integer i){
    	tabel.put(v, i);
    }
    
    /*Treat undefined variable problem using exceptions
     *Metoda pentru extragerea valorii asociate unei variabile din context.
     *Daca variabila nu este in context se arunca OutOfScopeException.
     */
    public Integer valueOf(String v) throws OutOfScopeException {
    	Integer rez = tabel.get(v);
    	if(rez == null){
    		throw new OutOfScopeException();
    	} 	
        return rez;
    }
    
    //Metoda prin care se obtin numele variabilelor dintr-un context.
    public Set<String> getVaraibile(){
    	return tabel.keySet();
    }
    
    /*Metoda prin care contextul curent (this) isi actualizeaza valorile 
     *variabilelor la valorile din alt context.
     *Trebuie folosit intotdeuna sub forma: context.update(subContext);
     */
    public void update(Context c){
    	Set<String> variabile = tabel.keySet();
    	for(String variabila : variabile){
    		Integer i = null;
    		try{
    			i = c.valueOf(variabila);
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		tabel.put(variabila, i);
    	}
    }
}