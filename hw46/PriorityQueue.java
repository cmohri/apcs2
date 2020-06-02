public interface PriorityQueue{

    //Adds a String to this priority queue.
    public void add(String x);

    //Returns true if this stack is empty, otherwise returns false.
    public boolean isEmpty();

    //Returns the smallest item stored in this priority queue without removing it.
    public String peekMin();

    //Removes and returns the smallest item stored in this priority queue.
    public String removeMin();

}