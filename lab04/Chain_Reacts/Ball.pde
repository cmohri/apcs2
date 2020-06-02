class Ball {

  int state;
  final static int MOVING = 0;
  final static int GROWING = 1;
  final static int SHRINKING = 2;
  final static int DEAD = 3;

  float rad = 25;
  float x = random(25, 575);
  float y = random(50, 550);
  float dx = random(3);
  float dy = random(3);

  float numr = random(256);
  float numg = random(256);
  float numb = random(256);
  color c = color(numr, numg, numb);

  final float CHANGE_FACTOR = .25;
  final float MAX_RADIUS = 100;

  Ball() {
    fill(c);
    ellipse(x, y, rad, rad);
    state = 0; //moving
  }

  Ball (int xcor, int ycor) {
    fill(c);
    ellipse(xcor, ycor, rad, rad);
    x = xcor;
    y = ycor;
    state = 1; //growing
  }

  int getState() {
    return state;
  }

  void move() {
    if (x <= (rad/2) || x >= (600-(rad/2))) {
      dx = -1 * dx;
    }
    if (y <= (rad/2) || y >= (600-(rad/2))) {
      dy = -1 *dy;
    }
    x += dx;
    y += dy;
    fill(c);
    ellipse(x, y, rad, rad);
    
    state = 0;
  }

  void grow() {
    if (rad == 0) {
      println("dead");
      state = 3; //dead
    } else if (rad >= MAX_RADIUS) {
      println("now shrinking");
      state = SHRINKING;
      rad -= CHANGE_FACTOR;
      fill(c);
      ellipse(x, y, rad, rad);
      
    } else if (state == GROWING) {
      println("growing");
      rad += CHANGE_FACTOR;      
      fill(c);
      ellipse(x, y, rad, rad);
      
    }
    if (state == SHRINKING) {
      println("shrinking");
      rad -= CHANGE_FACTOR;
      fill(c);
      ellipse(x, y, rad, rad);
      
    }
    if (state == MOVING) {
      state = GROWING;
      rad += CHANGE_FACTOR;
      fill(c);
      ellipse(x, y, rad, rad);
      
    }
  }

  boolean isColliding(Ball other) {
    return ( (!other.equals(this)) &&
      dist(x, y, other.x, other.y) <= ((rad + other.rad)/2) && 
      (other.getState() == 2 || other.getState() == 1) &&
      (state != 3));
  }
}
