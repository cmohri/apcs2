public class Log {
    public static void main (String[] args){
	for (int i = 100; i < 10000; i += 5){
	    System.out.print(i + ", " );
	    System.out.println(i* (Math.log(i)/ Math.log(2)));
	}
    }
}
	       