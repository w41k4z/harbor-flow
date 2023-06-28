<%@ page import="models.BoatCategory" %>
<% 
 BoatCategory[] allBoatCategories=(BoatCategory[]) request.getAttribute("allBoatCategories"); 
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
        href="<%= request.getContextPath() %>/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
        href="<%= request.getContextPath() %>/static/fontawesome-5/css/all.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/css/admin.css">
    <title>Boat Categories</title>
</head>

<body>
    <div class="d-flex admin-panel">
        <!-- Side panel -->
        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light sticky-top"
            style="max-width: 280px; height: 100vh; overflow: scroll">
            <div class="d-flex justify-content-center align-items-center mb-3 mb-md-0 me-md-auto">
                <img src="<%= request.getContextPath() %>/static/images/logo.png" width="150px"
                    height="70px" alt="Logo" />
            </div>
            <hr />
            <ul class="nav nav-pills flex-column mb-auto">
                <!-- title -->
                <li class="menu-title my-2 d-none d-md-block" style="font-weight: bold; font-size: 1.2rem;">
                    Other
                </li>
                <!-- menu items -->
                <li class="nav-item" style="cursor: pointer">
                    <a class="nav-link text-dark d-flex align-items-center" href="<%= request.getContextPath() %>/page/services">
                        <span class="d-flex align-items-center" style="font-size: 25px">
                            <i class="fab fa-servicestack"></i>
                        </span>
                        <p class="m-0 ms-4 d-none d-md-block">Services</p>
                    </a>
                </li>
            
                <!-- title -->
                <li class="menu-title my-2 d-none d-md-block" style="font-weight: bold; font-size: 1.2rem;">
                    Dock
                </li>
                <li class="nav-item" style="cursor: pointer">
                    <a class="nav-link text-dark d-flex align-items-center" href="<%= request.getContextPath() %>/page/docks">
                        <span class="d-flex align-items-center" style="font-size: 25px">
                            <i class="fas fa-bars"></i>
                        </span>
                        <p class="m-0 ms-4 d-none d-md-block">Docks</p>
                    </a>
                </li>
                <li class="nav-item" style="cursor: pointer">
                    <a class="nav-link text-dark d-flex align-items-center">
                        <span class="d-flex align-items-center" style="font-size: 25px">
                            <i class="fas fa-gas-pump"></i>
                        </span>
                        <p class="m-0 ms-4 d-none d-md-block">Prestation</p>
                    </a>
                </li>
            
                <!-- title -->
                <li class="menu-title my-2 d-none d-md-block" style="font-weight: bold; font-size: 1.2rem;">
                    Boat
                </li>
                <!-- menu items -->
                <li class="nav-item" style="cursor: pointer">
                    <a class="nav-link text-dark d-flex align-items-center" href="<%= request.getContextPath() %>/page/boats">
                        <span class="d-flex align-items-center" style="font-size: 25px">
                            <i class="fas fa-ship"></i>
                        </span>
                        <p class="m-0 ms-4 d-none d-md-block">Boats</p>
                    </a>
                </li>
                <li class="nav-item" style="cursor: pointer">
                    <a class="nav-link active d-flex align-items-center">
                        <span class="d-flex align-items-center" style="font-size: 25px">
                            <i class="fas fa-link"></i>
                        </span>
                        <p class="m-0 ms-4 d-none d-md-block">Category</p>
                    </a>
                </li>
                <li class="nav-item" style="cursor: pointer">
                    <a class="nav-link text-dark d-flex align-items-center" href="<%= request.getContextPath() %>/page/boatflags">
                        <span class="d-flex align-items-center" style="font-size: 25px">
                            <i class="fas fa-flag"></i>
                        </span>
                        <p class="m-0 ms-4 d-none d-md-block">Flag</p>
                    </a>
                </li>
            
                <!-- title -->
                <li class="menu-title my-2 d-none d-md-block" style="font-weight: bold; font-size: 1.2rem;">
                    Action
                </li>
                <!-- menu items -->
                <li class="nav-item" style="cursor: pointer">
                    <a class="nav-link text-dark d-flex align-items-center">
                        <span class="d-flex align-items-center" style="font-size: 25px">
                            <i class="fas fa-th"></i>
                        </span>
                        <p class="m-0 ms-4 d-none d-md-block">Planning</p>
                    </a>
                </li>
                <li class="nav-item" style="cursor: pointer">
                    <a class="nav-link text-dark d-flex align-items-center">
                        <span class="d-flex align-items-center" style="font-size: 25px">
                            <i class="fas fa-stopwatch"></i>
                        </span>
                        <p class="m-0 ms-4 d-none d-md-block">Stopover</p>
                    </a>
                </li>
                <li class="nav-item" style="cursor: pointer">
                    <a class="nav-link text-dark d-flex align-items-center">
                        <span class="d-flex align-items-center" style="font-size: 25px">
                            <i class="fas fa-money-bill"></i>
                        </span>
                        <p class="m-0 ms-4 d-none d-md-block">Billing</p>
                    </a>
                </li>
            </ul>
        </div>


        <!-- Main content -->
        <div class="main-content">
            <!-- header -->
            <header id="header"
                class="sticky-top header d-flex justify-content-end px-4 py-2 bg-light">
                <a href="#" class="logout dropdown float-right">
                    <span class="d-flex align-items-center">
                        LOG OUT <i class="fas fa-power-off ms-2"></i>
                    </span>
                </a>
            </header>

            <!-- content -->
            <div class="m-4 bg-white">
                <div class="d-flex flex-column flex-md-row justify-content-md-between p-3">
                    <!-- content title -->
                    <h3>Boat Categories</h3>

                    <div class="d-flex align-items-center mt-sm-3 mt-md-0"
                        style="height: fit-content">
                        <button class="mx-1 btn btn-outline-success" data-bs-toggle="modal"
                            data-bs-target="#insertModal">
                            <i class="fas fa-plus" style="font-size: 20px"></i>
                        </button>
                        <!-- Add modal -->
                        <div class="modal fade" id="insertModal" tabindex="-1"
                            aria-labelledby="insertModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header d-flex justify-content-between">
                                        <h4 class="modal-title" id="insertModalLabel">New Category</h4>
                                        <button class="btn btn-close" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                    </div>
                                    <div class="model-body justify-content-around mt-3 p-3">
                                        <div class="text-black">
                                            <div class="card">
                                                <div class="card-body">
                                                    <h4 class="card-title m-0">Fill the
                                                        above information</h4>
                                                    <hr>
                                                </div>
                                                <div class="card form-content">
                                                    <form
                                                        action="<%= request.getContextPath() %>/boats/category/new"
                                                        class="row mt-3 g-3 px-3" method="post">
                                                        <div class="col-auto col-lg-12">
                                                            <label class="form-label"
                                                                for="name">Name</label>
                                                            <input type="text" name="name" id="name"
                                                                class="form-control" required />
                                                        </div>
                                                        <div
                                                            class="col-auto col-lg-12 mt-3 d-flex justify-content-end">
                                                            <button type="submit"
                                                                class="btn btn-primary mb-3">Confirm</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- // <Add Modal/> -->
                    </div>
                </div>

                <div class="table-responsive">
                    <table class="table table-striped table-fixed">
                        <thead class="px-2 table-bordered table-dark">
                            <tr style="font-size: 1rem; font-weight: bold; border-bottom: 1px solid #959090"
                                classN="text-white">
                                <th scope="col">#.</th>
                                <th scope="col">Type</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (int i=0; allBoatCategories !=null && i < allBoatCategories.length; i++) { %>
                                <tr>
                                    <td scope="row" class="mt-auto">
                                        <%= (i+1) %>.
                                    </td>
                                    <td>
                                        <%= allBoatCategories[i].getName() %>
                                    </td>
                                    <td>
                                        <div class="d-flex justify-content-end">
                                            <span class="btn-group">
                                                <button class="btn btn-outline-warning">
                                                    <i class="far fa-edit"></i>
                                                </button>
                                        
                                                <button class="btn btn-outline-danger">
                                                    <i class="fas fa-trash"></i>
                                                </button>
                                            </span>
                                        </div>
                                    </td>
                                </tr>
                                <% } %>
                        </tbody>
                    </table>
                </div>
            </div>


            <!-- footet -->
            <footer>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="footer p-3 mt-4 text-center bg-light">
                                Developed By:
                                <span class="text-info font-weight-normal">
                                    Harbory
                                </span>
                                , Using Springy, Springy-cli &amp;
                                ORM integrated
                                <a href="http://www.omdbapi.com/" target="_blank" rel="noreferrer">
                                    OMDB
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>

    <!-- Scripts -->
    <script src="<%= request.getContextPath() %>/static/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>