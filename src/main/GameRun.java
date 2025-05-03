package main;
import main.element.*;
import main.tools.GameTool;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameRun extends JFrame {
    //about the Game states, 0 is not start yet
    // 1 playing
    // 2 pause
    // 3 Fail
    // 4 Win!!!
    public static int state = 0;
    Background background = new Background(GameTool.BackgroundImg,0,0,5);
    Jet jet = new Jet(GameTool.PlayerShip,55,54,290,900,5,this);
    Image UnderImg = null;
    int PlayerBulletCount = 1;
    int EnemyAppearCount = 1;
    int EnemyBulletCount = 1;
    int MiniBossCount = 1;
    MiniBoss1 miniBoss1 = new MiniBoss1(GameTool.Miniboss1Img,175,219,100,40, 2,this);
    MiniBoss2 miniBoss2 = new MiniBoss2(GameTool.Miniboss2Img,200,188,200,150,2,this);

    int FinalBossCount;
    public static int Score = 0;
    public void GameWindow(){
        //set visible
        this.setVisible(true);
        //set the windowsize
        this.setSize(640,1000);
        //set the position for game window to make it be the middle of our screen
        this.setLocationRelativeTo(null);
        //set title
        this.setTitle("SpaceJet: II");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameTool.GameBaseList.add(background);
        GameTool.GameBaseList.add(jet);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                // use if statements to change the game state from 0 to 1 if player press any key
                // except function key
                if (e.getKeyChar()!= KeyEvent.CHAR_UNDEFINED && state == 0) {
                    state = 1;
                }
            }
        });
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==32){
                    if(state==1){
                        state=2;
                    } else if (state==2) {
                        state=1;
                    }
                }
            }
        });
        while (true){
            // controlling the enemy and bullet appearing
            Create_Many();
            repaint();
            try {
                // use sleep to reduce the frequency
                Thread.sleep(15);
            }
            catch (Exception e){
                e.printStackTrace( );
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        // here we use double buffers to solve the splash screen problems
        if (UnderImg == null){
            UnderImg = createImage(640,1000);
        }
        Graphics FixImg =UnderImg.getGraphics();
        FixImg.fillRect(0,0,640,1000);

        if (state == 0){
            // the state is 0, we need to press any key to start, then the state change to 1
            FixImg.drawImage(GameTool.BackgroundImg,0,0,null);
            FixImg.drawImage(GameTool.PlayerShip,290,900,null);
            FixImg.setColor(Color.BLACK);
            FixImg.setFont(new Font("Times new roman",Font.ITALIC, 40));
            FixImg.drawString("Press any key to start the game",90,500);
        }
        if (state == 1){
            // when state is 1, game start, the code is start to print things
            for (int i = 0; i < GameTool.GameBaseList.size()-1; i++) {
                GameTool.GameBaseList.get(i).DrawItself(FixImg);
            }
            // this remove list is for remove all of out-of-bounds items
            GameTool.GameBaseList.removeAll(GameTool.RemoveList);
            PlayerBulletCount ++;
            EnemyAppearCount ++;
            EnemyBulletCount ++;
            MiniBossCount ++;
        }
        if (state == 2){
            FixImg.drawImage(GameTool.BackgroundImg,0,0,null);
            GameTool.PrintWords(FixImg,"GAME PAUSE",Color.BLACK,90,40,500);

        }
        if (state == 3){
            FixImg.drawImage(GameTool.BackgroundImg,0,0,null);
            GameTool.PrintWords(FixImg,"GAME-OVER :(",Color.BLACK,90,10,500);
        }
        if (state == 4){
            FixImg.drawImage(GameTool.BackgroundImg,0,0,null);
            GameTool.PrintWords(FixImg,"YOU ARE THE WINNER!",Color.BLACK,80,0,500);
        }
        GameTool.PrintWords(FixImg,"SCORE: " + Score,Color.BLACK,40,40,80);
        g.drawImage(UnderImg,0,0,null);
    }
    public void Create_Many(){
        if (PlayerBulletCount % 15 == 0) {
            if (jet.Giftcount == 0) {
                GameTool.BulletList.add(new Bullet(GameTool.PlayerBulletImg, 6, 27, jet.getX_value() + 25, jet.getY_value() - 20, 15, this));
                GameTool.GameBaseList.add(GameTool.BulletList.get(GameTool.BulletList.size() - 1));
            }
            if (jet.Giftcount == 1){
                GameTool.Bullet2List.add(new Bullet2(GameTool.PlayerBullet2Img, 38, 40, jet.getX_value() + 25, jet.getY_value() - 20, 15, this));
                GameTool.GameBaseList.add(GameTool.Bullet2List.get(GameTool.Bullet2List.size() - 1));
            }
            if (jet.Giftcount == 2){
                GameTool.Bullet3List.add(new Bullet3(GameTool.PlayerBullet3Img, 67, 88, jet.getX_value() + 25, jet.getY_value() - 20, 15, this));
                GameTool.GameBaseList.add(GameTool.Bullet3List.get(GameTool.Bullet3List.size() - 1));

            }
        }
        if (EnemyAppearCount % 35 == 0){
            GameTool.Enemylist.add(new Enemy1(GameTool.Enemy1Img,45,45,(int) ((Math.random() * 10) * 64) , 0, 3, this));
            GameTool.GameBaseList.add(GameTool.Enemylist.get(GameTool.Enemylist.size()-1));
        }
        if (EnemyBulletCount % 40 == 0){
            if (EnemyAppearCount % 100 == 0){
                GameTool.Enemylist2.add(new Enemy2(GameTool.Enemy2Img,60,60,(int) ((Math.random() * 10) * 64) , 0, 2, this));
                GameTool.GameBaseList.add(GameTool.Enemylist2.get(GameTool.Enemylist2.size()-1));
            }
            if (GameTool.Enemylist2.size()>0){
                int x = (GameTool.Enemylist2.get(GameTool.Enemylist2.size()-1).getX_value());
                int y = (GameTool.Enemylist2.get(GameTool.Enemylist2.size()-1).getY_value());
                GameTool.Enemybullet2.add(new Enemy2Bullet(GameTool.Enemy2Bullet,26,27,x+12, y+20,5,this));
                GameTool.GameBaseList.add(GameTool.Enemybullet2.get(GameTool.Enemybullet2.size()-1));

            }
        }
        if (MiniBossCount == 700 && (!GameTool.GameBaseList.contains(miniBoss1))){
            GameTool.GameBaseList.add(miniBoss1);
        }
        if(EnemyBulletCount % 20 == 0) {
            if (GameTool.GameBaseList.contains(miniBoss1)) {
                GameTool.MiniBoss1BulletList.add(new MiniBoss1Bullet(GameTool.MiniBoss1BulletImg, 42, 42, miniBoss1.getX_value() + 87, miniBoss1.getY_value() + 110, 4, this));
                GameTool.GameBaseList.add(GameTool.MiniBoss1BulletList.get(GameTool.MiniBoss1BulletList.size() - 1));
            }
        }
        if (MiniBossCount == 1200 && (!GameTool.GameBaseList.contains(miniBoss2))){
            GameTool.GameBaseList.add(miniBoss2);
        }
        if(EnemyBulletCount % 60 == 0) {
            if (GameTool.GameBaseList.contains(miniBoss2)) {
                GameTool.MiniBoss2BulletList.add(new MiniBoss2Bullet(GameTool.MiniBoss2BulletImg, 80, 60, miniBoss2.getX_value() + 87, miniBoss2.getY_value() + 110, 8, this));
                GameTool.GameBaseList.add(GameTool.MiniBoss2BulletList.get(GameTool.MiniBoss2BulletList.size() - 1));
            }
        }

    }

    public static void main(String[] args) {
        GameRun GameRun = new GameRun();
        GameRun.GameWindow();
    }
}
