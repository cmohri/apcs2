/*
Team Blueue
Clara Mohri and Colin Hosking
APCS2 Pd08
HW35 -- ...Nor Do Aussies
*/

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> {

    //instance vars:
    private ArrayList<T> _queue;
    private int _end, _front;
    
    //constructor
    public ALQueue(){
	_end = 0;
	_front = 0;
	_queue = new ArrayList();
    }

    //means of removing an element from collection:                          
    //Dequeues and returns the first element of the queue
    public T dequeue(){
	if (! isEmpty()){
	    T retval = peekFront();
	    _front += 1;
	    return retval;
	}
	else {
	    //means of getting rid of memory if it is empty
	    _queue = new ArrayList();
	    return null;
	}
    }

    //means of adding an element to collection:                              
    //Enqueue an element onto the back of this queue.
    public void enqueue(T x){
	_queue.add(x);
	_end += 1;
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
	return (_end == _front);
    }

    //Returns the first element of the queue without dequeuing it.  
    public T peekFront(){
	return _queue.get(_front);
    }

    public static void main (String[] args){

	ALQueue<Integer> blue = new ALQueue<Integer>();       
	System.out.println("Initialize queue: " + blue._queue);
	System.out.println("Enqueue 3, 4, then 5: ");
	blue.enqueue(3);
	blue.enqueue(4);
	blue.enqueue(5);
	System.out.println(blue._queue);
	System.out.println("Peek front: " +blue.peekFront());
	System.out.println("Front index: "+ blue._front);
	System.out.println("End index: " + blue._end);
	System.out.println("Dequeue: " + blue.dequeue());
	System.out.println("Peek front: " +blue.peekFront());
	System.out.println(blue._end);
	blue.enqueue(6);
	blue.enqueue(10);
	blue.enqueue(9);
	blue.enqueue(13);
	System.out.println("Add some more vals: " + blue._queue);
	while (! blue.isEmpty()){
	    System.out.println("peek front: " + blue.peekFront() + " ...dequeuing");
	    blue.dequeue();
	}
	System.out.println("Queue still looks the same: " +blue._queue);
	System.out.println("However, _front and _end are: " + blue._front +", " + blue._end);
	System.out.println("try dequeuing from an empty queue: ");
	blue.dequeue();
	System.out.println("queue looks like : " + blue._queue);

    }


}