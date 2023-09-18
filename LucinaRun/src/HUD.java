import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HUD{
    ImageView lifeImg1,lifeImg2,lifeImg3;
    ImageView blood;
    int bloodCnt;
    Text scoreTxt;
    public HUD(){
        this.scoreTxt = new Text(30,30,0+" pts");
        this.scoreTxt.setFont(Font.font("Arial Black",30));
        Image coeur = new Image(".\\img\\health.png",50,50,false,false);
        this.lifeImg1 = new ImageView(coeur);
        this.lifeImg1.setX(1228);
        this.lifeImg1.setY(10);
        this.lifeImg2 = new ImageView(coeur);
        this.lifeImg2.setX(1168);
        this.lifeImg2.setY(10);
        this.lifeImg3 = new ImageView(coeur);
        this.lifeImg3.setX(1108);
        this.lifeImg3.setY(10);
        this.blood = new ImageView(new Image(".\\img\\blood.png",50,50,true,true));
        blood.setVisible(false);
        blood.setFitHeight(312);
        blood.setPreserveRatio(true);
    }

    public void run(double s,int lives) {
        if (lives <3){lifeImg3.setVisible(false);}
        if (lives >=3){lifeImg3.setVisible(true);}
        if (lives <2){lifeImg2.setVisible(false);}
        if (lives >=2){lifeImg2.setVisible(true);}
        if (lives <1){lifeImg1.setVisible(false);blood.setVisible(false);}
        if (lives >=1){lifeImg1.setVisible(true);}
        scoreTxt.setText((int) s+" pts");
        if (blood.isVisible() && bloodCnt < 0) {blood.setVisible(false);}
        else if (blood.isVisible()) {bloodCnt--;}
        else {bloodCnt = 50;}


    }

    public void blood(){
        blood.setVisible(true);
    }


    public void reset(){
        blood.setVisible(false);
    }
}
