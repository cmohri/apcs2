/* 
Team Slant Coder
Clara Mohri, Kashf Mashrafi, John Liu
APCS2 Pd8   
L00-- But What Does the Data Say?
2018-02-09   
*/

/***
Driver class for MatrixFinder.java
 ***/
public class MFDriver{

    public static void main (String[] args){

	MatrixFinder a = new MatrixFinder();
	int[][] rand;
        //input for gen(int) is n, the size of the matrix                               
        int size = 500;
        rand = a.gen(size);

        long avgms = 0;
        //long avgns = 0;                                                                  
        int randNum = (int)((Math.random() * 100)+ 1);
        System.out.println(randNum);
        int i;
        int tenth = 0;
        //i is the number of trials                         
        for (i = 0; i < 10; i++){
            if (i % 10 == 0){
                rand = a.gen(size);
                tenth = 0;
            }

            long start = System.currentTimeMillis();
            a.find(rand, randNum);
            long end = System.currentTimeMillis();

            tenth += (end - start);
            if (i % 100 == 99){
                //System.out.println((double)tenth / 100);
            }
            avgms += (end - start);
            System.out.println("total time:\n " +(end - start) + "ms\t"/* + (nanoEnd - nano) + "ns"*/);
        }

        System.out.println(i);
        System.out.println("Average ms: " + ((double)avgms/i));
        //System.out.println("Average ns: " + (avgns/i));  

    }
}


