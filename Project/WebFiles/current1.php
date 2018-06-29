<html>
<title>Current Hour</title>
<head>

<link rel ="stylesheet" href= "cdn.oesmith.co.uk/morris-0.5.1.css">
<script src="ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"> </script>
<script src="cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"> </script>
<script src="cdnj.oesmith.co.uk/morris-0.5.1.min.js"> </script>
</head>
<body>
/*<?php
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
$sql = "SELECT * FROM SystemLoad  WHERE ID > date_sub(now(), interval 1 hour)";
$result = $link->query($sql);
$chart_data = '';
if($result->num_rows>0)
{
	while($row = $result->fetch_assoc())
	{
		$chart_data .= 'Timestamp ' . $row["ID"] . ' SystemLoad (%) ' . $row["SystemLoad"] ;
	}
	$chart_data = substr($chart_data, 0 , -2);
}
else
{
	echo "0 results";
}
?>*/
<script>
new Morris.Line({
element : 'chart',
data:[
{ year: '2008', value: 20},
{ year: '2009', value: 10},
{ year: '2010', value: 5},
{ year: '2011', value: 5},
{ year: '2012', value: 20}
],
xkey:'year',
ykeys:['value'],
labels: ['Value']
});
</script>
<style>
#chart{
height:400px;
}
</style>
<a href="past.php"><input type ="button" name="hour" value="Past Hour"></a>
<a href="pastday.php"><input type ="button" name="day" value="Past Day"></a>
<a href="averageload.php"><input type ="button" name="average" value="All Time Average"></a>
<div id="chart"></div>
</body>
</html>
