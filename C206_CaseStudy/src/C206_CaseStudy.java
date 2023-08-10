import java.util.ArrayList;

public class C206_CaseStudy {
	public static final int OPTION_ADDUSER = 1;
	public static final int OPTION_VIEWUSER = 2;
	public static final int OPTION_DELETEUSER = 3;
	public static final int OPTION_ADDBIKE = 4;
	public static final int OPTION_VIEWBIKE = 5;
	public static final int OPTION_DELETEBIKE = 6;
	public static final int OPTION_ADDGROUP = 7;
	public static final int OPTION_VIEWGROUP = 8;
	public static final int OPTION_DELETEGROUP = 9;
	public static final int OPTION_ADDDISCUSSION = 10;
	public static final int OPTION_VIEWDISCUSSION = 11;
	public static final int OPTION_DELETEDISCUSSION = 12;
	public static final int OPTION_QUIT = 13;
	

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Bike> bikeList = new ArrayList<>();
    public static ArrayList<Group> groupList = new ArrayList<>();
    public static ArrayList<Discussion> discussionList = new ArrayList<>();

    public static void main(String[] args) {
    	bikeList.add(new Bike("Harley", "Iron 883", 2022, "Black"));

        bikeList.add(new Bike("Honda", "CBR600RR", 2021, "Red"));

        bikeList.add(new Bike("Yamaha", "YZF-R1", 2023, "Blue"));

        int option = 0;
        while (option != OPTION_QUIT) {
            menu();
            option = Helper.readInt("Enter an option > ");

            if (option == OPTION_ADDUSER) {
                addUser();
            }

            if (option == OPTION_VIEWUSER) {
                viewAllUsers();
            }

            if (option == OPTION_DELETEUSER) {
                deleteUser();
            }

            if (option == OPTION_ADDBIKE) {
                addBike();
            }

            if (option == OPTION_VIEWBIKE) {
                viewAllBikes();
            }

            if (option == OPTION_DELETEBIKE) {
                deleteBike();
            }

            if (option == OPTION_ADDGROUP) {
                addGroup();
            }

            if (option == OPTION_VIEWGROUP) {
                viewAllGroup();
            }

            if (option == OPTION_DELETEGROUP) {
                deleteGroup();
            }

            if (option == OPTION_ADDDISCUSSION) {
                addDiscussion();
            }

            if (option == OPTION_VIEWDISCUSSION) {
                viewAllDiscussions();
            }

            if (option == OPTION_DELETEDISCUSSION) {
                deleteDiscussion();
            }
        }
    }

    public static void menu() {
        System.out.println("Biker's Community Portal");
        System.out.println("1. Add user");
        System.out.println("2. View all users");
        System.out.println("3. Delete user");
        System.out.println("4. Add bike");
        System.out.println("5. View all bikes");
        System.out.println("6. Delete bike");
        System.out.println("7. Add group");
        System.out.println("8. View all groups");
        System.out.println("9. Delete group");
        System.out.println("10. Add discussion");
        System.out.println("11. View all discussions");
        System.out.println("12. Delete discussions");
        System.out.println("13. Quit");
        Helper.line(80, "-");
    }

    
    public static void addUser() {
        String userId = Helper.readString("Enter User ID: ");
        String name = Helper.readString("Enter name: ");
        String email = Helper.readString("Enter email: ");
        int phoneNo = Helper.readInt("Enter phoneNo: ");

        User user = new User(userId, name, email, phoneNo);

        for (User existingUser : userList) {
            if (existingUser.getUserId().equalsIgnoreCase(userId)) {
                System.out.println("User with the same ID already exists. Cannot add.");
                return;
            }
        }

        userList.add(user);
        System.out.println("User added successfully.");
    }
    public static void viewAllUsers() {
        System.out.println("All Users:");
        for (User user : userList) {
            System.out.println(user);
        }
    }
    public static void deleteUser() {
        String userId = Helper.readString("Enter User ID to delete: ");

        User userToDelete = null;

        for (User user : userList) {
            if (user.getUserId().equalsIgnoreCase(userId)) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {
            userList.remove(userToDelete);
            System.out.println("User with ID " + userId + " has been deleted.");
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    
    public static void addBike() {

        String make = Helper.readString("Enter Bike Make: ");

        String model = Helper.readString("Enter Bike Model: ");

        int year = Helper.readInt("Enter Bike Year: ");

        String color = Helper.readString("Enter Bike Color: ");
        Bike bike = new Bike(make, model, year, color);

 

        bikeList.add(bike);

        System.out.println("Bike added successfully.");

    }
    public static void viewAllBikes() {

        System.out.println("All Bikes:");

 

        int bikeIndex = 1;

        for (Bike bike : bikeList) {

            System.out.println(bikeIndex + ". " + bike.getMake() + " " + bike.getModel() + " - " + bike.getYear() + " - " + bike.getColor());

            bikeIndex++;

        }

    }
    public static void deleteBike() {

        int bikeIndexToDelete = Helper.readInt("Enter Bike Number to delete: ");

        int index = bikeIndexToDelete - 1;

 

        if (index >= 0 && index < bikeList.size()) {

            Bike bikeToDelete = bikeList.get(index);

            bikeList.remove(index);

            System.out.println(bikeToDelete.getMake() + " " + bikeToDelete.getModel() + " has been deleted.");

        } else {

            System.out.println("Invalid bike number. Please try again.");

        }

    }


    
    public static void addGroup() {

        String title = Helper.readString("Enter Group Title: ");

        String description = Helper.readString("Enter Group Description: ");

        String author = Helper.readString("Enter Group Author: ");
        Group group = new Group(title, description, author);

        for (Group existingGroup : groupList) {

            if (existingGroup.getTitle().equalsIgnoreCase(group.getTitle())) {

                System.out.println("Group with the same title already exists. Cannot add.");
                return;

            }

        }

        groupList.add(group);



        System.out.println("Group added successfully.");
    }
    public static void viewAllGroup() {
        System.out.println("All Groups:");

        for (Group group : groupList) {
            System.out.println(group);

        }

    }

    public static void deleteGroup() {



        String groupTitle = Helper.readString("Enter Group title to delete: ");

        Group groupToDelete = null;

        for (Group group : groupList) {

            if (group.getTitle().equalsIgnoreCase(groupTitle)) {
                groupToDelete = group;
                break;
   }
            }
    }
    


    public static void addDiscussion() {
        int discussionId = Helper.readInt("Enter Discussion ID: ");
        String title = Helper.readString("Enter Discussion Title: ");
        String description = Helper.readString("Enter Discussion Description: ");
        String author = Helper.readString("Enter Author Name: ");

      
        for (Discussion existingDiscussion : discussionList) {
            if (existingDiscussion.getDiscussionId() == discussionId) {
                System.out.println("Discussion with the same ID already exists. Cannot add.");
                return;
            }
        }

        for (Discussion existingDiscussion : discussionList) {
            if (existingDiscussion.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Discussion with the same title already exists. Cannot add.");
                return;
            }
        }

        Discussion discussion = new Discussion(discussionId, title, description, author);
        discussionList.add(discussion);
        System.out.println("Discussion added successfully.");
    }



    public static void viewAllDiscussions() {
        System.out.println("All Discussions:");
        for (Discussion discussion : discussionList) {
            System.out.println(discussion);
        }
    }

    public static void deleteDiscussion() {
        int discussionId = Helper.readInt("Enter Discussion ID to delete: ");

        Discussion discussionToDelete = null;
        for (Discussion discussion : discussionList) {
            if (discussion.getDiscussionId()==(discussionId)) {
                discussionToDelete = discussion;
                break;
            }
        }

        if (discussionToDelete != null) {
            discussionList.remove(discussionToDelete);
            System.out.println("Discussion with ID " + discussionId + " has been deleted.");
        } else {
            System.out.println("Discussion with ID " + discussionId + " not found.");
        }
    }
}




