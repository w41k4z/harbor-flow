<%@ page import="models.StopoverInvoice" %>
<% 
    String userID = (String) request.getSession().getAttribute("user");
    StopoverInvoice[] allPendingStopoversBilling=(StopoverInvoice[]) request.getAttribute("allPendingStopoversBilling"); 
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
        href="<%= request.getContextPath() %>/static/bootstrap/css/bootstrap.min.css">
    <title>Stopover</title>
</head>

<body>
    <div class="container">
        <header
            class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom sticky-top bg-white">
            <a href="#"
                class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img src="<%= request.getContextPath() %>/static/images/logo.png" alt="" width="100px"
                    height="50px">
            </a>

            <ul class="nav nav-pills">
                <li class="nav-item"><a href="<%= request.getContextPath() %>/harbor/home/planning"
                        class="nav-link" aria-current="page">Planning</a></li>
                <li class="nav-item"><a href="<%= request.getContextPath() %>/harbor/home/stopover" class="nav-link">Stopover</a></li>
                <li class="nav-item"><a href="#" class="nav-link active">Billing</a></li>
            </ul>
        </header>
        <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Billing</h4>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th> Action Date </th>
                                        <th> Stopover Ref </th>
                                        <th> Boat </th>
                                        <th> Details </th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for(int i=0; allPendingStopoversBilling !=null && i <
                                        allPendingStopoversBilling.length; i++) { %>
                                        <tr>
                                            <td class="py-1">
                                                <%= allPendingStopoversBilling[i].getActionDate().toString() %>
                                            </td>
                                            <td>
                                                <%= allPendingStopoversBilling[i].getStopoverID() %>
                                            </td>
                                            <td>
                                                <%= allPendingStopoversBilling[i].getStopover().getBoat().getName() %>
                                            </td>
                                            <td>
                                                <button class="btn btn-secondary" data-bs-toggle="modal"
                                                    data-bs-target="#detailModal<%= i %>">See..</button>
                                                <div class="modal fade" id="detailModal<%= i %>"
                                                    tabindex="-1"
                                                    aria-labelledby="detailModalLabel<%= i %>"
                                                    aria-hidden="true">
                                                    <div class="modal-dialog modal-lg">
                                                        <div class="modal-content">
                                                            <div
                                                                class="modal-header d-flex justify-content-between">
                                                                <h4 class="modal-title"
                                                                    id="detailModalLabel<%= i %>">
                                                                    Services</h4>
                                                                <button class="btn btn-close"
                                                                    data-bs-dismiss="modal"
                                                                    aria-label="Close"></button>
                                                            </div>
                                                            <div
                                                                class="model-body justify-content-around mt-3 p-3">
                                                                <div class="text-black">
                                                                    <div class="card">
                                                                        <div class="card-body">
                                                                            <% for(int j=0;
                                                                                allPendingStopoversBilling[i].getStopover().getStopoverServices()
                                                                                !=null && j <
                                                                                allPendingStopoversBilling[i].getStopover().getStopoverServices().length;
                                                                                j++) { %>
                                                                                <h4
                                                                                    class="card-title m-0">
                                                                                    <%= allPendingStopoversBilling[i].getStopover().getStopoverServices()[j].getDock().getName()
                                                                                        %>
                                                                                </h4>
                                                                                <hr />
                                                                                <div
                                                                                    class="table-responsive">
                                                                                    <table
                                                                                        class="table table-striped">
                                                                                        <thead>
                                                                                            <tr>
                                                                                                <th> Service </th>
                                                                                                <th> From </th>
                                                                                                <th> To </th>
                                                                                                <th> State </th>
                                                                                                <th>  </th>
                                                                                            </tr>
                                                                                        </thead>
                                                                                        <tbody>
                                                                                            <% for(int k=0; allPendingStopoversBilling[i].getStopover().getStopoverServices()[j].getStopoverServicesDetails() !=null
                                                                                                && k < allPendingStopoversBilling[i].getStopover().getStopoverServices()[j].getStopoverServicesDetails().length;
                                                                                                k++) {
                                                                                                %>
                                                                                                <tr>
                                                                                                    <td>
                                                                                                        <%= allPendingStopoversBilling[i].getStopover().getStopoverServices()[j].getStopoverServicesDetails()[k].getDockService().getService().getName()
                                                                                                            %>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                        <%= allPendingStopoversBilling[i].getStopover().getStopoverServices()[j].getStopoverServicesDetails()[k].getStartDate().toString()
                                                                                                            %>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                        <%= allPendingStopoversBilling[i].getStopover().getStopoverServices()[j].getStopoverServicesDetails()[k].getEndDate().toString()
                                                                                                            %>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                        <%= allPendingStopoversBilling[i].getStopover().getStopoverServices()[j].getStopoverServicesDetails()[k].getActualState()
                                                                                                            %>
                                                                                                    </td>

                                                                                                    <td>
                                                                                                        <% if(allPendingStopoversBilling[i].getStopover().getStopoverServices()[j].getStopoverServicesDetails()[k].getState() >= 11) { %>
                                                                                                            <button class="btn btn-secondary" disabled>Validate</button>
                                                                                                        <% } else { %>
                                                                                                            <a class="btn btn-success" href="<%= request.getContextPath() %>/harbor/stopover/validate-service/<%= allPendingStopoversBilling[i].getStopover().getStopoverServices()[j].getStopoverServicesDetails()[k].getStopoverServicesDetailsID() %>">Validate</a>
                                                                                                        <% } %>
                                                                                                    </td>
                                                                                                </tr>
                                                                                                <% } %>
                                                                                        </tbody>
                                                                                    </table>
                                                                                </div>
                                                                                <% } %>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="d-flex justify-content-end">
                                                <a class="btn btn-success" href="<%= request.getContextPath() %>/harbor/stopover/invoice/<%= allPendingStopoversBilling[i].getStopoverInvoicesID() %>">To bill</a> 
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