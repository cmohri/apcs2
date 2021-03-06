import java.util.ArrayList;
import java.util.List;
public class ALStack<PANCAKE> implements Stack<PANCAKE>{

    //instance vars
    private List<PANCAKE> _stack;
    private int _stackSize;

    //Constructor initializes _stack to input size, and _stackSize to 0
    public ALStack (){
	_stack = new ArrayList();
	_stackSize = 0;
    }

    //Return true if this stack is empty, otherwise false.
    //running time : O(1)
    public boolean isEmpty(){
	return _stackSize == 0;
    }

    //Return top element of stack without popping it.  
    //Running time : O(1)
    public PANCAKE peek(){
	return _stack.get(_stackSize - 1);
    }

    //Pop and return top element of stack.
    //Running time : O(1)
    public PANCAKE pop(){
	if (isEmpty())
	    return null;
	PANCAKE retPan = peek();
	_stack.remove(_stackSize- 1);
	_stackSize -= 1;
	return retPan;
    }

    //Push an element onto top of this stack.    
    //Running time : O(1)
    public void push (PANCAKE x){
	_stack.add(x);
	_stackSize += 1;
    }

    public List<PANCAKE> getStack(){
	return _stack;
    }

    public static void main (String[] args){
	ALStack<String> a = new ALStack<String>();
	System.out.println("a: " + a._stack);
	System.out.println("isEmpty() : "+a.isEmpty());
	System.out.println(a.pop());
       
	a.push("hello");
	a.push("world");
	a.push("nice");
	a.push("to");
	a.push("meet");
	a.push("you");
	System.out.println(a);
	System.out.println(a._stack);
	System.out.println(a.pop());
	List<String> b= a.getStack();
	System.out.println(b);
    }


}