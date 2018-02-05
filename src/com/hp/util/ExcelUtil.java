package com.hp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hp.entity.AreaInfo;


/**
 * Excel操作工具类
 * 
 * @author root
 *
 */
public class ExcelUtil {

	/**
	 * 将Excel文件导入到List<AreaInfo>中去
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static List<AreaInfo> importExcel(String path) throws IOException {
		//判断格式
		String reg = "^.+\\.(?i)((xls)|(xlsx))$";
		AreaInfo area = null;
		List<AreaInfo> list = new ArrayList<AreaInfo>();
		if (path.matches(reg)) {
			FileInputStream fis = new FileInputStream(path);
			boolean is03Excel = path.matches("^.+\\.(?i)(xls)$") ? true : false;
			Workbook workbook = is03Excel ? new HSSFWorkbook(fis) : new XSSFWorkbook(fis);
			int numSheets = workbook.getNumberOfSheets();
			int i = 0;
			/**
			 * 按照工作簿遍历
			 */
			while (i < numSheets) {
				Sheet workSheet = workbook.getSheetAt(i);
				/**
				 * 按照行遍历，跳过第一行
				 */
				for (int j = 1; j < workSheet.getLastRowNum(); j++) {
					Row row = workSheet.getRow(j);
					if (row == null){
						continue;
					}
					area = new AreaInfo();
					int cellNum = row.getLastCellNum();
					int m = 0;
					area.setName(row.getCell(m).getStringCellValue());
					area.setHot(row.getCell(m + 1).getStringCellValue());
					area.setDesp(row.getCell(m + 2).getStringCellValue());
					i++;
					list.add(area);
				}
			}
		}
		return list;
	}
}
