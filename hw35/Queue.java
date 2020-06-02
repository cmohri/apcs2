/*****************************************************
 * interface Queue
 * Includes only methods listed in AP subset of Java
 * (Local version, to override built-in Java implementation.)
 ******************************************************/


public interface Queue<T> {

    //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public T dequeue();

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( T x );

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty();

    //Returns the first element of the queue without dequeuing it.
    public T peekFront();
    //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~


}//end interface Queue                                      