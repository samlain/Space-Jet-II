package main.element;

import main.GameRun;
import main.tools.GameTool;

import java.awt.*;

public class Enemy2Bullet extends GameBase{
    public Enemy2Bullet() {
        super();
    }

    public Enemy2Bullet(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        super(imgs, width, height, x_value, y_value, speed, gameWindow);
    }

    public Enemy2Bullet(Image imgs, int x_value, int y_value, double speed) {
        super(imgs, x_value, y_value, speed);


    }

    @Override
    public void DrawItself(Graphics g) {
        super.DrawItself(g);
        y_value += speed;
        if (this.y_value > 1000){
            GameTool.RemoveList.add(this);
        }
        for (Bullet bullet: GameTool.BulletList){
            if (this.getRectangle().intersects(bullet.getRectangle())){
                bullet.setX_value(-200);
                bullet.setY_value(-200);
                this.setX_value(-200);
                this.setY_value(-200);
                GameTool.RemoveList.add(bullet);
                GameTool.RemoveList.add(this);
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
            }
        }
    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
