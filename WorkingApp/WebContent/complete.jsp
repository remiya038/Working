<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "beans.Timesheet,java.text.SimpleDateFormat,logic.Convert,java.sql.Timestamp"%>
<%Convert convert = new Convert(); %>
<%Timestamp time = new Timestamp(System.currentTimeMillis()); %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 自動遷移 -->
    <META http-equiv="Refresh" content="2;URL=home">
    <link  href="css/stylesheet.css" rel="stylesheet">
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
 <title>実行完了</title>
</head>
<body>
<div class="container mr-sm-0 ml-sm-0 mr-md-5 ml-md-5 ">

<%String dayStr = convert.dayStr(time); %>
<p><%= dayStr  %>、書き込み完了<br>
	(自動で遷移するのでお待ちください)</p>
</div>
</body>
</html>