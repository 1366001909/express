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
@Table(name = "GoodsPosition") // Goods����������ݿ��GoodsPosition
public class GoodsPosition {
	// ʹ��ע�⽨�����������ݱ��Ӧ
	@Id // ����
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // �������ɲ��ԣ�����
	private Integer id;

	@Column(name = "mailNo") // ���ݿ��������
	private String mailNo;

	@Column(name = "locateRecorder") // ���ݿ��������
	private String locateRecorder;

	@Column(name = "time") // ���ݿ��������
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
