<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/bootstrap/css/bootstrap.css">
    <title>Error</title>
</head>

<body>
    <h3 class="text-danger text-center my-5 py-5">
        <%= request.getAttribute("error") %>
    </h3>
</body>

</html>