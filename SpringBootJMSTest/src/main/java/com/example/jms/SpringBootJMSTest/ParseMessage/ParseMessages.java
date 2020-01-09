package com.example.jms.SpringBootJMSTest.ParseMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.jms.SpringBootJMSTest.Config.DBCPDataSource;
import com.example.jms.SpringBootJMSTest.dto.MainMessage;
import com.google.gson.Gson;


public class ParseMessages {
	private static Gson gson = new Gson();
	static Logger logger = LoggerFactory.getLogger(ParseMessages.class);
	
	
	@SuppressWarnings("deprecation")
	public static void saveJmsTextData(String messageObj) {
		Connection con=null;
		PreparedStatement preStmt=null;
		
		logger.info("Messages in ParseMessages of TextMessage:::::-->"+messageObj);
		
		String s1=messageObj.substring(71);
		String requestType=messageObj.substring(0, 1);
		
		String trn=messageObj.substring(1, 23);
		
		String name=messageObj.substring(23, 43);
		String fortmateType=messageObj.substring(43, 44);
		
		String amt=messageObj.substring(44, 63);
		
		 double amount = Double.parseDouble(amt);
		
		String currency=messageObj.substring(63, 66);
		//double amount=
		String service=messageObj.substring(66, 69);
		String countryCode=messageObj.substring(69, 71);
		
		String[] strArray=s1.split(":");
		
		String refereceNumbers=strArray[2];
		
		
		String exeDate=strArray[4];
		
			String fxRa=strArray[6];
		 double fxRate = Double.parseDouble(fxRa);
		 java.sql.Date sqlDate=null;
		 
		 SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");

	     try {

	        Date utilDate = formatter.parse(exeDate);
	        sqlDate   = new java.sql.Date(utilDate.getTime());
	         System.out.println("executionDate"+sqlDate);
	     } catch (ParseException e) {
	         e.printStackTrace();
	     }
		
	     
	     
	     
	     try {
			 con = DBCPDataSource.getConnection();
			
			 logger.info("Connection --::"+con.toString());
				
			 preStmt=con.prepareStatement("insert into messages_stagging (amount,country_code,"
					+ "currency,execution_date,formate_type,fx_rate, name,"
					+ "	refference_number, request_type , service, trn ) values(?,?,?,?,?,?,?,?,?,?,?);");
			
			preStmt.setDouble(1,amount);
			preStmt.setString(2, countryCode);
			preStmt.setString(3, currency);
			preStmt.setDate(4, sqlDate);
			preStmt.setString(5,fortmateType);
			preStmt.setDouble(6, fxRate);
			preStmt.setString(7, name.trim());
			preStmt.setString(8, refereceNumbers);
			preStmt.setString(9, requestType);
			preStmt.setString(10, service);
			preStmt.setString(11, trn);
			
			
			logger.info("Connection --::"+preStmt.toString());
			
			preStmt.executeUpdate(); 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				preStmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	     
	}
	
	
	
	public static void saveJmsJSONData(MainMessage messageObj) {
		String text=gson.toJson(messageObj);
		logger.info("Object Message::"+text);
		Connection con=null;
		PreparedStatement preStmt=null;
		
		try {
			 con = DBCPDataSource.getConnection();
			
			
			 preStmt=con.prepareStatement("insert into messages_stagging (amount,country_code,"
					+ "currency,execution_date,formate_type,fx_rate, name,"
					+ "	refference_number, request_type , service, trn ) values(?,?,?,?,?,?,?,?,?,?,?);");
			
			preStmt.setDouble(1, messageObj.getAmount());
			preStmt.setString(2, messageObj.getCountryCode());
			preStmt.setString(3, messageObj.getCurrency());
			preStmt.setDate(4, messageObj.getExecutionDate());
			preStmt.setString(5, messageObj.getFormateType());
			preStmt.setDouble(6, messageObj.getFxRate());
			preStmt.setString(7, messageObj.getName());
			preStmt.setString(8, messageObj.getRefferenceNumber());
			preStmt.setString(9, messageObj.getRequestType());
			preStmt.setString(10, messageObj.getService());
			preStmt.setString(11, messageObj.gettRn());
			
		/*	String uniqueID = UUID.randomUUID().toString();
			preStmt.setString(12,uniqueID);*/
			
			
			logger.info("Connection --::"+preStmt.toString());
			
			
			preStmt.executeUpdate(); 
			
			logger.info("Connection --::"+con.toString());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				preStmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		//messageRepository.save(messageObj);
	}
}
