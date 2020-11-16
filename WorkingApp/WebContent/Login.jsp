<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <title>ログイン画面</title>
  </head>
  <body>
  	<div class="container mr-sm-0 ml-sm-0 mr-md-5 ml-md-5 ">
      <div class="headline">
      <h1 class="pt-1" id="title">勤怠管理システム test</h1>
      </div>
<%

%>
<%
if(request.getAttribute("coment") != null){
	out.println("<div id=\"caution\">");
	out.println("<p>" + request.getAttribute("coment") + "</p>");
	out.println("</div>");
}
%>

    <div id="contents">
        <form method="post" action="ExecuteLogin">
          <h2>社員番号：<br></h2><!--
          --><input type="text" name="emp_no" class="textarea"><br><!--
          --><p>※6から始まる4桁の数字<br></p>
          <br>
          <h2>パスワード：<br></h2>
          <input type="password" name="pass" class="textarea"><br>
          <input type="hidden" name="number" value=9>
          <input type="hidden" value="ログイン"  class="button">
          <input type="image" src="img/login.png" alt="送信する" width="160" height="160">
</form>


<br>
    </div>
    </div>
  </body>
</html>