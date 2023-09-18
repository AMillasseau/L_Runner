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

public class SceneTitle extends Scene {

    public SceneTitle(LucinaRun l) {
        super(new Pane(), 1288, 312, true);
        Group root = new Group();
        ImageView bg = new ImageView(new Image(".\\img\\title.png"));
        Button button = new Button("Launch");
        button.relocate(1288.0/2,312.0/2);
        button.setOnAction(event -> {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new SceneGame(l));
            l.tic.start();
            l.score = 0;
        });
        Button button2 = new Button("Settings");
        button2.relocate(1288.0/2,312.0/2+50.0);
        button2.setOnAction(event -> {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new SceneSettings(l));
        });
        Text text = new Text(500.0,312.0/4,"LUCINA RUN");
        text.setFont(Font.font("Impact",60));
        root.getChildren().addAll(bg,button,button2,text);
        this.setRoot(new Pane(root));
    }
}
