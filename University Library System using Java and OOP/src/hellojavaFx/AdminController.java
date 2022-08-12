package hellojavaFx;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Label label;
	
	@FXML 
	private Button AddStudent;
	@FXML 
	private Button AddLibrarian;
	@FXML
	private Button AddAdmin;
	
	@FXML
	private Button RemoveStudent;
	@FXML
	private Button RemoveLibrarian;
	@FXML
	private Button RemoveAdmin;
	
	@FXML
	private TextField id;
	@FXML
	private TextField name;
	@FXML
	private TextField birthday;
	@FXML
	private TextField email;
	@FXML
	private TextField mobile_number;

	
	String ID=" ";
	String Name=" " ;
	String Birthday=" ";
	String Email=" "; 
	String MobileNumber=" ";
	
	public void switch_to_LoginWindow(ActionEvent event) throws IOException {
		root=FXMLLoader.load(getClass().getResource("/Main.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void returnToAdminView(ActionEvent event) throws IOException {
		
		root=FXMLLoader.load(getClass().getResource("/AdminView.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void ResetFields(ActionEvent event) {
		
		 id.setText("");
		 name.setText("");
		 birthday.setText("");
	
	}
	
	public void ResetFieldAddStudent(ActionEvent event) {
		
		 id.setText("");
		 name.setText("");
		 birthday.setText("");
		 email.setText("");
		 mobile_number.setText("");
		 label.setText("");
	}
	
	public void CheckButton(ActionEvent event)  throws IOException{
		
		Button sourceButton = (Button) event.getSource();
		AdminView admin = new AdminView();
		
		
		if(sourceButton.equals(AddStudent)) {
			
			root=FXMLLoader.load(getClass().getResource("/AddStudent.fxml"));
			stage= (Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
		
		else if(sourceButton.equals(AddLibrarian)) {
			
			root=FXMLLoader.load(getClass().getResource("/AddLibrarian.fxml"));
			stage= (Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
		
		else if (sourceButton.equals(AddAdmin)) {
			root=FXMLLoader.load(getClass().getResource("/AddAdmin.fxml"));
			stage= (Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		else if (sourceButton.equals(RemoveStudent)) {
			root=FXMLLoader.load(getClass().getResource("/RemoveStudent.fxml"));
			stage= (Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		else if (sourceButton.equals(RemoveLibrarian)) {
			root=FXMLLoader.load(getClass().getResource("/RemoveLibrarian.fxml"));
			stage= (Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		else if (sourceButton.equals(RemoveAdmin)) {
			root=FXMLLoader.load(getClass().getResource("/RemoveAdmin.fxml"));
			stage= (Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		
		}
	
	public void addstudentbutton (ActionEvent event) throws IOException {
		
		AdminView admin = new AdminView();
		
		ID = id.getText();
		Name = name.getText();
		Birthday = birthday.getText();
		Email = email.getText();
		MobileNumber = mobile_number.getText();
		label.setText( admin.add_students(ID, Name, Birthday, Email, MobileNumber));
	}
	
	public void addLibrarianbutton (ActionEvent event) throws IOException {
		
		AdminView admin = new AdminView();
		
		ID = id.getText();
		Name = name.getText();
		Birthday = birthday.getText();
		label.setText(admin.add_librarian(ID, Name, Birthday));
	}
	
	public void addAdminbutton (ActionEvent event) throws IOException {
		
		AdminView admin = new AdminView();
		
		
		ID = id.getText();
		Name = name.getText();
		Birthday = birthday.getText();
		label.setText(admin.add_other_admins(ID, Name, Birthday));
	}

	public void RemoveStudentbutton (ActionEvent event) throws IOException {
		
		AdminView admin = new AdminView();
		
		ID = id.getText();
		Name = name.getText();
		
		label.setText(admin.remove_students(ID,Name));
	}
	
	public void RemoveLibrarianbutton (ActionEvent event) throws IOException {
		
		AdminView admin = new AdminView();
		
		ID = id.getText();
		Name = name.getText();
		
		label.setText(admin.remove_librarian(ID,Name));
	}
	
	public void RemoveAdminbutton (ActionEvent event) throws IOException {
		
		AdminView admin = new AdminView();
		
		ID = id.getText();
		Name = name.getText();
		
		label.setText(admin.remove_other_admins(ID,Name));
	}
}
