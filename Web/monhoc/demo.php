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
    $sql = "select * from monhoc";
    
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

function get_monhoc($khid)
{
    // gọi gloabal $conn
    global $conn ; 
    // kết nối db 
    connect_db();

    // câu lệnh lấy tất cả khách hàng theo id 
    $sql = "select * from monhoc where id ={$khid}";

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
function addMonhoc($id,$tenmon,$thuocnganh,$linkpdf)
{   
     // mỗi lần sử dụng hàm đều phải  gọi lại biến $conn
    global $conn ;

    // kết nối db
    connect_db();

    // chống SQL Injection 
    $id = addslashes($id);
    $tenmon = addslashes($tenmon);
    $thuocnganh = addslashes($thuocnganh);
    $linkpdf = addslashes($linkpdf);
    


    // câu lệnh truy vấn 
$sql = "INSERT INTO monhoc (id, tenmon, thuocnganh, linkpdf) 
        VALUES 
        ('$id','$tenmon','$thuocnganh','$linkpdf') 
        ";



        // thực hiện câu lệnh truy vấn 
        $query = mysqli_query($conn,$sql);
        return $query ;
}
function edit_monhoc($id,$tenmon,$thuocnganh,$linkpdf)
{
    // gọi $conn
    global $conn ;

    // kết nối db
    connect_db();

    // chống SQL Injection 
    $id = addslashes($id);
    $tenmon = addslashes($tenmon);
    $thuocnganh = addslashes($thuocnganh);
    $linkpdf = addslashes($linkpdf);
    

 
// truy vấn 
    $sql = "
            UPDATE `monhoc` SET `tenmon`='$tenmon',`thuocnganh`='$thuocnganh',`linkpdf`='$linkpdf'  WHERE `id` = '$id' 
            ";
// thực hiện câu lệnh truy vấn 
            $query =mysqli_query($conn, $sql);
// trả về 
            return $query;

}

function xoa_monhoc($id)
{
    // $conn
    global $conn ; 
    connect_db();


    $sql = "
        DELETE FROM `monhoc` WHERE `id`='$id'
    " ;
    // thực hiện câu lệnh
    $query = mysqli_query($conn,$sql);
    return $query;
}



 ?>