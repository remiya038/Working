<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "beans.Timesheet,java.util.ArrayList,logic.Convert,logic.Time_logic"%>
<%
	ArrayList<Timesheet> timesheets = (ArrayList<Timesheet>) session.getAttribute("timesheets");
%>
<%
	Convert convert = new Convert();
	Time_logic time_logic = new Time_logic();
	int now_month = time_logic.getMonth();
	int now_year = time_logic.getYear();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link  href="css/stylesheet.css" rel="stylesheet">
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
	<style>

    </style>
 <title>勤怠情報</title>
</head>
<body>
<div class="container mr-sm-0 ml-sm-0 mr-md-5 ml-md-5 ">

<!------------------------------------- 勤怠表の期間指定 -------------------------------->
<%	String month = null;
	String year = null;
	year =String.valueOf((int)session.getAttribute("year"));
	month =String.valueOf((int)session.getAttribute("month"));
%>

<form method="post" action="timesheet_date_change">

<!-- 年度の指定 -->
<select name="year">
<%
for(int i = 2020;i <= now_year;i++ ){
	if(i != Integer.parseInt(year)){ %>
	<option value=<%= i %>><%= i %></option>
	<%}else if(i == Integer.parseInt(year)){%>
	<option selected value=<%= i %>><%= i %></option>
<% 	}
} %>
</select>
年度

<!-- 月の指定 -->
<select name="month">
<%
for(int i = 1;i <= now_month;i++ ){
	if(i != Integer.parseInt(month)){ %>
	<option value=<%= i %>><%= i %></option>
	<%}else if(i == Integer.parseInt(month)){%>
	<option selected value=<%= i %>><%= i %></option>
<% 	}
} %>
</select>
月分勤怠表
<br>
	<input type="submit" value="更新"  class="button">
</form>
<!------------------------------------- 勤怠表の期間指定ここまで ------------------------->


<!-- 勤怠表の出力 -->
<table border="1" bordercolor="#333333">
<!-- 一行目　項目 -->
<tr>
	<th>日付</th>
	<th>出勤時間</th>
	<th>退勤時間</th>
	<th>勤怠区分</th>
</tr>
 <form id="update" method="post" action=Update>
<%
String strdate;

//書き込みがあるかどうかのフラグ
boolean inFlg = false;
boolean outFlg = false;
//指定された月は何日か
int maxday = (int)session.getAttribute("maxday");
//------------------1桁の数字には0を足して2桁-------------------------------------
 for(int date = 1;date <= maxday ;date++){
 	if(month.length() == 1){
		month = "0"+ month;
 	}
 	if(String.valueOf(date).length() == 1){
 		//String.valueOf(date) = "0"+ String.valueOf(date);
 		strdate = month + "/" +"0" +date;
 	}else{
	 strdate = month + "/" + date;
 	}
 //--------------------------------------------------------------------------------%>
 <tr>
<!--日付列の項目  -->
<td>
<%=month%>/<%=date %>
</td>


<!--出勤時間列の項目  -->
<td>
<%for(Timesheet timesheet:timesheets){
	if(strdate.equals(convert.dateStr2(timesheet.getPunchin()))){
		//書き込み日とテーブルの日付が一致
		String intime = convert.timeStr(timesheet.getPunchin());%>
		<%= intime %>
<%		//出勤の書き込みフラグTrue
		inFlg = true;
		break;
	}else{
		inFlg = false;
	}
}
if(inFlg == false){%>
	--:--
<%}%>
</td>

<!--退勤時間列の項目  -->
<td>
<%
for(Timesheet timesheet:timesheets){
	if(strdate.equals(convert.dateStr2(timesheet.getPunchout()))){
		//書き込み日とテーブルの日付が一致
		String outtime = convert.timeStr(timesheet.getPunchout());%>
		<%= outtime %>
<%		//出勤の書き込みフラグTrue
		outFlg = true;
		break;
	}else{
		outFlg = false;
	}
}
%>

<%
if(outFlg == false){
	%>
	--:--
<%
}
%>
</td>

<!--ステータス列の項目  -->
<td>cccc

</td>

</tr>


<tr>
<td>
<!--日付列  -->
<div class="mx-0 py-0">
 <div  id="table_font"><p>修正</p></div>
 </div></div>
 <div class="mx-0 py-0">
<input id="table_check" type="checkbox" name="riyu" value="3">
</div>
</td>
<td>
<!--出勤時間列  -->

<input type="time" name="time" >
</td>



<td>
<!--退勤時間列  -->

<input type="time" name="time" >
</td>

<td>
<!--ステータス列  -->

</td>
</tr>
<%
 }
%>
 </form>



</table>
</div>
</body>
</html>