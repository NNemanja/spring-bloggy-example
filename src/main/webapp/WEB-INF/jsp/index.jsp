<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Blog</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- Custom CSS -->
    
    <link href="<c:url value="/css/blog-post.css" />" rel="stylesheet"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/posts">Blog</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/newPost">New Post</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <!-- Blog Post Content Column -->
            <div class="col-lg-8">

                <!-- Blog Post -->


				<c:if test="${not empty posts}">
				
					<c:forEach var="listValue" items="${posts}">
			                <!-- Title -->
			                <h1><a href="/posts/${listValue.id}">${listValue.postTitle}</a></h1>
			                <hr>
			                <!-- Date/Time -->
			                <p>
			                <span class="glyphicon glyphicon-time"></span> Posted on ${listValue.getFormattedPostTime()}
			                <a href="/editPost/${listValue.id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
			                <a href="/deletePost/${listValue.id}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
			                </p>
			                <hr>
			                <!-- Content -->
							${listValue.postText}
					 
			                <hr>
					</c:forEach>
				</c:if>
				
            </div>

        </div>
        <!-- /.row -->

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

    
    <!-- jQuery -->
    
    <script src="<c:url value="/js/jquery.js" />"/></script>

    <!-- Bootstrap Core JavaScript -->
    
    <script src="<c:url value="/js/bootstrap.min.js" />"/></script>

</body>

</html>
