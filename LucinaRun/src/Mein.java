import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Mein extends Application {
    AnimationTimer tic;
    MediaPlayer musique= new MediaPlayer(new Media(new File("src\\sounds\\Conquest(Ablaze).mp3").toURI().toString()));

    Button button;
    Random r = new Random();

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primarystage){
        primarystage.setTitle("Lucina Test !");
        primarystage.getIcons().addAll(new Image(".\\img\\l_30.png"));
        primarystage.setResizable(false);
        musique.setAutoPlay(true);
        musique.setVolume(0.1);
        LucinaSounds sound = new LucinaSounds();
        button = new Button("Pause");
        button.relocate(300.0/2,300.0/2);
        button.setOnAction(event -> {
            musique.pause();
        });

        Group root = new Group();
        root.getChildren().addAll(button);
        Scene s = new Scene(new Pane(root),300,300);
        primarystage.setScene(s);
        primarystage.show();
        listener(primarystage,sound);
        tic = new AnimationTimer(){
            @Override
            public void handle(long l) {
                System.out.println(l);
            }
        };
        tic.start();
    }

    public void listener(Stage scene, LucinaSounds lucina){
        scene.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (ke.getCode() == KeyCode.UP) {
                lucina.start();
                button.relocate(r.nextInt(100,200), r.nextInt(100,200));
                ke.consume(); //<-- stops passing the event to next node
            }
            if (ke.getCode() == KeyCode.SPACE) {
                lucina.attack();
                button.relocate(r.nextInt(100,200), r.nextInt(100,200));
                ke.consume(); //<-- stops passing the event to next node
            }
            if (ke.getCode() == KeyCode.DOWN) {
                lucina.hope();
                button.relocate(r.nextInt(100,200), r.nextInt(100,200));
                ke.consume(); //<-- stops passing the event to next node
            }
            if (ke.getCode() == KeyCode.R) {

                ke.consume(); //<-- stops passing the event to next node
            }
        });
        scene.addEventFilter(KeyEvent.KEY_RELEASED, ke -> {

        });
    }
}