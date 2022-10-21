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
import javafx.scene.control.TextField;

/**
 * @author TM Mampa 219110597
 *
 */
public class Login {
	
	@FXML
	private Button btnLogin;
	@FXML
	private TextField txtUsername;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Label lblError;
	@FXML
	private Button btnForgot;
	

	public void gotoLogin(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("Register.fxml");
	}
	
	public void userLogin(ActionEvent event) throws IOException
	{
		
		ValidateUser();
	}
	

	private void ValidateUser() throws IOException
	{
		Main m = new Main();
		String username = txtUsername.getText();
		String password = txtPassword.getText();
		
		boolean result = GraphHandler.LogIn(username, password);
		if(result)
		{
			System.out.println("success");
			m.changeScene("MainMenu.fxml");
		}
		else if(txtUsername.getText().isEmpty() && txtPassword.getText().isEmpty())
		{
			lblError.setText("Please enter your details");
		}
		else {
			lblError.setText("Wrong username or password");
		}
		
		
	}
	
}
