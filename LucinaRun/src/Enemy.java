import java.util.Random;

public class Enemy extends Character{
    public boolean hit = false;

    public Enemy(boolean vague) {
        super(1388,212,"e");
        if (vague) {
            this.setX(2532);
        }
        this.setVisible(false);
        this.setXDirection(-9.0);
    }

public void init(double vit, int c){
        this.setX(1388);
        this.setY(212);
        this.setTheState(2);
        this.setXDirection(-vit);
        this.setTheClass(c);
            if (this.getTheClass()>=10){this.setFitHeight(40.0*100/30);}
        this.setVisible(true);
        this.hit = false;
}
    @Override
    public void changeClass(int i) {
    }
    public void shoot(boolean direction){
        if (direction){arrow.init(direction,getX()+(11.0*100/30),getY()+(12.0*100/30));}
        else {arrow.init(direction,getX()+(7.0*100/30),getY()+(12.0*100/30));}
    }
    @Override
    public void changeState() {
        Random r = new Random();
        switch (this.getTheClass()) {
            case (0):
            case (1):
                if (this.getX() < 644) {setTheState(4);}
                if (this.getX() < 322) {setTheState(6);}
                if (this.getX() < 90) {setTheState(8);}
                return ;
            case(2):
                if (this.getX() < 1000){setTheState(4);}
                if (this.getX() < 900){setTheState(6);}
                if (this.getX() < 800 && this.getX()>780) {
                    if (this.isVisible()){
                    this.shoot(false);}
                }
                if (this.getX() < 700) {setTheState(8);}
                return ;
            case (3):
                if (this.getX() < 644) {setTheState(4);}
                if (this.getX() < 322) {setTheState(6);
                    if (r.nextFloat()<0.9){
                    jump();}}
                if (this.getX() < 90) {
                    setTheState(8);
                }
                return ;
            case (10):
            case (11):
                this.setYDirection(0.0);
                this.setY(0.0);
                if (this.getX() < 644) {setTheState(4);}
                if (this.getX() < 322) {setTheState(6);}
                if (this.getX() < 90) {setTheState(8);}
                return ;

        }
    }



}
