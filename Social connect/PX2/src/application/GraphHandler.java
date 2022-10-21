/**
 * 
 */
package application;


import com.jwetherell.algorithms.data_structures.BFS;
import com.jwetherell.algorithms.data_structures.Graph;
import com.jwetherell.algorithms.data_structures.Graph.Edge;
import com.jwetherell.algorithms.data_structures.Graph.Vertex;

/**
 * @author TM Mampa 219110597
 *
 */
public class GraphHandler {
	public static Graph<UserProfile> _graph;
	public static Vertex<UserProfile> loggedInUser;
	

	/*public GraphHandler()
	{
		graph = new Graph<UserProfile>();
	}*/
	public static void setGraph(Graph<UserProfile> graph)
	{
		_graph = graph;
		Vertex<UserProfile> user1 = new Vertex<UserProfile>(new UserProfile("max","max123","Outgoing, energetic, adventurous", "Soccer, movies, games"));
		_graph.getVertices().add(user1);
		Vertex<UserProfile> user2 = new Vertex<UserProfile>(new UserProfile("charle","charle123","shy, adventurous", "cricket, movies, games"));
		_graph.getVertices().add(user2);
		Vertex<UserProfile> user3 = new Vertex<UserProfile>(new UserProfile("sophie","sophie","introvert", "reading, writing, singing"));
		_graph.getVertices().add(user3);
		Vertex<UserProfile> user4 = new Vertex<UserProfile>(new UserProfile("bob","bob@bob","Outgoing, extrovert", "Soccer, movies, riding motorcycles"));
		_graph.getVertices().add(user4);
		Vertex<UserProfile> user5 = new Vertex<UserProfile>(new UserProfile("stacy","stacy123","introvert, adventurous", "ballet, singing, writing"));
		_graph.getVertices().add(user5);
		Vertex<UserProfile> user6 = new Vertex<UserProfile>(new UserProfile("maxine","maxine1234","introvert", "ballet, dancing"));
		_graph.getVertices().add(user6);
		Vertex<UserProfile> user7 = new Vertex<UserProfile>(new UserProfile("john","johnny","extrovert", "rugby, extreme sports, soccer"));
		_graph.getVertices().add(user7);
	}
	
	public static boolean Register(String user, String password, String hobbies, String about)
	{
		UserProfile profile = new UserProfile(user, password, about, hobbies);
		Vertex<UserProfile> vertexProfile = new Vertex<UserProfile>(profile);
		
		for(Vertex<UserProfile> currentUser : _graph.getVertices())
		{
			if(currentUser.getValue().getUsername().equalsIgnoreCase(user))
			{
				return false;
			}
		}
		_graph.getVertices().add(vertexProfile);
		return true;
	}
	
	public static boolean LogIn(String user, String password)
	{
		for(Vertex<UserProfile> currentUser : _graph.getVertices())
		{
			if(currentUser.getValue().getUsername().equalsIgnoreCase(user) && currentUser.getValue().getPassword().equals(password))
			{
				loggedInUser = currentUser;
				return true;
			}
		}
		
		return false;
	}
	
	public static void FindFriends()
	{
		for(Vertex<UserProfile> currentUser: _graph.getVertices())
		{
			if(currentUser.getValue().getHobbies().equals(loggedInUser.getValue().getHobbies()))
			{
				loggedInUser = currentUser;
				try {
					Vertex<UserProfile>[] arrProfiles = BFS.BreadthFS(_graph, loggedInUser);
					for(int i =0; i < arrProfiles.length; i++)
					{
						System.out.println(arrProfiles[i].getValue().getUsername());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	
	public static void DeleteAccount()
	{
		for(Edge<UserProfile> friendLink : loggedInUser.getEdges())
		{
			for(Edge<UserProfile> otherLink : friendLink.getToVertex().getEdges())
			{
				if(otherLink.getToVertex().getValue().getUsername().equalsIgnoreCase(loggedInUser.getValue().getUsername()))
				{
					friendLink.getToVertex().getEdges().remove(otherLink);
				}
			}
			
		}	
		_graph.getVertices().remove(loggedInUser);
	}
	
	
	public static void EditPassword(String password)
	{
		loggedInUser.getValue().setPassword(password);
	}
	
	public static void EditAbout(String about)
	{
		loggedInUser.getValue().setAbout(about);;
	}
	
	public static void EditHobbies(String hobbies)
	{
		loggedInUser.getValue().setHobbies(hobbies);;
	}
	
	public static void ConnectFriend(String user)
	{
		for(int i = 0; i < _graph.getVertices().size();i++)
		{
			if(_graph.getVertices().get(i).getValue().getUsername().equalsIgnoreCase(user))
			{
				Edge<UserProfile> friend = new Edge<UserProfile>(1,loggedInUser,_graph.getVertices().get(i));
				loggedInUser.addEdge(friend);
				Edge<UserProfile> friend2 = new Edge<UserProfile>(1,_graph.getVertices().get(i),loggedInUser);
				_graph.getVertices().get(i).addEdge(friend2);
			} 
		}
	}


}
