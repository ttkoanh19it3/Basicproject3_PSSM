
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Quản lý Học Sinh</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/text.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/grid.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/layout.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" />
    <!--[if IE 6]><link rel="stylesheet" type="text/css" href="css/ie6.css" media="screen" /><![endif]-->
    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie.css" media="screen" /><![endif]-->
    <!-- BEGIN: load jquery -->
    <script src="js/jquery-1.6.4.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery-ui/jquery.ui.core.min.js"></script>
    <script src="js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>
    <script src="js/jquery-ui/jquery.effects.slide.min.js" type="text/javascript"></script>
    <!-- END: load jquery -->
    <!-- BEGIN: load jqplot -->
    <link rel="stylesheet" type="text/css" href="css/jquery.jqplot.min.css" />
    <!--[if lt IE 9]><script language="javascript" type="text/javascript" src="js/jqPlot/excanvas.min.js"></script><![endif]-->
    <script language="javascript" type="text/javascript" src="js/jqPlot/jquery.jqplot.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jqPlot/plugins/jqplot.barRenderer.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jqPlot/plugins/jqplot.pieRenderer.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jqPlot/plugins/jqplot.categoryAxisRenderer.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jqPlot/plugins/jqplot.highlighter.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/jqPlot/plugins/jqplot.pointLabels.min.js"></script>
    <!-- END: load jqplot -->
    <script src="js/setup.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            setupDashboardChart('chart1');
            setupLeftMenu();
			setSidebarHeight();
        });
    </script>
	 <script type="text/javascript">
	     $(window).load(function () {
	         $('#demo-side-bar').removeAttr('style');
	     });
</script>
<style type="text/css">
#demo-side-bar{left:90%!important;display:block!important;}
#branding .floatright{margin-right:130px!important;}
</style>
	<!--Dynamically creates ads markup-->
   <!-- <?php include("http://www.egrappler.com/ads-header.php"); ?> -->
    <div class="container_12">
        <div class="grid_12 header-repeat">
            <div id="branding">
                <div class="floatleft">
                    <h2 style="float: left ; color: #ffffff;">Quản Lý Sinh Viên</h2>
                <div class="floatright" style="margin-left: 800px;">
                    <div class="floatleft">
                        <img src="img/img-profile.jpg" alt="Profile Pic" /></div>
                    <div class="floatleft marginleft10">
                        <ul class="inline-ul floatleft">
                            <li>Admin</li>
                            <li><a href="#">Config</a></li>
                            <li><a href="#">Logout</a></li>
                        </ul>
                        <br />
                        <span class="small grey">Last Login: 3 hours ago</span>
                    </div>
                </div>
                <div class="clear">
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
              <ul class="nav main">
                <li class="ic-dashboard"><a href="dashboard.html"><span>Trình điều khiển</span></a> </li>
               </ul>
        </div>
        <div class="clear">
        </div>
        <div class="grid_2">
            <div class="box sidemenu">
                <div class="block" id="section-menu">
                    <ul class="section menu">
                        <li><a class="menuitem">Sinh Viên</a>
                            <ul class="submenu">
                                <li><a href="http://localhost/Web/PT11304/showhang.php">Danh sách sinh viên 11304</a></li>
                               <li><a href="http://localhost/Web/PT11304/showhang.php">Danh sách sinh viên 11305<a></li>                            
                               </ul>
                        <li><a class="menuitem">Môn học</a>
                           <ul class="submenu">
                                <li><a href="http://localhost/Web/monhoc/showhang.php">Chi tiết</a> </li>                        
                            </ul>

                        </li>

                        <li><a class="menuitem">Khen thưởng</a>

                            <ul class="submenu">

                                <li><a href="http://localhost/Web/khenthuong/showhang.php">Danh sách khen thưởng</a> </li>
                            </ul>
                        </li>
                        <li><a class="menuitem">Lịch học</a>
                            <ul class="submenu">
                                <li><a href="http://localhost/Web/lichhoc/showhang.php">Chi Tiết</a> </li>

                            </ul>
                        </li>
                        <li><a class="menuitem">View Json</a>
                            <ul class="submenu">
                                <li><a href="http://localhost/Web/parseJSON_QLSV.php">Sinh Viên</a> </li>
                                <li><a href="http://localhost/Web/monhoc/monhoc_JSON.php">Môn học</a> </li>
                                <li><a href="http://localhost/Web/khenthuong/Json_diem.php">Điểm</a> </li>
                                <li><a href="http://localhost/Web/lichhoc/lichhoc_JSON.php">Lịch học</a> </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="grid_10">
            <div class="box round first">
                <h2>Quản lý sinh viên</h2>
                <div class="block">
                <marquee direction="down" width="maxwidth" height="200" behavior="alternate" style="border:solid px red;">
  <arquee behavior="alternate">
                            <h3 style="color: #000000;">ĐÂY LÀ SEVER ỨNG DỤNG Student Management</h3>
  </marqee>
</marquee >  
                    
                </div>
            </div>
           
        </div>
        <div class="grid_5">
            <div class="box round">
                <h2>
        Đôi nét về VKU </h2>
                <div class="block">
                    <p class="start">
                        <img src="img/unnamed.png"  />Ngày 25/4/2021, Trường Đại học Công nghệ Thông tin và Truyền thông Việt - Hàn, Đại học Đà Nẵng tổ chức “Ngày hội trải nghiệm VKU” năm 2021 tại khuôn viên Nhà trường, nhằm giúp cho học sinh và phụ huynh hiểu đúng, hiểu rõ và hiểu đầy đủ về VKU bằng cách trải nghiệm trực tiếp hòa mình vào môi trường học tập và nghiên cứu tại Nhà trường. Qua đó khám phá năng lực bản thân, định hướng và quyết định lựa chọn ngành, chọn trường phù hợp theo sự phát triển của xã hội trong cuộc cách mạng công nghiệp 4.0</p>
                    <p>
                        Hiện nay, tại VKU quy tụ được đội ngũ giảng viên giỏi nhất và hùng hậu nhất tại miền Trung - Tây Nguyên với 100% giảng viên có trình độ sau đại học, 40 Phó Giáo sư và Tiến sĩ (chiếm 50% giảng viên toàn Trường), được đào tạo tại các nước có nền giáo dục phát triển, như: Đức, Pháp, Mỹ, Anh, Hàn Quốc, Nhật bản, Úc, Newzeland,… Với tổng diện tích 23,5 héc ta, cơ sở hạ tầng được xây dựng đồng bộ, trang thiết bị phục vụ cho đào tạo và quản lý hiện đại, khang trang bậc nhất tại miền Trung - Tây Nguyên và thậm chí cả nước. Từ năm 2022-2026, dự kiến sẽ được Chính phủ Hàn Quốc tài trợ thêm trên 200 tỷ đồng, phục vụ cho phát triển chất lượng, điều kiện học tập, nghiên cứu khoa học, trang thiết bị,...
    </p>
                </div>
            </div>
        </div>
        <div class="grid_5">
            <div class="box round">
                <h2>
                    Tuyển sinh</h2>
                <div class="block">
                    <p class="start">
                        <img rc="" style="width: 300px;float: right;margin: 10px;" />Kính chào toàn thể quý vị và cácbạn đến với Trường Đại học Công nghệ Thông tin và Truyền thông Việt - Hàn, Đại học Đà Nẵng
 
    Trường Đại học Công nghệ thông tin và Truyền thông Việt - Hàn (VKU) là trường đại học thành viên trực thộc Đại học Đà Nẵng - một đại học vùng trọng điểm quốc gia, đào tạo đa lĩnh vực, đa ngành ở khu vực Miền Trun - Tây Nguyên với hơn 2.000 cán bộ, giảng viên và trên 50.000 sinh viên đại học và sau đại học đang theo học.
    VKU tự hào l trường đại học công lập duy nhất và hàng đầu tại Miền Trung - Tây Nguyên định hướng phát triển theo mô hình ại học quốc tế, đào tạo và nghiên cứu chuyên sâu các lĩnh vực công nghệ thông tin, truyền thông và kinh tế số.
    VKU luôn xác định rõ sứ mạng và trách nhiệm của mình trong việc đào tạo và cug ứng nguồn nhân lực chất lượng cao, nghiên cứu khoa học, chuyển giao tri thức và công nghệ với tầm nhìn trở tành trường đại học định hướng ứng dụng hàng đầu của cả nước cùng khát vọng vươn tầm quốc tế về các lĩnh vực đo tạo, nghiên cứu của mình; hoạt động theo mô hình quản trị tiên tiến, trường học hiện đại - thông minh.</p>
                    <p>
                        Sự ra đời của các thiết bị di động thông minh như iPhone, iPad chạy trên hệ điề hành iOS, Android, Windows Phone đã mang lại cuộc cách mạng lớn về cách thức sử dụng hiết bị di động trong cuộc sống và công việc. Hiện nay số lượng thiết bị cầm tay đã vượt ua số lượng máy tính cá nhân. Điều này đã thực sự mở ra một kỷ nguyên công nghệ mới.</p>
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
    </div>
    <div class="clear">
    </div>
    <div id="site_info">
        <p>
            Copyright <a href="#">Tien Huynh</a>. All Rights Reserved.
        </p>
    </div>
  	<div id="demo-side-bar">
  <!--  <?php include("http://www.egrappler.com/ad-sidebar.php");?> -->
   </div>
    </div>
    <!--wrapper end-->
	<!--Dynamically creates analytics markup-->
	 <!-- <?php include("http://www.egrappler.com/analytics.php");?> -->
</body>
</html>

