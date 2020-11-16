package logic;

import java.sql.Timestamp;
import java.util.Calendar;

public class Time_logic {

	//月の最終日を取得(int型の年月)
	public int getActualMaximum(int year,int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);
		return lastDayOfMonth;
	}

	//今が何年か取得 int型
	public int getYear() {
		int year = 2000;
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Convert convert = new Convert();
		year = Integer.parseInt(convert.yyyyStr(time));
		return year;
	}

	//今が何月か取得 int型
	public int getMonth() {
		int month = 1;
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Convert convert = new Convert();
		month = Integer.parseInt(convert.mmStr(time));
		return month;
	}
}
