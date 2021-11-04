
package pabstract;

/**
 * @author A., Didum
 * @Date January 18, 2013
 * @Note programmer test for Perception Software
 * @Description Document(): abstract class
 */
abstract public class Document {
	/**
	 * @Description Document(): default superclass constructor
	 * @Notes even though Document() is never instantiated, it needs a constructor to initialize it variables
	 */
	public Document(){
		//constructor
	}
	/**
	 * @Description name(): accessor - concrete method in abstract class Document()
	 * @Notes This method can be implement in abstract class, Document, or in a derived class.
	 *  Without the public clause specification, this method is by default a private member to abstract class, Document().
	 *  Hence, you cannot override a private member method in a subclass 
	 * @param name
	 */
	public String getName(String name) {
		try {
			return name; 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	//or
	//public String getName(String name) {}	//this is a concrete method without any implementation
	
	/**
	 * @Description type(): accessor - abstract method in abstract class Document()
	 * @Notes This method can be implement in abstract class, Document, or in a derived class.
	 *  Without the public clause specification, this method is by default a private member to abstract class, Document().
	 *  Hence, you cannot override a private member method in a subclass
	 */
	abstract public String type();
}
