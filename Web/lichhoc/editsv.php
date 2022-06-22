<?php 
require './demo.php';
 // lấy thông tin hiển thị lên để người dùng sửa 
$id = isset($_GET['id']) ? (int)$_GET['id'] : '' ;
if ($id) 
{
	$data = get_kh_byid($id);
}

// nếu không có dữ liệu tức không tìm thấy sinh viên cần sữa 
if(!$data) 
{
	header("location: showhang.php");

}

// nếu người dùng submit form
	if(!empty($_POST['edit_sinhvien']))
	{
		// lấy data 
		$data['thu']  = isset($_POST['thu']) ? $_POST['thu'] : '' ;
        $data['monhoc'] = isset($_POST['monhoc']) ? $_POST['monhoc'] : '' ;
        $data['giaovien'] = isset($_POST['giaovien']) ? $_POST['giaovien'] : '' ;
        
		// validate form
		 $errors = array();
		 //id
   
   
    //môn
     if(empty($data['monhoc']))
    {
        $errors['monhoc'] = 'vui lòng điền vào monhoc' ;
    }
// giáo viên 
     if(empty($data['giaovien']))
    {
        $errors['giaovien'] = 'vui lòng điền vào giaovien' ;
    }



    // nếu  k có lỗi thì Cập nhật 
    	if(!$errors)
    	{
    		 edit_sinhvien($data['thu'], $data['monhoc'], $data['giaovien']);
    		// trở về trang show hàng 
    		header("location: showhang.php");
    	}




	}
	
	disconnect_db();

 ?>
 <!DOCTYPE html>
<html>
    <head>
        <title>Cập nhật sinh viên</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <center>
        <h1>Cập nhật sinh viên </h1>
        <a href="showhang.php">Trở về</a> <br/> <br/>
        <form method="POST" action="editsv.php?id=<?php echo $data['thu']; ?>">
            <table width="50%" border="1" cellspacing="0" cellpadding="10">
                <tr>
                    <td>thứ</td>
                    <td>
                        <input type="text" name="thu" value="<?php echo $data['thu']; ?>"/>
                         
                        
                    </td>
                </tr>
                <tr>
                    <td>môn</td>
                    <td>
                        <input type="text" name="monhoc" value="<?php echo $data['monhoc']; ?>"/>
                         <?php if (!empty($errors['monhoc'])) echo $errors['monhoc']; ?>
                        
                    </td>
                </tr>
                 <tr>
                    <td>Giáo viên</td>
                    <td>
                       <input type="text" name="giaovien" value="<?php echo !empty($data['giaovien']) ? $data['giaovien'] : ''; ?>"/>
                         <?php if (!empty($errors['giaovien'])) echo $errors['giaovien']; ?>
                    </td>
                </tr>
                
                 
                <tr>
                    <td></td>
                    <td>
                     <input type="hidden" name="thu" value="<?php echo $data['thu']; ?>"/>
                        <input type="submit" name="edit_sinhvien" value="Cập nhật"/>
                    </td>
                </tr>
            </table>
        </form>
        </center>
    </body>
</html>