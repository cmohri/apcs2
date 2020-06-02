/*
Clara Mohri and Rohan Ahammed
APCS2 Pd08
HW52 -- Grow & Shrink
2018-05-23
*/

//sets up black background, image dimensions are 500x500
void setup() {
  size(500, 500);
  background(color(0, 0, 0));
}

//variables that will be accessed and updated by draw() and mouseClicked()
int value = 0;
int size = 10;
int x;
int y;

//if mouse is clicked once, then a circle will appear at this spot and grow
//if the mouse is clicked a second time, then the circle will shrink until it reaches a size of 0
//when size reaches 0, then draw() will stop running
void draw() {
  //upon first click:
  if (value == 1) {
    ellipse(x, y, size, size);
    fill(color(113, 12, 1));
    size += 1;
    
  }
  //upon second click:
  else if (value > 1) {
    ellipse(x, y, size, size);
    size -= 1;
    //end if size has reached 0. 
    //if not ended, then the circle will appear to grow again
    if (size < 0) noLoop();
  }
}

//updates value for draw() to use
//sets initial x and y coordinates of circle
void mouseClicked() {
  if (value == 0){
    x = mouseX;
    y = mouseY;
  }
  value += 1;
}
