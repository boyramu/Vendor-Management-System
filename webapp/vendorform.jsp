<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Vendor Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Vendors</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${v != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${v == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${v != null}">
            			Edit User
            		</c:if>
						<c:if test="${v == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${v != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Vendor Name</label> <input type="text"
						value="<c:out value='${v.vendorName}' />" class="form-control"
						name="vendorName" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Bank Account No</label> <input type="text"
						value="<c:out value='${v.bankAccountNo}' />" class="form-control"
						name="bankAccountNo" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Bank Name</label> <input type="text"
						value="<c:out value='${v.bankName}' />" class="form-control"
						name="bankName" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Address Line1</label> <input type="text"
						value="<c:out value='${v.addressLine1}' />" class="form-control"
						name="addressLine1">
				</fieldset>
				<fieldset class="form-group">
					<label>Address Line2</label> <input type="text"
						value="<c:out value='${v.addressLine2}' />" class="form-control"
						name="addressLine2" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>City</label> <input type="text"
						value="<c:out value='${v.city}' />" class="form-control"
						name="city" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Country</label> <input type="text"
						value="<c:out value='${v.country}' />" class="form-control"
						name="country">
				</fieldset>
				<fieldset class="form-group">
					<label>Zip Code</label> <input type="text"
						value="<c:out value='${v.zipCode}' />" class="form-control"
						name="zipCode">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>