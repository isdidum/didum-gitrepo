package callable.io;
import java.util.*; //imports all util methods


public class KeyboardReader extends Print {

	private Scanner scanner;
	/**
	 * KeyboardReader(): default constructor
	 */
	public KeyboardReader() {
		scanner = new Scanner(System.in);
	}
	
	/**
	 * readLine(): accessor - reads keyboard input of type string
	 * @param sTitle - string to be presented to user
	 * @return next-line
	 */
	public String readLine(String sTitle){
		println(sTitle);
		return scanner.nextLine();
	}
	
	/**
	 * readInt(): accessor - reads keyboard input of type integer
	 * @param sTitle - string to be presented to user
	 * @return next-int
	 */
	public int readInt(String sTitle){
		println(sTitle);
		return scanner.nextInt();
	}
	
	/**
	 * readDouble(): accessor - reads keyboard input of type double
	 * @param sTitle - string to be presented to user
	 * @return next-double
	 */
	public double readDouble(String sTitle){
		println(sTitle);
		return scanner.nextDouble();
	}
	
	/**
	 * readFloat(): accessor - reads keyboard input of type float
	 * @param sTitle - string to be presented to user
	 * @return next-float
	 */
	public float readFloat(String sTitle){
		println(sTitle);
		return scanner.nextFloat();
	}
	
	/**
	 * readBoolean(): accessor - reads keyboard input of type boolean
	 * @param sTitle - string to be presented to user
	 * @return has-next
	 */
	public boolean readBoolean(String sTitle){
		println(sTitle);
		return scanner.hasNext();
	}
	
	/**
	 * readByte(): accessor - reads keyboard input of type Byte
	 * @param sTitle - string to be presented to user
	 * @return next-byte
	 */
	public byte readByte(String sTitle){
		println(sTitle);
		return scanner.nextByte();
	}
	
	/**
	 * readLong(): accessor - read keyboard inputs of type long
	 * @param sTitle - string to be presented to user
	 * @return next-long
	 */
	public long readLong(String sTitle){
		println(sTitle);
		return scanner.nextLong();
	}
	
	/**
	 * readShort(): accessor - reads keyboard input of type short
	 * @param sTitle - string to be presented to user
	 * @return next-short
	 */
	public short readShort(String sTitle){
		println(sTitle);
		return scanner.nextShort();
	}

}
