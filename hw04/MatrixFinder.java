/*
Team Slant Coder
Clara Mohri, Kashf Mashrafi, John Liu
APCS2 Pd8
L00-- But What Does the Data Say?
2018-02-09
*/

/***
Algorithm Summary: 
Our search algorithm begins on the bottom left corner of the matrix.
Then, it compares our search val to the val found here.
If the val found here is greater than our search val, then we look at the position one up.
If the val found here is less than our search val, then we look at the position one to the right.
Repeat the above two steps until the value is found.
If the row counter or column counter must be changed to something out of range, then the search val is not in our matrix, and we will return "(-1, -1)".
***/
import java.lang.Math;
import java.util.Random;

public class MatrixFinder{

    //method finds an int val in an int[][] arr
    //int[][] arr has increasing rows from left to right
    //int[][] arr has increasing columns from top to bottom
    public static String find(int[][] arr, int val){
	//first position to be checked:
	long start = System.currentTimeMillis();
	int row = arr.length - 1;
	int col = 0;
	
	if (arr.length == 0)
	    return ("(-1, -1)");

	//while loop identifies the next item to be checked	
	while (arr[row][col] != val){
	    if (arr[row][col] > val)
		row -= 1;
	    else if (arr[row][col] < val)
		col += 1;
	    //if row or col becomes out of bounds, then out search val is not in the matrix
	    if (row < 0 || col < 0 || row >= arr.length || col >= arr.length)
		return ("(-1, -1)");
	}

	//return the col position and the row position as a String
	return ("(" + (col+1) + ", " + (row+1) + ")");
	//	long end = System.currentTimeMillis();
	//System.out.println("time: " + (end-start));
    }

    //method to print out an int[][]
    public static void printOut(int[][] arr){
	for (int[] i: arr){
	    for (int x: i)
		System.out.print(x + "  ");
	    System.out.println();
	}
    }

    //random array size generator
    public static int[][] gen(int x){

	int[][] randArr = new int[x][x];

	//the skeleton of the matrix:
	randArr[0][0] = (int)( Math.random() * 10);

        for (int i = 1; i < randArr.length; i++){
	    randArr[0][i] = (int)(randArr[0][i-1] + (Math.random() * 10) + 1);
        }
	for (int j = 1; j < randArr.length; j++){
	    randArr[j][0] = (int)(randArr[j-1][0] + (Math.random() * 10) + 1);
	}

	//the rest:
	int one; 
	int two;
	for (int a = 1; a < randArr.length; a++){
	    for (int b = 1; b < randArr.length; b++){
		one = randArr[a-1][b] + (int) (Math.random() * 10) + 1;
		two = randArr[a][b-1] + (int) (Math.random() * 10) +  1; 
		if (one > two)
		    randArr[a][b] = one;
		else randArr[a][b] = two;
	    }
	}
	return randArr;
    }

    public static void main (String[] args){
	
	int[][] rand;	
	//input for gen(int) is n, the size of the matrix
	int size = 7000;
	rand = gen(size);

	long avgms = 0;
	//long avgns = 0;
	int randNum = (int)((Math.random() * 100)+ 1);
	System.out.println(randNum);
	int i;
	int tenth = 0;
	//i is the number of trials
	for (i = 0; i < 10000; i++){
	    if (i % 100 == 0){		
		rand = gen(size);
		tenth = 0;
	    }
	    //System.out.println("Trial #" + i);
	    long start = System.currentTimeMillis();
	    //long nano = System.nanoTime();
	    
	    find(rand, randNum);
	    long end = System.currentTimeMillis();
	    //long nanoEnd = System.nanoTime();
	    tenth += (end - start);
	    if (i % 10 == 9){
		System.out.println((double)tenth / 10);
	    }
	    avgms += (end - start);
	    //avgns += (nanoEnd - nano);

	    System.out.println("total time:\n " +(end - start) + "ms\t"/* + (nanoEnd - nano) + "ns"*/);
	}

	System.out.println(i);
	System.out.println("Average ms: " + ((double)avgms/i));
	//System.out.println("Average ns: " + (avgns/i));
    }

}