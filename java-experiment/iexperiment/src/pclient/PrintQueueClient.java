
package pclient;

import pconcrete.PrintQueue;
import callable.io.Print;

import java.util.Scanner;

/**
 * @author A., Didum
 * @date January 18, 2013
 * @description PrintQueueClient(): client class which invokes concrete class PrintQueue()
 */
public class PrintQueueClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int SIZE = 3;
		String alist[] = new String[SIZE];
		int cntr=0;
		String ndoc, tdoc;
				
		PrintQueue refPrint = null;
		Scanner refscan = new Scanner(System.in);
		Print view = new Print();
				
		view.println("Enter document name: ");
		ndoc = refscan.nextLine();
		
		while(cntr != SIZE) {
			view.println("Enter document extension or type : ");
			tdoc = refscan.nextLine();
			alist[cntr] = ndoc + tdoc;
			refPrint = new PrintQueue(SIZE, ndoc, tdoc);
			++cntr;
			
			if(cntr == 3) break;
			view.println("Enter document name: ");
			ndoc = refscan.nextLine();
		}
		refPrint.setStack(alist);
		refPrint.displayContents();
		
	}
}
