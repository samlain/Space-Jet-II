package main.element;

import main.GameRun;
import main.tools.GameTool;

import java.awt.*;

public class Enemy2 extends GameBase{
    //set health
    int health = 3;
    public Enemy2() {
        super();
    }

    public Enemy2(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        super(imgs, width, height, x_value, y_value, speed, gameWindow);
    }

    public Enemy2(Image imgs, int x_value, int y_value, double speed) {
        super(imgs, x_value, y_value, speed);
    }
    @Override
    public void DrawItself(Graphics g) {
        super.DrawItself(g);
        y_value += speed;
        //collied check
        for (Bullet bullet: GameTool.BulletList){
            if (this.getRectangle().intersects(bullet.getRectangle())&&health > 0) {
                bullet.setX_value(-200);
                bullet.setY_value(-200);
                GameTool.RemoveList.add(bullet);
                health--;
            }
            else if (this.getRectangle().intersects(bullet.getRectangle()) && health <= 0){
                bullet.setX_value(-200);
                bullet.setY_value(-200);
                GameTool.RemoveList.add(bullet);
                this.x_value = -200;
                this.y_value = -200;
                GameTool.RemoveList.add(this);
                GameRun.Score++;
            }
        }

        for (Bullet2 bullet2: GameTool.Bullet2List){
            if (this.getRectangle().intersects(bullet2.getRectangle())&&health > 0) {
                bullet2.setX_value(-200);
                bullet2.setY_value(-200);
                GameTool.RemoveList.add(bullet2);
                health -= 3;
            }
            else if (this.getRectangle().intersects(bullet2.getRectangle()) && health <= 0){
                bullet2.setX_value(-200);
                bullet2.setY_value(-200);
                GameTool.RemoveList.add(bullet2);
                this.x_value = -200;
                this.y_value = -200;
                GameTool.RemoveList.add(this);
                GameRun.Score++;
            }
        }

        for (Bullet3 bullet3: GameTool.Bullet3List){
            if (this.getRectangle().intersects(bullet3.getRectangle())&&health > 0) {
                bullet3.setX_value(-200);
                bullet3.setY_value(-200);
                GameTool.RemoveList.add(bullet3);
                health -= 5;
            }
            else if (this.getRectangle().intersects(bullet3.getRectangle()) && health <= 0){
                bullet3.setX_value(-200);
                bullet3.setY_value(-200);
                GameTool.RemoveList.add(bullet3);
                this.x_value = -200;
                this.y_value = -200;
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

