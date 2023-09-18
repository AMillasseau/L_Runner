import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public abstract class  Character extends ImageView{
    private boolean jump;
    private double vx, vy;
    private double ax, ay;
    String sprite;
    private int state;
    protected int stateCnt;
    protected boolean stateAttack;


    public Arrow arrow;

    public Character(double x, double y,String sprite){
        this.setY(y);
        this.sprite = sprite;
        this.setImage(new Image(".\\img\\"+sprite+"_01.png"));
        this.setX(x);
        this.setPreserveRatio(true);
        this.setFitHeight(100);
        this.vx = 0;
        this.vy = 0;
        this.ax = 0;
        this.ay = 0.2;
        this.state = 1;
        this.stateCnt = 0;
        this.stateAttack = false;
        this.arrow = new Arrow();
        this.jump = true;
    }
    public void attack(){this.stateAttack = true;}
    protected void setXDirection(double xDir){vx = xDir;}
    public double getXDirection(){return vx;}
    protected void setYDirection(double yDir){vy = yDir;}
    public double getYDirection(){return vy;}
    protected void setAx(double xDir){ax = xDir;}
    public double getAx(){return ax;}
    protected void setAy(double yDir){ay = yDir;}
    public double getAy(){return ay;}
    protected void setTheState(int i){this.state = 10*(this.state/10)+i;}
    protected void setTheClass(int i){this.state = 10*i+(this.state%10);}
    public int getTheClass(){return (this.state/10);}
    public int getTheState(){return (this.state%10);}
    public int getFullState(){return this.state;}

    public abstract void changeClass(int i);
   public abstract void changeState();


    public void affichage(){
        if(this.state<10){
            this.setImage(new Image(".\\img\\"+sprite+"_0"+state+".png"));
            return ;
        }
        this.setImage(new Image(".\\img\\"+sprite+"_"+state+".png"));
    }

    public void move() {
        vy += ay;
        vx += ax;
        this.setY(this.getY()+vy);
        this.setX(this.getX()+vx);
        if (this.getY()>212){
            this.setY(212);
            this.jump = true;
            this.setAy(0.2);
        }
        if (this.getTheClass()==2 && Objects.equals(this.sprite, "l")){
            if (this.getY()<14.5){
                this.setY(14.2);
                this.setYDirection(0.0);
                this.setAy(0.0);
            }
        }
        else if (getAy()<0.2){ setAy(0.2);}
    }

    public void jump(){
        if (jump){this.setYDirection(-9.0);}
        this.jump = false;
    }

    public void run() {
            this.move();
            this.changeState();
            this.affichage();
            if (arrow != null){
                arrow.run();
            }
        }
    }
