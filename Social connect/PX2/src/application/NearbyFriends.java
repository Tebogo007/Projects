/**
 * 
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jwetherell.algorithms.data_structures.Graph.Edge;
import com.jwetherell.algorithms.data_structures.Graph.Vertex;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

/**
 * @author TM MAMPA 219110597
 *
 */
public class NearbyFriends implements Initializable
{
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnProfile;
	@FXML
	private Button btnLogout;
	@FXML
	private Button btnAddFriend;
	@FXML
	private Button btnDeleteFriend;
	@FXML
	private Label lblUsername;
	@FXML
	private ListView<HBox> listView;
	@FXML
	private Button btnLoadFriends;
	
	Vertex<UserProfile> loggedInUser;
	ArrayList<String> friends = new ArrayList<>();
	
	public void FindNearbyFriends(ActionEvent event) throws IOException
	{
		for(Vertex<UserProfile> profile : GraphHandler._graph.getVertices())
		{
			/*if(friends.contains(profile.getValue().getUsername()))
				continue;*/
			boolean isFriend = false;
			for(Edge<UserProfile> friend : GraphHandler.loggedInUser.getEdges())
			{
				System.out.print(profile.getValue().getUsername() + " ");
				System.out.println(friend.getToVertex().getValue().getUsername() + " ");
				if(friend.getToVertex().getValue().getUsername().equalsIgnoreCase(profile.getValue().getUsername()))
				{
					isFriend = true;
					break;
				}
			}
			if(isFriend)
				continue;
			HBox box = new HBox();
			Label name = new Label(profile.getValue().getUsername());
			Button add = new Button("Add Friend");
			add.setId(profile.getValue().getUsername());
			add.setOnAction(e -> 
			{
				Button clicked = (Button) e.getSource();
				
				GraphHandler.ConnectFriend(clicked.getId());
				//friends.add(clicked.getId());
				listView.getItems().clear();
				try {
					FindNearbyFriends(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			//Button delete = new Button("Unfriend");
			box.getChildren().add(name);
			box.getChildren().add(add);
			//box.getChildren().add(delete);
			listView.getItems().add(box);
		}
		
	}
	
	public void DeleteFriend(ActionEvent event) throws IOException
	{
		//Edge<UserProfile> edge = new Edge<UserProfile>()
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
	
	public void EditUserProfile(ActionEvent event) throws IOException
	{
		Main m = new Main();
		m.changeScene("EditProfile.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//Vertex<UserProfile> currentUser = (Vertex<UserProfile>) GraphHandler._graph.getVertices();
		//Vertex<UserProfile>[] arrProfiles = BreadthFS(GraphHandler._graph, currentUser); 
		
	}

}
