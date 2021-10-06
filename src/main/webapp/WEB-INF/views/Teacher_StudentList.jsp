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
  
   <!-- START Page Custom CSS-->
   <!-- Data Table styles-->
   <link rel="stylesheet" href="${context}/External/css/dataTables.bootstrap.css">
   <link rel="stylesheet" href="${context}/External/css/dataTables.colVis.css">
   <!-- END Page Custom CSS-->
   <!-- App CSS-->
   <link rel="stylesheet" href="${context}/External/css/app.css">
   <!-- Modernizr JS Script-->
   <script src="${context}/External/js/modernizr.js" type="application/javascript"></script>
   <!-- FastClick for mobiles-->
   <script src="${context}/External/js/fastclick.js" type="application/javascript"></script>
</head>

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
      <c:if test="${empty sessionScope.teacherProfRecord}">
      <aside class="aside">
         <!-- START Sidebar (left)-->
         <nav class="sidebar">
            <ul class="nav">
               <!-- START Menu-->
               <li class="nav-heading">Main</li>
               <li>
                  <a href="${context}/teacher">
                     <em class="fa fa-home"></em>
                     <span class="item-text">Home</span>
                  </a>
               </li>
            </ul>
          </nav>
       </aside>
      </c:if>
      <c:forEach items="${sessionScope.teacherProfRecord}" var="r1" >
      <aside class="aside">
         <!-- START Sidebar (left)-->
         <nav class="sidebar">
            <ul class="nav">
               <!-- START Menu-->
               <li class="nav-heading">Main</li>
               <li>
                  <a href="${context}/teacher">
                     <em class="fa fa-home"></em>
                     <span class="item-text">Home</span>
                  </a>
               </li>
			   
			   <li>
                  <a href="${context}/teacher">
                     <em class="fa fa-user"></em>
                     <span class="item-text">Profile</span>
                  </a>
               </li>
			   
			   <li>
                  <a href="" title="Dashboard" data-toggle="collapse-next" class="has-submenu">
                     <em class="fa fa-building-o"></em>
                     <span class="item-text">Teacher Center</span>
                  </a>
                  <!-- START SubMenu item-->
                  <ul class="nav collapse ">
                  
                  	 <li>
                        <a href="${context}/teacher/showCourses?id=${r1.teid}" title="Default" data-toggle="" class="no-submenu">
                           <span class="item-text">View Student List</span>
                        </a>
                     </li>
                     
                     <li>
                        <a href="${context}/teacher/showGradeCourses?id=${r1.teid}" title="Default" data-toggle="" class="no-submenu">
                           <span class="item-text">Assign Grade</span>
                        </a>
                     </li>
                    
                     <li>
                        <a href="Admin_ViewCourse.html" title="User Profile" data-toggle="" class="no-submenu">
                           <span class="item-text">Drop Student</span>
                        </a>
                     </li>
                  </ul>
                  <!-- END SubMenu item-->
               </li>
			  
			   
			  <li>
                  <a href="${context}/teacher/schedule?id=${r1.teid}">
                     <em class="fa fa-calendar"></em>
                     <span class="item-text">Schedule</span>
                  </a>
               </li>
			  
               <!-- END Menu-->
            </ul>
         </nav>
         <!-- END Sidebar (left)-->
      </aside>
      </c:forEach>
      <!-- End aside-->
      <!-- START aside-->
   
      <!-- END aside-->
      <!-- START Main section-->
      <section>
         <!-- START Page content-->
         <div class="main-content">
            <h3>Student List 
               <br>
               <small>Enrolled Student Details</small>
            </h3>
            <!-- START row-->
            
            <!-- END row-->
            <!-- START row-->
            <!-- START DATATABLE 1 -->
            <div class="row">
               <div class="col-lg-12">
                  <div class="panel panel-default">
                     <div class="panel-heading">Student Table |
                        <small></small>
                     </div>
                     <div class="panel-body">
                        <table id="datatable1" class="table table-striped table-hover">
                           <thead>
                              <tr>
                              	 <th>#</th>
                                 <th>First Name</th>
                                 <th>Last Name</th>
                                 <th>Email</th>
                                 <th>Mobile</th>
                                 <th>Department</th>
                                 <th>Degree</th>
                              </tr>
                           </thead>
                           <tbody>
                           <c:forEach items="${studentList}" var="r" varStatus="loopCounter">
                              <tr class="gradeX">
                              	 <td><c:out value="${loopCounter.count}"></c:out></td>
                              	 <td>${r.student.firstname}</td>
                                 <td>${r.student.lastname}</td>
                                 <td>${r.student.email}</td>
                                 <td>${r.student.mobile}</td>
                                 <td>${r.student.department.departmentName}</td>
                                 <td>${r.student.degreelevel}</td>
                              </tr>
                           </c:forEach>   
                           </tbody>
                        </table>
                     </div>
                  </div>
               </div>
            </div>
            <!-- END DATATABLE 1 -->
            <!-- END row-->
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
   <!-- Main vendor Scripts-->
   <script src="${context}/External/js/jquery.min.js"></script>
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
   <!-- START Page Custom Script-->
   <!-- Data Table Scripts-->
   <script src="${context}/External/js/jquery.dataTables.min.js"></script>
   <script src="${context}/External/js/dataTables.bootstrap.js"></script>
   <script src="${context}/External/js/dataTables.bootstrapPagination.js"></script>
   <script src="${context}/External/js/dataTables.colVis.min.js"></script>
   <!-- END Page Custom Script-->

   <!-- END Scripts-->

   
   </body>

</html>