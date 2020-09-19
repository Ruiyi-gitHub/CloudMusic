package entity;
/**笔记类*/

import java.sql.Date;

public class Working {
	private int id;//工作笔记编号
	private String title;//工作笔记标题
	private String content;//工作笔记内容
	private Date createDate;//编写日期
	private int type;//工作笔记类型
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
