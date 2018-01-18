/*
 * 
 */
package database;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import algorithms.*;
import exportFiles.*;
import GUI.*;
import linkedListFilters.*;
import mainPackage.*;
import myObjects.*;
import java.sql.Statement;

// TODO: Auto-generated Javadoc
/**
 * The Class mySQL.
 */
public class mySQL {

	/** The ip. */
	private static String _ip = "5.29.193.52";
	
	/** The url. */
	private static String _url = "jdbc:mysql://" + _ip + ":3306/oop_course_ariel";
	
	/** The user. */
	private static String _user = "oop1";
	
	/** The password. */
	private static String _password = "Lambda1();";
	
	/** The con. */
	private static Connection _con = null;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
    	sqlConnectGui("5.29.193.52", "oop1", "Lambda1();", 3306,"oop_course_ariel","ex4_db");
    }
	
	/**
	 * Sql connect gui.
	 *
	 * @param ip the ip
	 * @param user the user
	 * @param pass the pass
	 * @param port the port
	 * @param db the db
	 * @param table the table
	 * @return the linked list
	 */
	public static LinkedList<Checks> sqlConnectGui(String ip,String user,String pass, int port, String db, String table) {
		
	/**
	 * connect to mySQL
	 * take from: https://github.com/benmoshe/OOP_Exe/blob/master/src/db/MySQL_101.java
	 * 
	 */
        Statement st = null;
        ResultSet rs = null;
        int max_id = -1;
        
        LinkedList<Checks> lc = new LinkedList<>();
        
    	String url = "jdbc:mysql://" + ip + ":"+port+"/"+db;

  
        try {     
            _con = DriverManager.getConnection(url, user, pass);
            st = _con.createStatement();
            rs = st.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = '"+table+"'");
            if (rs.next()) {
                System.out.println("**** Update: "+rs.getString(1));
            }
           
            PreparedStatement pst = _con.prepareStatement("SELECT * FROM "+table);
            rs = pst.executeQuery();
            int ind=0;
            while (rs.next()) {
            	Checks c = new Checks();
            	c.setTime(rs.getString(2));
            	c.setId(rs.getString(3));
            	c.setLat(rs.getDouble(4));
            	c.setLon(rs.getDouble(5));
            	c.setAlt(rs.getDouble(6));
            	c.setWifiCount(rs.getInt(7));
            	
            	int size = rs.getInt(7);
            	
            	System.out.println(size);
            	
            	WifiSort ws1 = new WifiSort(rs.getString(8),"null",0,rs.getInt(9));
            	c.setWifi1(ws1);
            	
            	if(size>1){
            		WifiSort ws2 = new WifiSort(rs.getString(10),"null",0,rs.getInt(11));
                	c.setWifi2(ws2);
            	}
            	if(size>2){
            		WifiSort ws3 = new WifiSort(rs.getString(12),"null",0,rs.getInt(13));
                	c.setWifi3(ws3);
            	}
            	if(size>3){
            		WifiSort ws4 = new WifiSort(rs.getString(14),"null",0,rs.getInt(15));
                	c.setWifi4(ws4);
            	}
            	if(size>4){
            		WifiSort ws5 = new WifiSort(rs.getString(16),"null",0,rs.getInt(17));
                	c.setWifi5(ws5);
            	}
            	if(size>5){
            		WifiSort ws6 = new WifiSort(rs.getString(18),"null",0,rs.getInt(19));
                	c.setWifi6(ws6);
            	}
            	if(size>6){
            		WifiSort ws7 = new WifiSort(rs.getString(20),"null",0,rs.getInt(21));
                	c.setWifi7(ws7);
            	}
            	if(size>7){
            		WifiSort ws8 = new WifiSort(rs.getString(22),"null",0,rs.getInt(23));
                	c.setWifi8(ws8);
            	}
            	if(size>8){
            		WifiSort ws9 = new WifiSort(rs.getString(24),"null",0,rs.getInt(25));
                	c.setWifi9(ws9);
            	}
            	if(size>9){
            		WifiSort ws10 = new WifiSort(rs.getString(26),"null",0,rs.getInt(27));
                	c.setWifi10(ws10);
            	}
            	
            	int len = 7+2*size;
            		
            	System.out.println(c);
            	lc.add(c);
            	ind++;
            }
        } 
        catch (SQLException ex) {
            Logger lgr = Logger.getLogger(mySQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            return  null;
        } 
        finally {
            try {
                if (rs != null) {rs.close();}
                if (st != null) { st.close(); }
                if (_con != null) { _con.close();  }
            } catch (SQLException ex) {
                
                Logger lgr = Logger.getLogger(mySQL.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
        return lc;
    }
		
}
