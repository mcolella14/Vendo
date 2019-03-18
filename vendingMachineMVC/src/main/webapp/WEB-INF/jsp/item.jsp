<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%@include file="common/header.jsp"%>
   <div id="itemPage">
   	 
   		<div>${item.name}</div>
        <div>Price: ${item.priceString}</div>
        <div>${item.quantity} left</div>
        <c:url var="con" value="/confirmation"/>
        
        
        
        
   	 <form method="POST" action="${con}">
   	 
   	 	<input type="hidden" name="slot" value="${item.slotNumber}"/>
   	 	<input type="hidden" name="amountToSubtract" value="${item.price}"/>
   	 	<input type="hidden" name="slotNumber" value="${item.slotNumber}"/>
   	 	
   	 	<c:if test="${item.quantity < 1}"><p>Out of stock</p></c:if>
   	 	
   	 	<c:if test="${item.price > balanceNum}"><p>Balance is too low</p></c:if>
   	 	
   	 	<c:if test="${item.price <= balanceNum && item.quantity > 0}">
   	 		<input id= "submitButton" type="submit" value="BUY"/>
   	 	</c:if>
   	 	
   	 </form> 
    </div>
<%@include file="common/footer.jsp"%>