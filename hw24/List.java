/*****************************************************
 * interface List -- subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 * If placed in current working dir, will be consulted instead of 
 * built-in Java library interface.
 *****************************************************/

public interface List
{ 

    //add node containing input String to end of list
    public boolean add( String x ); 

    //inserts a node containing s at position I
    public void add( int i, String s ); 

    //removes the node at position i and returns its cargo
    public String remove( int i );

    //return data in element at position i
    public String get( int i ); 

    //overwrite data in element at position i
    public String set( int i, String x ); 

    //return length of list
    public int size(); 

}//end interface
