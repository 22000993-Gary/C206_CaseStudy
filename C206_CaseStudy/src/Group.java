import java.util.ArrayList;
public class Group {
	
	  private String title;
	    private String description;
	    private String author;

	    private static ArrayList<Group> GroupList = new ArrayList<>();

	    public Group(String title, String description, String author) {
	        this.title = title;
	        this.description = description;
	        this.author = author;
	    }

	    public String getTitle() {
	        return title;
	    }
	    public String getDescription() {
	    	return description;
	    }
	    public String getAuthor() {
	    	return author;
	    }

		public static void addGroup(String string, String string2, String string3) {
			// TODO Auto-generated method stub
			
		}

		public static void viewAllGroups() {
			// TODO Auto-generated method stub
			
		}

		public static void deleteGroup(int i) {
			// TODO Auto-generated method stub
			
		}

}
