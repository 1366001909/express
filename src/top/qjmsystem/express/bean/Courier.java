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
@Table(name = "CourierInfo") // User����������ݿ��consumerInfo
public class Courier {
	// ʹ��ע�⽨�����������ݱ��Ӧ
	@Id // ����
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // �������ɲ��ԣ�������
	private Integer id;

	// openId
	@Column(name = "openid")
	private String openid;

	// ���Ա�ʺ�
	@Column(name = "accounts") // ���ݿ��������
	private String accounts;

	// ���Ա����
	@Column(name = "password")
	private String password;

	// ���Ա��ʵ����
	@Column(name = "realName")
	private String realName;

	// ���Ա�绰
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
