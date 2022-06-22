<?php
require './PT11304/demo.php' ;
connect_db();

 $data = Array();


$fetch = mysqli_query($conn,"SELECT * FROM `khachhang`");
while ($row = mysqli_fetch_array($fetch , MYSQL_ASSOC)) {
	$res[] = $row ;


}

$fetch = mysqli_query($conn,"SELECT * FROM `lop11305`");
while ($row = mysqli_fetch_array($fetch , MYSQL_ASSOC)) {
	$ress[] = $row ;


}

$data['PT11304'] = $res;
 $data['PT11305'] = $ress;
echo json_encode($data);


disconnect_db();

  ?>