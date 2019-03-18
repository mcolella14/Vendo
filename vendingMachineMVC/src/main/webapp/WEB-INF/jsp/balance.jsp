<%@include file="common/header.jsp"%>
<p>Current Balance ${balance}</p>
<c:url var="bal" value="/balance"/>
<form method="POST" action="${bal}">
	<label for="moneyAdded">Add Money:</label>
	<select name="moneyAdded" id="moneyAdded">
		<option value="0.01">Penny($0.01)</option>
		<option value="0.05">Nickel($0.05)</option>
		<option value="0.10">Dime($0.10)</option>
		<option value="0.25">Quarter($0.25)</option>
		<option value="1.00">$1.00</option>
		<option value="5.00">$5.00</option>
		<option value="10.00">$10.00</option>
	</select>
	<input type="submit" value="Add to Balance">
</form>
<%@include file="common/footer.jsp"%>