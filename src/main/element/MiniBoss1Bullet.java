package main.element;

import main.GameRun;
import main.tools.GameTool;

import java.awt.*;

public class MiniBoss1Bullet extends GameBase{
    public MiniBoss1Bullet() {
        super();
    }

    public MiniBoss1Bullet(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        super(imgs, width, height, x_value, y_value, speed, gameWindow);
    }

    public MiniBoss1Bullet(Image imgs, int x_value, int y_value, double speed) {
        super(imgs, x_value, y_value, speed);
    }

    @Override
    public void DrawItself(Graphics g) {
        super.DrawItself(g);
        y_value += speed;

        if (this.y_value > 1000){
            GameTool.RemoveList.add(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
