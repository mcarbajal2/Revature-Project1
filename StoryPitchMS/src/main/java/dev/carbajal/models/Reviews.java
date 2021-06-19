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
public class Reviews {
	
//	id serial primary key,
//	story_id int references stories(id),
//	editor_id int references editors(id),
//	review_type varchar(25),
//	decision varchar(25),
//	additional_info varchar(1000)
	
	@Id
	@Column(name="id", insertable=false, updatable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne
	@JoinColumn(name="story_id")
	private int storyId;
	@OneToOne
	@JoinColumn(name="editor_id")
	private int editorId;
	@Column(name="review_type")
	private String reviewType;
	@Column(name="decision")
	private String decision;
	@Column(name="additional_info")
	private String additional_Info;
	
	public Reviews() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public int getEditorId() {
		return editorId;
	}

	public void setEditorId(int editorId) {
		this.editorId = editorId;
	}

	public String getReviewType() {
		return reviewType;
	}

	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getAdditional_Info() {
		return additional_Info;
	}

	public void setAdditional_Info(String additional_Info) {
		this.additional_Info = additional_Info;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((additional_Info == null) ? 0 : additional_Info.hashCode());
		result = prime * result + ((decision == null) ? 0 : decision.hashCode());
		result = prime * result + editorId;
		result = prime * result + id;
		result = prime * result + ((reviewType == null) ? 0 : reviewType.hashCode());
		result = prime * result + storyId;
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
		Reviews other = (Reviews) obj;
		if (additional_Info == null) {
			if (other.additional_Info != null)
				return false;
		} else if (!additional_Info.equals(other.additional_Info))
			return false;
		if (decision == null) {
			if (other.decision != null)
				return false;
		} else if (!decision.equals(other.decision))
			return false;
		if (editorId != other.editorId)
			return false;
		if (id != other.id)
			return false;
		if (reviewType == null) {
			if (other.reviewType != null)
				return false;
		} else if (!reviewType.equals(other.reviewType))
			return false;
		if (storyId != other.storyId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", storyId=" + storyId + ", editorId=" + editorId + ", reviewType=" + reviewType
				+ ", decision=" + decision + ", additional_Info=" + additional_Info + "]";
	}	
}
