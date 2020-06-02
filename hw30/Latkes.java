/*
Clara Mohri
APCS2 Pd08
HW30 -- Stacks on Stacks on Stacks on Stacks…
2018-04-10
*/

/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/

public class Latkes
{
    private String [] _stack;
    private int _stackSize;
    
    //constructor
    public Latkes( int size )
    {
	 _stack = new String[size];	
	_stackSize = 0;
    }
    
    //means of insertion
    //adds String s to the top of stack (this will mean the beginning of _stack)
    public void push( String s )
    {
	if (isFull())
	    return;
	    //throw new StackOverflowError();
	for (int i = _stackSize - 1 ; i >= 0; i--){
	    _stack[i+1] = _stack[i];
	}
	_stack[0] = s;
	_stackSize += 1;
    }
    
    //means of removal
    public String pop( )
    {
	if (isEmpty()){
	    return "nothing to return";
	    //throw new StackOverflowError();
	}
	String retStr = _stack[0];
	String[] holder = _stack;
	for (int i = 1; i < _stackSize; i++){
	    _stack[i-1] = holder[i];
	}	
	_stackSize -= 1;
	return retStr;
    }
    
    //chk for emptiness
    public boolean isEmpty()
    {
	return _stackSize == 0;
    }
    
    //chk for fullness (what does it mean to be "full"?)
    //
    public boolean isFull()
    {
	return _stackSize == _stack.length;
    }
    
    
    //main method for testing
    public static void main( String[] args )
    {
	
	  Latkes tastyStack = new Latkes(10);

	  tastyStack.push("aoo");
	  System.out.println("tastyStack looks like: " );
	  for (String s: tastyStack._stack)
	      System.out.print(s + " ");
	  System.out.println("\tsize: " + tastyStack._stackSize);
	  System.out.println();

	  tastyStack.push("boo");
	  System.out.println("tastyStack looks like: " );
	  for (String s: tastyStack._stack)
	      System.out.print(s + " ");
	  System.out.println("\tsize: " + tastyStack._stackSize);
	  tastyStack.push("coo");
	  tastyStack.push("doo");


	  tastyStack.push("eoo");
	  tastyStack.push("foo");
	  tastyStack.push("goo");
	  tastyStack.push("hoo");
	  tastyStack.push("ioo");
	  tastyStack.push("joo");
	  tastyStack.push("coocoo");//now tastyStack is full. 
	  tastyStack.push("cachoo");
	  
	  System.out.println("\nAnd several rounds later, tastyStack looks like: ");
	  for (String s: tastyStack._stack)
              System.out.print(s + " ");
	  
	  System.out.println("\nRemoving...");
	  //joo
	  System.out.println( tastyStack.pop() );
	  //ioo
	  System.out.println( tastyStack.pop() );
	  //hoo
	  System.out.println( tastyStack.pop() );
	  //goo
	  System.out.println( tastyStack.pop() );
	  //foo
	  System.out.println( tastyStack.pop() );
	  //eoo
	  System.out.println( tastyStack.pop() );
	  //doo
	  System.out.println( tastyStack.pop() );
	  //coo
	  System.out.println( tastyStack.pop() );
	  //boo
	  System.out.println( tastyStack.pop() );
	  //aoo
	  System.out.println( tastyStack.pop() );
	  //error
	  System.out.println( tastyStack.pop() );
	  //error
	  System.out.println( tastyStack.pop() );	  
	  //stack empty by now; SOP(null)
	  System.out.println( tastyStack.pop() );
	

	  System.out.println("\nA new, tastier, Latkes:");
	  Latkes tastierStack = new Latkes(4);
	  tastierStack.push("pancake");
	  tastierStack.push("syrup");
	  tastierStack.push("whipped");
	  tastierStack.push("cream");
	  
	  for (int i = 0; i < 4; i++){
	      System.out.println(tastierStack.pop());
	  }


    }//end main()
    
}//end class Latkes
