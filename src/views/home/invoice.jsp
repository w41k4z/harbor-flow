<%@ page import="app.Invoice" %>
<% 
    String userID=(String) request.getSession().getAttribute("user");
    Invoice invoice=(Invoice) request.getAttribute("invoice"); 
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
                <li class="nav-item"><a href="<%= request.getContextPath() %>/harbor/home/billing"
                        class="nav-link">Billing</a></li>
            </ul>
        </header>
        <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">Invoice</h4>
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th> Dock </th>
                                        <th> Total (National) </th>
                                        <th> Total (International) </th>
                                        <th> Details </th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for(int i=0; i < invoice.getInvoiceDetails().size(); i++) { %>
                                        <tr>
                                            <td class="py-1">
                                                <%= invoice.getInvoiceDetails().get(i).getDock().getName() %>
                                            </td>
                                            <td>
                                                <%= invoice.getInvoiceDetails().get(i).getTotal()[0] + " " + invoice.getInvoiceDetails().get(i).getDock().getCurrency() %>
                                            </td>
                                            <td>
                                                <%= invoice.getInvoiceDetails().get(i).getTotal()[1] + " " + invoice.getInvoiceDetails().get(i).getDock().getCurrency() %>
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
                                                                            <% for(int j=0; j < invoice.getInvoiceDetails().get(i).getServices().size(); j++) { %>
                                                                                <h4
                                                                                    class="card-title m-0">
                                                                                    <%= invoice.getInvoiceDetails().get(i).getServices().get(j).getDockService().getService().getName() %>
                                                                                </h4>
                                                                                <hr />
                                                                                <div
                                                                                    class="table-responsive">
                                                                                    <table
                                                                                        class="table table-striped">
                                                                                        <thead>
                                                                                            <tr>
                                                                                                <th> National </th>
                                                                                                <th> International </th>
                                                                                            </tr>
                                                                                        </thead>
                                                                                        <tbody>
                                                                                                <tr>
                                                                                                    <td>
                                                                                                        <%= invoice.getInvoiceDetails().get(i).getAmounts().get(j)[0]  + " " + invoice.getInvoiceDetails().get(i).getDock().getCurrency() %>
                                                                                                    </td>
                                                                                                    <td>
                                                                                                        <%= invoice.getInvoiceDetails().get(i).getAmounts().get(j)[1] + " " + invoice.getInvoiceDetails().get(i).getDock().getCurrency() %>
                                                                                                    </td>
                                                                                                </tr>
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
                                                <div class="btn-group">

                                                    <button class="btn btn-primary"
                                                        data-bs-toggle="modal"
                                                        data-bs-target="#closeModal<%= i %>">Close</button>
                                                    <div class="modal fade" id="closeModal<%= i %>"
                                                        tabindex="-1"
                                                        aria-labelledby="closeModalLabel<%= i %>"
                                                        aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div
                                                                    class="modal-header d-flex justify-content-between">
                                                                    <h4 class="modal-title"
                                                                        id="closeModalLabel<%= i %>">
                                                                        Close stopover</h4>
                                                                    <button class="btn btn-close"
                                                                        data-bs-dismiss="modal"
                                                                        aria-label="Close"></button>
                                                                </div>
                                                                <div
                                                                    class="model-body justify-content-around mt-3 p-3">
                                                                    <div class="text-black">
                                                                        <div class="card">
                                                                            <div class="card-body">
                                                                                <form
                                                                                    action="<%= request.getContextPath() %>/harbor/stopover/close"
                                                                                    method="post">
                                                                                    <input type="hidden"
                                                                                        name="userID"
                                                                                        value="<%= userID %>">
                                                                                    <input type="hidden"
                                                                                        name="stopoverID"
                                                                                        >
                                                                                    <div
                                                                                        class="col-auto col-lg-12">
                                                                                        <input
                                                                                            type="datetime-local"
                                                                                            name="endDate"
                                                                                            step="1"
                                                                                            class="form-control"
                                                                                            placeholder="End Date"
                                                                                            required>
                                                                                    </div>
                                                                                    <div
                                                                                        class="col-auto col-lg-12 mt-3 d-flex justify-content-end">
                                                                                        <button
                                                                                            type="submit"
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