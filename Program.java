package tema1PP;

import java.util.ArrayList;
import java.util.List;

public abstract class Program implements Element {
	
	//Un program are un tip.
	protected String tipProgram = null;
	
	//Un program are o lista de instructiuni sau de parametrii (elemente).
	protected List<Element> instructions = null;
	
	public Program(){
		instructions = new ArrayList<Element>();
	}
	
	public void addParameter(Element e){
		instructions.add(e);
	}
}
