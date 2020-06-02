/*
Clara Mohri
APCS2 Pd08
HW16 -- About Face
2018-03-07
*/


/**
I can't fully name the functionality of mysterion, but here is what it does: 
Swap two numbers; arr[c] and arr[b]
Starting from arr[a], check if any number is less than a[b]. 
    If yes, then swap swap with where a was, and add one to this for next time.
When b-1 has been reached and checked, then swap arr[b] with the most recently swapped arr[s]. 
Additionally, the running time of mysterion is O(n). This is because there is one for loop, which will simply go through a part of the list, swapping certain items. The rest runs in constant time.

**/


public class Mysterion{
    
    //transcribed mysterion method
    public static int mysterion(int[] arr, int a, int b, int c){
	int x;
	int v= arr[c];
	//swap arr[c], arr[b]
	arr[c] = arr[b];
	arr[b] = v;
	//start point for comparison
	int s = a;
	//go through everything between a and b
	for (int i = a; i <= b - 1; i++){
	    //if it is less than a[c]
	    if (arr[i] < v){
		//swap arr[s], arr[i]
		x = arr[s];
		arr[s] = arr[i];
		arr[i] = x;
		s += 1;
	    }
	}
	//swap [b], arr[s]
	x = arr[s];
	arr[s] = arr[b];
	arr[b] = x;
	return s;
    }

    //method to print out content of array
    public static String printOut(int[] arr){
	String retStr = "";
	for (int i = 0; i < arr.length; i++){
	    retStr += arr[i] ;
	    retStr += " ";
	}
	return retStr;
    }

    public static void main (String[] args){
	int[] arr = {7, 1, 5, 12, 3};
	System.out.println("original: " );
	System.out.println(printOut(arr));
	int a = 1;
	int b= arr.length-1;
	int c = 0;
	System.out.println(mysterion(arr, a, b, c));
	System.out.println(printOut(arr));
	    // }
    }
}