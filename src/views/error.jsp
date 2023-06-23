
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/bootstrap/css/bootstrap.min.css">
    <title>Error</>
</head>
<body>
     <h1 class="m-5 p-5 text-danger" id="errorMessage"></h1>     
     <script>
         var error = 'ERROR: <%= request.getAttribute("error").toString() %>';
         document.getElementById("errorMessage").innerHTML = error;
     </script>
</body>
</html>
