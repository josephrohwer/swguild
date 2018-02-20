<%-- 
    Document   : displaySearchAddressFormNoAjax
    Created on : Oct 25, 2016, 2:03:57 PM
    Author     : josephrohwer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Address Book</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body>
        <div class="container">
            <h1>Address Book</h1>
            <hr/>
        </div>
        <div class="container">
            <h1>Search Address</h1>
            <!-- #1 - Link to displayAddressListNoAjax -->
            <a href="displayAddressListNoAjax">Address List (No Ajax)</a><br/>
            <hr/>
            <form class="form-horizontal"
                  role="form"
                  action="searchAddressNoAjax"
                  method="POST">
                <div class="form-group">
                    <label for="search-first-name"
                           class="col-md-4 control-label">First Name:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="search-first-name"
                               name="firstName"
                               placeholder="First Name"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="search-last-name" class="col-md-4 control-label">Last Name:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="search-last-name"
                               name="lastName"
                               placeholder="Last Name"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="search-address"
                           class="col-md-4 control-label">Street Address:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="search-address"
                               name="address"
                               placeholder="Street Address"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="search-city" class="col-md-4 control-label">City:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="search-city"
                               name="city"
                               placeholder="City"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="search-state" class="col-md-4 control-label">State:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="search-state"
                               name="state"
                               placeholder="State"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="search-zip" class="col-md-4 control-label">Zip Code:</label>
                    <div class="col-md-8">
                        <input type="text"
                               class="form-control"
                               id="search-zip"
                               name="zipCode"
                               placeholder="Zip Code"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <button type="submit"
                                id="add-button"
                                class="btn btn-default">Search for Address</button>
                    </div>
                </div>
            </form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>