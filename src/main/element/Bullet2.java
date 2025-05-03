package main.element;

import main.GameRun;
import main.tools.GameTool;

import java.awt.*;

public class Bullet2 extends GameBase {
    public Bullet2() {
        super();
    }

    public Bullet2(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        super(imgs, width, height, x_value, y_value, speed, gameWindow);
    }

    public Bullet2(Image imgs, int x_value, int y_value, double speed) {
        super(imgs, x_value, y_value, speed);
    }

    public Bullet2(int x_value, int y_value) {
        super(x_value, y_value);
    }

    @Override
    public void DrawItself(Graphics g) {
        super.DrawItself(g);
        y_value -= speed;
        if (this.y_value < 50){
            GameTool.RemoveList.add(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
