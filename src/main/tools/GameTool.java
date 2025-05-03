package main.tools;
import main.element.*;

import java.awt.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class GameTool {
    //get background image
    public static Image BackgroundImg = Toolkit.getDefaultToolkit().getImage("imgs/pink3.jpg");
    //get player spaceship image
    public static Image PlayerShip = Toolkit.getDefaultToolkit().getImage("imgs/jet.png");
    public static Image PlayerBulletImg = Toolkit.getDefaultToolkit().getImage("imgs/bullet1.png");
    public static Image Enemy1Img = Toolkit.getDefaultToolkit().getImage("imgs/enemy1.png");
    public static Image Enemy2Img = Toolkit.getDefaultToolkit().getImage("imgs/enemy2.png");
    public static Image Enemy2Bullet = Toolkit.getDefaultToolkit().getImage("imgs/Enemybullet1.png");
    public static Image Miniboss1Img = Toolkit.getDefaultToolkit().getImage("imgs/miniboss1.png");
    public static Image MiniBoss1BulletImg= Toolkit.getDefaultToolkit().getImage("imgs/Enemybullet2.png");
    public static Image Miniboss2Img = Toolkit.getDefaultToolkit().getImage("imgs/miniboss2.png");
    public static Image MiniBoss2BulletImg= Toolkit.getDefaultToolkit().getImage("imgs/Enemybullet3.png");
    public static Image GiftImg = Toolkit.getDefaultToolkit().getImage("imgs/gift.png");
    public static Image PlayerBullet2Img = Toolkit.getDefaultToolkit().getImage("imgs/bullet2.png");
    public static Image PlayerBullet3Img = Toolkit.getDefaultToolkit().getImage("imgs/bullet3.png");

    public  static List <Enemy1> Enemylist = new ArrayList<>();
    public  static List <Enemy2> Enemylist2 = new ArrayList<>();
    public static List <Bullet> BulletList = new ArrayList<>();
    public static List <Bullet2> Bullet2List = new ArrayList<>();
    public static List <Bullet3> Bullet3List = new ArrayList<>();
    public static List <GameBase> GameBaseList = new ArrayList<>();
    public static List <GameBase> RemoveList = new ArrayList<>();
    public static List <Enemy2Bullet> Enemybullet2 = new ArrayList<>();
    public static List<MiniBoss1Bullet> MiniBoss1BulletList=new ArrayList<>();
    public static List<MiniBoss2Bullet> MiniBoss2BulletList=new ArrayList<>();
    public static List<Gift> GiftList = new ArrayList<>();
    //print words on the game window
    public static void PrintWords(Graphics FixImg,String str,Color color,int size, int x_value,int y_value){
        FixImg.setColor(color);
        FixImg.setFont(new Font("Times new roman",Font.ITALIC,size));
        FixImg.drawString(str,x_value,y_value);
    }

}
