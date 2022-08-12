package hellojavaFx;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneController {
	
	@FXML
	private TextField Username;
	@FXML
	private PasswordField Password;
	
	@FXML
	private Label MESSAGELABEL;
	@FXML
	private Button button;
	
	@FXML
	private Button LOGOUTBUTTON;
	@FXML
	private AnchorPane firstWindow;
	
	private String login_Username;
	private String login_Password;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	
	public void switch_to_LoginWindow(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("/Main.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void switch_to_AdminView(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("/AdminView.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void switch_to_LibrarianView(ActionEvent event) throws IOException {
		
		root=FXMLLoader.load(getClass().getResource("/LibrarianView.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
			
		}
	
public void switch_to_LibrarianLogin(ActionEvent event) throws IOException {
		
		root=FXMLLoader.load(getClass().getResource("/LibrarianLogin.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
			
		}

public void switch_to_AdminLogin(ActionEvent event) throws IOException {
	
	root=FXMLLoader.load(getClass().getResource("/AdminLogin.fxml"));
	stage= (Stage)((Node)event.getSource()).getScene().getWindow();
	scene=new Scene(root);
	stage.setScene(scene);
	stage.show();
		
	}
	
	public void Admin_Login_Button(ActionEvent event) throws IOException {
		
		AdminView admin= new AdminView();
		login_Username = Username.getText();
		login_Password = Password.getText();
		
		try {
			if (admin.login(login_Username,login_Password) != 0 ) {
				MESSAGELABEL.setText("Please enter valid Username and Password!");
				MESSAGELABEL.setAlignment(Pos.CENTER);
			}
			
			else {
				
				root=FXMLLoader.load(getClass().getResource("/AdminView.fxml"));
				stage= (Stage)((Node)event.getSource()).getScene().getWindow();
				scene=new Scene(root);
				stage.setScene(scene);
				stage.show();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Librarian_Login_Button(ActionEvent event) throws IOException {
		
		LibrarianView librarian =new LibrarianView();
		login_Username = Username.getText();
		login_Password = Password.getText();
		
		if (librarian.login(login_Username, login_Password) != 0 ) {
			MESSAGELABEL.setText("Please enter valid Username and Password!");
			MESSAGELABEL.setAlignment(Pos.CENTER);
		}
		
		else {
			
			root=FXMLLoader.load(getClass().getResource("/LibrarianView.fxml"));
			stage= (Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
		
	}
	
	public void Logout(ActionEvent event) throws IOException{
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
}


//hellojavaFx.SceneController
