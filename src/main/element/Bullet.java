package main.element;

import main.GameRun;
import main.tools.GameTool;

import java.awt.*;

public class Bullet extends GameBase{
    public Bullet() {
        super();
    }

    public Bullet(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        super(imgs, width, height, x_value, y_value, speed, gameWindow);
    }

    public Bullet(Image imgs, int x_value, int y_value, double speed) {
        super(imgs, x_value, y_value, speed);
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
