package dev.carbajal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name="points_ref")
@Table (name="points_ref", schema="SPMS")
public class PointsRef {

	//	story_type varchar(25) unique,
	//	p_amount int unique

	@Id
	@Column(name="story_type", insertable=false, updatable=false)
	private String storyType;
	@Column(name="p_amount", insertable=false, updatable=false)
	private int pointAmount;

	public PointsRef() {
		super();
	}

	public String getStoryType() {
		return storyType;
	}

	public void setStoryType(String storyType) {
		this.storyType = storyType;
	}

	public int getPointAmount() {
		return pointAmount;
	}

	public void setPointAmount(int pointAmount) {
		this.pointAmount = pointAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pointAmount;
		result = prime * result + ((storyType == null) ? 0 : storyType.hashCode());
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
		PointsRef other = (PointsRef) obj;
		if (pointAmount != other.pointAmount)
			return false;
		if (storyType == null) {
			if (other.storyType != null)
				return false;
		} else if (!storyType.equals(other.storyType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PointsRef [storyType=" + storyType + ", pointAmount=" + pointAmount + "]";
	}
}
