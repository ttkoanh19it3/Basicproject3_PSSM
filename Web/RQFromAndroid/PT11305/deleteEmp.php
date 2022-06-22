<?php 
require "dbConnect.php";

$idsv = $_POST['idofsv'];




$query = "DELETE FROM `lop11305` WHERE `id`='$idsv'";

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