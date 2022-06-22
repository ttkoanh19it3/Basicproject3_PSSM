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
function ongvang()
{
    // Gọi tới biến toàn cục $conn
    global $conn;
    
    // Hàm kết nối
    connect_db();
    
    // Câu truy vấn lấy tất cả sinh viên
    $sql = "SELECT name,masv,DTB FROM khachhang WHERE DTB>8 ORDER BY DTB DESC LIMIT 1";
    
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




// hàm lấy sinh viên giỏi 
function sinhviengioi()
{
    // Gọi tới biến toàn cục $conn
    global $conn;

    // Mảng chứa kết quả
    $result = array();
    
    // Hàm kết nối
    connect_db();

    
    

    
    // Câu truy vấn lấy tất cả sinh viên
    $sql = "SELECT name,masv,DTB FROM khachhang WHERE DTB>8 ORDER BY DTB DESC LIMIT 1,3";
    
    // Thực hiện câu truy vấn
    $query = mysqli_query($conn, $sql);

    
    
    
    // Lặp qua từng record và đưa vào biến kết quả
    if ($query){
        while ($row = mysqli_fetch_assoc($query)){
            $result[] = $row;

        }
    }
    
    // Trả kết quả về
    return $result;
}

function sinhvienkha()
{
    // Gọi tới biến toàn cục $conn
    global $conn;

    // Mảng chứa kết quả
    $result = array();
    
    // Hàm kết nối
    connect_db();

    
    

    
    // Câu truy vấn lấy tất cả sinh viên
    $sql = "SELECT name,masv,DTB FROM khachhang WHERE DTB>8 ORDER BY DTB DESC LIMIT 4,6";
    
    // Thực hiện câu truy vấn
    $query = mysqli_query($conn, $sql);

    
    
    
    // Lặp qua từng record và đưa vào biến kết quả
    if ($query){
        while ($row = mysqli_fetch_assoc($query)){
            $result[] = $row;

        }
    }
    
    // Trả kết quả về
    return $result;
}




 ?>