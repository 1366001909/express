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
@Table(name = "GoodsInfo") // Goods����������ݿ��GoodsInfo
public class GoodsInfo {
	// ʹ��ע�⽨�����������ݱ��Ӧ
	@Id // ����
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // �������ɲ��ԣ�����
	private Integer id;

	@Column(name = "Num") // ���ݿ��������
	private String Num;

	@Column(name = "mailName") // ���ݿ��������
	private String mailName;

	@Column(name = "mailCompany") // ���ݿ��������
	private String mailCompany;

	@Column(name = "tCode") // ���ݿ��������
	private String tCode;

	@Column(name = "gCode") // ���ݿ��������
	private String gCode;

	@Column(name = "mailNo") // ���ݿ��������
	private String mailNo;

	@Column(name = "state") // ���ݿ��������
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
