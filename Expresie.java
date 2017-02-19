package tema1PP;

public abstract class Expresie implements Element{
	
	//O expresie contine doi operanzi (doua elemente).
	protected Element operandStanga = null;
	protected Element operandDreapta = null;
	
	//O expresie contine un operator.
	protected String operator = null;
	
	public Expresie(){
	}
	
	public void addOperandStanga(Element operandStanga){
		this.operandStanga = operandStanga;
	}
	
	public void addOperandDreapta(Element operandDreapta){
		this.operandDreapta = operandDreapta;
	}
}
