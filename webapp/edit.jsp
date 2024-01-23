<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.vendormanagement.model.Vendor" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>

<html>
<head>
    <title>Edit Vendor</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Vendor Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="container">
    <h3 class="text-center">Edit Vendor Details</h3>
    <hr>

    <%-- Retrieve the vendor object from the request attribute --%>
    <%
        Vendor vendor = (Vendor) request.getAttribute("vendor");
        if (vendor != null) {
    %>
            <form action="updateServlet" method="post">
                <div class="form-group">
                    <label for="vendorName">Vendor Name:</label>
                    <input type="text" class="form-control" id="vendorName" name="vendorName" value="<%= vendor.getVendor_name() %>" required>
                </div>

                <div class="form-group">
                    <label for="bankAccNo">Bank Account No:</label>
                    <input type="text" class="form-control" id="bankAccNo" name="bankAccNo" value="<%= vendor.getBank_accno() %>" required>
                </div>

                <div class="form-group">
                    <label for="bankName">Bank Name:</label>
                    <input type="text" class="form-control" id="bankName" name="bankName" value="<%= vendor.getBank_name() %>" required>
                </div>

                <div class="form-group">
                    <label for="addressLine">Address Line:</label>
                    <input type="text" class="form-control" id="addressLine" name="addressLine" value="<%= vendor.getAddressline() %>" required>
                </div>

                <div class="form-group">
                    <label for="city">City:</label>
                    <input type="text" class="form-control" id="city" name="city" value="<%= vendor.getCity() %>" required>
                </div>

                <div class="form-group">
                    <label for="country">Country:</label>
                    <input type="text" class="form-control" id="country" name="country" value="<%= vendor.getCountry() %>" required>
                </div>

                <div class="form-group">
                    <label for="zipCode">Zip Code:</label>
                    <input type="text" class="form-control" id="zipCode" name="zipCode" value="<%= vendor.getZipcode() %>" required>
                </div>

                <!-- Include a hidden input field to pass the vendor ID to the updateServlet -->
                <input type="hidden" name="vendorId" value="<%= vendor.getVendor_id() %>">

                <button type="submit" class="btn btn-primary">Update Vendor</button>
            </form>
    <%
        } else {
            // Handle the case when the vendor object is not found
            out.println("<p>Error: Vendor details not found.</p>");
        }
    %>
</div>

</body>
</html>
