<?php
$servername = "127.0.0.1";
$username = "root";
$password = "root";
$dbname = "Project";
$conn = mysqli ($servername,$username,$password,$dbname);
if ($conn->connect_error)
 die("Connection Failed" . connect_error);
?>
