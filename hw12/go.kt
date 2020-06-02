Clara Mohri
APCS2 Pd08
HW12 -- __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-03-01

Q0: 
When I compile Demo.java, I notice that in my working directory not only does the file Demo.class appear, but so does the file Boardasaurus.class. Thus, I tried the command : $ java Boardasaurus. It did not work because there was no main method in Boardasaurus. When I added a main method to Boardasaurus and compiled Demo.java, Boardasaurus became executable. 

Q1: 
Command line arguments are processed as a String array. This is evidenced by the main method's parameter being String[] args, which refers to the parameters input in the terminal. It is also evidenced by the following line in the main method of Demo: 
	n = Integer.parseInt( args[0] ); 
	and, 
       timeDelay = Integer.parseInt( args[1] );
If I run Demo with the call: $ java Demo 10 400, then 10 will be the value of n, and timeDelay will be set to 400. 

Q2: 
If no command line arguments are given, then Demo uses the default values for n and timeDelay. The first two lines of the main method in Demo set default values, seen as : 
    int n = 8; //default board size   
    int timeDelay = 500; //default delay time
The main method will try to set n = Integer.parseInt( args[0] ); and set timeDelay = Integer.parseInt( args[1] ); However, if this does not work and an error occurs, then the exception does not change the values of n or timeDelay.

Q3: 
The purpose of the recursion is to keep going until some random slots have been updated n*n - n times. If there is no recursion, then only one random slot will be assigned a value besides 0, so there will not really be any animation besides this one slot.

Q4:
When I run it, I expect to see random slots within the -1 border change values n*n - n times. Some slots will change values multiple times, whereas some will remain as 0. When the method go calls itself and moves is equal to n*n, that is, the number of slots, then go will stop calling itself, thus ending the animation.

Q5: 
The variable timeDelay is in milliseconds. This means that between every step in the animation, there is a delay of timeDelay ms before the next step is executed. The amount of steps that must be executed is (n*n) -n, since go is called starting with moves = n, and it goes all the way up until moves = n*n, and it increases by one every time. The time to change the value in a slot is constant. Therefore, I expect it to run in the following time: 
    timeDelay * (n*n - n)

Q6: 
ANSI stands for American National Standards Institute. According to ansi.org, 
     "Throughout its history, ANSI has maintained as its primary goal the enhancement of global competitiveness of U.S. business and the American quality of life by promoting and facilitating voluntary consensus standards and conformity assessment systems and promoting their integrity. The Institute represents the interests of its nearly 1,000 company, organization, government agency, institutional and international members through its office in New York City, and its headquarters in Washington, D.C."
ANSI seems to set universally accepted standards for things such as the meaning of certain sequences of characters.
The ASCII character set is part of the ANSI character set, and ASCII characters (I think?) characters that computers can understand and work with.

Q7: 
Because I did not understand the meaning of the ANSI codes, I thought that perhaps a new board would be printed out for every step.Furthermore, upon observing that there were two classes in Demo.java, I was unsure whether the code would compile or run, since this was something that I had never seen before and I found myself a little skeptical. Besides this, my observations matched my expectations.

Q8: 
I might adapt this framework to animate a probing for a Knight's Tour by having an array of 0's, and every time I placed a knight on a slot in the array, then I would mark this slot as 1. Then, I could create a method that checks if a knight can be placed on a certain spot based on whether this certain spot has as value 0 or 1. Similarly to the go method, I could keep calling a certain method until a sort of instance variable called moves reached the number of slots on the board, n*n. 

Knight's Tour Latest Algo: 
1. Begin at the top left of the board
2. Place knight at one of the 8 available spots. 
   Idea: A series of if statements could go through the possible moves to see where a knight can be placed.
Continue until: 
a. All spots have a knight
b. A knight has no available spots for the next knight:
   - Remove this knight, and go back to step 2.