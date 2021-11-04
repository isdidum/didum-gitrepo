package generics.sup;

import callable.io.Print;

/**
 * @author A., Didum
 * @date March 23, 2013
 * @description GenSuperObj(): abstract class generic type or generic super class
 */
public class GenSuperObj <ObjType> {
	ObjType obj;
	
	/**
	 * @description GenSuperObj(): specific constructor
	 * @param obj
	 */
	public GenSuperObj(ObjType obj) {
		this.obj = obj;
	}
	
	/**
	 * @description getSupObject(): accessor - returns object of superclass
	 * @return object
	 */
	public ObjType getSupObject() {
		try {
			return obj;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
}

//Anonymous inner subclass, whatever type param is passed to GenSuper is auto passed to GenSuperObj
class GenSubClass<SupType, SubType> extends GenSuperObj<SupType> {
	SubType sobj;
	
	/**
	 * @description GenSubClass(): specific constructor
	 */
	public GenSubClass(SupType obj, SubType styp) {
		super(obj);
		sobj = styp;
	}
	
	/**
	 * @description getSubObject(): accessor - returns object of subclass
	 * @return object
	 */
	public SubType getSubObject() {
		try {
			return sobj;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	/*static <Tobject> void noName(){
		int r, g, b;
		r = (int)Math.floor(Math.random()*255);
		g = (int)Math.floor(Math.random()*255);
		b = (int)Math.floor(Math.random()*255);
		return new Color(r,g,b);
	}*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		GenSubClass<String, Integer> gs = new GenSubClass<String, Integer>("Value is: ", 13);
		view.print(gs.getSupObject());
		view.println(""+gs.getSubObject());
	}

}
