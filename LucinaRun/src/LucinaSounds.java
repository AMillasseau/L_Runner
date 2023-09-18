import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Random;

public class LucinaSounds{

    protected Media ha;
    protected Media hope;
    protected Media ready;
    protected Media take;
    protected Media now;
    protected Media turn;
    public MediaPlayer player;
    private double volume = 0.5;


    public LucinaSounds() {
        this.ha = new Media(new File("src\\sounds\\lucina\\Attack.mp3").toURI().toString());
        this.hope = new Media(new File("src\\sounds\\lucina\\Hope.mp3").toURI().toString());
        this.ready = new Media(new File("src\\sounds\\lucina\\Ready.mp3").toURI().toString());
        this.take = new Media(new File("src\\sounds\\lucina\\Take.mp3").toURI().toString());
        this.now = new Media(new File("src\\sounds\\lucina\\Now.mp3").toURI().toString());
        this.turn = new Media(new File("src\\sounds\\lucina\\Turn.mp3").toURI().toString());
        this.player = new MediaPlayer(ha);
        player.setVolume(0.5);
    }

    public void setup_player(Media m){
        player = new MediaPlayer(m);
        player.setVolume(volume);
    }
    public void take(){setup_player(take);player.play();}
    public void hope(){setup_player(hope);player.play();}
    public void ready(){setup_player(ready);player.play();}
    public void ha(){setup_player(ha);player.play();}
    public void now(){setup_player(now);player.play();}
    public void turn(){setup_player(turn);player.play();}


    public void attack(){
        Random r = new Random();
        float random = r.nextFloat();
        if (random<0.1){
            this.take();
        }
        else {
            this.ha();
        }
    }

    public void start(){
        Random r = new Random();
        if (r.nextFloat()<0.5){
            this.ready();
        }
        else {
            this.turn();
        }
    }

    public void setVolume(double v){volume = v;}
    public double getVolume(){return volume;}
}
