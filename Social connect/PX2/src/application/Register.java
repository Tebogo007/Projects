/**
 * 
 */
package application;

import java.io.IOException;

import com.jwetherell.algorithms.data_structures.Graph;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * @author TM Mampa 219110597
 *
 */
public class Register {

	@FXML
	private Label error;
	@FXML
	private Button btnRegister;
	@FXML
	private Button btnChange;
	@FXML
	private TextField txtUser;
	@FXML
	private PasswordField psdPass;
	@FXML
	private PasswordField psdConfirm;
	@FXML
	private TextArea txaHobbies;
	@FXML
	private TextArea txaAbout;
	
	UserProfile profile;
	
	/**
	 * creating a new user
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void createUser(ActionEvent event) throws IOException
	{
		Main m = new Main();
		//Graph<UserProfile> graph = new Graph<UserProfile>();
		//GraphHandler.setGraph(graph);
		
		boolean result = GraphHandler.Register(txtUser.getText(), psdPass.getText(), txaAbout.getText(), txaHobbies.getText());
		if(result)
		{
			m.changeScene("sample.fxml");
		}
		else {
			error.setText("User already Exists, Please LogIN");
			//m.changeScene("sample.fxml");
		}
		
	}
	
	public void changeForm(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("sample.fxml");
	}
	
	
}
