 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html tabindex="-1"> 
	<head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<title>Heart Referee</title>
		<link rel="stylesheet" href="./cssStyle/styles.css">
		<link rel="stylesheet" href="./cssStyle/all.css">
        <script src="JavaScript/javaScript.js" defer></script>
	</head>
	<body tabindex="-1" style="overflow-x: hidden">
		<div id="modal01" class="mv-display-center mv-view-image mv-animate-zoom"> 
            <button class="mv-display-topRight mv-logIn-close-button hover-effect" onclick="displayNone('modal01')"><i class="far fa-times-circle"></i></button>
             <div id="radioTab" class="mv-table-input">
             	<div style="text-align: center;margin-top: 50px">
             		<p class="mv-username">Change Name</p>
	            	<c:forEach items="${userList}" var="user">
	            		<a href="HResult?username=${user.username}">
		            		<h5 class="user-choose" >
		             			${user.username}
		             		</h5>
	             		</a>
	             	</c:forEach>
             	</div>
             	<a href="HResult?username=12345">
	            	<button class="log-out-btn hover-effect" style="width: 100px">Total</button>
	            </a>
	            <a href="RecoverResult">
	            	<button class="log-out-btn hover-effect" style="width: 100px;margin-left: 120px">Recover</button>
	            </a>
			</div>
        </div>
		<div class="mv-basic-bg">
			 <div class="mv-tab-bar">
				<h3>
					<a href="Table" class="tab-bar-button hover-effect margin-left">Home</a>
				</h3>
				<h3>
					<a href="WaitingTable?m=money" class="tab-bar-button hover-effect margin-left">Waiting Table</a>
				</h3>
				<h3>
					<a href="Recover?limit=1500" class="tab-bar-button hover-effect margin-left">Recover Check</a>
				</h3>
				<h3>
					<a href="RecoverPageController?sellerName=Default" class="tab-bar-button hover-effect margin-left" >Recover Note</a>
				</h3>
				<h3>
					<a href="FullTableController" class="tab-bar-button hover-effect margin-left">Full Table</a>
				</h3>
				<h3>
					<a href="Final" class="tab-bar-button hover-effect margin-left">Report</a>
				</h3>
				<h3>
					<a href="HResult" class="tab-bar-button hover-effect margin-left" style="color:${ledger}">Ledger</a>
				</h3>
			</div>	
			<div class="user-total-field">
				<span class="user-name hover-effect" onclick="displayBlock('modal01')" style="margin-right: 5px">Recover ledger</span>
			</div>	
			<div class="mv-display-middle" style="margin-top: 10px">
				<div id="tb02" class="mv-table-style" style="height:auto;width: 100%">
					<table class="mv-waiting-table" style="width: 1200px">
						<tr class="mv-list-table-head" style="font-size: 16px">
							<th style="width: 50px">
								<h4>#</h4>
							</th>
							<th style="width: 200px">				
								<h4>Date</h4>
							</th>
							<th style="width: 300px">				
								<h4>SellerName</h4>
							</th>
							<th>
								<h4>Recover Money</h4>
							</th>
							<th>
								<h4>Recover Com</h4>
							</th>
							<th>
								<h4>Recover P</h4>
							</th>
							<th>				
								<h4>Recover Plus</h4>
							</th>
							<th>				
								<h4>Recover Total</h4>
							</th>
						</tr>
						<c:forEach items="${user2DList}" var="user2D">
							<tr class="mv-waiting-table-data" style="font-size: 16px">
								<td><p>${user2D.count}</p></td>
								<td><p>${user2D.time}</p></td>
								<td><p>${user2D.username}</p></td>
								<td><p>${user2D.recover} ks</p></td>
								<td><p>${user2D.recoverCom} ks</p></td>
								<td><p>${user2D.recoverP}</p></td>
								<td><p>${user2D.recoverPlus} ks</p></td>
								<td><p style="color:${user2D.color}">${user2D.totalMoney} ks</p></td>
							</tr>
						</c:forEach>
						<c:forEach items="${totalUser2DList}" var="tUser2D">
							<tr class="mv-waiting-table-data" style="font-size: 16px;background-color: silver">
								<td><p>-</p></td>
								<td><p>-</p></td>
								<td><p>-</p></td>
								<td><p>${tUser2D.recover} ks</p></td>
								<td><p>${tUser2D.recoverCom} ks</p></td>
								<td><p>${tUser2D.recoverP}</p></td>
								<td><p>${tUser2D.recoverPlus} ks</p></td>
								<td><p style="color:${tUser2D.color}">${tUser2D.totalMoney} ks</p></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<footer style="background-color: black;color:white">&copy; Heart Referee Version 2.8.0 &nbsp; Design by N0iSyLuvie</footer>
	</body>
</html>