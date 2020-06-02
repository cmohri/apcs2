/*
Clara Mohri, Rohan Ahammed, Soojin Choi
 APCS2 Pd08
 HW53-- All That Bouncin’
 2018-05-24
 */
Ball clicked;
float numBalls = random(25, 35);//randomly chooses a num of balls from 25-35
Ball[] list = new Ball[(int)numBalls];//creates an array to hold these balls.
//array is necessary to be able to reference the Balls w/o creating 25-35 references

void setup() {
  size(600, 600);//sets up 600x600
  background(0);//black background
  for (int i = 0; i < (int)numBalls; i++) {//stores the object in the array
    list[i] = new Ball((int)random(600), (int)random(600));
    fill(color(random(256), random(256), random(256)));//colors the ball a random color
  }
}


void draw() {
  clear();//get rid of the old position
  for (int i = 0; i < (int) numBalls; i++) {//for every ball
    list[i].update();//update aka move
  }
  if (clicked != null && clicked.getState() != clicked.DEAD){
    clicked.grow();
  }
}
void mouseClicked() {
  clicked = new Ball(mouseX, mouseY);
  
}
