/*
Clara Mohri
APCS2 Pd08
HW23 -- Give and Take
2018-03-22
*/

/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{ 

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal )
    {
	LLNode tmp = new LLNode( newVal, _head );
	_head = tmp;
	_size++;
	return true;
    }

    
    public String get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	LLNode tmp = _head; //create alias to head
	
	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();
	
	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }
    
    //--------------^  List interface methods  ^--------------

    //insert a node containing newVal at position index
    public void add( int index, String newVal ){
	if ( index < 0 || index >= size() )
            throw new IndexOutOfBoundsException();
	
	LLNode tmp = _head;// create alias to head
	LLNode a = new LLNode(newVal, null);
	/*	
	if (index == 0){
	    a.setNext(tmp);
	    }
	    else {*/
	
	//walk to desired node
	for (int i = 1; i < index; i++)
	    tmp = tmp.getNext();
	
	a.setNext(tmp.getNext());
	tmp.setNext(a);
	
	_size += 1;
    }
    
    //remove node at pos index, return its cargo
    public String remove( int index ){
	if ( index < 0 || index >= size() )
            throw new IndexOutOfBoundsException();

	LLNode tmp = _head;
	 
	//walk to desired node
	for (int i = 1; i < index; i++)
	    tmp = tmp.getNext();
	
	String retStr = tmp.getCargo();

	LLNode next = tmp.getNext().getNext();

	tmp.setNext(next);
	_size -= 1;
	return retStr;

    }


    // override inherited toString
    public String toString()
    {
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println( james );

	james.add(3, "uhh");
	System.out.println("... and now 3rd item is: " + james.get(3));
	System.out.println( james );
	System.out.println("size: " + james.size());

	james.remove(1);
	System.out.println( james);
	System.out.println("size: " + james.size());
    }

}//end class LList


