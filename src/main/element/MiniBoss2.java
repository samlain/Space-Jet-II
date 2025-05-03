package main.element;

import main.GameRun;
import main.tools.GameTool;

import java.awt.*;

public class MiniBoss2 extends GameBase{
    int health = 30;
    public MiniBoss2() {
        super();
    }

    public MiniBoss2(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        super(imgs, width, height, x_value, y_value, speed, gameWindow);
    }

    public MiniBoss2(Image imgs, int x_value, int y_value, double speed) {
        super(imgs, x_value, y_value, speed);
    }

    @Override
    public void DrawItself(Graphics g) {
        super.DrawItself(g);
        if(y_value < 300){
            y_value += 2;
        }
        else{
            x_value += speed;
            if (x_value > 400|| x_value <100){
                speed = -speed;
            }
        }
        for (Bullet bullet: GameTool.BulletList){
            if (this.getRectangle().intersects(bullet.getRectangle())&&health > 0) {
                bullet.setX_value(-200);
                bullet.setY_value(-200);
                GameTool.RemoveList.add(bullet);
                health--;
            }
            else if (this.getRectangle().intersects(bullet.getRectangle()) && health <= 0){
                Gift gift = new Gift(320, 700);
                GameTool.GiftList.add(gift);
                GameTool.GameBaseList.addAll(GameTool.GiftList);
                bullet.setX_value(-200);
                bullet.setY_value(-200);
                GameTool.RemoveList.add(bullet);
                this.x_value = -200;
                this.y_value = -200;
                GameTool.RemoveList.add(this);
                GameRun.Score += 100 ;
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
                Gift gift = new Gift(320, 700);
                GameTool.GiftList.add(gift);
                GameTool.GameBaseList.addAll(GameTool.GiftList);
                bullet2.setX_value(-200);
                bullet2.setY_value(-200);
                GameTool.RemoveList.add(bullet2);
                this.x_value = -200;
                this.y_value = -200;
                GameTool.RemoveList.add(this);
                GameRun.Score += 50;
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
                Gift gift = new Gift(320, 700);
                GameTool.GiftList.add(gift);
                GameTool.GameBaseList.addAll(GameTool.GiftList);
                bullet3.setX_value(-200);
                bullet3.setY_value(-200);
                GameTool.RemoveList.add(bullet3);
                this.x_value = -200;
                this.y_value = -200;
                GameTool.RemoveList.add(this);
                GameRun.Score -= 1000;
            }
        }

        }
    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
