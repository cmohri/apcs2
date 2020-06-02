public class QuickSortTester{

    public static int[] buildArray(int size){
	int[] retArr= new int [size];
	for(int i=0; i<size;i++){
	    retArr[i]=i;
	}
	return retArr;
    }

    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    QuickSort.swap( i, swapPos, d );
	}
    }

    public static int[] reverseArr(int size){
	int[] retArr = new int [size];
	int index = 0;
	for (int i = size ; i > 0; i--){
	    retArr[index] = i;
	    index += 1;
	}
	return retArr;
    }

    public static void main (String[] args){
	/*	int[] arr;
	long start;
	long end;
	long sum = 0;
	for (int i = 100; i < 10000; i+= 5){
	    System.out.print(i + ", ");
	    for (int x = 0; x < 3; x++){
		arr = buildArray(i);
		shuffle(arr);
		
		start = System.nanoTime();
		QuickSort.qsort(arr);
		end = System.nanoTime();
		//QuickSort.printArr(arr);
		sum += (end - start);
	    }
	    System.out.println(sum / 3);
	    sum = 0;
	}
	*/
	//int[] test = {};
	int[] arr = buildArray(10000);
	long start;
	long end;
	int sum = 0;
	QuickSort.shuffle(arr);

	for (int i = 100; i < 10000; i += 50){
	    int[] test = new int[i];
	    for (int j = 0; j < 20; j++){	       

		for (int k = 0; k < i; k++){
		    test[k] = arr[k];

		}
		//QuickSort.printArr(test);
		start = System.nanoTime();
		QuickSort.qsort(test);
		end = System.nanoTime();
		//QuickSort.printArr(test);
		sum += (end - start);
	    }
	    
	    System.out.print(i + ", " );
	    System.out.println(sum / 20);
	    sum = 0;
	}
    }

}
