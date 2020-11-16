package logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Convert {
//timastamp型とString型の変換


	//Timestamp型→String型("yyyy-MM-dd)
	public String dateStr(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(timestamp);
		return dateStr;
	}

	//Timestamp型→String型(MM/dd)
	public String dateStr2(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		String dateStr = sdf.format(timestamp);
		return dateStr;
	}

	//Timestamp型→String型(HH:mm)
	public String timeStr(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String timeStr = sdf.format(timestamp);
		return timeStr;
	}
	//文字列yyyy-MM-dd HH:mmをtimestamp型に
	public Timestamp strTimestamp(String timeStr){
		Timestamp timestamp = Timestamp.valueOf(timeStr);
		return timestamp;
	}

	//Timestamp型→String型("yyyy-MM-dd HH:mm)
	public String dayStr(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dayStr = sdf.format(timestamp);
		return dayStr;
	}
	//Timestamp型→String型("yyyy")
	public String yyyyStr(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String dateStr = sdf.format(timestamp);
		return dateStr;
	}
	//Timestamp型→String型("yyyy")
	public String mmStr(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		String dateStr = sdf.format(timestamp);
		return dateStr;
	}


}
