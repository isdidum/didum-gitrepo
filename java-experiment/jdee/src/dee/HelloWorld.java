/**
 * 
 */
package dee;

/**
 * @author A., Didum
 * @Description HelloWorld
 */
public class HelloWorld {
	//instance var
	private String msg;
	
	/**
	 * @description HelloWorld(): Default constructor
	 */
	public HelloWorld(){
		msg = "Hello, world!";
	}
	
	private String greetings(){
		try{
			return msg;
		}catch(Exception e){ e.printStackTrace();}
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloWorld hi = new HelloWorld();
		System.out.print(hi.greetings());
	}

}
