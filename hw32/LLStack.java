/*
Clara Mohri
APCS2 Pd08
HW32 -- Leon Leonwood Stack 
2018-04-12
*/

import java.util.LinkedList;

/**
Class LLStack<PANCAKE> represents a Stack, with _stack stored as a LinkedList
**/

public class LLStack<PANCAKE> implements Stack<PANCAKE>{

    //instance vars
    private LinkedList<PANCAKE> _stack;
    private int _stackSize;

    //constructor initializes _stack, and _stackSize to 0
    //LinkedLists cannot be initiliazed with a specific size
    public LLStack (){
	_stack = new LinkedList();
	_stackSize = 0;
    }

    //Return true if this stack is empty, otherwise false.   
    //running time : O(1)                                    
    public boolean isEmpty(){
        return _stackSize == 0;
    }

    //Return top element of stack without popping it.
    //Running time: O(n)
    public PANCAKE peek(){
	//PANCAKE a =  _stack.peekLast(); //from LinkedList API
	//question: what is the difference between peekLast() and getLast() ? 	
	
	PANCAKE a = _stack.get(_stackSize - 1);
	
	return a;
    }

    //Pop and return top element of stack.
    //Running time: O(n)
    public PANCAKE pop(){
	if (isEmpty())
	    return null;
	PANCAKE retPan = peek();
	_stack.remove(_stackSize - 1);
	_stackSize -= 1;
	return retPan;
    }

    //Push an element onto top of this stack.
    //Running time: O(n)
    public void push (PANCAKE x){
	_stack.addLast(x);
	_stackSize += 1;
    }

    public static void main (String[] args){
	LLStack<String> a = new LLStack<String>();
	System.out.println("a: " + a._stack);
	System.out.println("isEmpty() : "+a.isEmpty());
	System.out.println(a.pop());
	a.push("hello");
	a.push("world");
	a.push("nice");
	a.push("to");
	a.push("meet");
	a.push("you");
	System.out.println(a._stack);
	System.out.println(a.pop());
	System.out.println(a._stack);
	while (! a.isEmpty())
	    a.pop();
	System.out.println(a._stack);
    }
}