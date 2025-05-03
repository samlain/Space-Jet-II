package main.element;

import main.GameRun;

import java.awt.*;

public class Background extends GameBase{
    public Background() {
        super();
    }

    public Background(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        super(imgs, width, height, x_value, y_value, speed, gameWindow);
    }

    public Background(Image imgs, int x_value, int y_value, double speed) {
        super(imgs, x_value, y_value, speed);
    }

    @Override
    public void DrawItself(Graphics g) {

        super.DrawItself(g);
        y_value = 0;
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
