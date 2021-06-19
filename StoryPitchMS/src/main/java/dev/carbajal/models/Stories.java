package dev.carbajal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity (name="points_ref")
@Table (name="points_ref", schema="SPMS")
public class Stories {
	
//	id serial primary key,
//	author_id int references authors(id),
//	p_amount int references points_ref(p_amount),
//	title varchar(50),
//	completion_date int, --DDMMYYYY
//	story_type varchar(25),
//	genre varchar(25),
//	tag_line varchar(25),
//	description varchar(1000),
//	draft varchar(1000),
//	priority int,
//	pitch_status boolean,
//	story_status boolean
	
	@Id
	@Column(name="id", insertable=false, updatable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne
	@JoinColumn(name="author_id")
	private int authorId;
	@OneToOne
	@JoinColumn(name="p_amount")
	private int pointsAmount;
	@Column(name="title")
	private String title;
	@Column(name="completion_date")
	private int completionDate;
	@Column(name="story_type")
	private String storyType;
	@Column(name="genre")
	private String genre;
	@Column(name="tag_line")
	private String tagLine;
	@Column(name="description")
	private String description;
	@Column(name="draft")
	private String draft;
	@Column(name="priority")
	private int priority;
	@Column(name="pitch_approved")
	private boolean pitchApproved;
	@Column(name="story_approved")
	private boolean storyApproved;
	@Column(name="status")
	private String status;
	
	public Stories() {
		super();
		this.priority = 1;
		this.pitchApproved = false;
		this.storyApproved = false;
		this.status = "Pending";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getPointsAmount() {
		return pointsAmount;
	}

	public void setPointsAmount(int pointsAmount) {
		this.pointsAmount = pointsAmount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(int completionDate) {
		this.completionDate = completionDate;
	}

	public String getStoryType() {
		return storyType;
	}

	public void setStoryType(String storyType) {
		this.storyType = storyType;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDraft() {
		return draft;
	}

	public void setDraft(String draft) {
		this.draft = draft;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean getIsPitchApproved() {
		return pitchApproved;
	}

	public void setIsPitchApproved(boolean pitchApproved) {
		this.pitchApproved = pitchApproved;
	}

	public boolean getIsStoryApproved() {
		return storyApproved;
	}

	public void setIsStoryStatus(boolean storyApproved) {
		this.storyApproved = storyApproved;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + authorId;
		result = prime * result + completionDate;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((draft == null) ? 0 : draft.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + (pitchApproved ? 1231 : 1237);
		result = prime * result + pointsAmount;
		result = prime * result + priority;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + (storyApproved ? 1231 : 1237);
		result = prime * result + ((storyType == null) ? 0 : storyType.hashCode());
		result = prime * result + ((tagLine == null) ? 0 : tagLine.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stories other = (Stories) obj;
		if (authorId != other.authorId)
			return false;
		if (completionDate != other.completionDate)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (draft == null) {
			if (other.draft != null)
				return false;
		} else if (!draft.equals(other.draft))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (pitchApproved != other.pitchApproved)
			return false;
		if (pointsAmount != other.pointsAmount)
			return false;
		if (priority != other.priority)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (storyApproved != other.storyApproved)
			return false;
		if (storyType == null) {
			if (other.storyType != null)
				return false;
		} else if (!storyType.equals(other.storyType))
			return false;
		if (tagLine == null) {
			if (other.tagLine != null)
				return false;
		} else if (!tagLine.equals(other.tagLine))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stories [id=" + id + ", authorId=" + authorId + ", pointsAmount=" + pointsAmount + ", title=" + title
				+ ", completionDate=" + completionDate + ", storyType=" + storyType + ", genre=" + genre + ", tagLine="
				+ tagLine + ", description=" + description + ", draft=" + draft + ", priority=" + priority
				+ ", pitchApproved=" + pitchApproved + ", storyApproved=" + storyApproved + ", status=" + status + "]";
	}
}
