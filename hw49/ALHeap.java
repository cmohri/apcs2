/*
  Blue Boat
  APCS2 Pd08
  HW49 -- Sink || Swim
  2018-05-16
*/

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;
import java.lang.Math;

public class ALHeap
{
    
    //instance vars
    private ArrayList<Integer> _heap; 
    
    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
	_heap = new ArrayList<Integer>();
	_heap.add(null);
    }

    
    
    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (more complicated, more fun)
     *****************************************************/
    //for now, returns level-order traversal of the tree
    public String toString() 
    { 
	String retStr = "";
	int pow = 0;
	int num = 0;
	for (Integer i: _heap){
	    retStr += i + " ";
	    num += 1;
	    if (num >= Math.pow(2, pow)){
		retStr += "\n";
		pow += 1;
	    }
	}
	return retStr;
    }//O(n)
    
    
    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty()
    { 
	return _heap.size() <= 1;
    }//O(?)
    
    
    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin()
    { 
	return _heap.get(1);
    }//O(1)
    
    
    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree exhibits heap property.
     * Procedure for adding: 
     * 1. Add to the end of the _heap
       2. If the parent is  <= than the added value, then keep in place
       3. Else, swap the parent and the added value
       4. Keep doing this until the parent of the added value is <= the added value
     *****************************************************/

    public void add( Integer addVal )
    { 
	_heap.add(addVal);

	int addedIndex = _heap.size() - 1;

	int parentIndex = addedIndex / 2;

	while (parentIndex >= 1 &&  _heap.get(parentIndex) > _heap.get(addedIndex) ){
	    swap(parentIndex, addedIndex);
	    addedIndex = parentIndex;
	    parentIndex = addedIndex / 2;

	}
    }//O(logn)
    
    
    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     * Rules for removing: 
     * 1. Initialize minVal to the root
       2. Swap the root with the right most value in the _heap
       3. Remove the rightmost value in the _heap
       4. While minChildPos != -1, keep on swapping the index of the minChild with the parent, starting at the root
     *****************************************************/
    public Integer removeMin()
    { 
	if (_heap.size() <= 1) 
	    throw new IndexOutOfBoundsException();

	Integer minVal = _heap.get(1);
	if (_heap.size() == 2) {
	    _heap.remove(1);
	    return minVal;
	}
	swap(1, _heap.size() - 1);
	_heap.remove(_heap.size() - 1);
	int indexholder = 1;
	while (minChildPos(indexholder) != -1){
	    int minChild = minChildPos(indexholder);
	    swap(indexholder, minChild);
	    indexholder = minChild;
	}
	return minVal;

    }//O(?)
    
    
    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     * The children of a parent are located at 2* pos and/or 2*pos + 1, if they exist
     *****************************************************/
    private int minChildPos( int pos )
    { 
	if (pos >= _heap.size() || pos <= 0) return -1;
	if ( (2*pos) >= _heap.size()) return -1;
	if ((2*pos) == _heap.size() - 1) return 2*pos;
	else {
	    if (_heap.get(2*pos) > _heap.get(2*pos + 1)) return (2*pos + 1);
	    else return 2*pos;
	}

    }//O(1)
    
    
    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b )
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }
    
    //swap for an ArrayList
    private void swap( int pos1, int pos2 )
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************
    
    
    
    //main method for testing
    public static void main( String[] args )
    {

	  ALHeap pile = new ALHeap();
	  
	  pile.add(2);
	  System.out.println(pile);       
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  for (int i = 0; i < 10; i++){
	      System.out.println(i + ": " + pile.minChildPos(i));
	  }

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("minChild: " +pile.minChildPos(1));
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);

    }//end main()
    
}//end class ALHeap
