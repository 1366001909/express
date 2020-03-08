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
@Table(name = "ConsumerInfo") // User对象关联数据库表consumerInfo
public class Consumer {
	// 使用注解建立对象与数据表对应
	@Id // 主键
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，自增长
	private Integer id;

	@Column(name = "Num") // 数据库的列名称
	private String Num;

	@Column(name = "wetChatAccounts") // 数据库的列名称
	private String wetChatAccounts;
	
	@Column(name="openid")
	private String openid;

	@Column(name = "sex")
	private String sex;

	@Column(name = "tel")
	private String tel;

	@Column(name = "address")
	private String address;

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

	public String getWetChatAccounts() {
		return wetChatAccounts;
	}

	public void setWetChatAccounts(String wetChatAccounts) {
		this.wetChatAccounts = wetChatAccounts;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Override
	public String toString() {
		return "Consumer [id=" + id + "Num=" + Num + ", wetChatAccounts=" + wetChatAccounts + "openid=" + openid+" sex=" + sex + ", tel="
				+ tel + ", address=" + address + "]";
	}

}