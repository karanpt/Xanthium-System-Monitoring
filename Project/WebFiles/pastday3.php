<?php

 $con = mysqli_connect('localhost','root','root','Project');

?>

<!DOCTYPE HTML>

<html>

<head>

 <meta charset="utf-8">

 <title>Past Day M3</title>

 <script type="text/javascript" src="https:/www.google.com/jsapi"></script>

  <script type="text/javascript" src="https:/www.gstatic.com/charts/loader.js"></script>

    <link rel="stylesheet" href="https:/maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https:/ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

  <script src="https:/maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <script type="text/javascript">

 google.load("visualization", "1", {packages:["corechart"]});

 google.setOnLoadCallback(drawChart);

 function drawChart() {

 var data = google.visualization.arrayToDataTable([



 ['ID','SystemLoad'],

 <?php 

			$query = "SELECT * FROM SystemLoad3 WHERE ID > date_sub(now(), interval 1 day)";



			 $exec = mysqli_query($con,$query);

			 while($row = mysqli_fetch_array($exec)){



				 echo "['".$row['ID']."',".$row['SystemLoad']."],";

			 }

			 ?> 

 

 ]);



 var options = {


  pieHole: 0.5,

          pieSliceTextStyle: {

            color: 'black',

          },

          legend: 'none',
title:'System Load'

 };

 var chart = new google.visualization.LineChart(document.getElementById("columnchart12"));

 chart.draw(data,options);

 }

google.setOnLoadCallback(drawChart2);

 function drawChart2() {

 var data2 = google.visualization.arrayToDataTable([



 ['ID','MemLoad'],

 <?php 

			$query = "SELECT * FROM MemLoad3 WHERE ID > date_sub(now(), interval 1 day)";



			 $exec = mysqli_query($con,$query);

			 while($row = mysqli_fetch_array($exec)){



				 echo "['".$row['ID']."',".$row['MemLoad']."],";

			 }

			 ?> 

 

 ]);



 var options2 = {


  pieHole: 0.5,

          pieSliceTextStyle: {

            color: 'black',

          },

          legend: 'none',
title:'Memory Load'
 };

 var chart2 = new google.visualization.LineChart(document.getElementById("columnchart13"));

 chart2.draw(data2,options2);

 }
	google.setOnLoadCallback(drawChart3);
function drawChart3() {

 var data3 = google.visualization.arrayToDataTable([



 ['ID','NetLoad'],

 <?php 

			$query = "SELECT * FROM NetLoad3 WHERE ID > date_sub(now(), interval 1 day)";



			 $exec = mysqli_query($con,$query);

			 while($row = mysqli_fetch_array($exec)){



				 echo "['".$row['ID']."',".$row['NetLoad']."],";

			 }

			 ?> 

 

 ]);



 var options3 = {


  pieHole: 0.5,

          pieSliceTextStyle: {

            color: 'black',

          },

          legend: 'none',
title:'Network Load'
 };

 var chart3 = new google.visualization.LineChart(document.getElementById("columnchart14"));

 chart3.draw(data3,options3);

 }	

    </script>



<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">


</head>
<body id="top">



<div class="wrapper row1">

  <header id="header" class="hoc clear">

    <div id="logo" class="fl_left">

		<br/>

      <h1 style="font-size:50px; font-style:italic"><a href="start.html">Xanthium</a></h1>

    </div>

    <div id="quickinfo" class="fl_right">

      <img src="ongc_logo.jpg" alt="ONGC" width="200" height="200" style="float:left;">

    </div>

    </header>

</div>

<div class="wrapper row2">

  <nav id="mainav" class="hoc clear">

        <ul class="clear">

      <li class="active"><a href="start.html">Home</a></li>

 <li><a class="drop" href="#">Machine 1</a>

        <ul>

          <li><a href="current.php">Current Hour</a></li>

          <li><a href="past.php">Past Hour</a></li>

          <li><a href="pastday.php">Past Day</a></li>

          <li><a href="averageload.php">All Time Average</a></li>

        </ul>

      </li>



	   <li><a class="drop" href="#">Machine 2</a>

        <ul>

          <li><a href="current2.php">Current Hour</a></li>

          <li><a href="past2.php">Past Hour</a></li>

          <li><a href="pastday2.php">Past Day</a></li>

          <li><a href="averageload2.php">All Time Average</a></li>

        </ul>

      </li>



	   <li><a class="drop" href="#">Machine 3</a>

        <ul>

          <li><a href="current3.php">Current Hour</a></li>

          <li><a href="past3.php">Past Hour</a></li>

          <li><a href="pastday3.php">Past Day</a></li>

          <li><a href="averageload3.php">All Time Average</a></li>

        </ul>

      </li>



	   <li><a class="drop" href="#">Machine 4</a>

        <ul>

          <li><a href="current4.php">Current Hour</a></li>

          <li><a href="past4.php">Past Hour</a></li>

          <li><a href="pastday4.php">Past Day</a></li>

          <li><a href="averageload4.php">All Time Average</a></li>

        </ul>

      </li>

    </ul>


  </nav>

</div>

<div class="wrapper bgded overlay" style="background-image:url('images/demo/backgrounds/01.png');">


</div>



<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>

<script src="layout/scripts/jquery.min.js"></script>

<script src="layout/scripts/jquery.backtotop.js"></script>

<script src="layout/scripts/jquery.mobilemenu.js"></script>


 <div class="container-fluid">

 <div id="columnchart12" style="height: 700px;top:10px;position:relative;"></div>

 </div>

<div class="container-fluid">

 <div id="columnchart13" style="height: 700px;top:30px;position:relative;""></div>

 </div>
<div class="container-fluid">

 <div id="columnchart14" style="height: 700px;top:30px;position:relative;""></div>

 </div>



</body>

</html>
