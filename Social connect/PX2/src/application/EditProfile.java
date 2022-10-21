/**
 * 
 */
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * @author TM Mampa 219110597
 *
 */
public class EditProfile {

	@FXML
	private Button btnLogout;
	@FXML
	private Button btnProfile;
	@FXML
	private Button nearbyFriends;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnEditProfile;
	@FXML
	private Button btnPost;
	@FXML
	private Button btnChangePassword;
	@FXML
	private PasswordField txtChangePassword;
	@FXML
	private TextArea txaChangeHobbies;
	@FXML
	private TextArea txaChangeBio;
	@FXML
	private VBox vbox;
	@FXML
	private ImageView imgPost1;
	@FXML 
	private ImageView imgPost2;
	
	public void changePassword(ActionEvent event) throws IOException
	{
		String password = txtChangePassword.getText();
		if(password.isBlank())
		{
			Alert alertP = new Alert(AlertType.ERROR, "Please fill in the Password");
			alertP.show();
		}else {
			Alert alertPassword = new Alert(AlertType.CONFIRMATION, "Do you want to continue with the changes?");
			alertPassword.showAndWait();
			GraphHandler.EditPassword(password);
		}
	}
	
	public void changeBio(ActionEvent event) throws IOException
	{
		String bio =  txaChangeBio.getText();
		String hobbies = txaChangeHobbies.getText();
		
		if(bio.isBlank())
		{
			Alert alertBio = new Alert(AlertType.ERROR, "Please fill in the Bio");
			alertBio.show();
		}
		else {
			Alert alertB = new Alert(AlertType.CONFIRMATION, "Do you want to continue with the changes?");
			alertB.showAndWait();
			GraphHandler.EditAbout(bio);
		}
		
		
		if(hobbies.isBlank())
		{
			Alert alertHobbies = new Alert(AlertType.ERROR, "Please fill in the Hobbies");
			alertHobbies.show();
		}else {
			Alert alertH = new Alert(AlertType.CONFIRMATION, "Do you want to continue with the changes?");
			alertH.showAndWait();
			GraphHandler.EditHobbies(hobbies);
		}
	}
	
	public void EditUserProfile(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("EditProfile.fxml");
	}

	
	public void FindFriends(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("NearbyFriends.fxml");
	}
	public void userLogout(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("sample.fxml");
	}
	
	public void DeleteAccount(ActionEvent event) throws IOException
	{
		GraphHandler.DeleteAccount();
		Main m = new Main();
		m.changeScene("sample.fxml");
	}
	
	/*public void PostPicture(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("MainMenu.fxml");
		
		FileChooser fc = new FileChooser();
		fc.setTitle("Open File");
		File file = fc.showOpenDialog(new Stage());
		
		if(file != null) {
		    String imagepath = file.getPath();
		    System.out.println("file:"+imagepath);
		    Image image = new Image(imagepath);
		    imgPost1.setImage(image);
		}
		else
		{
		    Alert alert = new Alert(AlertType.INFORMATION);
		    alert.setTitle("Information Dialog");
		    alert.setHeaderText("Please Select a File");
		    alert.showAndWait();
		}

	}*/
}
