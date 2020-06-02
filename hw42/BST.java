/*
Clara Mohri
APCS2 Pd08
HW42 -- Algorithm as Data Structure
2018-05-01
*/

/*****************************************************
 * class BST - v1:partial
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /*****************************************************
   * default constructor
   *****************************************************/
    public BST( )
    {
	_root = null;
    }


  /*****************************************************
   * void insert( int )
   * Adds a new data element to tree.
   *****************************************************/
  public void insert( int newVal )
  {
      TreeNode newNode = new TreeNode( newVal );
      if (_root == null)
	  _root = newNode;
      else insert(_root, newNode);
  }

  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
      //dealing with the left side of the tree:
      if (newNode.getValue() < stRoot.getValue()){
	  TreeNode next = stRoot.getLeft();
	  if (next == null)
	      stRoot.setLeft(newNode);
	  else if (next.getValue() < newNode.getValue()){
	      stRoot.setLeft(newNode);
	      newNode.setLeft(next);
	  }
	  else { insert(next, newNode); }
      }
      //dealing with the right side of the tree:
      else {
	  TreeNode next = stRoot.getRight();
	  if (next == null)
	      stRoot.setRight(newNode);
	  else if (next.getValue() > newNode.getValue()){
	      stRoot.setRight(newNode);
	      newNode.setRight(next);
	  }
	  else {insert(next, newNode); }
      }
  }//end insert()


  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order
    
  //process root, recurse left, recurse right
    public void preOrderTrav()
    {
	preOrderTrav( _root );
    }
    public void preOrderTrav( TreeNode currNode )
    {
	System.out.println(currNode.getValue());
	if (currNode.getLeft() != null)
	    preOrderTrav(currNode.getLeft());
	if (currNode.getRight() != null)
	    preOrderTrav(currNode.getRight());
    }
    
    //recurse left, process root, recurse right
    public void inOrderTrav()
    {
	inOrderTrav(_root);
    }
    public void inOrderTrav( TreeNode currNode )
    {
	if (currNode.getLeft() != null)
	    inOrderTrav(currNode.getLeft());
	System.out.println(currNode.getValue());
	if (currNode.getRight() != null)
	    inOrderTrav(currNode.getRight());
    }
    
    //recurse left, recurse right, process root
    public void postOrderTrav()
    {
	postOrderTrav(_root);
    }
    public void postOrderTrav( TreeNode currNode )
    {
	if (currNode.getLeft() != null)
            postOrderTrav(currNode.getLeft());
	if (currNode.getRight() != null)
            postOrderTrav(currNode.getRight());
	System.out.println(currNode.getValue());

    }
    
  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    
  //main method for testing
    public static void main( String[] args )
    {
	  
	  BST arbol = new BST();
	  
	  //PROTIP: sketch state of tree after each insertion
	  //        ...BEFORE executing these.
	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );
	  arbol.insert(10);
	  
	  /*
	  System.out.println(arbol._root.getValue());
	  System.out.println(arbol._root.getLeft().getValue());
	  System.out.println(arbol._root.getRight().getValue());
	  System.out.println(arbol._root.getRight().getRight().getValue());
	  */

	  System.out.println( "\n-----------------------------");
	  System.out.println( "pre-order traversal:" );
	  arbol.preOrderTrav();

	  System.out.println( "\n-----------------------------");
	  System.out.println( "in-order traversal:" );
	  arbol.inOrderTrav();

	  System.out.println( "\n-----------------------------");
	  System.out.println( "post-order traversal:" );
	  arbol.postOrderTrav();
	  
	  System.out.println( "\n-----------------------------");

    }
    
}//end class
