
package pconcrete;

import pabstract.Document;

/**
 * @author Didum
 * @date January 18, 2013
 * @description WordDocument(): derived class
 */
public class WordDocument extends Document{
	//private instance vars
	private String docType, docName;

	/**
	 * WordDocument(): specific constructor
	 * @param name, type
	 */
	public WordDocument(String name, String type) {
		super();	//explicit invocation of superclass default constructor
		this.docName = name;
		this.docType = type;
	}
	
	/**
	 * getName(): accessor - returns document name
	 * @return dname
	 */
	public String getName() {
		String dname = null;
		try {
			if(docName.length() != 0) {
				dname = docName;
				return getName(dname);	//uses method developed in abstract class Document
			}else {
				dname = "";
				return dname;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dname;
	}
	
	/**
	 * type(): accessor - returns document type via its extension
	 * @return dtype
	 */
	public String type() {
		String dtype = null;
		try {
			if(docType.length() != 0) {
				dtype = docType;
				return dtype;
			}else {
				dtype = "";
				return dtype;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtype;
	}
}
