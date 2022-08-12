package hellojavaFx;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**            
 * @author Nouran Hady Shaaban
 *
 */
public class Main extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
			
			Parent root=FXMLLoader.load(getClass().getResource("/Main.fxml"));
			root.getStylesheets().add(getClass().getResource("StyleCSS.css").toString());
			Image icon= new Image("logo.png");
			
			Scene scene= new Scene(root,800,700,Color.DARKGREY);
			   
			stage.getIcons().add(icon);
			stage.setScene(scene);
			
			UserIDandPasswords idandpassword= new UserIDandPasswords();
			LoginSystem login=new LoginSystem();
			
			
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}





//Stage stage= new Stage();
//
////Group root=new Group();
//Scene scene= new Scene(root,Color.DARKGREY);
////ROYALBLUE
//Image icon= new Image("logo.png");
//
//Text text=new Text();
//text.setX(240);
//text.setY(100);
//text.setFill(Color.BLACK);
//
//text.setText("Welcome to University Library");
////root.getChildren().add(text);
//text.setFont(Font.font("Times New Roman",30));
//
//
//
//stage.setWidth(900);
//stage.setHeight(700);
//
////stage.setResizable(false);
////stage.setFullScreen(true);
//
//stage.getIcons().add(icon);
//stage.setScene(scene);
//
//stage.setTitle("University Library");
//stage.show();



//Line line=new Line();
//line.setStartX(240);
//line.setStartY(500);
//
//line.setEndX(400);
//line.setEndY(600);
//line.setStrokeWidth(5);
