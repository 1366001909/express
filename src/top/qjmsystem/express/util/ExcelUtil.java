package top.qjmsystem.express.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import top.qjmsystem.express.bean.Consumer;
import top.qjmsystem.express.bean.Courier;
import top.qjmsystem.express.bean.GoodsInfo;
import top.qjmsystem.express.bean.GoodsPosition;
import top.qjmsystem.express.bean.User;


public class ExcelUtil {
	
	/**
	 * ������Ԫ����ʽ
	 * @param wb ����������
	 * @param fontSize �����С
	 * @return ��Ԫ����ʽ
	 */
	public static HSSFCellStyle createCellStyle(HSSFWorkbook wb, short fontSize){
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);//ˮƽ����
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//��ֱ����
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints(fontSize);//���������С
		font.setBold(true);;//�Ӵ�
		cellStyle.setFont(font);
		return cellStyle;
	}
	
	public static void exportExcel(List<User> dataList,OutputStream os) throws Exception{
		//����������
		HSSFWorkbook wb = new HSSFWorkbook();
		//����������
		HSSFSheet sheet = wb.createSheet("��ɫ�б�");
		sheet.setDefaultColumnWidth(20);//����Ĭ���п�
		
		//-------------�������б���----------------
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 6);//�����ϲ������
		sheet.addMergedRegion(region);
		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		HSSFCellStyle titleStyle = createCellStyle(wb, (short)16);//������ʽ��ָ�������СΪ16
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue("��ɫ�б�");
		
		
		//-------------������������-----------------
		String[] columns = {"�ʺ�","����","�û���","��ʵ����","�Ա�","�ֻ�����","Ȩ��"};
		HSSFRow colRow = sheet.createRow(1);//���ɵ�2��
		HSSFCellStyle colStyle = createCellStyle(wb, (short)12);//��������������ʽ
		//ѭ��������
		for(int i=0;i<columns.length;i++){
			HSSFCell colCell = colRow.createCell(i);
			colCell.setCellStyle(colStyle);//������ʽ
			colCell.setCellValue(columns[i]);//����������
		}
		
		//----------------�����û��б�-------------------
		
		HSSFRow dataRow = null;
		if(dataList!=null){
			for(int j=0;j<dataList.size();j++){
				try {
					dataRow = sheet.createRow(j+2);//�ӵ����п�ʼ,����������
					dataRow.createCell(0).setCellValue(dataList.get(j).getAccounts());//�ʺ�
					dataRow.createCell(1).setCellValue(dataList.get(j).getPassword());//����
					dataRow.createCell(2).setCellValue(dataList.get(j).getUserName());//�û���
					dataRow.createCell(3).setCellValue(dataList.get(j).getRealName());//��ʵ����
					dataRow.createCell(4).setCellValue(dataList.get(j).getSex());//�Ա�
					dataRow.createCell(5).setCellValue(dataList.get(j).getTel());//�ֻ�
					dataRow.createCell(6).setCellValue(dataList.get(j).getPermissions());//Ȩ��
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//�������
		wb.write(os);
	}
	



	
	
	
	
	public static void exportExcel_Consumer(List<Consumer> dataList,ServletOutputStream os) throws Exception{
		//����������
		HSSFWorkbook wb = new HSSFWorkbook();
		//����������
		HSSFSheet sheet = wb.createSheet("�û��б�");
		sheet.setDefaultColumnWidth(20);//����Ĭ���п�
		
		//-------------�������б���----------------
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 4);//�����ϲ������
		sheet.addMergedRegion(region);
		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		HSSFCellStyle titleStyle = createCellStyle(wb, (short)16);//������ʽ��ָ�������СΪ16
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue("�û��б�");
		
		
		//-------------������������-----------------
		String[] columns = {"���к�","΢�ź�","�Ա�","�绰","��ַ"};
		HSSFRow colRow = sheet.createRow(1);//���ɵ�2��
		HSSFCellStyle colStyle = createCellStyle(wb, (short)12);//��������������ʽ
		//ѭ��������
		for(int i=0;i<columns.length;i++){
			HSSFCell colCell = colRow.createCell(i);
			colCell.setCellStyle(colStyle);//������ʽ
			colCell.setCellValue(columns[i]);//����������
		}
		
		//----------------�����û��б�-------------------
		
		HSSFRow dataRow = null;
		if(dataList!=null){
			for(int j=0;j<dataList.size();j++){
				try {
					dataRow = sheet.createRow(j+2);//�ӵ����п�ʼ,����������
					dataRow.createCell(0).setCellValue(dataList.get(j).getNum());//���к��ʺ�
					dataRow.createCell(1).setCellValue(dataList.get(j).getWetChatAccounts());//΢�ź�
					dataRow.createCell(2).setCellValue(dataList.get(j).getSex());//�Ա�
					dataRow.createCell(3).setCellValue(dataList.get(j).getTel());//�ֻ�
					dataRow.createCell(4).setCellValue(dataList.get(j).getAddress());//��ַ
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//�������
		wb.write(os);
	}

	public static void exportExcel_GoodsInfo(List<GoodsInfo> dataList, ServletOutputStream os) throws IOException {
		//����������
				HSSFWorkbook wb = new HSSFWorkbook();
				//����������
				HSSFSheet sheet = wb.createSheet("������Ϣ�б�");
				sheet.setDefaultColumnWidth(20);//����Ĭ���п�
				
				//-------------�������б���----------------
				CellRangeAddress region = new CellRangeAddress(0, 0, 0, 6);//�����ϲ������
				sheet.addMergedRegion(region);
				HSSFRow titleRow = sheet.createRow(0);
				HSSFCell titleCell = titleRow.createCell(0);
				HSSFCellStyle titleStyle = createCellStyle(wb, (short)16);//������ʽ��ָ�������СΪ16
				titleCell.setCellStyle(titleStyle);
				titleCell.setCellValue("������Ϣ�б�");
				
				
				//-------------������������-----------------
				String[] columns = {"���к�","�����","������˾","������","ȡ����","mailNo","״̬"};
				HSSFRow colRow = sheet.createRow(1);//���ɵ�2��
				HSSFCellStyle colStyle = createCellStyle(wb, (short)12);//��������������ʽ
				//ѭ��������
				for(int i=0;i<columns.length;i++){
					HSSFCell colCell = colRow.createCell(i);
					colCell.setCellStyle(colStyle);//������ʽ
					colCell.setCellValue(columns[i]);//����������
				}
				
				//----------------�����û��б�-------------------
				
				HSSFRow dataRow = null;
				if(dataList!=null){
					for(int j=0;j<dataList.size();j++){
						try {
							dataRow = sheet.createRow(j+2);//�ӵ����п�ʼ,����������
							dataRow.createCell(0).setCellValue(dataList.get(j).getNum());//���к�
							dataRow.createCell(1).setCellValue(dataList.get(j).getMailName());//�����
							dataRow.createCell(2).setCellValue(dataList.get(j).getMailCompany());//������˾
							dataRow.createCell(3).setCellValue(dataList.get(j).gettCode());//������
							dataRow.createCell(4).setCellValue(dataList.get(j).getgCode());//ȡ����
							dataRow.createCell(5).setCellValue(dataList.get(j).getMailNo());//mailNo
							dataRow.createCell(6).setCellValue(dataList.get(j).getState());//״̬
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				//�������
				wb.write(os);
		
	}

	public static void exportExcel_GoodsPosition(List<GoodsPosition> dataList, ServletOutputStream os) throws IOException {
		//����������
		HSSFWorkbook wb = new HSSFWorkbook();
		//����������
		HSSFSheet sheet = wb.createSheet("����λ���б�");
		sheet.setDefaultColumnWidth(20);//����Ĭ���п�
		
		//-------------�������б���----------------
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 4);//�����ϲ������
		sheet.addMergedRegion(region);
		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		HSSFCellStyle titleStyle = createCellStyle(wb, (short)16);//������ʽ��ָ�������СΪ16
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue("����λ���б�");
		
		
		//-------------������������-----------------
		String[] columns = {"mailNo","��λ��¼","ʱ���-date","ʱ���-time"};
		HSSFRow colRow = sheet.createRow(1);//���ɵ�2��
		HSSFCellStyle colStyle = createCellStyle(wb, (short)12);//��������������ʽ
		//ѭ��������
		for(int i=0;i<columns.length;i++){
			HSSFCell colCell = colRow.createCell(i);
			colCell.setCellStyle(colStyle);//������ʽ
			colCell.setCellValue(columns[i]);//����������
		}
		
		//----------------�����û��б�-------------------
		
		HSSFRow dataRow = null;
		if(dataList!=null){
			for(int j=0;j<dataList.size();j++){
				try {
					dataRow = sheet.createRow(j+2);//�ӵ����п�ʼ,����������
					dataRow.createCell(0).setCellValue(dataList.get(j).getMailNo());//mailNO
					dataRow.createCell(1).setCellValue(dataList.get(j).getLocateRecorder());//��λ��¼
					dataRow.createCell(2).setCellValue(dataList.get(j).getDate());//ʱ���
					dataRow.createCell(3).setCellValue(dataList.get(j).getTime());//ʱ���
					
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//�������
		wb.write(os);
		
	}
	
	
	
	
	
	
	
	

	public static void exportExcel_Courier(List<Courier> dataList,ServletOutputStream os) throws Exception{
		//����������
		HSSFWorkbook wb = new HSSFWorkbook();
		//����������
		HSSFSheet sheet = wb.createSheet("���Ա�б�");
		sheet.setDefaultColumnWidth(20);//����Ĭ���п�
		
		//-------------�������б���----------------
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 4);//�����ϲ������
		sheet.addMergedRegion(region);
		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		HSSFCellStyle titleStyle = createCellStyle(wb, (short)16);//������ʽ��ָ�������СΪ16
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue("�û��б�");
		
		
		//-------------������������-----------------
		String[] columns = {"openid","�ʺ�","����","��ʵ����","�绰"};
		HSSFRow colRow = sheet.createRow(1);//���ɵ�2��
		HSSFCellStyle colStyle = createCellStyle(wb, (short)12);//��������������ʽ
		//ѭ��������
		for(int i=0;i<columns.length;i++){
			HSSFCell colCell = colRow.createCell(i);
			colCell.setCellStyle(colStyle);//������ʽ
			colCell.setCellValue(columns[i]);//����������
		}
		
		//----------------�����û��б�-------------------
		
		HSSFRow dataRow = null;
		if(dataList!=null){
			for(int j=0;j<dataList.size();j++){
				try {
					dataRow = sheet.createRow(j+2);//�ӵ����п�ʼ,����������
					dataRow.createCell(0).setCellValue(dataList.get(j).getOpenid());//���к��ʺ�
					dataRow.createCell(1).setCellValue(dataList.get(j).getAccounts());//΢�ź�
					dataRow.createCell(2).setCellValue(dataList.get(j).getPassword());//�Ա�
					dataRow.createCell(3).setCellValue(dataList.get(j).getRealName());//�ֻ�
					dataRow.createCell(4).setCellValue(dataList.get(j).getTel());//��ַ
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//�������
		wb.write(os);
	}
	
}
