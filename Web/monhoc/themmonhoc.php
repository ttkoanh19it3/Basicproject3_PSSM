<?php 
 require './demo.php' ;
    // nếu người dùng submit form

    if(!empty($_POST['addMonhoc']))
    {
        //laydata 
        $data['id']  = isset($_POST['id']) ? $_POST['id'] : '' ;
        $data['tenmon'] = isset($_POST['tenmon']) ? $_POST['thuocnganh'] : '' ;
        $data['thuocnganh'] = isset($_POST['thuocnganh']) ? $_POST['thuocnganh'] : '' ;
         $data['linkpdf'] = isset($_POST['linkpdf']) ? $_POST['linkpdf'] : '' ;


               // validate thông tin
    $errors = array();
    // //id
    // if(empty($data['id']))
    // {
    //     $errors['id'] = 'vui lòng điền vào id' ;
    // }
    //name
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


    // nếu không có lỗi thì thêm khách hàng vào 
if(!$errors)
{
    addMonhoc($data['id'], $data['tenmon'], $data['thuocnganh'], $data['linkpdf']);
    // back to showhang.php
header("location: showhang.php");
}
   

    }
 

    disconnect_db();

 ?>

<!DOCTYPE html>
<html>
    <head>
        <title>Thêm Môn Học</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <center>
        <h1>Thêm Môn Học</h1>
        <a href="showhang.php">Trở về</a> <br/> <br/>
        <form method="POST" action="themmonhoc.php">
            <table width="50%" border="1" cellspacing="0" cellpadding="10">
                 <tr>
                    <td>ID</td>
                    <td>
                        <input type="text" name="id" value="<?php echo !empty($data['id']) ? $data['id'] : ''; ?>"/>
                         <?php if (!empty($errors['id'])) echo $errors['id']; ?>
                        
                    </td>
                </tr>
                <tr>
                    <td>Tên Môn</td>
                    <td>
                        <input type="text" name="tenmon" value="<?php echo !empty($data['tenmon']) ? $data['tenmon'] : ''; ?>"/>
                         <?php if (!empty($errors['tenmon'])) echo $errors['tenmon']; ?>
                        
                    </td>
                </tr>
                <tr>
                    <td>Thuộc Ngành</td>
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
                        <input type="submit" name="addMonhoc" value="Lưu"/>

                    </td>
                </tr>
            </table>
        </form>
        </center>
    </body>
</html>