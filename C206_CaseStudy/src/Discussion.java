public class Discussion {
    private int discussionId;
    private String title;
    private String description;
    private String author;

    public Discussion(int discussionId, String title, String description, String author) {
        this.discussionId = discussionId;
        this.title = title;
        this.description = description;
        this.author = author;
    }

 

    public int getDiscussionId() {
        return discussionId;
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

    public String toString() {
        return "Discussion ID: " + discussionId +
               "\nTitle: " + title +
               "\nDescription: " + description +
               "\nAuthor: " + author +
               "\n";
    }
}


