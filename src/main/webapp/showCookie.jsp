<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Cookie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <div class="mx-auto" style="width: 300px;">
            <h1>Cookie Content</h1>
            <%
                String cookieValue = (String) request.getAttribute("cookieValue");
                if (cookieValue != null && !cookieValue.isEmpty()) {
            %>
                <p class="text-center fs-4">The value of the cookie is: <%= cookieValue %></p>
            <%
                } else {
            %>
                <p class="text-center fs-4">No cookie found.</p>
            <%
                }
            %>
            <div class="form-group d-flex justify-content-center">
                <a href="index.html" class="btn btn-primary mt-3">Back to Home Page</a>
            </div>
        </div>
    </div>
</body>
</html>