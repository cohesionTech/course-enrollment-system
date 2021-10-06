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
   <title>CSULB-Teacher</title>
   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!--[if lt IE 9]><script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script><script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script><![endif]-->
   <!-- Bootstrap CSS-->
   <link rel="stylesheet" href="${context}/External/css/bootstrap.css">
   <!-- Vendor CSS-->
   <link rel="stylesheet" href="${context}/External/css/font-awesome.min.css">
   <link rel="stylesheet" href="${context}/External/css/animate+animo.css">
   <link rel="stylesheet" href="${context}/External/css/csspinner.min.css">
   <link rel="stylesheet" href="${context}/External/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="${context}/External/css/bootstrap-tagsinput.css">
	<link rel="stylesheet" href="${context}/External/css/codemirror.css">
	<link rel="stylesheet" href="${context}/External/css/chosen.min.css">
	<link rel="stylesheet" href="${context}/External/css/slider.css">
   <!-- START Page Custom CSS-->
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
       		 <ul class="nav navbar-nav navbar-right">
               <!-- Search icon-->
              
               <!-- END Alert menu-->
               <!-- START User menu-->
               <li class="dropdown">
                  <a href="#" data-toggle="dropdown" data-play="fadeIn" class="dropdown-toggle">
                     <em class="fa fa-sign-out"></em>
                  </a>
                  <!-- START Dropdown menu-->
                  <ul class="dropdown-menu">
                 
                     <li><a href="#">Logout</a>
                     </li>
                  </ul>
                  <!-- END Dropdown menu-->
               </li>
               <!-- END User menu-->
              
            </ul>
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
                  <a href="Admin_Home.html">
                     <em class="fa fa-home"></em>
                     <span class="item-text">Home</span>
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
            <h3>Teacher Registration
               <br>
               <small>Please fill out the following details accurately</small>
            </h3>
            <!-- START row-->
            
            <!-- END row-->
            <!-- START row-->
            <div class="row">
               <div class="col-md-12">
               <c:url var="addAction" value="/teacher/add" ></c:url>
                  <form action="${addAction}" data-parsley-validate="" novalidate="" class="form-horizontal" method="post">
                     <!-- START panel-->
                     <div class="panel panel-default">
                        <div class="panel-heading">
                           <div class="panel-title">Personal Details</div>
                        </div>
                        <div class="panel-body">
                           <fieldset>
                              <div class="form-group">
                                 <label class="col-sm-2 control-label">Firstname*</label>
                                 <div class="col-sm-4">
                                    <input type="text" name="fn" required="required" class="form-control">
                                 </div>
                              </div>
                           </fieldset>
						   
						   <fieldset>
                              <div class="form-group">
                                 <label class="col-sm-2 control-label">Lastname*</label>
                                 <div class="col-sm-4">
                                    <input type="text" name="ln" required="required" class="form-control">
                                 </div>
                              </div>
                           </fieldset>
						   
						   <fieldset>
                              <div class="form-group">
                                 <label class="col-sm-2 control-label">Address*</label>
                                 <div class="col-sm-7">
                                    <input type="text" name="addr" required="required" class="form-control">
                                 </div>
                              </div>
                           </fieldset>
						   
                           <fieldset>
                              <div class="form-group">
                                 <label class="col-sm-2 control-label">Email*</label>
                                 <div class="col-sm-6">
                                    <input type="email" name="email" required="required" data-parsley-type="email" class="form-control">
                                 </div>
                              </div>
                           </fieldset>
                           
						   <fieldset>
                              <div class="form-group">
                                 <label class="col-sm-2 control-label">Mobile*</label>
                                 <div class="col-sm-3">
									<input class="form-control" name="mobile" type="text" required="required"  data-inputmask="'mask': '(999) 999-9999'" data-toggle="masked">
                                 </div>
                              </div>
                           </fieldset>
						   
						   <fieldset>
                              <div class="form-group">
                                 <label class="col-sm-2 control-label">Teaching Interest*</label>
                                 <div class="col-sm-4">
                                    <input type="text" name="ti" required="required" class="form-control">
                                 </div>
                              </div>
                           </fieldset>
						   
				
						  <div class="panel-heading">
						  <div class="panel-title">Login Details</div>
						  </div>
						  </br>
							<fieldset>
                              <div class="form-group">
                                 <label class="col-sm-2 control-label">Username</label>
                                 <div class="col-sm-4">
                                    <input type="text" name="un" required class="form-control">
                                 </div>
                              </div>
                           </fieldset>
						   
						   <fieldset>
                              <div class="form-group">
                                 <label class="col-sm-2 control-label">Password</label>
                                 <div class="col-sm-4">
                                    <input type="password" id="id-password" name="pwd" required class="form-control">
                                 </div>
                              </div>
                           </fieldset>
						   
						   <fieldset>
                              <div class="form-group">
                                 <label class="col-sm-2 control-label">Confirm Password</label>
                                 <div class="col-sm-4">
                                    <input type="password" name="un" data-parsley-type="alphanum" required data-parsley-equalto="#id-password" class="form-control">
                                 </div>
                              </div>
                           </fieldset>
                           
                           <input type="hidden" name="role" value="ROLE_TEACHER">
                           <input type="hidden" name="enable" value="1">
                           
                        </div>
						
                        <div class="panel-footer">
                           <div class="clearfix">
                              <div class="pull-left">
                                 <div class="checkbox c-checkbox">
                                    <label>
                                       <input type="checkbox" name="agreements" required data-parsley-error-message="Please read and agree the terms">
                                       <span class="fa fa-check"></span>I agree with the <a href="#">terms</a>
                                    </label>
                                 </div>
                              </div>
                              <div class="pull-right">
                                 <button type="submit" class="btn btn-primary">Register</button>
                              </div>
                           </div>
                        </div>
                     </div>
                     <!-- END panel-->
					 
                  </form>
               </div>
            </div>
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
   <!-- START Page Custom Script-->
   <!-- Form Validation-->
   <script src="${context}/External/js/parsley.min.js"></script>
   <!-- END Page Custom Script-->
   <!-- App Main-->
   <script src="${context}/External/js/app.js"></script>
   
   <script src="${context}/External/js/moment-with-langs.min.js"></script>
   <script src="${context}/External/js/bootstrap-datetimepicker.min.js"></script>
   <!-- Tags input-->
   <script src="${context}/External/js/bootstrap-tagsinput.min.js"></script>
    <!-- Input Mask-->
   <script src="${context}/External/js/jquery.inputmask.bundle.min.js"></script>
   <script src="${context}/External/js/codemirror.js"></script>
   <script src="${context}/External/js/overlay.js"></script>
   <script src="${context}/External/js/markdown.js"></script>
   <script src="${context}/External/js/xml.js"></script>
   <script src="${context}/External/js/gfm.js"></script>
   <!-- END Scripts-->

   
   </body>

</html>