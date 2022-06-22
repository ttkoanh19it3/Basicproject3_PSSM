<?php
require 'demo.php' ;
connect_db();

 $data = Array();


$fetch = mysqli_query($conn,"SELECT * FROM `monhoc`");
while ($row = mysqli_fetch_array($fetch , MYSQL_ASSOC)) {
	$res[] = $row ;
}



$data['monhoc'] = $res;
echo json_encode($data);


disconnect_db();

  ?>