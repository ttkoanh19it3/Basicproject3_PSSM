<?php 
require './demo.php' ;
// thực hiện lệnh xóa 

$id = isset($_POST['id']) ? (int)$_POST['id']:'';

if($id)
{
	xoa_monhoc($id);

}

header("location: showhang.php");


 ?>