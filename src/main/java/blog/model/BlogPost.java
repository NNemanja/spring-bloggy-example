package blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

@Entity
public class BlogPost {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotNull @NotEmpty
	private String postTitle;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime postTime;
    @Column(columnDefinition = "text") @NotNull @NotEmpty
	private String postText;
	private int postDeleted;

    
	public BlogPost() {
	}
    public BlogPost(String postTitle, String postText, int postDeleted)
    {
    	this.postTitle = postTitle;
    	this.postTime = new DateTime();
    	this.postText = postText;
    	this.postDeleted = postDeleted;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public DateTime getPostTime() {
		return postTime;
	}
	public String getFormattedPostTime()
	{
		return DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss").print(getPostTime());
	}
	

	public void setPostTime(DateTime postTime) {
		this.postTime = postTime;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public int getPostDeleted() {
		return postDeleted;
	}

	public void setPostDeleted(int postDeleted) {
		this.postDeleted = postDeleted;
	}
	
    
}
