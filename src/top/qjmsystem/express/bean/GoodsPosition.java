package top.qjmsystem.express.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//ORM思想
//JPA
@Entity // 标明当前类会与数据库建立关联关系
@Table(name = "GoodsPosition") // Goods对象关联数据库表GoodsPosition
public class GoodsPosition {
	// 使用注解建立对象与数据表对应
	@Id // 主键
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，自增
	private Integer id;

	@Column(name = "mailNo") // 数据库的列名称
	private String mailNo;

	@Column(name = "locateRecorder") // 数据库的列名称
	private String locateRecorder;

	@Column(name = "time") // 数据库的列名称
	private String time;
	
	@Column(name="date")
	private String date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}

	public String getLocateRecorder() {
		return locateRecorder;
	}

	public void setLocateRecorder(String locateRecorder) {
		this.locateRecorder = locateRecorder;
	}



	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "GoodsPosition [id = " + id + ", mailNo=" + mailNo + ", locateRecorder=" + locateRecorder +", date="
				+ date + ", time="
				+ time + "]";
	}
}
