package top.qjmsystem.express.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//ORM˼��
//JPA
@Entity // ������ǰ��������ݿ⽨��������ϵ
@Table(name = "UserInfo") // User����������ݿ��userInfo
public class User {
	// ʹ��ע�⽨�����������ݱ��Ӧ
	@Id // ����
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // �������ɲ��ԣ�������
	private Integer id;

	@Column(name = "accounts") // ���ݿ��������
	private String accounts;

	@Column(name = "password")
	private String password;

	@Column(name = "userName")
	private String userName;

	@Column(name = "realName")
	private String realName;

	@Column(name = "sex")
	private String sex;

	@Column(name = "tel")
	private String tel;

	@Column(name = "permissions")
	private String permissions;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", accounts=" + accounts + ", password=" + password + ", userName=" + userName
				+ ",realName=" + realName + ", sex=" + sex + ", tel=" + tel + ", permissions=" + permissions + "]";
	}

}
