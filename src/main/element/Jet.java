package main.element;

import main.GameRun;
import main.tools.GameTool;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Jet extends GameBase{
    public int Giftcount = 0;
    MiniBoss1 miniBoss1 = new MiniBoss1();
    MiniBoss2 miniBoss2 = new MiniBoss2();
    int health = 5;
    @Override
    public Image getImgs() {
        return super.getImgs();
    }

    public Jet() {
        super();
    }

    public Jet(Image imgs, int width, int height, int x_value, int y_value, double speed, GameRun gameWindow) {
        super(imgs, width, height, x_value, y_value, speed, gameWindow);
        //add the mouse controlling to control the jet moving.
        this.GameWindow.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Jet.super.x_value=e.getX()-20;
                Jet.super.y_value=e.getY()-20;
            }
        });
    }


    public Jet(Image imgs, int x_value, int y_value, double speed) {
        super(imgs, x_value, y_value, speed);
    }

    @Override
    public void DrawItself(Graphics g) {
        // this part controls the appear for the graph
        super.DrawItself(g);
        // check the collision
        for (Enemy1 enemy1: GameTool.Enemylist){
            if (this.getRectangle().intersects(enemy1.getRectangle())){
                enemy1.setX_value(-200);
                enemy1.setY_value(-200);
                this.x_value = -200;
                this.y_value = -200;
                GameTool.RemoveList.add(enemy1);
                GameTool.RemoveList.add(this);
                GameRun.state = 3;
            }
        }

        for (Enemy2 enemy2: GameTool.Enemylist2){
            if (this.getRectangle().intersects(enemy2.getRectangle())){
                enemy2.setX_value(-200);
                enemy2.setY_value(-200);
                this.x_value = -200;
                this.y_value = -200;
                GameTool.RemoveList.add(enemy2);
                GameTool.RemoveList.add(this);
                GameRun.state = 3;
            }
        }

        for (Enemy2Bullet enemy2Bullet: GameTool.Enemybullet2){
            if (this.getRectangle().intersects(enemy2Bullet.getRectangle())){
                enemy2Bullet.setX_value(-200);
                enemy2Bullet.setY_value(-200);
                this.x_value = -200;
                this.y_value = -200;
                GameTool.RemoveList.add(enemy2Bullet);
                GameTool.RemoveList.add(this);
                GameRun.state = 3;
            }
        }
        if(this.getRectangle().intersects(miniBoss1.getRectangle())){
            this.x_value = -200;
            this.y_value = -200;
            GameTool.RemoveList.add(this);
            GameRun.state = 3;
        }
        if(this.getRectangle().intersects(miniBoss2.getRectangle())){
            this.x_value = -200;
            this.y_value = -200;
            GameTool.RemoveList.add(this);
            GameRun.state = 3;
        }
        for (MiniBoss1Bullet miniBoss1Bullet : GameTool.MiniBoss1BulletList) {
            if (this.getRectangle().intersects(miniBoss1Bullet.getRectangle())){
                this.x_value = -200;
                this.y_value = -200;
                GameTool.RemoveList.add(this);
                GameRun.state = 3;
            }
        }
        for (MiniBoss2Bullet miniBoss2Bullet : GameTool.MiniBoss2BulletList) {
            if (this.getRectangle().intersects(miniBoss2Bullet.getRectangle())){
                this.x_value = -200;
                this.y_value = -200;
                GameTool.RemoveList.add(this);
                GameRun.state = 3;
            }

        }
        for (Gift gift: GameTool.GiftList) {
            if (this.getRectangle().intersects(gift.getRectangle())){
                gift.setX_value(-200);
                gift.setY_value(-200);
                GameTool.RemoveList.add(gift);
                Giftcount ++;
            }
        }


    }

    @Override
    public Rectangle getRectangle() {
        return super.getRectangle();
    }
}
