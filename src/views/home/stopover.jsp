<%@ page import="models.Boats" %>
<%@ page import="models.Docks" %>
<%@ page import="models.Stopover" %>
<%
    String userID = (String) request.getSession().getAttribute("user");
    Boats[] allBoats = (Boats[]) request.getAttribute("allBoats");
    Docks[] allDocks = (Docks[]) request.getAttribute("allDocks");
    Stopover[] allPendingStopovers = (Stopover[]) request.getAttribute("allPendingStopovers");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/bootstrap/css/bootstrap.min.css">
    <title>Stopover</title>
</head>

<body>
    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom sticky-top">
            <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img src="<%= request.getContextPath() %>/static/images/logo.png" alt="" width="100px" height="50px">
            </a>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="<%= request.getContextPath() %>/harbor/planning" class="nav-link" aria-current="page">Planning</a></li>
                <li class="nav-item"><a href="#" class="nav-link active">Stopover</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Billing</a></li>
            </ul>
        </header>
        <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Stopover</h4>
                        <div class="card-description d-flex justify-content-end">
                            <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#insertModal">+</button>
                            <div class="modal fade" id="insertModal" tabindex="-1" aria-labelledby="insertModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header d-flex justify-content-between">
                                            <h4 class="modal-title" id="insertModalLabel">New Stopover</h4>
                                            <button class="btn btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="model-body justify-content-around mt-3 p-3">
                                            <div class="text-black">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <h4 class="card-title m-0">Fill all the
                                                            above information</h4>
                                                        <hr>
                                                    </div>
                                                    <div class="card">
                                                        <form class="row g-3 px-3" method="POST">
                                                            <input type="hidden" name="userID" value="<%= userID %>">
                                                            <div class="col-auto col-lg-12">
                                                                <label class="form-label" for="boat_id">Boat</label>
                                                                <select name="boatID" id="boat_id" class="form-select" required>
                                                                    <option value="">1</option>
                                                                    <option value="">2</option>
                                                                    <option value="">3</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-auto col-lg-12">
                                                                <label class="form-label" for="dock_id">Dock</label>
                                                                <select name="dockID" id="dock_id" class="form-select" required>
                                                                    <option value="">1</option>
                                                                    <option value="">2</option>
                                                                    <option value="">3</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-auto col-lg-12">
                                                                <input type="datetime-local" name="startDate" class="form-control" placeholder="Start Date" required>
                                                            </div>
                                                            <div
                                                                class="col-auto col-lg-12 mt-3 d-flex justify-content-end">
                                                                <button type="submit" class="btn btn-primary mb-3">Confirm</button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th> Arrival Date </th>
                                        <th> Boat </th>
                                        <th> Current dock </th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for(int i = 0; allPendingStopovers != null && i < allPendingStopovers.length; i++) { %>
                                    <tr>
                                        <td class="py-1"> <%= allPendingStopovers[i].getStartDate().toString() %> </td>
                                        <td> <%= allPendingStopovers[i].getBoat().getName() %> </td>
                                        <td> <%= allPendingStopovers[i].getCurrentStopoverServices().getDock().getName() %> </td>
                                        <td class="d-flex justify-content-end">
                                            <div class="btn-group">
                                                <button class="btn btn-info" data-toggle="modal"
                                                    data-target="#editModal">Change dock</button>
                                                <button class="btn btn-success" data-toggle="modal"
                                                    data-target="#editModal">New prestation</button>
                                                <a class="btn btn-primary">Close</a>
                                            </div>
                                        </td>
                                    </tr>
                                    <% } %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="<%= request.getContextPath() %>/static/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>