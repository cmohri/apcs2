/*
Clara Mohri
APCS2 Pd08
HW51 -- Heapling Piles of Sordidness
2018-05-21
*/

/**
 *class HeapSort uses heap sort algorithm to sort an array of ints
 * Algo: 
 * 1. From left to right, promote element at current index, via swaps, to where it belongs
 * 2. Now, element at index 0 is in FRP
 * 3. Heapify the array from index 1 to end, adding 1 to index every time until end of array is reached.
 **/

public class HeapSort{

    //min heapifies an array using param index as the root of the heap, and disregarding every item to the left of the root. Assumes that all items to left of root are already in FRP
    public static int[] minheapify(int[] arr, int index){
	for (int i = index; i < arr.length; i ++ ){
	    int addedIndex = i;
	    int parentIndex = (addedIndex + (index - 1)) / 2;
	    while (parentIndex >= index && arr[parentIndex] > arr[addedIndex]){
		swap(arr, addedIndex, parentIndex);
		addedIndex = parentIndex;
		parentIndex = addedIndex / 2;
	    }
	}
	return arr;
    }

    //calls minheapify to sort array
    public static int[] sort(int[] arr){
	for (int i = 0; i < arr.length; i++)
	    minheapify(arr, i);
	return arr;
    }
    
    //swaps two indeces of an array
    public static int[] swap(int[] arr, int indexone, int indextwo){
	int temp = arr[indexone];
	arr[indexone] = arr[indextwo];
	arr[indextwo] = temp;
	return arr;
    }

    //prints out contents of an array
    public static void printOut(int[] arr){
	for (int i: arr)
	    System.out.print (i + " ");
	System.out.println();
    }

    public static void main (String[] args){

	int[] arr = {7, 3, 12, 5, 1};	
	System.out.println("arr: ");
	printOut (arr);
	System.out.println("minheapify arr, from index 0 up to 4: ");
	minheapify(arr, 0);
	printOut (arr);
	minheapify(arr, 1);
	printOut(arr);
	minheapify(arr, 2);
	printOut(arr);
	minheapify(arr, 3);
	printOut(arr);
	minheapify(arr, 4);
	printOut(arr);

	System.out.println("--------------------------------------");

	int[] arr1 = {2, 9, 1, 4, 3, 110, 13};
	System.out.println("arr1: ");
        printOut (arr1);
	System.out.println("minheapify arr1, from index 0 up to 6: ");
        minheapify(arr1, 0);
        printOut (arr1);
	minheapify(arr1, 1);
	printOut(arr1);
	minheapify(arr1, 2);
	printOut(arr1);
	minheapify(arr1, 3);
	printOut(arr1);
	minheapify(arr1, 4);
	printOut(arr1);
	minheapify(arr1, 5);
	printOut(arr1);
	minheapify(arr1, 6);
	printOut(arr1);

	System.out.println("--------------------------------------");

	int[] arr2 = {9, 1, 2, 3, 5, 10, 110, -4, 111, 29};
	System.out.println("arr2: ");
	printOut(arr2);
	sort(arr2);
	System.out.println("Sorting arr2…");
	printOut(arr2);
    }


}