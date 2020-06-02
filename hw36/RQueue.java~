/*
Clara Mohri
APCS2 Pd08
HW36 -- Now Let's Consider You Lot at Fake Terry's
2018-04-18
*/

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/

import java.lang.Math;

public class RQueue<T> implements Queue<T>{

    //instance variables
    private LLNode<T> _front, _end;
    private int _size;
    
    
    // default constructor creates an empty queue
    public RQueue(){ 
	_front = null;
	_end = null;
	_size = 0;
    }//end default constructor
    
    
    //means of adding an element to collection: 
    //Running time: O(1)
    public void enqueue( T enQVal ) 
    {
	LLNode<T> next = new LLNode<T>(enQVal, null);
	if (_size == 0){
	    _end = next;
	    _front = next;
	}
	else {
	    _end.setNext(next);
	    _end = next;
	}
	_size += 1;
	//by randomizing the order here, then the data remains in random order
	if (_size > 1)
	    sample();
    }//end enqueue()
    
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    { 
	if (isEmpty()){
	    return null;
	}
	T retval = _front.getValue();
	_front = _front.getNext();
	_size -= 1;
	return retval;
    }//end dequeue()
    
    //Returns the first element of the queue without dequeuing it.
    public T peekFront() 
    {
	return _front.getValue();
    }
    
    
    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * Dequeue _front, and enqueue it. Do this a random number of times, so as to "shift" the queue over a random amount.
     * This will create a random _front
     ******************************************/
    public void sample () 
    {
	//dequeue _front a random number of times, and enqueue _front again random number of times.
	int randNum = (int)(Math.random()*_size*5);
	//System.out.println(randNum);
	for (int i = randNum; i > 0; i --){
	    LLNode<T> tmp = _front;
	    _front = _front.getNext();
	    _end.setNext(tmp);
	    _end = tmp;
	}
    }//end sample()
    

    public boolean isEmpty() 
    {
	return (_size == 0);
    } //O(1)
    
    
    // print each node, separated by spaces
    public String toString() 
    { 
	String retStr = "HEAD -> ";
	LLNode<T> tmp = _front;
	int ctr = _size;
	while (ctr > 0){
	    retStr += (tmp.getValue() + ", ");
	    tmp = tmp.getNext();
	    ctr -= 1;
	}
	retStr += "-> TAIL";
	return retStr;
    }//end toString()
    
    //main method for testing
    public static void main( String[] args )
    {

	  
	  RQueue<String> PirateQueue = new RQueue<String>();
	  
	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow testing sample()...");
	  PirateQueue.sample();
	  System.out.println ( PirateQueue);
	  PirateQueue.sample();
          System.out.println ( PirateQueue);
	  PirateQueue.sample();
          System.out.println ( PirateQueue);
	  PirateQueue.sample();
          System.out.println ( PirateQueue);

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println("Going to remove: " +  PirateQueue.peekFront() );
	  System.out.println( "...removed: " +PirateQueue.dequeue() );
	  System.out.println("Going to remove: " +  PirateQueue.peekFront() );
          System.out.println( "...removed: " +PirateQueue.dequeue() );
	  System.out.println("Going to remove: " +  PirateQueue.peekFront() );
          System.out.println( "...removed: " +PirateQueue.dequeue() );
          System.out.println("Going to remove: " +  PirateQueue.peekFront() );
          System.out.println( "...removed: " +PirateQueue.dequeue() );
          System.out.println("Going to remove: " +  PirateQueue.peekFront() );
          System.out.println( "...removed: " +PirateQueue.dequeue() );

          System.out.println("Going to remove: " +  PirateQueue.peekFront() );
          System.out.println( "...removed: " +PirateQueue.dequeue() );


	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
	  

	
    }//end main
    
}//end class RQueue
