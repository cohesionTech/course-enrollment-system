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
   <title>CSULB-Login</title>
   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!--[if lt IE 9]><script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script><script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script><![endif]-->
   <!-- Bootstrap CSS-->
   <link rel="stylesheet" href="${context}/External/css/bootstrap.css">
   <!-- Vendor CSS-->
   <link rel="stylesheet" href="${context}/External/css/font-awesome.min.css">
   <link rel="stylesheet" href="${context}/External/css/animate+animo.css">
   <!-- App CSS-->
   <link rel="stylesheet" href="${context}/External/css/app.css">
   <link rel="stylesheet" href="${context}/External/css/common.css">
   <!-- Modernizr JS Script-->
   <script src="${context}/External/js/modernizr.js" type="application/javascript"></script>
   <!-- FastClick for mobiles-->
   <script src="${context}/External/js/fastclick.js" type="application/javascript"></script>
</head>

<body>
   <!-- START wrapper-->
   <div class="row row-table page-wrapper">
      <div class="col-lg-3 col-md-6 col-sm-8 col-xs-12 align-middle">
         <!-- START panel-->
         <div data-toggle="play-animation" data-play="fadeIn" data-offset="0" class="panel panel-dark panel-flat">
            <div class="panel-heading text-center">
               <a href="#">
                  <img src="${context}/External/images/csulb.gif" alt="Image" class="block-center img-rounded">
               </a>
               <p class="text-center mt-lg">
                  <strong>SELECT YOUR ROLE</strong>
               </p>
            </div>
            <div class="panel-body">
               
                  <button type="submit" class="btn btn-block btn-primary" onclick="window.location='admin'">Admin</button>
				  <button type="submit" class="btn btn-block btn-success" onclick="window.location='student'">Student</button>
				  <button type="submit" class="btn btn-block btn-warning" onclick="window.location='teacher'">Teacher</button>
               
            </div>
         </div>
         <!-- END panel-->
      </div>
   </div>
   <!-- END wrapper-->
   <!-- START Scripts-->
   <!-- Main vendor Scripts-->
   <script src="${context}/External/js/jquery.min.js"></script>
   <script src="${context}/External/js/bootstrap.min.js"></script>
   <!-- Animo-->
   <script src="${context}/External/js/animo.min.js"></script>
   <!-- Custom script for pages-->
   <script src="${context}/External/js/pages.js"></script>
   <!-- END Scripts-->
</body>

</html>