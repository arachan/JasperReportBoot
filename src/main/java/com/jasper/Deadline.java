package com.jasper;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;


/**
 * Deadline Class
 * 
 * Generate this month's closing date and start date for invoice from current date.  
 * 
 * @author yusuke
 * @version 1.0
 * @since 2018/1/24
 */
public class Deadline {
	//Now Date
	LocalDateTime nowdate;
	// Start Date
	LocalDate startdate;
	// End Date
	LocalDate enddate;
	
	/**
	 * Constructor
	 * 
	 * get current date.
	 * 
	 * generated started date and closing date for invoice.
	 * 
	 */
	public Deadline(){
		// Start Date
		nowdate=LocalDateTime.now();
		startdate=LocalDate.now();
		startdate=startdate.minusMonths(1);
		startdate=LocalDate.of(startdate.getYear(), startdate.getMonth(),26);
		// End Date
		enddate=LocalDate.now();
		enddate=LocalDate.of(enddate.getYear(), enddate.getMonth(), 25);
	}
	
	public String startdate(){
		return startdate.toString();
	}
	
	public String enddate(){
		return enddate.toString();
	}
	
	/**
	 * getParameter Method
	 * 
	 * get generated date packed in HashMap.
	 * 
	 * this date change java.sql.date.
	 * JasperReports don't deal java.time and can deal java.sql.date.
	 * 
	 * @return parameters  startdate and enddate 
	 */
	public HashMap<String, Object> getParameter(){
		HashMap<String,Object> parameters =new HashMap<>();
		Date sdate=Date.valueOf(startdate);
		Date edate=Date.valueOf(enddate);
		
        parameters.put("startdate",sdate);
        parameters.put("enddate",edate);
               
        return parameters;
	}
	
	public LocalDateTime getNowdate(){
		return this.nowdate;
	}

}
