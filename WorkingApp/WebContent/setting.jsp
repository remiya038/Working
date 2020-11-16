<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "setting.Beans_setting,logic.Convert"%>
<% Beans_setting beans =(Beans_setting)request.getAttribute("beans");%>
<% Convert con = new Convert(); %>
<!DOCTYPE html>
<html>
<head>
<script>

</script>

<meta charset="UTF-8">
<title>設定画面</title>
</head>
<body>
<% String msg =(String)session.getAttribute("setting_msg");%>
<%=msg %>
<br>

 <form id="update" method="post" action=Update>
 	<select form="update" name="mode">
	<option value="0">通常</option>
	<option value="1">テストモード</option>
	</select>
	<br>
 	<input type="date" name="date" min="2020-01-01" max="2999-12-31" id="today">
 	<br>
 	<input type="time" name="time" >
 	<br>
 	<input type="submit" value="変更"  class="button">
 </form>
<br>

 	<h1>現在の設定</h1>
	<%if(beans.getMode()==0){ %>
		<p>通常モード</p>
		<p>現在の時刻で処理</p>

	<%}else if(beans.getMode()==1){ %>
		<p>テストモード</p>
		<p><%=con.dateStr(beans.getDate()) %><br>
		<%=con.timeStr(beans.getDate()) %>で処理</p>
	<%} %>


</body>
</html>