/*
Clara Mohri
APCS2 Pd08
HW25 -- Generically Speaking...
2018-03-27
*/

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 * new in v2: add-at-index, remove
 *****************************************************/

public class LList<T> implements List<T> //your List interface must be in same dir
{ 
    
    //instance vars
    private DLLNode _head, _tail;
    private int _size;
    
    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_tail = null;
	_size = 0;
    }
    
    
    //--------------v  List interface methods  v--------------
    
    public boolean add(T newVal )
    {
	DLLNode tmp = new DLLNode( newVal, _head, null );
	_head = tmp;
	_size++;
	return true;
    }
    

    public T get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	
	T retVal;
	DLLNode tmp;
	tmp = _head; //create alias to head
	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();
	//check target node's cargo hold
	retVal = (T)tmp.getCargo();
	return retVal;
    }
    
    
    public T set( int index, T newVal )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	
	DLLNode tmp = _head; //create alias to head
	
	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();
	
	//store target node's cargo
	T oldVal = (T)tmp.getCargo();
	
	//modify target node's cargo
	tmp.setCargo( newVal );
	
	return oldVal;
    }
    
    
    //return number of nodes in list
    public int size() { return _size; }
    
    
    //insert a node containing newVal at position index
    public void add( int index, T newVal ) {
	
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	
	DLLNode newNode = new DLLNode( newVal, null, null );
	
	//if index==0, insert node before head node
	if ( index == 0 ) 
	    add( newVal );

	else {

	    DLLNode tmp = _head; //create alias to head
	    
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();
		
	    //insert new node
	    newNode.setNext( tmp.getNext() );
	    newNode.setPrev( tmp.getPrev() );
	    tmp.setNext( newNode );
	    
	    //increment size attribute
	    _size++;
	}
	
    }

    
    
    //remove node at pos index, return its cargo
    public T remove( int index ) {
	
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();
	
	T retVal;
	DLLNode tmp = _head; //create alias to head
	
	//if index==0, remove head node
	if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = (T)_head.getCargo();
	    
	    //remove target node
	    _head = _head.getNext();	    
	}
	else {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();
	    
	    //check target node's cargo hold
	    retVal = (T)tmp.getNext().getCargo();
	    
	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );
	}
	
	//decrement size attribute
	_size--;
	
	return retVal;
    }
    
    //--------------^  List interface methods  ^--------------
    
    
    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	DLLNode tmp = _head; 
	retStr += "NULL->";
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL->";
	retStr += "TAIL";
	return retStr;
    }
    
    
    //main method for testing
    public static void main( String[] args )
    {
	
	LList james = new LList();
	
	System.out.println( james );
	System.out.println( "size: " + james.size() );
	
	james.add("I");
	james.add("the");
	james.add("on");
	james.add("sneezed");
	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size());
	
	System.out.println("fifth item: " + james.get(4));
	james.add(3, "and");
	System.out.println("james.add(3, 'and') : ");
	System.out.println(james);
	
	james.remove(3);
	System.out.println("james.remove(3) : ");
	System.out.println(james);
	
    }
    
}//end class LList


