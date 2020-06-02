/*
Clara Mohri
APCS2 Pd08
HW34 -- The English Do Not Wait In Line 
2018-04-16
*/

public class NodeQueue<T> {

    //instance var
    private int _queueSize;
    private LLNode<T> _head;
    private LLNode<T> _tail;

    //constructor
    public NodeQueue(){
	_queueSize = 0;
	_head= null;
	_tail = null;
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public T dequeue(){	
	if (isEmpty())
	    return null;
	T retVal = _head.getValue();
	if (_queueSize == 1){	    
	    _head = null;
	    _tail = null;
	}
	else {
	    LLNode<T> temp = _tail;
	    while (temp.getNext().getNext() != null){
		temp = temp.getNext();
	    }
	    temp.setNext(null);
	    _head = temp;
	}
	_queueSize -=1;
	return retVal;
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue (T x){
	LLNode<T> a = new LLNode<T>(x, null);
	if (isEmpty()){
	    _head = a;
	    _tail = a;
	}
	else{
	    a.setNext(_tail);
	    _tail = a;	 
	}
	_queueSize += 1;
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
	return _queueSize <= 0;
    }

    //Returns the first element of the queue without dequeuing it
    public T peekFront(){	    	
	return _head.getValue();
    }

    public static void main (String[] args){
	NodeQueue<String> a = new NodeQueue<String>();
	a.enqueue("helo");
	System.out.println(a._head);
	System.out.println(a._tail);
	System.out.println(a._queueSize);
	a.enqueue("world");
	System.out.println(a._head);
        System.out.println(a._tail);
        System.out.println(a._queueSize);
	System.out.println(a.dequeue());
	System.out.println(a._head);
	System.out.println(a._tail);
	System.out.println(a.dequeue());
	System.out.println(a._tail);

	NodeQueue<String> b = new NodeQueue<String>();
	b.enqueue("first");
	b.enqueue("second");
	b.enqueue("third");
	b.enqueue("fourth");
	b.enqueue("fifth");	
	while (! b.isEmpty()){
	    System.out.println(b.peekFront());
	    b.dequeue();
	}
	System.out.println(Math.random());
    }

}

