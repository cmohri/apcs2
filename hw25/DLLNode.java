/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode<T> 
{
    private T  _cargo;    //cargo may only be of type String
    private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes
    
    //constructor -- initializes instance vars
    public DLLNode(T value, DLLNode next, DLLNode prev){
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }

    //--------- ACCESSORS ----------
    public T getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrev() { return _prevNode; }

    //--------- MUTATORS -----------
    public T setCargo (T newCargo) { 
	T foo = getCargo(); 
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
        DLLNode foo = getNext();
        _nextNode = newNext;
	
        return foo;
    }

    public DLLNode setPrev( DLLNode newPrev ) {
        DLLNode foo = getNext();
        _prevNode = newPrev;
	
        return foo;
    }

    //ovverride inherited toString
    public String toString() { return _cargo.toString(); }

    public static void main (String[] args){
	//create a DLLNode
	DLLNode first = new DLLNode("cat", null, null);
	//create a new node after the first
	first.setNext(new DLLNode("dog", null, null));
	//create a new node before the first
	first.setPrev(new DLLNode("bird", null, null));
	System.out.println(first.getPrev());
	System.out.println(first.getCargo());
	System.out.println(first.getNext());
	System.out.println(first.getPrev().getCargo());
	first.setCargo("fly");
	System.out.println(first.getCargo());
    }

}//end class DLLNo
