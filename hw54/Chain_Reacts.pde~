float numBalls = random(25, 35);
Ball[] list = new Ball[(int)numBalls];

void setup() {
  size(600, 600);
  background(0);
  for (int i = 0; i < (int)numBalls; i++) {
    list[i] = new Ball();
    fill(color(random(256), random(256), random(256)));
  }
}


void draw() {
  clear();
  fill(0, 0, 0);
  for (int i = 0; i < (int) numBalls; i++) {
    list[i].update();
    
  }
}
