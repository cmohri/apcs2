/*
  Clara Mohri
  APCS2 Pd08
  HW17 -- So So Fast
  2018-03-10
*/

/***
 * class FastSelect
 * Algorithm: Call partition with arr, a = 0, b = arr.length -1, and c being some number within this range(here, I use a+b / 2). If the return value is less than y, then set the range for partition to look at to be to the right of c. If the return value is greater than y, then set the range for partition to look at to be to the left of c. Continue until the return value of partition is equal to y.

 *Execution time: 
 *Best case:
   O(n)
   This occurs if the desired value is in the middle of the array, thus becoming c in partition. Immediately goes to base case.

 *Worst case: 
   O(nlogn)
   This occurs if the desired value is at one of the ends of the array. The array can be divided logn times, and every time that it is divided and partition is called again, the cost of this is n. By multiplying the two, we get O(nlogn)
 **/

public class FastSelect 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }
    
    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }
    
    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }
    
    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------

    //within the range a to b in arr, partition returns how many items are less than arr[c], and places arr[c] in FRP
    public static int partition( int arr[], int a, int b, int c)
    {
	int v = arr[c];
	
	swap( c, b, arr);
	int s = a;
	
	for( int i = a; i < b; i++ ) {
	    if ( arr[i] <= v) {
		swap( i, s, arr );
		s++;}
	}
	swap(s,b,arr);
	
	return s;
    }//end partition
    
    //fastSel uses helper to return the y-least item in arr
    //for the smallest value in the array, y = 1
    public static int fastSel(int[] arr, int y){	
	return helper(arr, 0, arr.length-1, (arr.length-1)/2, y);
    } 
    
    //helper uses partition to return to fastSel what the y-least item in arr is, using recursion and a binary search-style algorithm
    public static int helper(int[] arr, int a, int b, int c, int y){
	//linear time
	int s = partition(arr, a, b, c) +1;
	if (s == y){
	    return arr[s-1];
	}
	//if s is greater than y, then check the left side of c in the array
	else if (s > y){
	    return helper(arr, a, c, (a+c)/2, y);
	}
	//else, check the right side of c in the array
	else {
	    return helper(arr, c, b, (1+c+b)/2, y);
	}
    }

    //main method for testing
    public static void main( String[] args )
    {
	//init test arrays of magic numbers
	int[] arr1 = {8,21,17,69,343, 49};
	int[] arr2 = {1, 9, 7, 2, 3};
	int[] arr3 = {1,28,33,4982,37};
	int[] arr4 = {5,4,17,9000,6};
	int[] arr5 = {3,0,16,599,1024};
	int[] arr6 = {1, 6, 4, 5, 3};
	int[] arr7 = {1, 6, 4, 5, 3};

	//testing arr1:
	System.out.print("Array arr1: ");
	printArr(arr1);
	System.out.println("Items from least to greatest:");
	for (int i = 1; i <= arr1.length; i++){
	    System.out.print(i + ": ");
	    System.out.println(fastSel(arr1, i));
	}
	
	//testing arr2:
	System.out.print("========================\nArray arr2: ");
	printArr(arr2);
        System.out.println("Items from least to greatest:");
        for (int i = 1; i <= arr2.length; i++){
            System.out.print(i + ": ");
            System.out.println(fastSel(arr2, i));
        }

	//testing arr3:      
	System.out.print("========================\nArray arr3: ");
	printArr(arr3);
        System.out.println("Items from least to greatest:");
        for (int i = 1; i <= arr3.length; i++){
            System.out.print(i + ": ");
            System.out.println(fastSel(arr3, i));
        }

	//testing arr4: 
	System.out.print("========================\nArray arr4: ");
        printArr(arr4);
        System.out.println("Items from least to greatest:");
        for (int i = 1; i <= arr4.length; i++){
            System.out.print(i + ": ");
            System.out.println(fastSel(arr4, i));
        }

	//testing arr5: 
	System.out.print("========================\nArray arr5: ");
        printArr(arr5);
        System.out.println("Items from least to greatest:");
        for (int i = 1; i <= arr5.length; i++){
            System.out.print(i + ": ");
            System.out.println(fastSel(arr5, i));
        }


	//BEST AND WORST CASE RUNNING TIME
	System.out.print("========================\nArray arr6: ");
	printArr(arr6);
	System.out.println("Best case: Looking for third smallest");
	long start = System.nanoTime();
	fastSel(arr6, 3);
	long end = System.nanoTime();
	System.out.println("time to run: " + (end - start));
	System.out.println("Worst case: Looking for second smallest");
	start = System.nanoTime();
	fastSel(arr7, 2);
	end = System.nanoTime();
	System.out.println("time to run: " + (end - start));



	/*
	  A lot of test cases that break down the algorithm: 
	  System.out.println(partition(arr1, 0, 4, 2));
	  printArr(arr1);
	  System.out.println(partition(arr1, 2, 4, 3));
	  printArr(arr1);
	  System.out.println(partition(arr1, 3, 4, 3));
	  printArr(arr1);
	  System.out.println(partition(arr1, 3, 4, 3));
	  printArr(arr1);
	  System.out.println(partition(arr1, 3, 4, 3));	
	  printArr(arr1);
	  //System.out.println(fastSel(arr1, 0, 4, 2));
	  System.out.println("Find first smallest (retval must be 1 - 1  = 0)");
	  System.out.println(partition(arr3, 0, 4, 2));
	  printArr(arr3);
	  System.out.println(partition(arr3, 0, 2, 1));
	  printArr(arr3);
	  System.out.println(partition(arr3, 0, 1, 0));
	  printArr(arr3);
	  System.out.println(arr3[0]);
	  
	  System.out.println("====================\nFind second smallest(retval must be 2-1 = 1");
	  System.out.println(partition(arr4, 0, 4, 2));
	  printArr(arr4);
	  System.out.println(partition(arr4, 0, 2, 1));
	  printArr(arr4);
	  System.out.println(partition(arr4, 1, 2, 1));
	  printArr(arr4);
	  System.out.println(partition(arr4, 1, 2, 2));
	  printArr(arr4);
	  System.out.println(partition(arr4, 1, 2, 1));
	  printArr(arr4);
	  System.out.println(arr4[1]);
	  
	  System.out.println("=================\nFind third smallest (retval must == 2)");
	  System.out.println(partition(arr5, 0, 4, 2));
	  printArr(arr5);
	  System.out.println(arr5[2]);
	  
	  System.out.println("=================\nFind fourth smallest (retval must == 3)");
	  System.out.println(partition(arr1, 0, 4, 2));
	  printArr(arr1);
	  System.out.println(partition(arr1, 2, 4, 3));
	  printArr(arr1);
	  System.out.println(arr1[3]);
	*/
	
	
    }//end main
    
}//end class FastSelect
