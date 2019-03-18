<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/css.css">

<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
</head>
<body>
	
	    <nav>
	    <div id="header">
	    <div><h1>VENDO</h1></div>
		<c:url var ="home" value="/home"/>
		<div><a href="${home}">Home</a></div>
		<br>
		<c:url var ="add" value="/balance"></c:url>
		<div><a href="${add}">Add to Balance</a></div>
		<br>
		<div>Balance: ${balance}</div>
	</div>
</nav>
