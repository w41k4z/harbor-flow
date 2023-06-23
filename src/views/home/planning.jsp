<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/bootstrap/css/bootstrap.min.css">
    <title>Planning</title>
</head>
<body>
    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom sticky-top">
            <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img src="<%= request.getContextPath() %>/static/images/logo.png" alt="" width="100px" height="50px">
            </a>
    
            <ul class="nav nav-pills">
                <li class="nav-item"><a href="#" class="nav-link active" aria-current="page">Planning</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Stopover</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Billing</a></li>
            </ul>
        </header>
        <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Stopover forecast</h4>
                        <div class="card-description d-flex justify-content-end">
                            <button class="btn btn-success" data-toggle="modal" data-target="#insertModal">+</button>
                            <div class="modal fade" id="insertModal" tabindex="-1" aria-hidden="true">
                                <div class="modal-dialog modal-fullscreen">
                                    <div class="modal-content">
                                        <div class="modal-header d-flex justify-content-between">
                                            <h4 class="modal-title" id="mediumModalLabel">Add new employee
                                            </h4>
                                            <button class="btn" data-dismiss="modal" aria-label="Close"><i
                                                    class="mdi mdi-close"></i> </button>
                                        </div>
                                        <div class="model-body justify-content-around mt-3 p-3">
                                            <div>
                                                <div class="card">
                                                    <div class="card-body">
                                                        <h4 class="card-title m-0 text-white">Fill all the
                                                            above information</h4>
                                                        <hr>
                                                    </div>
                                                    <div class="card">
                                                        <form class="row g-3 px-3" id="employeeForm" method="POST">
                                                            <div class="col-auto col-lg-12">
                                                                <input type="text" class="form-control" placeholder="Name"
                                                                    name="name">
                                                            </div>
                                                            <div class="col-auto col-lg-12">
                                                                <input type="text" class="form-control" placeholder="First Name"
                                                                    name="firstName">
                                                            </div>
                                                            <div class="col-auto col-lg-12">
                                                                <input type="text" class="form-control" placeholder="Post"
                                                                    name="post">
                                                            </div>
                                                            <div class="col-auto col-lg-12">
                                                                <input type="number" class="form-control" placeholder="Salary"
                                                                    name="salary">
                                                            </div>
                                                            <div class="col-auto col-lg-12 mt-3 d-flex justify-content-end">
                                                                <button type="submit" class="btn btn-primary mb-3"
                                                                    onclick="addEmployee(event)">Confirm</button>
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
                                        <th> Date </th>
                                        <th> Source </th>
                                        <th> Boat </th>
                                        <th> Arrival </th>
                                        <th> Departure </th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="py-1"> 12/12/2023 </td>
                                        <td> 127.0.0.1 </td>
                                        <td> Man'oWar </td>
                                        <td> 13/12/2023 13:20:00 </td>
                                        <td> 13/12/2023 22:35:00 </td>
                                        <td>
                                            <div class="btn-group">
                                                <button class="btn btn-warning" data-toggle="modal"
                                                    data-target="#editModal">Edit</button>
                                                <div class="modal fade" id="editModal" tabindex="-1" role="dialog"
                                                    aria-labelledby="mediumModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog modal-md modal-dialog-centered" role="document">
                                                        <div class="modal-content">
                                                            <div class="modal-header d-flex justify-content-between">
                                                                <h5 class="modal-title" id="mediumModalLabel">Update
                                                                    employee
                                                                </h5>
                                                                <button class="btn" data-dismiss="modal" aria-label="Close"><i
                                                                        class="mdi mdi-close"></i>
                                                                </button>
                                                            </div>
                                                            <div class="model-body justify-content-around mt-3 p-3">
                                                                <div>
                                                                    <div class="card">
                                                                        <div class="card-body">
                                                                            <h4 class="card-title m-0 text-white">Change
                                                                                the
                                                                                above information</h4>
                                                                            <hr>
                                                                        </div>
                                                                        <div class="card">
                                                                            <form class="row g-3 px-3" id="employeeForm"
                                                                                method="POST">
                                                                                <input type="hidden" name="employeeID"
                                                                                    value="" />
                                                                                <div class="col-auto col-lg-12">
                                                                                    <input type="text" class="form-control"
                                                                                        placeholder="Name" name="name"
                                                                                        value="Alain">
                                                                                </div>
                                                                                <div class="col-auto col-lg-12">
                                                                                    <input type="text" class="form-control"
                                                                                        placeholder="First Name"
                                                                                        name="firstName" value="Rico">
                                                                                </div>
                                                                                <div class="col-auto col-lg-12">
                                                                                    <input type="text" class="form-control"
                                                                                        placeholder="Post" name="post"
                                                                                        value="CEO">
                                                                                </div>
                                                                                <div class="col-auto col-lg-12">
                                                                                    <input type="text" class="form-control"
                                                                                        placeholder="Salary" name="salary"
                                                                                        value="1200">
                                                                                </div>
                                                                                <div
                                                                                    class="col-auto col-lg-12 mt-3 d-flex justify-content-end">
                                                                                    <button type="button"
                                                                                        class="btn btn-secondary"
                                                                                        data-dismiss="modal">Cancel</button>
                                                                                    <button type="submit"
                                                                                        class="btn btn-primary">Confirm</button>
                                                                                </div>
                                                                            </form>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
        
                                                <a class="btn btn-primary">Validate</a>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="d-flex justify-content-end">
                                <button class="btn btn-info">Plan</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="<%= request.getContextPath() %>/static/bootstrap/v4.1.3/js/bootstrap.min.js"></script>

</body>
</html>