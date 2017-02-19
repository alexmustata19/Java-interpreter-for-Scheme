package tema1PP;

public class RETURNProgram extends Program{
	
	//return <expresie>
	
	public RETURNProgram() {
		this.tipProgram = "return";
	}
	
	@Override
	public Integer evaluare(Context c, boolean test) throws OutOfScopeException {
		//Se returneaza rezultatul evaluarii expresiei.
		return instructions.get(0).evaluare(c, test);
	}

	@Override
	public String getIdentitate() {
		//Un return nu are identitate.
		return null;
	}

}
