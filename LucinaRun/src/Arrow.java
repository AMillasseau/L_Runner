import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Arrow extends ImageView{
    boolean direction;

    public Arrow(){
        direction = false;
        this.setVisible(false);
        this.setFitHeight(10.0);
        this.setPreserveRatio(true);
    }
    public void init(boolean direction,double x, double y) {
        this.direction = direction;
        if (direction){this.setImage(new Image(".\\img\\Arrow.png"));}
        else {this.setImage(new Image(".\\img\\Arrow2.png"));}
        this.setX(x);
        this.setY(y);
        this.setVisible(true);
    }


    public void run() {
        if (direction){this.setX(this.getX()+9.0);}
        else {this.setX(this.getX()-9.0);}
        if (this.getX()>1388){this.setVisible(false);}
        if (this.getX()<0){this.setVisible(false);}
    }

    public double hit(Enemy e,double score){
        if (e.getTheClass()!=1) {
            e.setVisible(false);
            score += 100;
        }
        this.setVisible(false);
        return score;
    }

    public void hited(Lucina lucina, HUD hud){
        if (lucina.getTheState()==7 && (lucina.getTheClass()==0 || lucina.getTheClass()==2)){
            this.setVisible(false);
            return ;
        }
        (lucina.lives)--;
        hud.blood();
        if (lucina.getTheClass()==2){(lucina.lives)--;}
        this.setVisible(false);
        return ;
    }
}
