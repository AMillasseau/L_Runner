import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneGame extends Scene {
    public SceneGame(LucinaRun l) {
        super(new Pane(), 1288, 312, true);
        Group root = new Group();
        l.bg = new BackGround();
        Group backg = new Group();
        backg.getChildren().addAll(l.bg.tbg,l.bg.bg1,l.bg.bg2,l.bg.bg3);
        Group chara = new Group();
        Group object = new Group();
        Group hudgroup = new Group();
        Group soundsg = new Group();
        l.hud.reset();
        l.lucina.reset();
        l.lucina.sounds.start();
        l.en1 = new Enemy(false);
        l.en2 = new Enemy(false);
        l.en3 = new Enemy(true);
        l.en4 = new Enemy(true);
        chara.getChildren().addAll(l.en1,l.en2,l.en3,l.en4,l.lucina);
        object.getChildren().addAll(l.lucina.arrow,l.en1.arrow,l.en2.arrow,l.en3.arrow,l.en4.arrow);
        hudgroup.getChildren().addAll(l.hud.blood,l.hud.scoreTxt,l.hud.lifeImg1,l.hud.lifeImg2,l.hud.lifeImg3);
        soundsg.getChildren().addAll();
        root.getChildren().addAll(soundsg,backg,chara,object,hudgroup);
        Pane pane = new Pane(root);
        this.setRoot(pane);
    }
}
