package main.element;

import main.GameRun;
import main.tools.GameTool;

import java.awt.*;

public class Gift extends GameBase{
    public Gift() {
        super();
    }

    public Gift(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        super(imgs, width, height, x_value, y_value, speed, gameWindow);
    }

    public Gift(Image imgs, int x_value, int y_value, double speed) {
        super(imgs, x_value, y_value, speed);
    }

    public Gift(int x_value, int y_value) {
        super(x_value, y_value);
    }

    @Override
    public void DrawItself(Graphics g) {
        super.imgs = GameTool.GiftImg;
        super.height = 80;
        super.width = 54;
        super.DrawItself(g);
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
