public class Find {

    public static int search(int val, int[][] arr){

	for (int i = 0; 
	    
	if(val==arr[i][i]){
	    System.out.println(i);
	    System.out.println(i);
	    return arr[i][i];
        }
	for(int r=0; r<i; r++){
	    if(val==arr[r][i]){
		System.out.println(r);
		System.out.println(i);
		return arr[r][i];
            }
        }
	for(int c=0; c<i; c++){
	    if(val==arr[i][c]){
		return arr[i][c];
            }
        }
	return 0;
    }

    public static void main (String[] args){
	int[][] arr = {{1, 3, 5},
		       {3, 7, 8},
		       {5, 12, 15}};
	int a = 20; 
	System.out.println(search(a, arr));

    }

}