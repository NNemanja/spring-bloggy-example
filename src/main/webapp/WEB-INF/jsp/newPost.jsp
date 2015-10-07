<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Add/Update Post</title>

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

<div class="container">
    <div class="row">
		
		 <div class="col-lg-6">
		 <h2>Add/Update post</h2>
            <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Fields</strong></div>
			<form:form modelAttribute="blogPost" method="POST" action="/formPost">
				<div class="form-group">
					<form:label for="postTitle" path="postTitle">Title</form:label>
                    <div class="input-group">
                    	
			        	<form:input class="form-control" path="postTitle" />
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                	
                    <c:set var="postTitleError"><form:errors path="postTitle"/></c:set>
					<c:if test="${not empty postTitleError}">
						 <div class="alert alert-danger">
		                    <span class="glyphicon glyphicon-remove"></span>
		                    <strong>${postTitleError}</strong>
	                	</div>
					</c:if>
				</div>
				<div class="form-group">
					<form:label for="postText" path="postText">Text</form:label>
                    <div class="input-group">
			        	<form:textarea class="form-control" path="postText"/>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                    
                    <c:set var="postTextError"><form:errors path="postText"/></c:set>
					<c:if test="${not empty postTextError}">
						 <div class="alert alert-danger">
		                    <span class="glyphicon glyphicon-remove"></span>
		                    <strong>${postTextError}</strong>
	                	</div>
					</c:if>
                    
		        	
				</div>
				<form:hidden path="id" />
				<form:hidden path="postTime" />
                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
			   
			</form:form>
		</div>
	</div>
</div>

 <!-- jQuery -->
    
    <script src="<c:url value="/js/jquery.js" />"/></script>

    <!-- Bootstrap Core JavaScript -->
    
    <script src="<c:url value="/js/bootstrap.min.js" />"/></script>

</body>
</html>