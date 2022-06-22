<?php 

// Biến kết nối toàn cục
global $conn;

// Hàm kết nối database
function connect_db()
{
    // Gọi tới biến toàn cục $conn
    global $conn;
    
    // Nếu chưa kết nối thì thực hiện kết nối
    if (!$conn){
        $conn = mysqli_connect('localhost', 'root', '', 'demosql') or die ('Can\'t not connect to database');
        // Thiết lập font chữ kết nối
        mysqli_set_charset($conn, 'utf8');
    }
}

// Hàm ngắt kết nối
function disconnect_db()
{
    // Gọi tới biến toàn cục $conn
    global $conn;
    
    // Nếu đã kêt nối thì thực hiện ngắt kết nối
    if ($conn){
        mysqli_close($conn);
    }
}

// Hàm lấy tất cả sinh viên
function get_all_students()
{
    // Gọi tới biến toàn cục $conn
    global $conn;
    
    // Hàm kết nối
    connect_db();
    
    // Câu truy vấn lấy tất cả sinh viên
    $sql = "select * from khachhang";
    
    // Thực hiện câu truy vấn
    $query = mysqli_query($conn, $sql);

    
    // Mảng chứa kết quả
    $result = array();
    
    // Lặp qua từng record và đưa vào biến kết quả
    if ($query){
        while ($row = mysqli_fetch_assoc($query)){
            $result[] = $row;

        }
    }
    
    // Trả kết quả về
    return $result;
}

// lấy sinh viên theo id
function get_kh_byid($khid)
{
	// gọi gloabal $conn
	global $conn ; 
	// kết nối db 
	connect_db();

	// câu lệnh lấy tất cả khách hàng theo id 
	$sql = "select * from khachhang where id ={$khid}";

	// thực hiện câu lệnh truy vấn 
	$query = mysqli_query($conn , $sql);

	// mảng chứa kết quả 

	$result = array();

	// nếu có kết quả thì đưa vào biến $result 
	if(mysqli_num_rows($query) > 0) {
		$row = mysqli_fetch_assoc($query);
		$result = $row ; 

	}
	// trả kết quả về 
	return $result ;

}

// hàm thêm khách hàng 

function addKhachhang($id,$name,$masv,$link,$DTB)
{	
	 // mỗi lần sử dụng hàm đều phải  gọi lại biến $conn
	global $conn ;

	// kết nối db
	connect_db();

	// chống SQL Injection 
	$id = addslashes($id);
	$name = addslashes($name);
	$age = addslashes($age);
	$link = addslashes($link);
	$DTB = addslashes($DTB);


	// câu lệnh truy vấn 
$sql = "INSERT INTO khachhang (id, name, masv, link, DTB) 
		VALUES 
		('$id','$name','$masv','$link','$DTB') 
		";



		// thực hiện câu lệnh truy vấn 
		$query = mysqli_query($conn,$sql);
		return $query ;
}


 // hảm update khách hàng 
function edit_sinhvien($id,$name,$masv,$link,$DTB)
{
	// gọi $conn
	global $conn ; 
	// kết nối db 
	connect_db();

	$id = addslashes($id);
	$name = addslashes($name);
	$age = addslashes($age);
	$link = addslashes($link);
	$DTB = addslashes($DTB);
 
// truy vấn 
	$sql = "
			UPDATE `khachhang` SET `name`='$name',`masv`='$masv',`link`='$link',`DTB`='$DTB' WHERE `id` = '$id' 
			";
// thực hiện câu lệnh truy vấn 
			$query =mysqli_query($conn, $sql);
// trả về 
			return $query;

}

// hàm xóa sinh viên 

function xoa_sv($id)
{
	// $conn
	global $conn ; 
	connect_db();


	$sql = "
		DELETE FROM `khachhang` WHERE `id`='$id'
	" ;
	// thực hiện câu lệnh
	$query = mysqli_query($conn,$sql);
	return $query;
}



 ?>