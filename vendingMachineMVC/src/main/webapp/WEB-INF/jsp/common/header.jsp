<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/css.css">

<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
</head>
<body>
    <h1>VENDO</h1>
    <nav>
	<c:url var ="home" value="/home"/>
	<a href="${home}">Home</a>
	<c:url var ="add" value="/balance"></c:url>
	<a href="${add}">Add to Balance</a>
	Balance: ${balance}
</nav>