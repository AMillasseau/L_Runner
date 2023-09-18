import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LucinaRun extends Application {
    BackGround bg;
    Lucina lucina = new Lucina();
    Enemy en1,en2,en3,en4;
    double score;
    HUD hud = new HUD();
    double vitesse=5.5,acceleration=0;
    AnimationTimer tic;
    LucinaRun lucinaRun = this;

    MediaPlayer musique= new MediaPlayer(new Media(new File("src\\sounds\\Conquest(Ablaze).mp3").toURI().toString()));


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primarystage){
        primarystage.setTitle("Lucina !");
        primarystage.getIcons().addAll(new Image(".\\img\\l_00.png"));
        primarystage.setResizable(false);
        musique.setAutoPlay(true);
        musique.setCycleCount(MediaPlayer.INDEFINITE);
        musique.setVolume(0.1);
        listener(primarystage,lucina);
        primarystage.setScene(new SceneTitle(lucinaRun));
        primarystage.show();
        tic = new AnimationTimer(){
            @Override
            public void handle(long l) {
                lucina.run();
                acceleration =bg.run(vitesse);
                vitesse += acceleration;
                score+=0.05;
                hud.run(score,lucina.lives);
                initEnemies();
                en1.run();
                en2.run();
                en3.run();
                en4.run();
                checkColides();
                if (lucina.lives>3){lucina.lives = 3;}
                if (lucina.lives <= 0){
                    lucina.sounds.hope();
                    primarystage.setScene(new SceneGameOver(lucinaRun,score));
                    this.stop();
                }
            }
        };}

    public void listener(Stage scene, Character lucina){
        scene.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (ke.getCode() == KeyCode.UP) {
                lucina.jump();
                ke.consume(); //<-- stops passing the event to next node
            }
            if (ke.getCode() == KeyCode.SPACE) {
                lucina.attack();
                ke.consume(); //<-- stops passing the event to next node
            }
            if (ke.getCode() == KeyCode.RIGHT) {
                lucina.changeClass(1);
                ke.consume(); //<-- stops passing the event to next node
            }
            if (ke.getCode() == KeyCode.LEFT) {
                lucina.changeClass(5);
                ke.consume(); //<-- stops passing the event to next node
            }
            if (ke.getCode() == KeyCode.DOWN) {
                if (lucina.getTheClass()==2){lucina.setAy(0.8);}
                else{lucina.setAy(0.4);}
                ke.consume(); //<-- stops passing the event to next node
            }
            if (ke.getCode() == KeyCode.H) {
                ke.consume(); //<-- stops passing the event to next node
            }
        });
        scene.addEventFilter(KeyEvent.KEY_RELEASED, ke -> {

        });
    }
    public void initEnemies(){
        Random r = new Random();
        int i = r.nextInt(0,4);
        int i2 = r.nextInt(0,2);
        if (en1.getX()<-400){en1.init(vitesse, i);
            en2.setVisible(false);
            if (i == 1 && i2 == 1 ) {initEnemies();return ;}
            if (i != 3 && r.nextFloat()<0.5){
                en2.init(vitesse, 10+i2);}}
        int i3 = r.nextInt(0,4);
        int i4 = r.nextInt(0,2);
        if (en3.getX()<-400){en3.init(vitesse, i3);
            en4.setVisible(false);
            if (i3 == 1 && i4 == 1 ) {initEnemies();return ;}
            if (i3 != 3 && r.nextFloat()<0.5){
                en4.init(vitesse, 10+i4);}}
    }

    public void checkColides(){
        List<Enemy> ens = Arrays.asList(en1,en2,en3,en4);
        for (int i = 0; i < 4; i++){
            Enemy e = ens.get(i);
            if (lucina.intersects(e.getBoundsInLocal()) && e.isVisible()){
                    hit(e);
            }
            if (lucina.arrow.intersects(e.getBoundsInLocal()) && e.isVisible() && lucina.arrow.isVisible()){
                score = lucina.arrow.hit(e,score);
            }
            if (lucina.intersects(e.arrow.getBoundsInLocal()) && e.arrow.isVisible()){
                e.arrow.hited(lucina,hud);
            }

        }

    }

    public void hit(Enemy e){
        if (lucina.attacking() && e.getTheClass()!=1 && e.getTheClass()!=11){
            e.setVisible(false);
            score += 100;
        }
        else if (!e.hit && e.getTheClass()!=2) {
            lucina.lives--;
            hud.blood();
            e.hit = true;
        }
    }
}