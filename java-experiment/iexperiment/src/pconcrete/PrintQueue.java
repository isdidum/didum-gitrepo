package pconcrete;

import pconcrete.PdfDocument;
import pconcrete.WordDocument;
import callable.io.Print;

/**
 * @author A., Didum
 * @date January 18, 2013
 * @decription PrintQueue(): concrete class that adds/remove document to/from array list via push/pop, respectively.
 * @param size, name, type
 */
public class PrintQueue {
	//private instance variables
	private String stack[] = null;
	private int index, size;
	private String name, type;
	public PdfDocument refPdf;
	public WordDocument refWord;
	private boolean pdfVisible, wordVisible;
	private Print view;
	
	/**
	 * @Descripton PrintQueue(): specific constructor
	 * @param size, name, type
	 */
	public PrintQueue(int size, String name, String type) {
		pdfVisible = false;
		wordVisible = false;
		index = 0; //index=0 p.124
		this.size = size;
		this.name = name;
		this.type = type;
		stack = new String[this.size];
		refPdf = new PdfDocument(name, type);
		refWord = new WordDocument(name, type);
		view = new Print();
	}
	
	/**
	 * setStack(): mutator - sets up stack array
	 */
	public void setStack(String stck[]) {
		try {
			stack = stck;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * getWord(): accessor - returns both document name and type
	 * @return name, type
	 */
	public String getWord() {
		String wordItem = "";
		try {
			wordItem = refWord.getName() + refWord.type();
			return wordItem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wordItem;
	}
	
	/**
	 * getPdf(): accessor - returns both document name and type
	 * @return name, type
	 */
	public String getPdf() {
		String pdfItem = "";
		try {
			pdfItem = refPdf.getName(name) + refPdf.type();
			return pdfItem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pdfItem;
	}
		
	/**
	 * push(): mutator - adds item onto stack 
	 */
	public void push() {
		try {
			if(index == stack.length-1) { //prevents stack overflow
				view.println("The list is full");
			} else {
				if((index < stack.length) && wordVisible) {
					stack[++index] = wordValidation();
					//++index;
					view.println("valid worddocument type: "+ stack[++index]);
				} else if((index < stack.length) && pdfVisible) {
					stack[++index] = pdfValidation();
					//++index;	//if index=-1 in constructor, use ++index or stck[++index]
					view.println("valid pdfdocument type: "+ stack[++index]);
				} else if((index < stack.length) && !(wordVisible || pdfVisible)) {
					view.println("Invalid document type: "+ refWord.type());
					view.println("wrdVisible: "+ wordVisible+" pdfVisible: "+pdfVisible);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * pop(): accessor - removes item from stack
	 * @Notes Removing a data element from the end of an array requires no changes to the array itself, simply decrement the logical size
	 */
	public String pop() {
		try {
			if(index < 0) {//prevents stack underflow
				view.println("The list is empty");
				return "";
			} else {
				// pops item from stack's top-level
				return stack[index--];	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; //stack[index--];
	}
	
	/**
	 * @Descripton wordValidation(): accessor - ensures document type is valid *.doc/*.docx  
	 * @return visible
	 */
	public String wordValidation() {
		try {
			if(type.equals(".doc") || type.equals(".docx")) {
				wordVisible = true;
				return getWord();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Descripton pdfValidation(): accessor - ensures document type is valid *.pdf
	 * @return visible
	 */
	public String pdfValidation() {
		try {
			if(type.equals(".pdf")) {
				pdfVisible = true;
				return getPdf();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * displayContents(): mutator - displays contents of all documents in list array
	 */
	public void displayContents() {
		try {
			for(String x: stack) {
				view.println("stack: "+x);
			}
			//if these two sop lines are commented, the program fails to work as intended.
			view.println("w_validation: "+wordValidation());
			view.println("p_validation: "+pdfValidation());
			push();
			view.println("pop: "+pop());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
