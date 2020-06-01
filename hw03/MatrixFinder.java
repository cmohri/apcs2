/*
Team Slant Coder
Clara Mohri, Kashf Mashrafi, John Liu
APCS2 Pd8
HW03 -- I Am Still Searching
2018-02-02
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

public class MatrixFinder{

    //method finds an int val in an int[][] arr
    //int[][] arr has increasing rows from left to right
    //int[][] arr has increasing columns from top to bottom
    public static String find(int[][] arr, int val){
	//first position to be checked:
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
    }

    //method to print out an int[][]
    public static void printOut(int[][] arr){
	for (int[] i: arr){
	    for (int x: i)
		System.out.print(x + "  ");
	    System.out.println();
	}
    }


    public static void main (String[] args){
	System.out.println("matrix arr:");
	int[][] arr = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
	printOut(arr);
	System.out.print("search 3: ");
	System.out.println(find(arr, 3));
	System.out.print("search -1: ");
	System.out.println(find(arr, -1));
	System.out.print("search 5: ");
	System.out.println(find(arr, 5));
	System.out.print("search 4: ");
	System.out.println(find(arr, 4));
	System.out.print("search 1: ");
	System.out.println(find(arr, 1));
	System.out.println("\n======================\n");

	System.out.println("matrix arr1:");
	int[][] arr1 = {{1, 2, 6}, {2, 3, 7}, {3, 4, 8}};
	printOut(arr1);
	System.out.print("search 6: ");
	System.out.println(find(arr1, 6));
	System.out.print("search 8: ");
	System.out.println(find(arr1, 8));
	System.out.print("search 0:");
	System.out.println(find(arr1, 0));
	System.out.println("\n======================\n");

	System.out.println("matrix arr2: size zero");
	int[][] arr2 = {};
	System.out.print("search 3: " );
	System.out.println(find(arr2, 3));
	System.out.println("\n======================\n");

	System.out.println("matrix arr3: ");
	int[][] arr3 = {{1}};
	printOut(arr3);
	System.out.print("search 3: " );
        System.out.println(find(arr3, 3));
	System.out.print("search 1: " );
        System.out.println(find(arr3, 1));

    }

}