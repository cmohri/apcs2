/*****************************************************
 * class TreeNode
 * SKELETON
 * Implements a node for use in a binary tree.
 * Only holds int cargo.
 *****************************************************/

public class TreeNode
{

    //instance variables / attributes of a TreeNode:
    int _cargo;        //this node's data
    TreeNode _lt, _rt; //pointers to left, right subtrees
    
    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode( int initValue )
    {
	_cargo = initValue;
	_lt = null;
	_rt = null;
    }
          

    /*****************************************************
     * overloaded constructor
     * Construct tree node w specified value, left, and right subtrees.
     *****************************************************/
    TreeNode( int initValue, TreeNode initLeft, TreeNode initRight ) 
    {
	_cargo = initValue;
	_lt = initLeft;
	_rt = initRight;
    }
 

    /*****************************************************
     * Returns the left subtree of this node.
     *****************************************************/
    TreeNode getLeft() 
    {
	return _lt;
    }


    /*****************************************************
     * Returns the right subtree of this node.
     *****************************************************/
    TreeNode getRight() 
    {
	return _rt;
    }


    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    int getValue() 
    {
	return _cargo;
    }


    /*****************************************************
     * Sets the value of the left subtree of this node.
     *****************************************************/
    void setLeft( TreeNode theNewLeft ) 
    {
	_lt = theNewLeft;
    }


    /*****************************************************
     * Sets the value of the right subtree of this node.
     *****************************************************/
    void setRight( TreeNode theNewRight ) 
    {
	_rt = theNewRight;
    }


    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    void setValue( int theNewValue ) 
    {
	_cargo = theNewValue;
    }
 
    public static void main (String[] args){
	TreeNode a = new TreeNode(3);
	TreeNode b = new TreeNode(2);
	TreeNode c = new TreeNode(5);
	System.out.println(a.getLeft() == null);
	a.setLeft(b);
	a.setRight(c);
	System.out.println(a.getValue());//3
	System.out.println(a.getLeft().getValue());//2
	System.out.println(a.getRight().getValue());//5

	b.setRight(c);
	b.setLeft(a);
	System.out.println(b.getLeft().getValue());//3
	System.out.println(b.getRight().getValue());//5
    }
}//end class
