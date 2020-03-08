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
	 * 创建单元格样式
	 * @param wb 工作簿对象
	 * @param fontSize 字体大小
	 * @return 单元格样式
	 */
	public static HSSFCellStyle createCellStyle(HSSFWorkbook wb, short fontSize){
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints(fontSize);//设置字体大小
		font.setBold(true);;//加粗
		cellStyle.setFont(font);
		return cellStyle;
	}
	
	public static void exportExcel(List<User> dataList,OutputStream os) throws Exception{
		//创建工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet = wb.createSheet("角色列表");
		sheet.setDefaultColumnWidth(20);//设置默认列宽
		
		//-------------生成首行标题----------------
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 6);//创建合并域对象
		sheet.addMergedRegion(region);
		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		HSSFCellStyle titleStyle = createCellStyle(wb, (short)16);//生成样式，指定字体大小为16
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue("角色列表");
		
		
		//-------------生成列名标题-----------------
		String[] columns = {"帐号","密码","用户名","真实姓名","性别","手机号码","权限"};
		HSSFRow colRow = sheet.createRow(1);//生成第2行
		HSSFCellStyle colStyle = createCellStyle(wb, (short)12);//生成列名标题样式
		//循环创建列
		for(int i=0;i<columns.length;i++){
			HSSFCell colCell = colRow.createCell(i);
			colCell.setCellStyle(colStyle);//设置样式
			colCell.setCellValue(columns[i]);//设置列名称
		}
		
		//----------------生成用户列表-------------------
		
		HSSFRow dataRow = null;
		if(dataList!=null){
			for(int j=0;j<dataList.size();j++){
				try {
					dataRow = sheet.createRow(j+2);//从第三行开始,生成数据列
					dataRow.createCell(0).setCellValue(dataList.get(j).getAccounts());//帐号
					dataRow.createCell(1).setCellValue(dataList.get(j).getPassword());//密码
					dataRow.createCell(2).setCellValue(dataList.get(j).getUserName());//用户名
					dataRow.createCell(3).setCellValue(dataList.get(j).getRealName());//真实姓名
					dataRow.createCell(4).setCellValue(dataList.get(j).getSex());//性别
					dataRow.createCell(5).setCellValue(dataList.get(j).getTel());//手机
					dataRow.createCell(6).setCellValue(dataList.get(j).getPermissions());//权限
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//输出数据
		wb.write(os);
	}
	



	
	
	
	
	public static void exportExcel_Consumer(List<Consumer> dataList,ServletOutputStream os) throws Exception{
		//创建工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet = wb.createSheet("用户列表");
		sheet.setDefaultColumnWidth(20);//设置默认列宽
		
		//-------------生成首行标题----------------
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 4);//创建合并域对象
		sheet.addMergedRegion(region);
		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		HSSFCellStyle titleStyle = createCellStyle(wb, (short)16);//生成样式，指定字体大小为16
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue("用户列表");
		
		
		//-------------生成列名标题-----------------
		String[] columns = {"序列号","微信号","性别","电话","地址"};
		HSSFRow colRow = sheet.createRow(1);//生成第2行
		HSSFCellStyle colStyle = createCellStyle(wb, (short)12);//生成列名标题样式
		//循环创建列
		for(int i=0;i<columns.length;i++){
			HSSFCell colCell = colRow.createCell(i);
			colCell.setCellStyle(colStyle);//设置样式
			colCell.setCellValue(columns[i]);//设置列名称
		}
		
		//----------------生成用户列表-------------------
		
		HSSFRow dataRow = null;
		if(dataList!=null){
			for(int j=0;j<dataList.size();j++){
				try {
					dataRow = sheet.createRow(j+2);//从第三行开始,生成数据列
					dataRow.createCell(0).setCellValue(dataList.get(j).getNum());//序列号帐号
					dataRow.createCell(1).setCellValue(dataList.get(j).getWetChatAccounts());//微信号
					dataRow.createCell(2).setCellValue(dataList.get(j).getSex());//性别
					dataRow.createCell(3).setCellValue(dataList.get(j).getTel());//手机
					dataRow.createCell(4).setCellValue(dataList.get(j).getAddress());//地址
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//输出数据
		wb.write(os);
	}

	public static void exportExcel_GoodsInfo(List<GoodsInfo> dataList, ServletOutputStream os) throws IOException {
		//创建工作簿
				HSSFWorkbook wb = new HSSFWorkbook();
				//创建工作表
				HSSFSheet sheet = wb.createSheet("物流信息列表");
				sheet.setDefaultColumnWidth(20);//设置默认列宽
				
				//-------------生成首行标题----------------
				CellRangeAddress region = new CellRangeAddress(0, 0, 0, 6);//创建合并域对象
				sheet.addMergedRegion(region);
				HSSFRow titleRow = sheet.createRow(0);
				HSSFCell titleCell = titleRow.createCell(0);
				HSSFCellStyle titleStyle = createCellStyle(wb, (short)16);//生成样式，指定字体大小为16
				titleCell.setCellStyle(titleStyle);
				titleCell.setCellValue("物流信息列表");
				
				
				//-------------生成列名标题-----------------
				String[] columns = {"序列号","快递名","物流公司","运输码","取件码","mailNo","状态"};
				HSSFRow colRow = sheet.createRow(1);//生成第2行
				HSSFCellStyle colStyle = createCellStyle(wb, (short)12);//生成列名标题样式
				//循环创建列
				for(int i=0;i<columns.length;i++){
					HSSFCell colCell = colRow.createCell(i);
					colCell.setCellStyle(colStyle);//设置样式
					colCell.setCellValue(columns[i]);//设置列名称
				}
				
				//----------------生成用户列表-------------------
				
				HSSFRow dataRow = null;
				if(dataList!=null){
					for(int j=0;j<dataList.size();j++){
						try {
							dataRow = sheet.createRow(j+2);//从第三行开始,生成数据列
							dataRow.createCell(0).setCellValue(dataList.get(j).getNum());//序列号
							dataRow.createCell(1).setCellValue(dataList.get(j).getMailName());//快递名
							dataRow.createCell(2).setCellValue(dataList.get(j).getMailCompany());//物流公司
							dataRow.createCell(3).setCellValue(dataList.get(j).gettCode());//运输码
							dataRow.createCell(4).setCellValue(dataList.get(j).getgCode());//取件码
							dataRow.createCell(5).setCellValue(dataList.get(j).getMailNo());//mailNo
							dataRow.createCell(6).setCellValue(dataList.get(j).getState());//状态
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				//输出数据
				wb.write(os);
		
	}

	public static void exportExcel_GoodsPosition(List<GoodsPosition> dataList, ServletOutputStream os) throws IOException {
		//创建工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet = wb.createSheet("物流位置列表");
		sheet.setDefaultColumnWidth(20);//设置默认列宽
		
		//-------------生成首行标题----------------
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 4);//创建合并域对象
		sheet.addMergedRegion(region);
		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		HSSFCellStyle titleStyle = createCellStyle(wb, (short)16);//生成样式，指定字体大小为16
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue("物流位置列表");
		
		
		//-------------生成列名标题-----------------
		String[] columns = {"mailNo","定位记录","时间戳-date","时间戳-time"};
		HSSFRow colRow = sheet.createRow(1);//生成第2行
		HSSFCellStyle colStyle = createCellStyle(wb, (short)12);//生成列名标题样式
		//循环创建列
		for(int i=0;i<columns.length;i++){
			HSSFCell colCell = colRow.createCell(i);
			colCell.setCellStyle(colStyle);//设置样式
			colCell.setCellValue(columns[i]);//设置列名称
		}
		
		//----------------生成用户列表-------------------
		
		HSSFRow dataRow = null;
		if(dataList!=null){
			for(int j=0;j<dataList.size();j++){
				try {
					dataRow = sheet.createRow(j+2);//从第三行开始,生成数据列
					dataRow.createCell(0).setCellValue(dataList.get(j).getMailNo());//mailNO
					dataRow.createCell(1).setCellValue(dataList.get(j).getLocateRecorder());//定位记录
					dataRow.createCell(2).setCellValue(dataList.get(j).getDate());//时间戳
					dataRow.createCell(3).setCellValue(dataList.get(j).getTime());//时间戳
					
		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//输出数据
		wb.write(os);
		
	}
	
	
	
	
	
	
	
	

	public static void exportExcel_Courier(List<Courier> dataList,ServletOutputStream os) throws Exception{
		//创建工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建工作表
		HSSFSheet sheet = wb.createSheet("快递员列表");
		sheet.setDefaultColumnWidth(20);//设置默认列宽
		
		//-------------生成首行标题----------------
		CellRangeAddress region = new CellRangeAddress(0, 0, 0, 4);//创建合并域对象
		sheet.addMergedRegion(region);
		HSSFRow titleRow = sheet.createRow(0);
		HSSFCell titleCell = titleRow.createCell(0);
		HSSFCellStyle titleStyle = createCellStyle(wb, (short)16);//生成样式，指定字体大小为16
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue("用户列表");
		
		
		//-------------生成列名标题-----------------
		String[] columns = {"openid","帐号","密码","真实姓名","电话"};
		HSSFRow colRow = sheet.createRow(1);//生成第2行
		HSSFCellStyle colStyle = createCellStyle(wb, (short)12);//生成列名标题样式
		//循环创建列
		for(int i=0;i<columns.length;i++){
			HSSFCell colCell = colRow.createCell(i);
			colCell.setCellStyle(colStyle);//设置样式
			colCell.setCellValue(columns[i]);//设置列名称
		}
		
		//----------------生成用户列表-------------------
		
		HSSFRow dataRow = null;
		if(dataList!=null){
			for(int j=0;j<dataList.size();j++){
				try {
					dataRow = sheet.createRow(j+2);//从第三行开始,生成数据列
					dataRow.createCell(0).setCellValue(dataList.get(j).getOpenid());//序列号帐号
					dataRow.createCell(1).setCellValue(dataList.get(j).getAccounts());//微信号
					dataRow.createCell(2).setCellValue(dataList.get(j).getPassword());//性别
					dataRow.createCell(3).setCellValue(dataList.get(j).getRealName());//手机
					dataRow.createCell(4).setCellValue(dataList.get(j).getTel());//地址
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//输出数据
		wb.write(os);
	}
	
}
