package com.codurance;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * Clock 
 * recupere la date a l instant t et le format
 * 
 * @author ykhekhone
 * @date 4 avr. 2020
 */
public class Clock {
    
	public String dateAsString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.format(new Date());
	}
}
