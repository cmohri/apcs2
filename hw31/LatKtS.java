/*
Clara Mohri
APCS2 Pd08
HW#31 --  Stack: What Is It Good For?
2018-04-11
*/

/*****************************************************
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{
    
    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s )
    {
	Latkes stack = new Latkes(s.length());
	String chr;
	for (int i = 0; i < s.length(); i++){
	    chr = s.substring(i, i+1);
	    stack.push(chr);
	}
	String retStr = "";
	for (int j = 0; j < s.length(); j++)
	    retStr  = retStr + stack.pop();
	    
	return retStr;
    }//end flip()
    
    
    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s )
    {
	//create stack
	Latkes stack = new Latkes(s.length());
	for (int i = 0; i < s.length(); i++){
	    String chr = s.substring(i, i+1);
	    //System.out.print(chr + ": ");
	    //if there is a starting parens, then push to stack
	    if (chr.equals("{") || chr.equals("[") || chr.equals("(")){
		//System.out.println("pushing");
		stack.push(chr);
	    }

	    else if ( chr.equals("}") || chr.equals("]") || chr.equals(")")){
		//if there is a closing parens and the stack is empty, then there is a mismatch
		if (stack.isEmpty())
		    return false;
		//if the peek value matches with the closing parens, then pop the peek value
		if (matching(stack.peek(), chr)){
		    stack.pop();
		    //System.out.println("popping");
		}
	    }
	}
	//the stack is only empty if all the parens have been matched, or if s was an empty String
	return stack.isEmpty();
    }//end allMatched()
    

    /**********************************
     *boolean matching(String, String) 
     *returns whether the two Strings form a matching pair of parenthesis
     **********************************/
    public static boolean matching(String a, String b){
	return (a.equals("(") & b.equals(")") ||
		a.equals("{") & b.equals("}") ||
		a.equals("[") & b.equals("]") );
    }// end matching(String, String)
    
    //main method to test
    public static void main( String[] args )
    {

	  System.out.println(flip("stressed"));
	  System.out.println(flip("clara"));
	  System.out.println(flip("racecar"));
	  System.out.println(flip("I believe this works"));

	  //test matching method
	  //System.out.println(matching("(", ")"));
	  //System.out.println(matching("(", "]"));
	  //System.out.println(matching("[", "]"));
	  System.out.println("==============================\nTesting matching parens:");
	  System.out.println("({}[()]) : "+ allMatched( "({}[()])" )); //true
	  System.out.println("([)] :" + allMatched( "([)]" ) ); //false
	  System.out.println("(){([])} :" + allMatched( "(){([])}" ) ); //true
	  System.out.println("](){([])} :" + allMatched( "](){([])}" ) ); //false
	  System.out.println("(){([])}( :" + allMatched( "(){([])}(" ) ); //false
	  System.out.println("()[[]]{{{{((([])))}}}} : " + allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	  System.out.println(" : " + allMatched("")); //true
	  System.out.println("{[]({[]})} :" + allMatched("{[]({[]})}")); //true
	  System.out.println("{(}) :" + allMatched("{(})")); //false
	  
    }
    
}//end class LatKtS
