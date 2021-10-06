<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="ie ie6 lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="ie ie7 lt-ie9 lt-ie8"        lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="ie ie8 lt-ie9"               lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="ie ie9"                      lang="en"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-ie">
<!--<![endif]-->

<head>
<c:set var="context" value="${pageContext.request.contextPath}" />
   <!-- Meta-->
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
   <meta name="description" content="">
   <meta name="keywords" content="">
   <meta name="author" content="">
   <title>CSULB-Admin</title>
   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!--[if lt IE 9]><script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script><script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script><![endif]-->
   <!-- Bootstrap CSS-->
   <link rel="stylesheet" href="${context}/External/css/bootstrap.css">
   <!-- Vendor CSS-->
   <link rel="stylesheet" href="${context}/External/css/font-awesome.min.css">
   <link rel="stylesheet" href="${context}/External/css/animate+animo.css">
   <link rel="stylesheet" href="${context}/External/css/csspinner.min.css">
  
 
   <!-- App CSS-->
   <link rel="stylesheet" href="${context}/External/css/app.css">
   <!-- Modernizr JS Script-->
   <script src="${context}/External/js/modernizr.js" type="application/javascript"></script>
   <!-- FastClick for mobiles-->
   <script src="${context}/External/js/fastclick.js" type="application/javascript"></script>
   
   <!-- Nivo-Slider -->
   <link rel="stylesheet" href="${context}/External/Nivo-Slider-master/themes/default/default.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="${context}/External/Nivo-Slider-master/themes/light/light.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="${context}/External/Nivo-Slider-master/themes/dark/dark.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="${context}/External/Nivo-Slider-master/themes/bar/bar.css" type="text/css" media="screen" />
    <link rel="stylesheet" href="${context}/External/Nivo-Slider-master/nivo-slider.css" type="text/css" media="screen" />
</head>

<c:forEach items="${sessionScope.studentSession}" var="r" >
<body>
   <!-- START Main wrapper-->
   <div class="wrapper">
      <!-- START Top Navbar-->
      <nav role="navigation" class="navbar navbar-default navbar-top navbar-fixed-top">
         <!-- START navbar header-->
         <div class="navbar-header">
            <a href="dashboard.html" class="navbar-brand">
               <div class="brand-logo">
                  <img src="${context}/External/images/csulb.gif" alt="App Logo" class="img-responsive">
               </div>
               <div class="brand-logo-collapsed">
                  <img src="app/img/logo-single.png" alt="App Logo" class="img-responsive">
               </div>
            </a>
         </div>
         <!-- END navbar header-->
         <!-- START Nav wrapper-->
         <div class="nav-wrapper">
            <!-- START Left navbar-->
            <ul class="nav navbar-nav">
               <li>
                  <!-- Button used to collapse the left sidebar. Only visible on tablet and desktops-->
                  <a href="#" data-toggle-state="aside-collapsed" data-persists="true" class="hidden-xs">
                     <em class="fa fa-navicon"></em>
                  </a>
                  <!-- Button to show/hide the sidebar on mobile. Visible on mobile only.-->
                  <a href="#" data-toggle-state="aside-toggled" class="visible-xs">
                     <em class="fa fa-navicon"></em>
                  </a>
               </li>
               <!-- START Messages menu (dropdown-list)-->
      
               <!-- END Messages menu (dropdown-list)-->
               <li>
                  <!-- Button to clear all site options stored option from browser storage-->
                  <a href="#" data-toggle="reset">
                     <em class="fa fa-refresh"></em>
                  </a>
               </li>
            </ul>
            <!-- END Left navbar-->
            <!-- START Right Navbar-->
       
            <!-- END Right Navbar-->
         </div>
         <!-- END Nav wrapper-->
         <!-- START Search form-->
         
         <!-- END Search form-->
      </nav>
      <!-- END Top Navbar-->
      <!-- START aside-->
      <aside class="aside">
         <!-- START Sidebar (left)-->
         <nav class="sidebar">
            <ul class="nav">
               <!-- START Menu-->
               <li class="nav-heading">Main</li>
               <li>
                  <a href="${context}/studentHome">
                     <em class="fa fa-home"></em>
                     <span class="item-text">Home</span>
                  </a>
               </li>
			   
			   <li>
                  <a href="" title="Dashboard" data-toggle="collapse-next" class="has-submenu">
                     <em class="fa fa-book"></em>
                     <span class="item-text">Courses</span>
                  </a>
                  <!-- START SubMenu item-->
                  <ul class="nav collapse ">
                     <li>
                        <a href="${context}/student/showAddCourse" title="Default" data-toggle="" class="no-submenu">
                           <span class="item-text">Add Course</span>
                        </a>
                     </li>
                     <li>
                        <a href="${context}/student/showDrop?id=${r.sid}" title="User Profile" data-toggle="" class="no-submenu">
                           <span class="item-text">Drop Course</span>
                        </a>
                     </li>
                  </ul>
                  <!-- END SubMenu item-->
               </li>
			   
			   <li>
                  <a href="${context}/student">
                     <em class="fa fa-user"></em>
                     <span class="item-text">Profile</span>
                  </a>
               </li>
			   
			  <li>
                  <a href="${context}/student/schedule?id=${r.sid}">
                     <em class="fa fa-calendar"></em>
                     <span class="item-text">Schedule</span>
                  </a>
               </li>
			   
			   <li>
                  <a href="${context}/student/showAssignedGrade?id=${r.sid}">
                     <em class="fa fa-trophy"></em>
                     <span class="item-text">Grade</span>
                  </a>
               </li>
			   
              
               <!-- END Menu-->
            </ul>
         </nav>
         <!-- END Sidebar (left)-->
      </aside>
      <!-- End aside-->
      <!-- START aside-->
   
      <!-- END aside-->
      <!-- START Main section-->
      <section>
         <!-- START Page content-->
         <div class="main-content">
            <h3>Welcome ${r.firstname}
               <br>
               <small>Home</small>
            </h3>
            <!-- START row-->
            <div class="col-md-12">
        <div class="slider-wrapper theme-default">
            <div id="slider" class="nivoSlider">
                <img src="${context}/External/images/carlson-tower.jpg" data-thumb="images/carlson-tower.jpg" alt="" />
                <img src="${context}/External/images/csulb_library.jpg" data-thumb="images/csulb_library.jpg" alt="" />
                <img src="${context}/External/images/declare_support2.jpg" data-thumb="images/declare_support2.jpg" alt="" data-transition="slideInLeft" />
                <img src="${context}/External/images/02.jpg" data-thumb="images/02.jpg" alt="" >
				
            </div>
           
        </div>
		</div>
            <!-- END row-->
            
            <center><p>CALIFORNIA STATE UNIVERSITY LONG BEACH</br>
					1250 Bellflower Boulevard</br>
					Long Beach, California 90840</br>
					562.123.4567
				</p>
				</center>
            
         </div>
         <!-- END Page content-->
         <!-- START Page footer-->
         <footer>&copy; 2016 - California State University-Long Beach</footer>
         <!-- END Page Footer-->
      </section>
      <!-- END Main section-->
   </div>
   <!-- END Main wrapper-->
   <!-- START Scripts-->
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js" type="text/javascript"></script> 
    <script type="text/javascript" src="${context}/External/Nivo-Slider-master/jquery.nivo.slider.js"></script>
    <script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
    </script>
   
   
   <!-- Main vendor Scripts-->
   <script src="${context}/External/js/bootstrap.min.js"></script>
   <!-- Plugins-->
   <script src="${context}/External/js/chosen.jquery.min.js"></script>
   <script src="${context}/External/js/bootstrap-slider.js"></script>
   <script src="${context}/External/js/bootstrap-filestyle.min.js"></script>
   <!-- Animo-->
   <script src="${context}/External/js/animo.min.js"></script>
   <!-- Sparklines-->
   <script src="${context}/External/js/jquery.sparkline.min.js"></script>
   <!-- Slimscroll-->
   <script src="${context}/External/js/jquery.slimscroll.min.js"></script>
   <!-- Store + JSON-->
   <script src="${context}/External/js/store+json2.min.js"></script>
   <!-- Classyloader-->
   <script src="${context}/External/js/jquery.classyloader.min.js"></script>
   <!-- App Main-->
   <script src="${context}/External/js/app.js"></script>
   

   <!-- END Scripts-->

   
   </body>
</c:forEach>
</html>