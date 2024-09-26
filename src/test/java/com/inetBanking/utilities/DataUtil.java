package com.inetBanking.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.inetBanking.testCases.BaseClass;

public class DataUtil extends BaseClass{
	@DataProvider(name = "LoginData")
	String [][] getData() throws IOException{
		String path = "src/test/resources/Login_Data.xlsx";
		
		int rownum = XLUtil.getRowCount(path, "Sheet1");
		logger.info("rows: "+rownum);
		int colnum = XLUtil.getCellCount(path, "Sheet1", 1);
		logger.info("cols: "+colnum);
		String loginData[][] = new String [rownum][colnum];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++) {
				loginData [i-1][j] = XLUtil.getCellData(path, "Sheet1", i, j);
				logger.info("Data:" + loginData [i-1][j] );
			}
		}
		return loginData;
		
	}
	

}
