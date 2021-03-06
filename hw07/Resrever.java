/*
Clara Mohri
APCS2 Pd08
HW07 -- A Man, A Plan, A Canal: Panama!
2018-02-13
*/

public class Resrever {

    /*====================================
    String reverseLin(String) 
    Returns the reverse of a String input
    Uses an algorithm of complexity O(n)
    ====================================*/
    public static String reverseLin(String str){
	String retStr = "";
	for (int i = str.length(); i > 0; i--){
	    retStr += str.substring(i-1, i);
	}
	return retStr;
    }//end reverseLin

    /*====================================
    String merge(String, String)
    Merges two Strings into one, as b + a
    Uses an algorithm of complexity O(1)
    ====================================*/
    public static String merge(String a, String b){
	return b+a;
    }//end merge

    /*====================================
    String reverseLog(String)
    Returns the reverse of a String input
    Uses an algorithm of complexity O(logn):
       1. Divide the String until there is only one letter
       2. Merge the Strings, in reverse order
    ====================================*/
    public static String reverseLog(String str){
	//base case:
	if (str.length() <= 1)
	    return str;
	//else, divide String in two:
	int leftLen = str.length() / 2;
	//it takes constant time to get and store a substring
	String leftHalf = str.substring(0, leftLen);
	String rightHalf = str.substring(leftLen, str.length());
	//merge the two halves, now in reverse order, in reverse order
	return merge( reverseLog(leftHalf), reverseLog(rightHalf));
    }//end reverseLog

    public static void main (String[] args){

	String[] foo = {"Stressed!", "aralc", "irhoM", "rats", "Does this work?!?"};
	for (String i: foo){
	    System.out.println("Word: " + i);
	    System.out.println("reverseLin: " + reverseLin(i));
	    System.out.println("reverseLog: " + reverseLog(i));
	    System.out.println();

	    for (int i = 1; i < 5000; i++) {
		String test = "";
		int count = 0;
		while (count < i){
		    test += "a";
		    count += 1;
		}
		int counter = 0;
		long d = System.currentTimeMillis();
		while (counter < 1000) {
		    reverseLog(test);
		    counter += 1;
		}
		long j = System.currentTimeMillis();
		long time = j-d;
		System.out.println(i +", " + time);
	    }

	}
		
    }//end main


}