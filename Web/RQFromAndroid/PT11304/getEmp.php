<?php 
 
 //Getting the requested id
 $id = $_GET['id'];
 
 //Importing database
 require_once('dbConnect.php');
 
 //Creating sql query with where clause to get an specific employee
 $sql = "SELECT * FROM khachhang WHERE id=$id";
 
 //getting result 
 $r = mysqli_query($connect,$sql);
 
 //pushing result to an array 
 $result = array();
 $row = mysqli_fetch_array($r);
 array_push($result,array(
"id"=>$row['id'],
 "name"=>$row['name'],
 "masv"=>$row['masv'],
 "link"=>$row['link'],
 "DTB"=>$row['DTB']
 ));
 
 //displaying in json format 
 echo json_encode(array('result'=>$result));
 
 mysqli_close($connect);