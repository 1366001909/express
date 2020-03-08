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
@Table(name = "CourierInfo") // User对象关联数据库表consumerInfo
public class Courier {
	// 使用注解建立对象与数据表对应
	@Id // 主键
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略，自增长
	private Integer id;

	// openId
	@Column(name = "openid")
	private String openid;

	// 快递员帐号
	@Column(name = "accounts") // 数据库的列名称
	private String accounts;

	// 快递员密码
	@Column(name = "password")
	private String password;

	// 快递员真实姓名
	@Column(name = "realName")
	private String realName;

	// 快递员电话
	@Column(name = "tel")
	private String tel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Courier [id=" + id + ", openid=" + openid + ", accounts=" + accounts + ", password=" + password
				+ ",realName=" + realName + ", tel=" + tel + "]";
	}

}
