/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class LLNode<T> {

    private T _cargo;    //cargo may only be of type T
    private LLNode<T> _nextNode; //pointer to next LLNode


    // constructor -- initializes instance vars
    public LLNode( T value, LLNode<T> next ) {
	_cargo = value;
	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public T getValue() { return _cargo; }

    public LLNode<T> getNext() { return _nextNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public T setValue( T newCargo ) {
	T foo = getValue();
	_cargo = newCargo;
	return foo;
    }

    public LLNode<T> setNext( LLNode<T> newNext ) {
	LLNode<T> foo = getNext();
	_nextNode = newNext;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args ) {

	//Below is an exercise in creating a linked list...

	//Create a node
	LLNode<String> first = new LLNode<String>( "cat", null );

	//Create a new node after the first
	first.setNext( new LLNode<String>( "dog", null ) );

	//Create a third node after the second
	first.getNext().setNext( new LLNode<String>( "cow", null ) );

	LLNode temp = first; 
	while( temp != null ) {
	    System.out.println( temp );
	    temp = temp.getNext();
	}

    }//end main

}//end class LLNode
