<html>
<title>All Time Average M3</title>
<head>
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

<div>
<?php
$servername = "localhost";
$username = "root";
$password = "root";
$db = "Project";
$id = 0;
$link = new mysqli($servername,$username,$password,$db);
if($link->connect_error)
{
die("Connection Failed: " . $link->connect_error);
}
else if($link)
{

}
$sql = "SELECT AVG(SystemLoad) AS average FROM SystemLoad3";
$result = $link->query($sql);
if($result->num_rows>0)
{
foreach($result as $row)
{
echo "Average All Time Load : " . $row["average"] . "<br>" ;
}
}
else
{
echo "0 results";
}
?>
</div>
<div>
<?php
$servername = "localhost";
$username = "root";
$password = "root";
$db = "Project";
$id = 0;
$link = new mysqli($servername,$username,$password,$db);
if($link->connect_error)
{
die("Connection Failed: " . $link->connect_error);
}
else if($link)
{

}
$sql = "SELECT AVG(MemLoad) AS average FROM MemLoad3";
$result = $link->query($sql);
if($result->num_rows>0)
{
foreach($result as $row)
{
echo "Average All Time Memory Load : " . $row["average"] . "<br>" ;
}
}
else
{
echo "0 results";
}
?>
</div>
<div>
<?php
$servername = "localhost";
$username = "root";
$password = "root";
$db = "Project";
$id = 0;
$link = new mysqli($servername,$username,$password,$db);
if($link->connect_error)
{
die("Connection Failed: " . $link->connect_error);
}
else if($link)
{

}
$sql = "SELECT AVG(NetLoad) AS average FROM NetLoad3";
$result = $link->query($sql);
if($result->num_rows>0)
{
foreach($result as $row)
{
echo "Average All Time Network Load : " . $row["average"] . "<br>" ;
}
}
else
{
echo "0 results";
}
?>
</div>


<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>

<script src="layout/scripts/jquery.min.js"></script>

<script src="layout/scripts/jquery.backtotop.js"></script>

<script src="layout/scripts/jquery.mobilemenu.js"></script>

</body>

</html>
