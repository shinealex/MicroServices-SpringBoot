package jm.shine.library.activities.model;

public class Activity {
	
	private String memberId;
	private String bookId;
	private ActivityType activityType;
	
	
	public Activity(String memberId, String bookId, ActivityType activityType) {
		super();
		this.memberId = memberId;
		this.bookId = bookId;
		this.activityType = activityType;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public ActivityType getActivityType() {
		return activityType;
	}
	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}
}
