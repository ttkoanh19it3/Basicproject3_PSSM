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
		$data['id']  = isset($_POST['id']) ? $_POST['id'] : '' ;
        $data['name'] = isset($_POST['name']) ? $_POST['name'] : '' ;
        $data['masv'] = isset($_POST['masv']) ? $_POST['masv'] : '' ;
         $data['link'] = isset($_POST['link']) ? $_POST['link'] : '' ;
          $data['DTB'] = isset($_POST['DTB']) ? $_POST['DTB'] : '' ;
		// validate form
		 $errors = array();
		 //id
    //id
    if(empty($data['id']))
    {
        $errors['id'] = 'vui lòng điền vào id' ;
    }
    //name
     if(empty($data['name']))
    {
        $errors['name'] = 'vui lòng điền vào name' ;
    }
// age 
     if(empty($data['masv']))
    {
        $errors['masv'] = 'vui lòng điền vào masv' ;
    }
// link 
     if(empty($data['link']))
    {
        $errors['link'] = 'vui lòng điền vào link' ;
    }
// age 
     if(empty($data['DTB']))
    {
        $errors['DTB'] = 'vui lòng điền vào DTB' ;
    }


    // nếu  k có lỗi thì Cập nhật 
    	if(!$errors)
    	{
    		 edit_sinhvien($data['id'], $data['name'], $data['masv'], $data['link'], $data['DTB']);
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
        <form method="POST" action="editsv.php?id=<?php echo $data['id']; ?>">
            <table width="50%" border="1" cellspacing="0" cellpadding="10">
                <tr>
                    <td>ID</td>
                    <td>
                        <input type="text" name="id" value="<?php echo $data['id']; ?>"/>
                         <?php if (!empty($errors['id'])) echo $errors['id']; ?>
                        
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name" value="<?php echo $data['name']; ?>"/>
                         <?php if (!empty($errors['name'])) echo $errors['name']; ?>
                        
                    </td>
                </tr>
                 <tr>
                    <td>MaSV</td>
                    <td>
                       <input type="text" name="masv" value="<?php echo !empty($data['masv']) ? $data['masv'] : ''; ?>"/>
                         <?php if (!empty($errors['masv'])) echo $errors['masv']; ?>
                    </td>
                </tr>
                 <tr>
                    <td>Link</td>
                    <td>
                       <input type="text" name="link" value="<?php echo !empty($data['link']) ? $data['link'] : ''; ?>"/>
                         <?php if (!empty($errors['link'])) echo $errors['link']; ?>
                    </td>
                </tr>
                 <tr>
                    <td>DTB</td>
                    <td>
                       <input type="text" name="DTB" value="<?php echo !empty($data['DTB']) ? $data['DTB'] : ''; ?>"/>
                         <?php if (!empty($errors['DTB'])) echo $errors['DTB']; ?>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                     <input type="hidden" name="id" value="<?php echo $data['id']; ?>"/>
                        <input type="submit" name="edit_sinhvien" value="Cập nhật"/>
                    </td>
                </tr>
            </table>
        </form>
        </center>
    </body>
</html>