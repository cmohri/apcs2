/*
Clara Mohri
APCS2 Pd08
HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
2018-02-27
*/

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
    private int[][] _board;
    private int numQueens = 0;
    private int numTrials = 0;

    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }
    
    
    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve()
    {
	return solveH(0);
    }

    private boolean solveH(int col){

	if (col == _board.length){
	    return true;
	}
	for (int row = 0; row < _board.length; row++){
	    if (addQueen(row, col)){
		addQueen(row, col);
		if( solveH(col + 1))
		    return true;
		removeQueen(row, col);
	    }
	}
	return false;

    }




    //removes all the queens from a certain column as well as everything to the right
    private void remover(int col){
	for (int x = 0; x < _board.length; x++){
	    for (int y = col; y < _board.length; y++){
		removeQueen(x, y);
	    }
	}
    }

  
    /**
     *Helper method for solve. 

    private boolean solveH( int col ) 
    {
	return _board[0][col] == 1;
    }
    */
   
    /**
     * prints solution
     all negs and 0's replaced with underscore                                                                   
     all 1's replaced with 'Q'  
     */
    public void printSolution()
    {
	String ans = "";
        for( int r = 0; r < _board.length; r++ ) {
            for( int c = 0; c < _board[0].length; c++ ) {
		if (_board[r][c] <= 0)
		    ans += "_\t";
		else ans += "Q\t";
            }
            ans += "\n";
        }
        System.out.println( ans);
    }
    
    
    
    //================= YE OLDE SEPARATOR =================
    
    /***
     * boolean addQueen(int, int): Places a queen at the desired location, if possible based on the current board. If it is possible, then it also sets the values of all positions that can be attacked by this queen that are to the right (col number is greater) to -=1.
     * precondition: A board exists, and the row and col number are within the range on the board.
     * postcondition: Either a queen has not been added because it is not allowed, or a queen has been added at this position, marking it as 1, and all attacked squares to the right have been marked as -=1. 
     */
    private boolean addQueen(int row, int col){
	if(_board[row][col] != 0){
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
		_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
		_board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }
    
    
    /***
     * boolean removeQueen (int, int): Removes a queen at a desired position, if there is a queen there.
     * precondition: A board exists, and the row and col number are within the range on the board.
     * postcondition: If the method is asked to remove a queen where there is not one, then false is returned and nothing happens. Otherwise, the position specified by row and col is set to 0, and all previously attacked positions are changed to += 1.
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;
	
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }
    
    
    /***
     * String toString(): returns the contents of the board in a String 
     * precondition: board exists, and has a size greater than or equal to 0.
     * postcondition: a String containing the contents of the board has been created and is returned.
     */
    public String  toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    
    //main method for testing...
    public static void main( String[] args )
    {
	/*	QueenBoard b = new QueenBoard(5);
	System.out.println("b");
	System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
	//b.addQueen(3, 0);
	System.out.println("b.addQueen(3,0) and b.addQueen(0,1)");
	System.out.println(b);
	b.removeQueen(3,0);
	b.removeQueen(1, 1);
	//b.removeQueen(10, -1);
	System.out.println("b.removeQueen(3, 0) and b.removeQueen(1, 1)");
	System.out.println(b);
	b.printSolution();*/
	QueenBoard a = new QueenBoard(10);
	System.out.println(a);
	a.solve();
	a.printSolution();
    }
    
}//end class
