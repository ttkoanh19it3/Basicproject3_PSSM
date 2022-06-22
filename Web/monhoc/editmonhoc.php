<?php 
require './demo.php';
 // lấy thông tin hiển thị lên để người dùng sửa 
$id = isset($_GET['id']) ? (int)$_GET['id'] : '' ;
if ($id) 
{
	$data = get_monhoc($id);
}

// nếu không có dữ liệu tức không tìm thấy sinh viên cần sữa 
if(!$data) 
{
	header("location: showhang.php");

}

// nếu người dùng submit form
	if(!empty($_POST['edit_monhoc']))
	{
		// lấy data 
		$data['id']  = isset($_POST['id']) ? $_POST['id'] : '' ;
        $data['tenmon'] = isset($_POST['tenmon']) ? $_POST['tenmon'] : '' ;
        $data['thuocnganh'] = isset($_POST['thuocnganh']) ? $_POST['thuocnganh'] : '' ;
         $data['linkpdf'] = isset($_POST['linkpdf']) ? $_POST['linkpdf'] : '' ;
		// validate form
		 $errors = array();
		 //id
    //id
     if(empty($data['tenmon']))
    {
        $errors['tenmon'] = 'vui lòng điền vào tenmon' ;
    }
// age 
     if(empty($data['thuocnganh']))
    {
        $errors['thuocnganh'] = 'vui lòng điền vào thuocnganh' ;
    }
// link 
     if(empty($data['linkpdf']))
    {
        $errors['linkpdf'] = 'vui lòng điền vào link' ;
    }


    // nếu  k có lỗi thì Cập nhật 
    	if(!$errors)
    	{
    		 edit_monhoc($data['id'], $data['tenmon'], $data['thuocnganh'], $data['linkpdf0']);
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
        <form method="POST" action="editmonhoc.php?id=<?php echo $data['id']; ?>">
            <table width="50%" border="1" cellspacing="0" cellpadding="10">
                <tr>
                    <td>ID</td>
                    <td>
                        <input type="text" name="id" value="<?php echo $data['id']; ?>"/>
                         <?php if (!empty($errors['id'])) echo $errors['id']; ?>
                        
                    </td>
                </tr>
                <tr>
                    <td>Tên Môn</td>
                    <td>
                        <input type="text" name="tenmon" value="<?php echo $data['tenmon']; ?>"/>
                         <?php if (!empty($errors['tenmon'])) echo $errors['tenmon']; ?>
                        
                    </td>
                </tr>
                 <tr>
                    <td>Thuộc ngành</td>
                    <td>
                       <input type="text" name="thuocnganh" value="<?php echo !empty($data['thuocnganh']) ? $data['thuocnganh'] : ''; ?>"/>
                         <?php if (!empty($errors['thuocnganh'])) echo $errors['thuocnganh']; ?>
                    </td>
                </tr>
                 <tr>
                    <td>Link PDF</td>
                    <td>
                       <input type="text" name="linkpdf" value="<?php echo !empty($data['linkpdf']) ? $data['linkpdf'] : ''; ?>"/>
                         <?php if (!empty($errors['linkpdf'])) echo $errors['linkpdf']; ?>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                     <input type="hidden" name="id" value="<?php echo $data['id']; ?>"/>
                        <input type="submit" name="edit_monhoc" value="Cập nhật"/>
                    </td>
                </tr>
            </table>
        </form>
        </center>
    </body>
</html>