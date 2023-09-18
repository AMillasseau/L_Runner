public class Lucina extends Character{
    int lives;
    LucinaSounds sounds;
    public Lucina(){
        super(100,212,"l");
        this.setTheState(3);
        this.lives = 3;
        this.sounds = new LucinaSounds();
    }

    @Override
    public void changeClass(int i){
        if (this.getTheState()<4){
            this.setTheClass((getTheClass()+i)%4);
        }}

    @Override
    public void changeState(){
        if (this.getTheState()>=4){this.stateCnt +=1;}
        if (this.stateAttack && this.getTheState()<=3){
            this.stateAttack=false;
            this.setTheState(5);
            return ;
        }
        if (this.getTheState()==5 && this.stateCnt>=this.attackCnt()){
            this.setTheState(7);
            if (this.getTheClass() != 3){sounds.attack();}
            stateCnt = 0;
            this.stateAttack = false;
            return ;
        }
        if (this.getTheState()==7 && this.stateCnt>=this.attackCnt()){
            if (getTheClass()==1 && (stateAttack || this.stateCnt>=90)){shoot(true);}
            else if (getTheClass()==1) {return ;}
            this.setTheState(9);
            stateCnt = 0;
            this.stateAttack = false;
            return ;
        }
        if (this.getTheState()==9 && this.stateCnt>=this.attackCnt()){
            this.setTheState(3);
            if (getTheClass()==3){lives++;}
            stateCnt = 0;
            this.stateAttack = false;
            return ;
        }
    }

    public void shoot(boolean direction){
        if (direction){arrow.init(true,getX()+(11.0*100.0/30),getY()+(13.0*100.0/30));}
        else {arrow.init(false,getX()+(7.0*100.0/30.0),getY()+(13.0*100.0/30));}
    }
    private int attackCnt(){
        switch (this.getFullState()){
            case (5):
                return 40;
            case (7):
                return 60;
            case (9):
                return 40;
            case (15):
                return 70;
            case (17):
                return 20;
            case (19):
                return 60;
            case (25):
                return 40;
            case (27):
                return 40;
            case (29):
                return 40;
            case (35):
            case (37):
            case (39):
                return 300;
        }
        return 0;
    }
    public boolean attacking(){
        return (this.getTheState()==7 && (this.getTheClass()==0 || this.getTheClass()==2));
    }

    public void reset(){
        lives =3;
        setTheState(3);
        setTheClass(0);
        setY(212);
    }
}
