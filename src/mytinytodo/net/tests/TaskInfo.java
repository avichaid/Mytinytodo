package mytinytodo.net.tests;

public class TaskInfo {
	private String taskName;
	private String priority;
	private String day;
	private String note;
	private String tag;



	public TaskInfo(String taskName, String priority, String day, String note, String tag) {
		this.taskName = taskName;
		this.priority = priority;
		this.day = day;
		this.note = note;
		this.tag = tag;
	}



	public String getTaskName() {
		return taskName;
	}



	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}



	public String getPriority() {
		return priority;
	}



	public void setPriority(String priority) {
		this.priority = priority;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public String getTag() {
		return tag;
	}



	public void setTag(String tag) {
		this.tag = tag;
	}





}
