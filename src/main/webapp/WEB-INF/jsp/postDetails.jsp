<html lang="en">
<head>
    <title>Post Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
</div>
<body>
<div class="container">
    <h1>Post details</h1>
    <div class="row">
        <div class="col-sm-1 font-weight-bold text-nowrap bg-light">User id:</div>
        <div class="col-sm-11 bg-light">${post.userId}</div>
    </div>

    <div class="row">
        <div class="col-sm-1 font-weight-bold text-nowrap bg-light">Id:</div>
        <div class="col-sm-11 bg-light">${post.id}</div>
    </div>

    <div class="row">
        <div class="col-sm-1 font-weight-bold text-nowrap bg-light">Title:</div>
        <div class="col-sm-11 bg-light">${post.title}</div>
    </div>

    <div class="row">
        <div class="col-sm-1 font-weight-bold text-nowrap bg-light" >Body:</div>
        <div class="col-sm-11 bg-light" >${post.body}</div>
    </div>
</div>
</body>
</html>