import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneSettings extends Scene {

    int BGM=5,BGS=5;

    public SceneSettings(LucinaRun l) {
        super(new Pane(), 1288, 312, true);
        BGM = (int) (l.musique.getVolume()/0.02);
        BGS = (int) (l.lucina.sounds.getVolume()/0.1);
        Group root = new Group();
        ImageView bg = new ImageView(new Image(".\\img\\title.png"));
        Button title =new Button("Title");
        title.relocate(400,250);
        title.setOnAction(event ->{
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new SceneTitle(l));
        });
        Text text = new Text(500.0,50.0,"LUCINA RUN");
        text.setFont(Font.font("Impact",60));
        Group reglages = setupreglages(l);
        root.getChildren().addAll(bg,title,text,reglages);
        this.setRoot(new Pane(root));
    }

    private Group setupreglages(LucinaRun l) {
        Text BGM1 = new Text(644,100.0,"Musique");
        BGM1.setFont(Font.font("Arial Black",30));
        Text BGM2 = new Text(644,150.0,BGM+"");
        BGM2.setFont(Font.font("Arial Black",30));
        Button BGMmoins =new Button("-");
        BGMmoins.relocate(500,100);
        BGMmoins.setOnAction(event ->{
            if (BGM > 0){
                BGM -=1;
                BGM2.setText(BGM+"");
                l.musique.setVolume(0.02*BGM);
            }
        });
        Button BGMplus =new Button("+");
        BGMplus.relocate(800,100);
        BGMplus.setOnAction(event ->{
            if (BGM < 10){
                BGM +=1;
                BGM2.setText(BGM+"");
                l.musique.setVolume(0.02*BGM);
            }
        });

        Text BGS1 = new Text(644,200.0,"Voix");
        BGS1.setFont(Font.font("Arial Black",30));
        Text BGS2 = new Text(644,250.0,BGS+"");
        BGS2.setFont(Font.font("Arial Black",30));
        Button BGSmoins =new Button("-");
        BGSmoins.relocate(500,200);
        BGSmoins.setOnAction(event ->{
            if (BGS > 0){
                BGS -=1;
                BGS2.setText(BGS+"");
                l.lucina.sounds.setVolume(0.1*BGS);
            }
        });
        Button BGSplus =new Button("+");
        BGSplus.relocate(800,200);
        BGSplus.setOnAction(event ->{
            if (BGS < 10){
                BGS +=1;
                BGS2.setText(BGS+"");
                l.lucina.sounds.setVolume(0.1*BGS);
            }
        });
        Button BGStest =new Button("Test");
        BGStest.relocate(850,200);
        BGStest.setOnAction(event ->{
            l.lucina.sounds.player.stop();
                l.lucina.sounds.hope();
            });
        Group g = new Group();
        g.getChildren().addAll(BGM1,BGM2,BGMmoins,BGMplus,BGS1,BGS2,BGSmoins,BGSplus,BGStest);
        return g;
    }
}
