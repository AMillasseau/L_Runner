import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackGround{
    ImageView bg1,bg2,bg3,tbg;

    public BackGround() {
        Image truebackGround = new Image(".\\img\\truebackground.png");
        Image backGround1 = new Image(".\\img\\background0.png");
        Image backGround2 = new Image(".\\img\\background1.png");
        Image backGround3 = new Image(".\\img\\background2.png");
        tbg = new ImageView(truebackGround);
        bg1 = new ImageView(backGround1);
        bg2 = new ImageView(backGround2);
        bg3 = new ImageView(backGround3);
        tbg.setPreserveRatio(true);
        bg1.setPreserveRatio(true);
        bg2.setPreserveRatio(true);
        bg3.setPreserveRatio(true);
        tbg.setFitHeight(312);
        bg1.setFitHeight(312);
        bg2.setFitHeight(312);
        bg3.setFitHeight(312);
        bg2.setX(644);
        bg3.setX(1288);
    }


    public double run(double vitesse) {
        double a=0;
        bg1.setX(bg1.getX()-vitesse);
        bg2.setX(bg2.getX()-vitesse);
        bg3.setX(bg3.getX()-vitesse);
        if (bg1.getX()<-644){bg1.setX(1288);bg2.setX(0);bg3.setX(644);a=0.05;}
        if (bg2.getX()<-644){bg2.setX(1288);bg3.setX(0);bg1.setX(644);a=0.05;}
        if (bg3.getX()<-644){bg3.setX(1288);bg1.setX(0);bg2.setX(644);a=0.05;}
        if (vitesse>5) {a = 0;}
        return a;
    }
}
