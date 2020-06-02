/*======================================
  class Demo
  Techniques for animation in a POSIX terminal

  usage: 
  $ java Demo [BOARDSIZE] [DELAY]
  BOARDSIZE: sidelength of board
  DELAY: time in milliseconds between screen refreshes
  eg
  $ java Demo 5 1000
  $ java Demo 5 500
  $ java Demo 8 200  
  ======================================*/

import java.io.*;
import java.util.*;

class Boardasaurus
{
  //instance vars
  private int[][] _board;
  private int sideLength; //board has dimensions n x n
  private boolean goMode = true;
  
  //constructor
  public Boardasaurus( int n )
  {
    sideLength = n;

    //init 2D array to represent square board with moat
    _board = new int[n+4][n+4];

    //SETUP BOARD:
    //  0 on each cell of actual board
    // -1 on each border/buffer cell around edges (moat)
    //---------------------------------------------------------
    for( int i=0; i < n+4; i++ )
	    for( int j=0; j < n+4; j++ )
        _board[i][j] = -1; //lay down initial blanket of -1's

    for( int i=2; i < n+2; i++ )
	    for( int j=2; j < n+2; j++ )
        _board[i][j] = 0; //lay down 0's for actual board
    //---------------------------------------------------------

  }//end constructor


  public String toString()
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";  
    //emacs shortcuts to generate this ANSI escape code:
    // C-q, then press ESC
    // or
    // M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i < sideLength+4; i++ ) {
	    for( j=0; j < sideLength+4; j++ ) {
        retStr = retStr + String.format( "%3d", _board[j][i] );
        //"%3d" allots 3 spaces for each number
      }
	    retStr = retStr + "\n";
    }
    return retStr;
  }


  // helper method to keep try/catch clutter out of main flow
  private void delay( int n )   //delay in ms
  {
    try {
	    Thread.sleep(n);
    }
    catch( InterruptedException e ) {
	    System.exit(0);
    }
  }


  /*********************************************
   * void go( moves, t ) -- animation driver method
   * @param moves  number of moves
   * @param t      number milliseconds between screen refreshes
   *********************************************/
  public void go( int moves, int t )
  {
    delay(t); //slow it down enough to be followable

    int i = 2 + (int)(Math.random() * sideLength);
    int j = 2 + (int)(Math.random() * sideLength);

    _board[i][j] = moves;
    System.out.println( this ); //refresh screen

    if ( !goMode )
      System.exit(0);

    if ( moves > sideLength * sideLength ) {
      goMode = false;
      System.out.println( this ); //refresh screen
    }
    else {
      go( moves+1, t );
      System.out.println( this ); //refresh screen
    }
  }//end go
  
}//end class Boardasaurus


//class to demo simple techniques for animating the terminal
//..and some handy ANSI escape codes
public class Demo
{
  public static void main( String[] args )
  {
    int n = 8; //default board size
    int timeDelay = 500; //default delay time
    
    //if command line argument given, set board size accordingly
    try { 
	    n = Integer.parseInt( args[0] );
    } catch( Exception e ) { 
	    System.out.println( "Invalid input. Using board size " 
                          + n + "..." );
    }
    
    //if command line argument given, set delay time accordingly
    try { 
	    timeDelay = Integer.parseInt( args[1] );
    } catch( Exception e ) { 
	    System.out.println( "Invalid time delay input. Using " 
                          + timeDelay + " milliseconds..." );
    }

    //clear screen using ANSI control code
    System.out.println( "[2J" ); 

    //initialize new board
    Boardasaurus boo = new Boardasaurus(n);

    //initial display of board
    System.out.println( boo );

    //animate board
    boo.go( n, timeDelay );
    
  }//end main()

}//end class Demo
