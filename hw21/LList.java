/*
Clara Mohri
APCS2 Pd08
2018-03-19
HW21c -- Rockin' Through the Night
*/

public class LList implements List{
    
    private LLNode[] list;
    private int size;

    //constructor allows user to create list of certain size
    public LList(int i){
	size = i;
	//System.out.print("uh");
	list = new LLNode[i];
	for (int j = 0; j < size; j++){
	  list[j] = new LLNode();
	  //System.out.print(j);
	}
    }
    
    //add node to list, containing input String as its data
    public boolean add (String x){
	size += 1;
	LLNode adding = new LLNode();
	adding.setCargo(x);
	LLNode[] old = list;
	LLNode[] list = new LLNode[size];
	for (int i = 0; i < size - 1; i++){
	    list[i] = old[i];
	}
	list[size - 1] = adding;
	return true;
    }

    //return data in element at position i
    public String get (int i){
	return list[i].getCargo();
    }

    //overwrite data in element at position i   
    public String set (int i, String x){
	String errormsg = "Please select index within bounds of list";
	if (i >= size){
	    return errormsg;
	}
	else {
	    //System.out.println("testing");
	    String old = get(i);
	    LLNode set = new LLNode();
	    set.setCargo(x);
	    list[i] = set;
	    return old;
	}
    }    

    //return length of list 
    public int size(){
	return size;
    }

    public static void main (String[] args){
	LList a = new LList(1);
	LLNode b = new LLNode();
	System.out.println(a.get(0));
	a.set(0, "hello");
	System.out.println(a.get(0));
	System.out.println(a.set(2, "hi"));
	System.out.println(a.set(0, "hi"));
	System.out.println(a.get(0));
	System.out.println(a.add("uhh"));
	System.out.println(a.get(0));
    }

}