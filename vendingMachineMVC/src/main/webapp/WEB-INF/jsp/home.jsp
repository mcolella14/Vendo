<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%@include file="common/header.jsp"%>
  <div id="machine"><p>Vendo</p>
        <div id="machineItems">
        <c:forEach var="item" items="${items}">
      
      	
        	<c:url var="itemPage" value="/item?slot=${item.slotNumber}"/>
        	 <a 
        	 
        	 id="machineItem" href="${itemPage}">
        	 <c:if test="${item.quantity < 1}"><p id="soldOut">SOLD OUT</p></c:if>
        	 ${item.slotNumber}
        	 	
        	 </a>
        	
        </c:forEach>
        </div>
  
        <div class="machineRow" id="door"> 
        </div>
    </form>
    </div>
<%@include file="common/footer.jsp"%>