import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

 

public class C206_CaseStudyTest {

    private ArrayList<Discussion> discussionList;
    private ArrayList<Bike> bikeList = new ArrayList<>();
    private ArrayList<Group> GroupList = new ArrayList<>();

    
    
    @Before
    public void setUp() {
        // Adding some random bikes for testing
        bikeList.add(new Bike("Harley", "Iron 883", 2022, "Black"));
        bikeList.add(new Bike("Honda", "CBR600RR", 2021, "Red"));
        bikeList.add(new Bike("Yamaha", "YZF-R1", 2023, "Blue"));
        
        GroupList.add(new Group("Go",  "Kill yourself", "Royce"));
        GroupList.add(new Group("I", "don't know", "Hugh Janus"));
        GroupList.add(new Group("Lol", "C6 Xiao Gone", "Rhyce"));

     

        }
    private ArrayList<Group> getGroupListFromGroup() {
        try {
            Field field = Group.class.getDeclaredField("GroupList");
            field.setAccessible(true);
            return (ArrayList<Group>) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


 

    private String getConsoleOutput() {
        // Helper method to capture the console output
        return System.out.toString();
    }
    @Test
    public void testAddGroup() {
        Group.addGroup("I", "Love Biking", "Royce");
        ArrayList<Group> GroupList = getGroupListFromGroup();
        assertEquals(4, GroupList.size());
        Group addedGroup = GroupList.get(3);
        assertEquals("I", addedGroup.getTitle());
        assertEquals("Love Biking", addedGroup.getDescription());
        assertEquals("Royce", addedGroup.getAuthor());
        
    }
    @Test
    public void testViewAllGroups() {
        Group.viewAllGroups();
        String expectedOutput = "All Groups:\n1. Go - Kill Yourself - Royce\n" +
                                "2. I - Don't Know - Hugh Janus\n" +
                                "3. Lol - C6 Xiao Gone - Rhyce\n";
        assertEquals(expectedOutput, getConsoleOutput());
    }
    @Test
    public void testDeleteGroup() {
        Group.deleteGroup(3);
        ArrayList<Group> GroupList = getGroupListFromGroup();
        assertEquals(2, GroupList.size());
        String expectedOutput = "Lol has been deleted.\n";
        assertEquals(expectedOutput, getConsoleOutput());
    }

    
    @Test
    public void testAddDiscussion_NormalCase() {

       
        C206_CaseStudy caseStudy = new C206_CaseStudy();
        ArrayList<Discussion> discussionList1 = new ArrayList<>();
         discussionList1 = C206_CaseStudy.discussionList;
        
        String mockInput = "1\nSample Discussion\nThis is a sample discussion.\nGary\n";
        InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        caseStudy.addDiscussion();
       
        assertEquals(1, discussionList1.size());
        String expectedOutput = "Discussion added successfully.";
        assertTrue(outputStream.toString().contains(expectedOutput));
     
    }


    @Test
    public void testAddDiscussion_ErrorCase() {

        C206_CaseStudy caseStudy1 = new C206_CaseStudy();
        ArrayList<Discussion> discussionList2 = new ArrayList<>();
        discussionList2 = C206_CaseStudy.discussionList;

       
        String existingTitle = "Existing Discussion";
        String existingDescription = "This is an existing discussion.";
        String existingAuthor = "Existing Author";
        Discussion discussion11 = new Discussion(2, existingTitle, existingDescription, existingAuthor);
        discussionList2.add(discussion11);

     
        String Input1 = "3\n" + existingTitle + "\nThis is a duplicate discussion.\nDuplicate Author\n";
        InputStream inputStream = new ByteArrayInputStream(Input1.getBytes());
        System.setIn(inputStream);

       
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));


        caseStudy1.addDiscussion();

        assertEquals(1, discussionList2.size()); 
        Discussion addedDiscussion = discussionList2.get(0);
        assertEquals("Existing Discussion", addedDiscussion.getTitle());

      
        String expectedOutput = "Discussion with the same title already exists. Cannot add.";
        assertTrue(outputStream.toString().contains(expectedOutput));
        C206_CaseStudy.discussionList.clear();
    }

    @Test
    public void testAddDiscussion_BoundaryCase() {

        C206_CaseStudy caseStudy = new C206_CaseStudy();
        ArrayList<Discussion> discussionList3 = new ArrayList<>();
        discussionList3 = C206_CaseStudy.discussionList;

        String mockInput = Integer.MAX_VALUE+"\nSample Discussion\nThis is a sample discussion.\nJohn Doe\n";
        InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

       
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));


        caseStudy.addDiscussion();

       
        assertEquals(1, discussionList3.size());
        Discussion addedDiscussion = discussionList3.get(0);
        assertEquals(Integer.MAX_VALUE, addedDiscussion.getDiscussionId());
        assertEquals("Sample Discussion", addedDiscussion.getTitle());
        assertEquals("This is a sample discussion.", addedDiscussion.getDescription());
        assertEquals("", addedDiscussion.getAuthor());

        
        String expectedOutput = "Discussion added successfully.";
        assertTrue(outputStream.toString().contains(expectedOutput));

        C206_CaseStudy.discussionList.clear();
    }

    @Test
    public void testViewAllDiscussions_BoundaryCase() {
      
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

      
        C206_CaseStudy.viewAllDiscussions();

        
        String expectedOutput = "All Discussions:";
        assertEquals(expectedOutput, outputStream.toString().trim());
        assertFalse(outputStream.toString().contains("Discussion ID:"));
        C206_CaseStudy.discussionList.clear();
    }

    @Test
    public void testViewAllDiscussions_NormalCase() {
        ArrayList<Discussion> discussionList4 = new ArrayList<>();
        discussionList4 = C206_CaseStudy.discussionList;
       
        Discussion discussion1 = new Discussion(1, "Discussion 1", "Description 1", "Author 1");
        Discussion discussion2 = new Discussion(2, "Discussion 2", "Description 2", "Author 2");
        discussionList4.add(discussion1);
        discussionList4.add(discussion2);

        assertEquals(2, discussionList4.size());
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        C206_CaseStudy.viewAllDiscussions();
        assertTrue(outputStream.toString().contains("Author 2"));

        C206_CaseStudy.discussionList.clear();
    }

    @Test
    public void testDeleteDiscussion_NormalCase() {
        ArrayList<Discussion> discussionList5 = new ArrayList<>();
        discussionList5 = C206_CaseStudy.discussionList;

        // Create a discussion to be deleted
        Discussion discussionToDelete = new Discussion(10, "Discussion Title", "Discussion Description", "Author Name");
        discussionList5.add(discussionToDelete);

        int id=10;
        String mockInput = id +"\n"; 
        InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
      
        C206_CaseStudy.deleteDiscussion();
        
        assertTrue(discussionList5.isEmpty());
        String expectedOutput = "Discussion with ID " + id + " has been deleted.";
        assertTrue(outputStream.toString().contains(expectedOutput));
        C206_CaseStudy.discussionList.clear();
    }

    @Test
    public void testDeleteDiscussion_ErrorCase() {
        ArrayList<Discussion> discussionList6 = new ArrayList<>();
        discussionList6 = C206_CaseStudy.discussionList;
        // Create discussions
        Discussion discussion1 = new Discussion(1, "Discussion 1", "Description 1", "Author 1");
        Discussion discussion2 = new Discussion(2, "Discussion 2", "Description 2", "Author 2");
        discussionList6.add(discussion1);
        discussionList6.add(discussion2);

        
        String mockInput = "3\n"; 
        InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

       
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the deleteDiscussion() method
        C206_CaseStudy.deleteDiscussion();

        // Check the console output for the error message
        String expectedOutput = "Discussion with ID 3 not found.";
        assertTrue(outputStream.toString().contains(expectedOutput));
        C206_CaseStudy.discussionList.clear();
    }

    @Test
    public void testDeleteDiscussion_BoundaryCase() {
        ArrayList<Discussion> discussionList7 = new ArrayList<>();
        discussionList7 = C206_CaseStudy.discussionList;
        Discussion discussionToDelete = new Discussion(Integer.MIN_VALUE, "Discussion Title", "Discussion Description", "Author Name");
        discussionList7.add(discussionToDelete);

        
        String mockInput = Integer.toString(Integer.MIN_VALUE) + "\n"; 
        InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        System.setIn(inputStream);

        C206_CaseStudy.deleteDiscussion();
        assertTrue(discussionList7.isEmpty());
        
        
    }    
}
