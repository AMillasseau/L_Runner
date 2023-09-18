import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class SceneGameOver extends Scene {
    public SceneGameOver(LucinaRun l, double score) {
        super(new Pane(), 1288, 312,true);
        Group root = new Group();
        ImageView bg = new ImageView(new Image(".\\img\\game_over.png"));
        bg.setOnMouseClicked(event -> {
            if (easter_egg(score)){
                bg.setImage(new Image(".\\img\\game_over2.png"));
            }
        });
        Text text = new Text(1288.0/2,312.0/2,"Score : " + (int) score);
        text.setFont(Font.font("Arial Black",30));
        Text title = new Text(400.0,50.0,"GAME OVER");
        title.setFont(Font.font("Impact",60));
        Group ghs = new Group();
        Text hs = new Text(1288.0*0.75,50.0,"HIGH SCORES");
        hs.setFont(Font.font("Arial Black",30));
        ghs.getChildren().add(hs);
        HighScore highScore = new HighScore();
        for (int i = 0; i< 10; i++){
            Text sco1 = new Text(1288.0*0.75,50.0+(20.0*(i+1)),highScore.names[i]+" :");
            Text sco2 = new Text(1288.0*0.75+120.0,50.0+(20.0*(i+1)), ""+highScore.scores[i]);
            sco1.setFont(Font.font("Arial Black",20-i));
            sco2.setFont(Font.font("Arial Black",20-i));
            ghs.getChildren().add(sco1);
            ghs.getChildren().add(sco2);
        }
        TextField field = new TextField();
        field.relocate(400,312.0/2);
        field.setPromptText("Name");
        Button butt = new Button("Submit");
        butt.relocate(400,200);
        butt.setOnAction(event -> {
            if (!Objects.equals(field.getText(), "")){
                field.setEditable(false);
                butt.setDisable(true);
                highScore.write_new( field.getText(),(int) score);
                highScore.refresh();
                for (int i = 0; i< 10; i++){
                    Text sco1 = new Text(1288.0*0.75,50.0+(20.0*(i+1)),highScore.names[i]+" :");
                    Text sco2 = new Text(1288.0*0.75+120.0,50.0+(20.0*(i+1)), ""+highScore.scores[i]);
                    sco1.setFont(Font.font("Arial Black",20-i));
                    sco2.setFont(Font.font("Arial Black",20-i));
                    ghs.getChildren().add(sco1);
                    ghs.getChildren().add(sco2);
                }
            }
        });
        Button butt2 =new Button("Title");
        butt2.relocate(400,250);
        butt2.setOnAction(event ->{
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new SceneTitle(l));
        });
        root.getChildren().addAll(bg,text,title,field,butt,butt2,ghs);
        Pane pane = new Pane(root);
        this.setRoot(pane);

    }

    public boolean easter_egg(double score){
        int n = (int) Math.log10(score);
        for (int i=0; i < n; i++){
            if (((int) (score/(Math.pow(10,i))))%100 == 42){
                return true;
            }
        }
        return false;
    }
}
