package Many_to_Many;


import javax.persistence.*;


@Entity
@Table(name="review")
public class Review
{
	// Private
	// Define and annotate fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;

	// Public
	// define constructors
	public Review()
	{
		this.comment = null;
	}

	public Review(String comment)
	{
		this.comment = comment;
	}

	// Define getter/setters
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	// Define to string
	@Override
	public String toString()
	{
		return "Review [id=" + id + ", comment=" + comment + "]";
	}
}