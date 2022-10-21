/**
 * 
 */
package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author TM Mampa 219110597
 *
 */
public class MainMenu {
	
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnProfile;
	@FXML
	private Button nearbyFriends;
	@FXML
	private Button btnPost;
	@FXML
	private Button btnDelete;
	@FXML
	private VBox vbox;
	@FXML
	private ImageView imgPost1;
	@FXML 
	private ImageView imgPost2;
	
	public MainMenu()
	{
		try {
			FileInputStream file = new FileInputStream("../PX2/img/man-playing-golf-min.jpg/");
			Image image = new Image(file);
			imgPost1 = new ImageView(image);
			imgPost1.setImage(image);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void EditProfile(ActionEvent event) throws IOException
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
	
	public void PostPicture(ActionEvent event) throws IOException
	{
		//Main m = new Main();
		//m.changeScene("MainMenu.fxml");
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
	}
}
