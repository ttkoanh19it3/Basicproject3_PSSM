<?php
require 'demo.php' ;
connect_db();

 $data = Array();



// ong vàng là ta

$fetch = mysqli_query($conn,"SELECT name,masv,DTB FROM khachhang WHERE DTB>8 ORDER BY DTB DESC LIMIT 1");
while ($row = mysqli_fetch_array($fetch , MYSQL_ASSOC)) {
	$res[] = $row ;




}


// sinh viên xuất sắc
$fetch = mysqli_query($conn,"SELECT name,masv,DTB FROM khachhang WHERE DTB>8 ORDER BY DTB DESC LIMIT 1,3");
while ($row = mysqli_fetch_array($fetch , MYSQL_ASSOC)) {
	$ress[] = $row ;


}

// sinh viên giỏi
$fetch = mysqli_query($conn,"SELECT name,masv,DTB FROM khachhang WHERE DTB>8 ORDER BY DTB DESC LIMIT 4,6");
while ($row = mysqli_fetch_array($fetch , MYSQL_ASSOC)) {
	$resss[] = $row ;

}


$data['ongvang'] = $res;
$data['xuatsac'] = $ress;
$data['gioi'] = $resss;
echo json_encode($data);


disconnect_db();

  ?>