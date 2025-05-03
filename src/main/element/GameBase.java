package main.element;

import main.GameRun;

import java.awt.*;

public class GameBase {
    // define the basic attributes for all subclasses.
    Image imgs;
    int width;
    int height;
    int x_value;
    int y_value;
    double speed;
    //game_window
    GameRun GameWindow;
    public Image getImgs() {
        return imgs;
    }

    public void setImgs(Image imgs) {
        this.imgs = imgs;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX_value() {
        return x_value;
    }

    public void setX_value(int x_value) {
        this.x_value = x_value;
    }

    public int getY_value() {
        return y_value;
    }

    public void setY_value(int y_value) {
        this.y_value = y_value;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameRun getGameWindow() {
        return GameWindow;
    }

    public void setGameWindow(GameRun gameWindow) {
        GameWindow = gameWindow;
    }
    public GameBase(){

    }

    public GameBase(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        this.imgs = imgs;
        this.width = width;
        this.height = height;
        this.x_value = x_value;
        this.y_value = y_value;
        this.speed = speed;
        GameWindow = gameWindow;
    }

    public GameBase(Image imgs, int x_value, int y_value, double speed) {
        this.imgs = imgs;
        this.x_value = x_value;
        this.y_value = y_value;
        this.speed = speed;
    }
    public GameBase(int x_value,int y_value){
        this.x_value = x_value;
        this.y_value = y_value;
    }

    public void DrawItself(Graphics g){
        g.drawImage(imgs,x_value,y_value,null);
    }
    public Rectangle getRectangle(){
        return new Rectangle(x_value,y_value,width,height);
    }
}
