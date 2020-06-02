/*
  Clara Mohri
  APCS2 Pd08
  HW17 -- So So Fast
  2018-03-10
*/

/***
 * class FastSelect
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
    
    public static int fastSel(int[] arr, int a, int b, int y){	
	int c = (a + b)/2;
	if ( 1 + partition(arr, a, b, c) == y){
	    return arr[c];
	}
	else if (s < y){
	    return fastSel(arr, a, c, (a+c)/2, y);
	}
	else return fastSel(arr, c, b, (c+b)/2, y);
	 
    } 
    


    //main method for testing
    public static void main( String[] args )
    {
	//init test arrays of magic numbers
	int[] arr1 = {8,21,17,69,343};
	int[] arr3 = {1,28,33,4982,37};
	int[] arr4 = {5,4,17,9000,6};
	int[] arr5 = {3,0,16,599,1024};
	
    }//end main
    
}//end class FastSelect
