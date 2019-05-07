package kr.or.ddit.ibatis;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DBUTIL1 {
	private static SqlMapClient smc;
	
	public static SqlMapClient getInstance() {
		
		if (smc == null) {
			Reader rd;
			
			try {
				rd = Resources.getResourceAsReader("SqlMapConfig.xml");
				smc = SqlMapClientBuilder.buildSqlMapClient(rd);
				rd.close();
			} catch (IOException e) {
				System.out.println("Err!! Can Not Found [SqlMapConfig.xml]");
				e.printStackTrace();
			}
		}
		return smc;
	}
	
}
