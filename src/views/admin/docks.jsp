<%@ page import="java.util.Arrays" %>
<%@ page import="models.Docks" %>
<%@ page import="models.BoatCategory" %>
<%@ page import="models.Service" %>
<%@ page import="models.Currency" %>
<% 
    Docks[] allDocks = (Docks[]) request.getAttribute("allDocks");
    Service[] allServices = (Service[]) request.getAttribute("allServices");
    BoatCategory[] allBoatCategories = (BoatCategory[]) request.getAttribute("allBoatCategories");
    Currency[] allCurrencies = (Currency[]) request.getAttribute("allCurrencies");

    out.println("<script>");
    out.println("var allCurrencies = []");
    for (Currency currency : allCurrencies) {
        out.println("allCurrencies.push({currency: '" + currency.getCurrencyID() + "', label: '" + currency.getLabel() + "'})");
    }
    out.println("</script>");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/fontawesome-5/css/all.min.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/css/admin.css">
    <script>
        var index = 0;
    </script>
    <title>Docks</title>
</head>
<body>
    <div class="d-flex admin-panel">
        <!-- Side panel -->
        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light sticky-top" style="max-width: 280px; height: 100vh; overflow: scroll">
            <div class="d-flex justify-content-center align-items-center mb-3 mb-md-0 me-md-auto">
                <img src="<%= request.getContextPath() %>/static/images/logo.png" width="150px" height="70px" alt="Logo" />
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
                    <a class="nav-link active d-flex align-items-center">
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
                    <a class="nav-link text-dark d-flex align-items-center" href="<%= request.getContextPath() %>/page/boatcategories">
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
            <header id="header" class="sticky-top header d-flex justify-content-end px-4 py-2 bg-light">
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
                    <h3>Docks</h3>

                    <div class="d-flex align-items-center mt-sm-3 mt-md-0" style="height: fit-content">
                        <button class="mx-1 btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#insertModal">
                            <i class="fas fa-plus" style="font-size: 20px"></i>
                        </button>
                        <!-- Add modal -->
                        <div class="modal fade" id="insertModal" tabindex="-1" aria-labelledby="insertModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header d-flex justify-content-between">
                                        <h4 class="modal-title" id="insertModalLabel">New Boat</h4>
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
                                                <div class="card form-content">
                                                    <form action="<%= request.getContextPath() %>/docks/new"
                                                        class="row mt-3 g-3 px-3" method="post">
                                                        <div class="col-auto col-lg-12">
                                                            <label class="form-label" for="name">Name</label>
                                                            <input type="text" name="name" id="name" class="form-control" required />
                                                        </div>
                                                        <div class="col-auto col-lg-12">
                                                            <label class="form-label" for="length">Length</label>
                                                            <input type="number" name="length" id="length" class="form-control" required />
                                                        </div>
                                                        <div class="col-auto col-lg-12">
                                                            <label class="form-label" for="width">Width</label>
                                                            <input type="number" name="width" id="width" class="form-control" required />
                                                        </div>
                                                        <div class="col-auto col-lg-12">
                                                            <label class="form-label" for="depth">Depth</label>
                                                            <input type="number" name="depth" id="depth" class="form-control" required />
                                                        </div>
                                                        <div class="col-auto col-lg-12">
                                                            <label class="form-label" for="currency">Currency</label>
                                                            <select name="currency" id="currency" class="form-select" required>
                                                                <% for(int i = 0; allCurrencies != null && i < allCurrencies.length; i++) { %>
                                                                    <option value="<%= allCurrencies[i].getCurrencyID() %>">
                                                                        <%= allCurrencies[i].getLabel() %>
                                                                    </option>
                                                                <% } %>
                                                            </select>
                                                        </div>
                                                        <div class="col-auto col-lg-12 mt-3 d-flex justify-content-end">
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
                        <!-- // <Add Modal/> -->
                    </div>
                </div>

                <div class="table-responsive">
                    <table class="table table-striped table-fixed">
                        <thead class="px-2 table-bordered table-dark">
                            <tr style="font-size: 1rem; font-weight: bold; border-bottom: 1px solid #959090" classN="text-white">
                                <th scope="col">#.</th>
                                <th scope="col">Name</th>
                                <th scope="col">Length</th>
                                <th scope="col">Width</th>
                                <th scope="col">Depth</th>
                                <th scope="col">Currency</th>
                                <th scope="col">Services</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (int i = 0; allDocks != null && i < allDocks.length; i++) { %>
                                <tr>
                                    <td scope="row" class="mt-auto"><%= (i+1) %>.</td>
                                    <td><%= allDocks[i].getName() %></td>
                                    <td><%= allDocks[i].getLength() %></td>
                                    <td><%= allDocks[i].getWidth() %></td>
                                    <td><%= allDocks[i].getDepth() %></td>
                                    <td><%= allDocks[i].getCurrency() %></td>
                                    <td>
                                        <!-- Service details -->
                                        <button class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#detailModal<%= i %>">See..</button>
                                        <div class="modal fade" id="detailModal<%= i %>" tabindex="-1" aria-labelledby="detailModalLabel<%= i %>"
                                            aria-hidden="true">
                                            <div class="modal-dialog modal-lg">
                                                <div class="modal-content">
                                                    <div class="modal-header d-flex justify-content-between">
                                                        <h4 class="modal-title" id="detailModalLabel<%= i %>">
                                                            Services</h4>
                                                        <button class="btn btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                    </div>
                                                    <div class="model-body justify-content-around mt-3 p-3">
                                                        <div class="text-black">
                                                            <div class="card">
                                                                <div class="card-body form-content">
                                                                    <% for(int j = 0; j < allDocks[i].getDockServices().length; j++) { %>
                                                                        <h3 class="card-title m-0">
                                                                            <%= (j+1) + ". " + allDocks[i].getDockServices()[j].getService().getName() %>
                                                                        </h3>
                                                                        <hr />
                                                                        <% for(int k = 0; k < allDocks[i].getDockServices()[j].getDockServicePrices().length; k++) { %>
                                                                            <div class="table-responsive">
                                                                                <table class="table table-striped">
                                                                                    <caption><%= allDocks[i].getDockServices()[j].getDockServicePrices()[k].getBoatCategory().getName() %> (hourly tier: <%= allDocks[i].getDockServices()[j].getDockServicePrices()[k].getHourlyTier() %>mn)</caption>
                                                                                    <thead>
                                                                                        <tr>
                                                                                            <th>i-th hourly tier</th>
                                                                                            <th>From</th>
                                                                                            <th>To</th>
                                                                                            <th>National</th>
                                                                                            <th>International</th>
                                                                                        </tr>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <% for(int l = 0; l < allDocks[i].getDockServices()[j].getDockServicePrices()[k].getDockServicePriceDetails().length; l++) { %>
                                                                                            <tr>
                                                                                               <td><%= allDocks[i].getDockServices()[j].getDockServicePrices()[k].getDockServicePriceDetails()[l].getI_Th_hourlyTier() %></td> 
                                                                                               <td><%= allDocks[i].getDockServices()[j].getDockServicePrices()[k].getDockServicePriceDetails()[l].getFromTime().toString() %></td> 
                                                                                               <td><%= allDocks[i].getDockServices()[j].getDockServicePrices()[k].getDockServicePriceDetails()[l].getToTime().toString() %></td> 
                                                                                               <td class="text-end"><%= allDocks[i].getDockServices()[j].getDockServicePrices()[k].getDockServicePriceDetails()[l].getNationalPrice() %></td> 
                                                                                               <td class="text-end"><%= allDocks[i].getDockServices()[j].getDockServicePrices()[k].getDockServicePriceDetails()[l].getInternationalPrice() %></td> 
                                                                                            </tr>
                                                                                        <% } %>
                                                                                    </tbody>
                                                                                </table>
                                                                            </div>
                                                                        <% } %>
                                                                    <% } %>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- // Service details -->
                                    </td>
                                    <td>
                                        <div class="d-flex justify-content-end">
                                            <span class="btn-group">
                                                <button class="btn btn-outline-primary" data-bs-toggle="modal" data-bs-target="#newPrestModal<%= i %>">
                                                    Add
                                                </button>
                                                <div class="modal fade" id="newPrestModal<%= i %>" tabindex="-1" aria-labelledby="newPrestModalLabel<%= i %>"
                                                    aria-hidden="true">
                                                    <div class="modal-dialog modal-lg">
                                                        <div class="modal-content">
                                                            <div class="modal-header d-flex justify-content-between">
                                                                <h4 class="modal-title" id="newPrestModalLabel<%= i %>">New prestation</h4>
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
                                                                        <div class="card form-content">
                                                                            <form action="<%= request.getContextPath() %>/docks/<%= allDocks[i].getDockID() %>/new-service"
                                                                                class="row g-3 px-3" method="post">
                                                                                <div class="col-auto col-lg-12">
                                                                                    <label class="form-label" for="prestation_id">Service</label>
                                                                                    <select name="prestation" id="prestation_id" class="form-select" required>
                                                                                        <% for(int j=0; allServices !=null && j < allServices.length; j++) { %>
                                                                                            <option value="<%= allServices[j].getServiceID() %>">
                                                                                                <%= allServices[j].getName() %>
                                                                                            </option>
                                                                                            <% } %>
                                                                                    </select>
                                                                                </div>
                                                                                <div class="col-auto col-lg-6">
                                                                                    <label class="form-label" for="hourly_tier">Hourly tier (minute)</label>
                                                                                    <input type="number" name="hourlyTier" id="hourly_tier" step=".01" class="form-control" required />
                                                                                </div>
                                                                                <div class="col-auto col-lg-6">
                                                                                    <label class="form-label" for="category_id">Service</label>
                                                                                    <select name="categoryID" id="category_id" class="form-select" required>
                                                                                        <% for(int j = 0; allBoatCategories != null && j < allBoatCategories.length; j++) { %>
                                                                                            <option value="<%= allBoatCategories[j].getBoatCategoryID() %>">
                                                                                                <%= allBoatCategories[j].getName() %>
                                                                                            </option>
                                                                                        <% } %>
                                                                                    </select>
                                                                                </div>
                                                                                <hr class="mt-3">
                                                                                <div class="col-12 row g-3 px-3" id="detail">
                                                                                    <div class="d-flex justify-content-end">
                                                                                        <p class="mx-1 btn btn-success" onclick="addDetail()">
                                                                                            <i class="fas fa-plus" style="font-size: 20px"></i>
                                                                                        </p>
                                                                                    </div>
                                                                                    <div class="col-auto col-md-4">
                                                                                        <label class="form-label" for="hourly_tier">i-th hourly tier</label>
                                                                                        <input type="number" name="hourlyTiers[]" id="hourly_tier" class="form-control" required />
                                                                                    </div>
                                                                                    <div class="col-auto col-md-4">
                                                                                        <label class="form-label" for="fromTime">From</label>
                                                                                        <input type="time" name="fromTimes[]" id="fromTime" step="1" class="form-control" required>
                                                                                    </div>
                                                                                    <div class="col-auto col-md-4">
                                                                                        <label class="form-label" for="toTime">To</label>
                                                                                        <input type="time" name="toTimes[]" id="toTime" step="1" class="form-control" required>
                                                                                    </div>

                                                                                    <div class="col-auto col-md-4">
                                                                                        <label class="form-label" for="national">National</label>
                                                                                        <input type="number" name="nationals[]" id="national" class="form-control" required />
                                                                                    </div>
                                                                                    <div class="col-auto col-md-4">
                                                                                        <label class="form-label" for="international">International</label>
                                                                                        <input type="number" name="internationals[]" id="international" class="form-control" required>
                                                                                    </div>
                                                                                    <div class="col-auto col-md-4">
                                                                                        <label class="form-label" for="currency">CUR</label>
                                                                                        <select name="currencies[]" id="currency" class="form-select" required>
                                                                                            <% for(int k = 0; allCurrencies != null && k < allCurrencies.length; k++) { %>
                                                                                                <option value="<%= allCurrencies[k].getCurrencyID() %>">
                                                                                                    <%= allCurrencies[k].getLabel() %>
                                                                                                </option>
                                                                                                <% } %>
                                                                                        </select>
                                                                                    </div>
                                                                                </div>

                                                                                <div class="col-auto col-lg-12 mt-3 d-flex justify-content-end">
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
    <script>
        function addDetail() {
            let i = index++;

            let div = document.getElementById("detail");
            
            let iThHourlyTier = document.createElement("div");
            iThHourlyTier.classList.add("col-auto", "col-md-4");
            let input1 = document.createElement("input");
            input1.classList.add("form-control");
            input1.setAttribute("type", "number");
            input1.setAttribute("name", "hourlyTiers[]");

            iThHourlyTier.appendChild(input1);

            let fromTime = document.createElement("div");
            fromTime.classList.add("col-auto", "col-md-4");
            let input2 = document.createElement("input");
            input2.classList.add("form-control");
            input2.setAttribute("type", "time");
            input2.setAttribute("name", "fromTimes[]");
            input2.setAttribute("step", "1");

            fromTime.appendChild(input2);

            let toTime = document.createElement("div");
            toTime.classList.add("col-auto", "col-md-4");
            let input3 = document.createElement("input");
            input3.classList.add("form-control");
            input3.setAttribute("type", "time");
            input3.setAttribute("name", "toTimes[]");
            input3.setAttribute("step", "1");

            toTime.appendChild(input3);

            let national = document.createElement("div");
            national.classList.add("col-auto", "col-md-4");
            let input4 = document.createElement("input");
            input4.classList.add("form-control");
            input4.setAttribute("type", "number");
            input4.setAttribute("name", "nationals[]");

            national.appendChild(input4);

            let international = document.createElement("div");
            international.classList.add("col-auto", "col-md-4");
            let input5 = document.createElement("input");
            input5.classList.add("form-control");
            input5.setAttribute("type", "number");
            input5.setAttribute("name", "internationals[]");

            international.appendChild(input5);

            let currency = document.createElement("div");
            currency.classList.add("col-auto", "col-md-4");
            let input6 = document.createElement("select");
            input6.classList.add("form-select");
            input6.setAttribute("name", "currencies[]");
            
            for(let cur of allCurrencies) {
                let option = document.createElement("option");
                option.setAttribute("value", cur.currency);
                option.innerHTML = cur.label;
                input6.appendChild(option);
            }
            
            currency.appendChild(input6);

            div.appendChild(iThHourlyTier);
            div.appendChild(fromTime);
            div.appendChild(toTime);
            div.appendChild(national);
            div.appendChild(international);
            div.appendChild(currency);
        }
    </script>
    <div class="col-auto col-md-5">
        <label class="form-label" for="national">National</label>
        <input type="number" name="national[]" id="national" class="form-control" required />
    </div>
    <div class="col-auto col-md-3">
        <label class="form-label" for="international">International</label>
        <input type="number" name="international[]" id="international" class="form-control" required>
    </div>
    <div class="col-auto col-md-2">
        <label class="form-label" for="currency">CUR</label>
        <select name="currency[]" id="currency" class="form-select" required>
            <% for(int i=0; allCurrencies !=null && i < allCurrencies.length; i++) { %>
                <option value="<%= allCurrencies[i].getCurrencyID() %>">
                    <%= allCurrencies[i].getLabel() %>
                </option>
                <% } %>
        </select>
    </div>
</body>
</html>