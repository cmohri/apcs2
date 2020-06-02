/*
Clara Mohri
APCS2 Pd08
HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
2018-02-06
*/

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
  1. Divide the array into two
  2. Sort these two arrays by continuing step one until arrays of length one (sorted) are obtained
  3. Merge sorted arrays until finally the length of the full list is obtained again  
  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
      int[] retAr = new int[a.length + b.length];
      int actr = 0;
      int bctr = 0;
      int rctr = 0;
      //all the comparisons that can be made:
      while (actr < a.length && bctr < b.length){	
	  if (a[actr] < b[bctr]){
	      retAr[rctr] = a[actr];
	      //System.out.println("added " + a[actr]);
	      actr += 1;
	  }
	  else {
	      retAr[rctr] = b[bctr];
	      //System.out.println("added " + b[bctr]);
	      bctr += 1;
	  }
	  rctr += 1;
      }
      //if one int[] is empty, and there are still items in the other int[] to be added:
      if (actr == a.length){
	  for (int i = bctr; i < b.length; i++){
	      retAr[rctr] = b[i];
	      rctr += 1;
	  }
      }
      else {
	  for (int x = actr; x < a.length; x++){
	      retAr[rctr] = a[x];
	      rctr += 1;
	  }
      }
      return retAr;
  }//end merge()

  /******************************************************
   * int[] firstHalf(int[])
   * Returns first half of int[] input
   ******************************************************/
    public static int[] firstHalf(int[] arr ){
	int[] retArr = new int[(arr.length )/2];
	for (int i = 0; i < retArr.length; i++)
	    retArr[i] = arr[i];
	return retArr;
    }

  /******************************************************
   * int[] secHalf(int[])
   * Returns second half of int[] input
   ******************************************************/
    public static int[] secHalf(int[] arr){
	int[] retArr;
	//if length is even:
	if (arr.length % 2 == 0){
	    retArr = new int[(arr.length) / 2];
	}
	//if length is odd: 
	else{ retArr = new int[((arr.length) / 2) + 1];}
	int ctr = 0;
	for (int i = arr.length - retArr.length; i < arr.length; i++){
	    retArr[ctr] = arr[i];
	    ctr += 1;
	}
	return retArr;
    }

  /******************************************************
   * int[] firstHalf(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
    public static int[] sort( int[] arr )
    {
	//base case: 
	if (arr.length == 1)
	    return arr;
	else {
	    //split the array in two, and merge the sorted version of each
	    int[] one = firstHalf(arr);
	    int[] two = secHalf(arr);	    
	    return merge(sort(one), sort(two));
	    }
    }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  //This method alters the actual values of the input array
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {


      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};
      /*
      System.out.println("\nTesting mess-with-array method...");
      System.out.print("printArray (arr3 ): ");
      printArray( arr3 );
      System.out.print("mess( arr3 ): ");
      mess(arr3);
      System.out.print("\nprintArray (arr3 ): ");
      printArray( arr3 );
      */
      System.out.println("\nMerging arr1 and arr0: ");
      System.out.print("arr1: ");
      printArray(arr1);
      System.out.print("arr0: ");
      printArray(arr0);
      System.out.print("merged: ");
      printArray( merge(arr1,arr0) );
      System.out.println("arr1 and arr0 remain unchanged: ");
      System.out.print("arr1: ");
      printArray(arr1);
      System.out.print("arr0: ");
      printArray(arr0);


      System.out.println("\nMerging arr4 and arr3: ");
      printArray( merge(arr4,arr3) );

      System.out.println("\nMerging arr2 and arr3: ");
      printArray( merge(arr2,arr3) );

      //testing the division of arrays:
      System.out.println("\nFirst half of arr6: ");
      printArray(firstHalf(arr6));
      System.out.println("Second half of arr6: ");
      printArray(secHalf(arr6));
      System.out.println("\nFirst half of arr7: ");
      printArray(firstHalf(arr7));
      System.out.println("Second half of arr7: ");
      printArray(secHalf(arr7));

      System.out.println("\nSorting arr1-7...");
      printArray( sort( arr1 ) );
      printArray( sort( arr2 ) );
      printArray( sort( arr3 ) );
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );

  }//end main()

}//end class MergeSort
