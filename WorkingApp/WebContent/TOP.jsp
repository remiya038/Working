<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "setting.Logic_setting,setting.Beans_setting,logic.Convert"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link  href="css/stylesheet.css" rel="stylesheet">
    <!-- BootstrapのCSS読み込み -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery読み込み -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- BootstrapのJS読み込み -->
    <script src="js/bootstrap.min.js"></script>
    <script>
    function clock()
    {
        // 曜日を表す各文字列の配列
        var weeks = new Array("日","月","火","水","木","金","土");
        // 現在日時を表すインスタンスを取得
        var now = new Date();
        // 年
        var y = now.getFullYear();
        // 月 0~11で取得されるので実際の月は+1したものとなる
        var mo = now.getMonth() + 1;
        // 日
        var d = now.getDate();
        // 曜日 0~6で日曜始まりで取得されるのでweeks配列のインデックスとして指定する
        var w = weeks[now.getDay()];
        // 時
        var h = now.getHours();
        // 分
        var mi = now.getMinutes();
        // 秒
        var s = now.getSeconds();

        // 日付時刻文字列のなかで常に2ケタにしておきたい部分はここで処理
        if (mo < 10) mo = "0" + mo;
        if (d < 10) d = "0" + d;
        if (mi < 10) mi = "0" + mi;
        if (s < 10) s = "0" + s;

        //　HTML: <span id="clock_date">(ココの日付文字列を書き換え)</span>
        document.getElementById("clock_date").innerHTML =  y + "/" + mo + "/" + d + " (" + w + ")";
        //　HTML: <span id="clock_time">(ココの時刻文字列を書き換え)</span>
        document.getElementById("clock_time").innerHTML = h + ":" + mi + ":" + s;
        //　HTML: <div id="clock_frame"> の内部要素のフォントサイズをウインドウサイズの10分の1ピクセルに設定
        document.getElementById("clock_frame").style.fontSize =  window.innerWidth / 10 + "px";
    }

    // 上記のclock関数を1000ミリ秒ごと(毎秒)に実行する
    setInterval(clock, 1000);



</script>
	<title>メイン</title>
  </head>
  <body>
  	<div class="container mr-sm-0 ml-sm-0 mr-md-5 ml-md-5 ">
      <div class="headline">
      <div id="headline_coment"><p><%=request.getAttribute("name") %>さんがログインしました</p></div>
      </div>


	<div class="row col-sm-12 col-md-4" >
    <div id="clock_frame">
        <!-- 日付部分 -->
        <span id="clock_date"></span>
        <!-- 時刻部分 -->
        <span id="clock_time"></span>
    </div>
 </div>



	<% Boolean start =(Boolean)request.getAttribute("start"); %>

	<% if(start==true){ %>
	<form method="post" action="punchin">
	<input type="submit" value="出勤"  class="button">
	</form>
	<% }else{ %>
	<button type="submit" disabled>出勤</button>
	<%} %>


	<% try{  %>
	<% Boolean end =(Boolean)request.getAttribute("end"); %>
	<% if(end==true){ %>
	<form method="post" action="punchout">
	<input type="submit" value="退勤"  class="button">
	</form>
	<% }else{ %>
	<button type="submit" disabled>退勤</button>
	<%} %>
	<% }catch(Exception e){ %>
	<button type="submit" disabled>退勤</button>
	<% } %>

	<form method="post" action="timesheet_output">
	<input type="submit" value="一覧"  class="button">
	</form>






	<form method="post" action="Executelogout">
	<input type="submit" value="ログアウト"  class="button">
	</form>
</div>
</body>
</html>