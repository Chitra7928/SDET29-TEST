package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 *  this class contains java specific generic libraries  
 * @author Chitra
 *
 */

public class JavaUtility {
	/**
	 *   its used to generate the integer RanDom number with in the boundary of 0 to 10000
	 * @return intData
	 */

	public int getRandomNumber() {
		
		Random ran= new Random();
		int random=ran.nextInt(1000);
		return random;
		
}
	/**
	 * its used to get the current System date & time
	 * @return
	 */


	public String getCurrentDate() {
		Date date = new Date();	
		String currentDate = date.toString();
		return currentDate;
	}
		
	/**
	 * its used to get the current System date with YYYY-MM-DD format
	 * @return
	 */

		public String systemdDate_YYYY_MM_DD()
		{
			Date date = new Date();
			String d= date.toString();
			String[] dte = d.split(" ");
			String YYYY = dte[5];
			String dd = dte[2];
			String mm = dte[1];
			String systemDateAndTime = YYYY+"-"+mm+"-"+dd;
			return systemDateAndTime;
		}
}