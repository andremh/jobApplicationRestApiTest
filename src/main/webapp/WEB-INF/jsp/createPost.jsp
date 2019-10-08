<html lang="en">
<head>
    <title>Create a new Post</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/myStyle.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container">
    <h1>Insert post details</h1>
    <form action="createNewPost" method="post">
        <div class="row">
            <div class="col-sm-1 font-weight-bold text-nowrap">User id</div>
            <div class="col-sm-11 "><input type="text" name="userID"/></div>
        </div>

        <div class="row">
            <div class="col-sm-1 font-weight-bold text-nowrap">Title</div>
            <div class="col-sm-11 "><input type="text" name="title"/></div>
        </div>

        <div class="row">
            <div class="col-sm-1 font-weight-bold text-nowrap">Body</div>
            <div class="col-sm-11"><input type="text" name="body"/></div>
        </div>
        <input type="submit" value="Create new post" class="btn btn-success btn-sm button1">
    </form>
</div>
</body>
</html>