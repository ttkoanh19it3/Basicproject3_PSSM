<?php 
 require './demo.php' ;
    // nếu người dùng submit form

    if(!empty($_POST['addKhachhang']))
    {
        //laydata 
        $data['id']  = isset($_POST['id']) ? $_POST['id'] : '' ;
        $data['name'] = isset($_POST['name']) ? $_POST['name'] : '' ;
        $data['masv'] = isset($_POST['masv']) ? $_POST['masv'] : '' ;
         $data['link'] = isset($_POST['link']) ? $_POST['link'] : '' ;
          $data['DTB'] = isset($_POST['DTB']) ? $_POST['DTB'] : '' ;


               // validate thông tin
    $errors = array();
    // //id
    // if(empty($data['id']))
    // {
    //     $errors['id'] = 'vui lòng điền vào id' ;
    // }
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

    // nếu không có lỗi thì thêm khách hàng vào 
if(!$errors)
{
    addKhachhang($data['id'], $data['name'], $data['masv'], $data['link'], $data['DTB']);
    // back to showhang.php
header("location: showhang.php");
}
   

    }
 

    disconnect_db();

 ?>

<!DOCTYPE html>
<html>
    <head>
        <title>Thêm sinh vien</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <center>
    <body>

        <h1>Thêm sinh vien </h1>
        <a href="showhang.php">Trở về</a> <br/> <br/>
        <form method="POST" action="themsinhvien.php">
            <table width="50%" border="1" cellspacing="0" cellpadding="10">
                <tr>
                    <td>ID</td>
                    <td>
                        <input type="text" name="id" value="<?php echo !empty($data['id']) ? $data['id'] : ''; ?>"/>
                         <?php if (!empty($errors['id'])) echo $errors['id']; ?>
                        
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name" value="<?php echo !empty($data['name']) ? $data['name'] : ''; ?>"/>
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
                        <input type="submit" name="addKhachhang" value="Lưu"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
    </center>
</html>