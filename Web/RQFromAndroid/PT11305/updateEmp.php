<?php 
require "dbConnect.php";


$name = $_POST['namesv04'];
$masv = $_POST['masv04'];
$link =$_POST['linksv04'];
$DTB =$_POST['dtbsv04'];
$id = $_POST['idsv04'];




$query = "UPDATE `lop11305` SET `name`='$name',`masv`='$masv',`link`='$link',`DTB`='$DTB' WHERE `id`='$id'" ;

if(mysqli_query($connect,$query))
{
	// thành công
	echo "OK";
}
else 
{
	//k thành công 
	echo "Loi";

}
	
	?>