<html lang="en">
<head>
    <title>JAVA REST API- TEST</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1 >List of Posts</h1>
    <table class="table table-sm table-striped table-bordered table-hover">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Post title</th>
            <th scope="col" colspan="2"  class="text-center">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="i" value="1" />
        <c:forEach items="${postList}"  begin="0" end="11" var="u">
            <tr class="text-center">
                <th scope="row">${i}</th>
                <td class="text-left">${u.title}</td>
                <td><a href="postDetails/${u.id}" class="btn btn-info btn-sm" role="button" aria-pressed="true">Details</a></td>
                <td><button class="btn btn-danger btn-sm" onclick="deletePost(${u.id})">Delete</button></td>
            </tr>
            <c:set var="i" value="${i+1}" />
        </c:forEach>
        </tbody>
    </table>
    <p><a href="createPost"  class="btn btn-success btn-sm button1">Create a new post</a></p>
</div>
<script>
    function  deletePost(id) {
        $.ajax({
            url: 'deletePost/' + id,
            type: 'DELETE',
            success: function(result) {
              alert(result);
            },
            error: function (result) {
                alert(result);
            }
        });
    }
</script>
</body>
</html>