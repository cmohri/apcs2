/*
Clara Mohri
APCS2 Pd08
HW43 --  BSTs is the Perfect Place for Shade
2018-05-02
*/

/*****************************************************
 * class BST - v1
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
    BST( )
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

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
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
    if ( currNode == null ) //stepped beyond leaf
      return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

  //recurse left, process root, recurse right
  public void inOrderTrav()
  {
    inOrderTrav( _root );
  }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }

  //recurse left, recurse right, process root
  public void postOrderTrav()
  {
    postOrderTrav( _root );
  }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
	if (_root.getValue() == target)
	    return _root;
	TreeNode a = _root;
	while (a != null){
	    if (a.getValue() == target)
		return a;
	    else if (target < a.getValue())
		a = a.getLeft();
	    else if (target > a.getValue())
		a = a.getRight();
	}
	return null;
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height()
    {
	return height(_root);
    }
    public int height(TreeNode a){
	if (a == null) return 0;
	else {
	    int left = height(a.getLeft());
	    int right = height(a.getRight());
	    if (left > right) return left+ 1;
	    else return right+1;
	}
    }

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {	
	if (_root == null) return 0;
	return numLeaves(_root) - 1;
    }    
    public int numLeaves(TreeNode a){
	if (a == null) return 0;
	else return 1 + numLeaves(a.getLeft()) + numLeaves(a.getRight());
    }

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

    System.out.println("searching for ints in tree");
    for (int i = 0; i < 10; i++){
	System.out.print(i);
	if (arbol.search(i) != null){
	    System.out.print(": found! ");
	    System.out.println(arbol.search(i).getValue());
	}
	else System.out.println(": not found: " + arbol.search(i));
    }

    System.out.println( "\n-----------------------------");
    System.out.print("Number of leaves in tree: ");
    System.out.println(arbol.numLeaves());
    System.out.println("Insert 10...");
    arbol.insert(10);System.out.print("Number of leaves in tree: ");
    System.out.println(arbol.numLeaves());
    System.out.print("Size of empty tree: ");
    BST arbre = new BST();
    System.out.println(arbre.numLeaves());

    System.out.println( "\n-----------------------------");
    System.out.println("Testing height of tree...");
    System.out.println("arbol height: " +arbol.height());
    System.out.println("Insert 11...");
    arbol.insert(11);
    System.out.println("Insert 12...");
    arbol.insert(12);
    System.out.println("arbol height: " +arbol.height());

  }

}//end class
