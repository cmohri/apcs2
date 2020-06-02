/*
Clara Mohri
APCS2 Pd08
HW33 -- What a Racket
2018-04-13
*/
 
/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Split the input expression by spaces, into a String[] array
 *   2. Push elements to a stack until a closing parenthesis is reached
 *   3. Go back until the  most recent opening parenthesis
 *   4. Evaluate the expression between the most recent opening parenthesis and current parenthesis 
 *      - Keep popping off the stack and onto a new stack until the operation is reached    
 *   5. Push the evaluation onto the stack
 *   6. Once the entire array of the expression has been iterated through, then return the top of the main stack
 * STACK OF CHOICE: ALStack by Clara Mohri
 * ArrayLists have better running time efficiency when it comes to peeking, and peeking will be used a lot
 ******************************************************/

public class Scheme 
{
    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	String[] exArr = expr.split("\\s");
	Stack<String> stArr = new ALStack<String>();
	Stack<String> b = new ALStack<String>();
	for (int i = exArr.length - 1; i >= 0; i--){
	    stArr.push(exArr[i]);
	    if (exArr[i].equals("(")){
		stArr.pop();
		String opS = stArr.peek();
		int op = opID(opS);
		stArr.pop();
		b = new ALStack<String>();
		//push everything that you pop from stArr
		while (! stArr.peek().equals(")")){
		    b.push(stArr.pop());
		}
		String eval = unload(op, b);
		stArr.pop();
		stArr.push(eval);
	    }
	}
	return stArr.peek();
    }//end evaluate()
    
    //identifies operation
    public static int opID(String op){
	if (op.equals("+")) return 1;
	else if (op.equals("-")) return 2;
	else return 3;
    }
	    
    
    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
	Integer retVal=0;
	//addition:
	if (op == 1){
	    retVal = 0;
	    while (! numbers.isEmpty()){
		if (isNumber(numbers.peek())) 
		    retVal += Integer.parseInt(numbers.pop());
	    }
	}
	//subtraction:
	else if (op == 2){
	    Stack<String> reverse = new ALStack<String>();	    
	    while (! numbers.isEmpty())
		reverse.push(numbers.pop());
	    if (isNumber(reverse.peek()))
		retVal = Integer.parseInt(reverse.pop());
	    while (! reverse.isEmpty()){
		if (isNumber(reverse.peek()))
		    retVal -= Integer.parseInt(reverse.pop());
	    }
	}
	//multiplication:
	else{
	    retVal = 1;
	    while (! numbers.isEmpty()){
		if (isNumber(numbers.peek()))
		    retVal *= Integer.parseInt(numbers.pop());
	    }
	}
	String retStr = retVal.toString();
	return retStr;
    }//end unload()
    
        
    //check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
	try {
	    Integer.parseInt(s);
	    return true;
	}
	catch( NumberFormatException e ) {
	    return false;
	}
    }
       
    //main method for testing
    public static void main( String[] args )
    {
	

	  String zoo1 = "( + 4 3 )";
	  System.out.println(zoo1);
	  System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	  //...7

	  String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	  System.out.println(zoo2);
	  System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	  //...17

	  String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	  System.out.println(zoo3);
	  System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	  //...29

	  String zoo4 = "( - 1 2 3 )";
	  System.out.println(zoo4);
	  System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	  //...-4
	  
	  String zoo5 = "( + ( - 1 3 ) 4 6 ( * 5 2 ) )";
	  System.out.println(zoo5);
	  System.out.println("zoo5 eval'd: " + evaluate(zoo5) );
	  //...-18

	  String zoo6 = "( + ( + 1 ) )";
	  System.out.println(zoo6);
	  System.out.println("zoo6 eval'd: " + evaluate(zoo6) );
	  
    }//main
    
}//end class Scheme
