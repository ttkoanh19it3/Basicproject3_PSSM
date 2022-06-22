<?php 
require "dbConnect.php";


$name = $_POST['namesv04'];
$masv = $_POST['masv04'];
$link =$_POST['linksv04'];
$DTB =$_POST['dtbsv04'];

$query = "INSERT INTO `lop11305`(`id`, `name`, `masv`, `link`, `DTB`) VALUES (null,'$name','$masv','$link','$DTB')" ;

if(mysqli_query($connect,$query))
{
	// thành công
	echo "OK";
}
else 
{
	//k thành công 
	echo "LoiThem";

}
	
	?>