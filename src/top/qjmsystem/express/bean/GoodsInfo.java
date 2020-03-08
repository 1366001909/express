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
@Table(name = "GoodsInfo") // Goods对象关联数据库表GoodsInfo
public class GoodsInfo {
	// 使用注解建立对象与数据表对应
	@Id // 主键
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，自增
	private Integer id;

	@Column(name = "Num") // 数据库的列名称
	private String Num;

	@Column(name = "mailName") // 数据库的列名称
	private String mailName;

	@Column(name = "mailCompany") // 数据库的列名称
	private String mailCompany;

	@Column(name = "tCode") // 数据库的列名称
	private String tCode;

	@Column(name = "gCode") // 数据库的列名称
	private String gCode;

	@Column(name = "mailNo") // 数据库的列名称
	private String mailNo;

	@Column(name = "state") // 数据库的列名称
	private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNum() {
		return Num;
	}

	public void setNum(String num) {
		Num = num;
	}

	public String getMailName() {
		return mailName;
	}

	public void setMailName(String mailName) {
		this.mailName = mailName;
	}

	public String getMailCompany() {
		return mailCompany;
	}

	public void setMailCompany(String mailCompany) {
		this.mailCompany = mailCompany;
	}

	public String gettCode() {
		return tCode;
	}

	public void setTCode(String tCode) {
		this.tCode = tCode;
	}

	public String getgCode() {
		return gCode;
	}

	public void setGCode(String gCode) {
		this.gCode = gCode;
	}

	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "GoodsInfo [id = " + id + ", Num=" + Num + ", mailName=" + mailName + ", mailCompany=" + mailCompany
				+ ",tCode=" + tCode + ", gCode=" + gCode + ", mailNo=" + mailNo + ",state=" + state + "]";
	}
}
