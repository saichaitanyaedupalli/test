<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <% String flightNumber = request.getParameter("flight_number"); %>
    <form action="passengerdetails" method="POST">
        <input type="hidden" name="flightNumber" value="<%= flightNumber %>">
    
        First name: <input type="text" name="firstName"><br><br>
        Last name: <input type="text" name="lastName"><br><br>
        Gender: 
        <input type="radio" name="userGender" value="male">Male
        <input type="radio" name="userGender" value="female">Female<br><br>
        Contact number: <input type="text" name="mobileNum"><br><br>
        <input type="submit">
    </form>
</body>
</html>