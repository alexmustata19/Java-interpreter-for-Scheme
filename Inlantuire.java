package tema1PP;

public class Inlantuire extends Program {
	
	// ; <instructiune1> <instructiune2>
	
	public Inlantuire(){
		this.tipProgram = ";";
	}
	
	@Override
	public Integer evaluare(Context c, boolean test) throws OutOfScopeException {
		//Se executa prima instructiune din secventa.
		instructions.get(0).evaluare(c, test);
		
		//Se executa a doua instructiune din secventa si se intoarce rezultatul acesteia.
		return instructions.get(1).evaluare(c, test);
	}

	@Override
	public String getIdentitate() {
		//O inlantuire/secventa nu are identitate.
		return null;
	}

}
