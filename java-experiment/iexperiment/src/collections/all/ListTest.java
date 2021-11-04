package collections.all;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import callable.io.Output;

public class ListTest {
	private List<Object> list;
	//default constructor
	public ListTest(){
		list = new ArrayList<Object>();
	}
	
	//list initial size
	int initSize(){
		return list.size();
	}
	
	boolean isEmpty(){
		return list.isEmpty();
	}
	
	/**
	 * initList(): accessor - returns list
	 * @note a list can shrink/grow. Element count is via Java's Array index convention: zero-based index  
	 * @return list
	 */
	private List<Object> initList(){
		for(int i=1; i<=2; i++){
			list.add("" + i);	//adds 1,2,3,4 to list
		}	//list now has [1,2,3,4]
		list.remove(2);			//removes element at index 2, removes 3
		list.add(1, "5");		//inserts 5 at index 1
		list.remove("4");		//removes element 4 at index 3
		list.set(0, "8");		//replaces element at index 0
		list.add(new Double(4.5));	//append to list
		list.add(null);			//list accepts a null-value
		list.add("2.5");
		return list;
	}
	
	//facilitator
	public void display(){
		Output.println("Initial size: "+initSize());
		Output.println("isEmpty: "+isEmpty());
		Output.println("List: "+initList());
		Output.println("Final size: "+list.size());
		Output.println("isEmpty: "+isEmpty());
		Output.println("get: "+ list.get(initSize()-1));
		
		Iterator<?> itr = list.iterator(); //? or Object
		int i = -1;
		while(true){//replace true with itr.hasNext() and remove if(...)...
			i++;
			Output.println(i + "\t Element: " + itr.next());
			if(!itr.hasNext()) break;
		}
	}
	
	//main(): application starting point
	public static void main(String args[]){
		ListTest list = new ListTest();
		list.display();
	}
}
