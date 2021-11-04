package xceptions.custom;

public class StackXception extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StackXception(String str) {
		super(str);
	}
	
	public StackXception(){
		super();
	}
}
