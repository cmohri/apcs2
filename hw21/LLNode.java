/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String cargo;
    private LLNode cdr;

    // constructors 
    public LLNode(){
	cargo = "";
    }

    public LLNode(String car){
	cargo = car;
    }

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
	return cargo;
    }

    public LLNode getNext()
    {
	return cdr;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo(String car)
    {
	String old = cargo;
	cargo = car;
	return old;
    }

    public LLNode setNext(LLNode newcdr)
    {
	LLNode old = cdr;
	cdr = newcdr;
	return old;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
	return cargo;
    }


    //main method for testing
    public static void main( String[] args )
    {
	LLNode n = new LLNode();
	LLNode a = new LLNode();
	LLNode b = new LLNode();
	n.setNext(a);
	a.setNext(b);
	System.out.println(n.setCargo("hello"));
	System.out.println(n.getCargo());
	System.out.println(a.setCargo("my"));
	System.out.println(b.setCargo("friend!"));
	
    }//end main

}//end class LLNode
