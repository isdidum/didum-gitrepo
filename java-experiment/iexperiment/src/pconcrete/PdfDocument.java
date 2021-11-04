
package pconcrete;

import pabstract.Document;

/**
 * @author Didum
 * @date January 18, 2013
 * @description WordDocument(): derived class
 */
public class PdfDocument extends Document {
	//private instance vars
	private String docType, docName;
		
	/**
	 * PdfDocument(): specific constructor
	 * @param name, type
	 */
	public PdfDocument(String name, String type) {
		super();	//explicit invocation of superclass default constructor
		if(type.length() != 0 && name.length() != 0) {
			this.docName = name;
			this.docType = type;
		} else {
			this.docName = "";
			this.docType = "";
		}
	}
	
	/**
	 * name(): accessor - returns document name
	 * @return
	 */
	public String name() {
		try {
			return getName(docName);	//uses method developed in abstract class Document
		}catch(Exception e) {
			e.printStackTrace();
		}
		return getName(docName);
	}
	
	/**
	 * type(): accessor - returns document type by its extension
	 * @return
	 */
	public String type() {
		try {
			return docType;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return docType;
	}

}
