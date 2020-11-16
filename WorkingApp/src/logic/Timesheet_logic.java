package logic;
import java.sql.Timestamp;
import java.util.ArrayList;

import beans.Timesheet;
import dao.Dao2;




public class Timesheet_logic {
   Dao2 dao = new Dao2();
   Timestamp time = new Timestamp(System.currentTimeMillis());
   Convert convert = new Convert();

   //出勤チェックメソッド
   public Boolean start_check(int emp_no) {

	   //出勤可能：true 不可能:false
	   Boolean flag=null;
	   Timesheet timesheet = new Timesheet();//検索したタイムシートを格納する変数
	   String dateStr = convert.dateStr(time);
	   timesheet = dao.search_emp_date(emp_no, dateStr);//検索したタイムシートを格納
	   if(timesheet != null) {
		   //「実行日」が本日と一致するデータ取得
		   flag = false;
	   }else{
		   //本日のデータがないので出勤可能
		   flag = true;
	   }
	   return flag;
   }


   //退勤チェックメソッド
   public Boolean end_check(int emp_no) {

	   //退勤可能：true 不可能:false
	   Boolean flag=null;
	   Timesheet timesheet = new Timesheet();//検索したタイムシートを格納する変数
	   String dateStr = convert.dateStr(time);
	   timesheet = dao.search_emp_date(emp_no, dateStr);//検索したタイムシートを格納
	   if(timesheet != null) {
		   //「実行日」が本日と一致するデータ取得
		   if(timesheet.getPunchin() != null) {
			   //本日出勤済み
			   if(timesheet.getPunchout() == null) {
				 //本日退勤していない
			   flag = true;
		   }
	   }
	   }else{
		   //本日のデータがないので退勤可能
		   flag = false;
	   }
	   return flag;
   }


   //出勤メソッド
   public Timesheet punchin(int emp_no) {
      Timesheet timesheet = dao.punchin(emp_no, time);
      return timesheet;
   }
   //退勤メソッド
   public int punchout(int emp_no) {
	   String dateStr = convert.dateStr(time);
	   int num = dao.punchout(emp_no, time,dateStr);
	   return num;
	   }

 //勤怠一覧出力メソッド
   public ArrayList<Timesheet> table(int emp_no) {
      new ArrayList();
      ArrayList<Timesheet> timesheets = this.dao.select_emp(emp_no);
      return timesheets;
   }
}