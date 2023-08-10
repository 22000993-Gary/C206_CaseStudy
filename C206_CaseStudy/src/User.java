
public class User {
	    private String userId;
	    private String name;
	    private String email;
	    private int phoneNo;

	    public User(String userId, String name, String email, int phoneNo) {
	        this.userId = userId;
	        this.name = name;
	        this.email = email;
	        this.phoneNo = phoneNo;
	    }

	    public String getUserId() {
	        return userId;
	    }
	    public String getName() {
	        return name;
	    }

	    // You should override the toString() method to provide a custom string representation of the User object.
	    @Override
	    public String toString() {
	        return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + "]";
	    }
	}


