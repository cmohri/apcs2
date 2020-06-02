Ball clicked;
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
    if (list[i].getState() == 0) {
      list[i].move();
    } 
    if (list[i].getState() == 1 || list[i].getState() == 2) {
      list[i].grow();
      for (int x = 0; x < (int) numBalls; x++) {
        if (list[x].isColliding(list[i])) {
          list[x].grow();
        }
      }
    }
    if (clicked != null) {
      if (list[i].isColliding(clicked)) {
        list[i].grow();
      }
    }
  }
  if (clicked != null && clicked.getState() != clicked.DEAD) {
    clicked.grow();
  }
}

void mouseClicked() {
  clicked = new Ball(mouseX, mouseY);
}
