/*****************************************************
 * interface List
 * Specifies actions a List must be able to perform.
 * New in Version 4: GENERIC TYPING
 * ---
 * Clyde "Thluffy" Sinclair
 * 2018-03-26m
 *****************************************************/


public interface List<T> 
{ 
    //add element T to end of list
    //always return true
    public boolean add( T x ); 

    //insert element T at index i
    public void add( int i, T newVal );

    //remove element at index i
    public T remove( int i );

    //return element at index i
    public T get( int i ); 

    //overwrite element at index i, return old element at index i
    public T set( int i, T x ); 

    //return number of elements in list
    public int size(); 

}//end interface List
