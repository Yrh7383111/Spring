package One_to_Many_Bi;


import javax.persistence.*;


// Annotate the class as an entity and map to db table
@Entity
@Table(name="instructor_detail")
public class InstructorDetail
{
	// Private
	// Define the fields
	// Annotate the fields with db column names
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;

	@OneToOne(mappedBy="instructorDetail", cascade={CascadeType.DETACH, CascadeType.MERGE,
													CascadeType.PERSIST, CascadeType.REFRESH})
	private Instructor instructor;


	// Public
	// Create constructors
	public InstructorDetail()
	{
		this.youtubeChannel = null;
		this.hobby = null;
		this.instructor = null;
	}

	public InstructorDetail(String youtubeChannel, String hobby)
	{
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public InstructorDetail(String youtubeChannel, String hobby, Instructor instructor)
	{
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
		this.instructor = instructor;
	}

	// Generate getter/setter methods
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getYoutubeChannel()
	{
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel)
	{
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby()
	{
		return hobby;
	}

	public void setHobby(String hobby)
	{
		this.hobby = hobby;
	}

	public Instructor getInstructor()
	{
		return instructor;
	}

	public void setInstructor(Instructor instructor)
	{
		this.instructor = instructor;
	}

	// Generate toString() method
	@Override
	public String toString()
	{
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
}