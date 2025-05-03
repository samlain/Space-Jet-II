package main.element;

import main.GameRun;
import main.tools.GameTool;

import java.awt.*;

public class Enemy1 extends GameBase {
    public Enemy1() {
        super();
    }

    public Enemy1(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        super(imgs, width, height, x_value, y_value, speed, gameWindow);
    }

    public Enemy1(Image imgs, int x_value, int y_value, double speed) {
        super(imgs, x_value, y_value, speed);
    }
    @Override
    public void DrawItself(Graphics g) {
        super.DrawItself(g);
        // controlling the enemy movements
        int y_speed = 1;
        y_value += y_speed;
        if (y_value > 650 || y_value < 0){
            y_speed = -y_speed;
            y_value += y_speed*2;
        }
        x_value += speed;
        if (x_value > 600 || x_value < 0) {
            speed = -speed;
            x_value += speed * 2;
        }
        //collision check for bullet1
        for (Bullet bullet: GameTool.BulletList){
            if (this.getRectangle().intersects(bullet.getRectangle())){
                bullet.setX_value(-200);
                bullet.setY_value(-200);
                this.setX_value(-200);
                this.setY_value(-200);
                GameTool.RemoveList.add(bullet);
                GameTool.RemoveList.add(this);
                GameRun.Score++;
            }
        }
        //check for bullet2
        for (Bullet2 bullet2: GameTool.Bullet2List){
            if (this.getRectangle().intersects(bullet2.getRectangle())){
                bullet2.setX_value(-200);
                bullet2.setY_value(-200);
                this.setX_value(-200);
                this.setY_value(-200);
                GameTool.RemoveList.add(bullet2);
                GameTool.RemoveList.add(this);
                GameRun.Score++;
            }
        }
        //check for bullet3
        for (Bullet3 bullet3: GameTool.Bullet3List){
            if (this.getRectangle().intersects(bullet3.getRectangle())){
                bullet3.setX_value(-200);
                bullet3.setY_value(-200);
                this.setX_value(-200);
                this.setY_value(-200);
                GameTool.RemoveList.add(bullet3);
                GameTool.RemoveList.add(this);
                GameRun.Score++;
            }
        }
        if (this.y_value > 1000){
            GameTool.RemoveList.add(this);
        }
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
