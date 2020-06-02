/*
Clara Mohri
APCS2 Pd08
HW32 -- Leon Leonwood Stack  
2018-04-12 
*/

/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/
import java.util.ArrayList;
import java.util.LinkedList;

public class Stckr 
{
    public static void main( String[] args )
    {
	Stack<String> cakes = new ALStack<String>();
	Stack<String> cookies = new LLStack<String>();
	Stack<Integer> crackers = new ALStack<Integer>();
	Stack<Integer> crepes = new ALStack<Integer>();

	System.out.println("ALStack: ");	
	cakes.push("hello");
	cakes.push("world");
	cakes.push("how");
	cakes.push("are");
	cakes.push("you");
	while (! cakes.isEmpty())
	    System.out.println(cakes.pop());

	System.out.println("LLStack: ");
	cookies.push("hello");
	cookies.push("world");
	cookies.push("how");
	cookies.push("are");
	cookies.push("you");
	while (! cookies.isEmpty())
	    System.out.println(cookies.pop());

	System.out.println("ALStack of Integers: ");
	crackers.push(3);
	crackers.push(2);
	while (! crackers.isEmpty())
	    System.out.println(crackers.pop());

	System.out.println("LLStack of Integers: ");
	crepes.push(3);
	crepes.push(2);
	while (! crepes.isEmpty())
	    System.out.println(crepes.pop());


    }//end main
    
}//end class

