<!DOCTYPE html>
<html lang="en">
    <head>
    <head>
		<meta charset="ISO-8859-1">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<title>Heart Referee</title>
		<link rel="stylesheet" href="./cssStyle/styles.css">
		<link rel="stylesheet" href="./cssStyle/all.css">
        <script src="JavaScript/javaScript.js" defer></script>
	</head>
    <body>
        <div class="mv-index-bg">
            <div id="click">
            	<h3 id="msg00" class="mv-menu-msgBox">${message}</h3>
            </div>
            <div class="mv-display-center">
                <h3 style="font-family: roboto;color: silver">since 2021<br>founded by S.H.M.K <br> shared by H.M.K.T.Z</h3>
                <h1 class="mv-welcomeText animate-charcter">HEART REFEREE &nbsp;<i class="fas fa-heart"></i><i class="fas fa-user-secret"></i></h1>
                <div style="display: flex;">
                	<form action="Setting" method="GET">
                    <input id="user" type="text" name="userName" placeholder="Enter Name" maxlength="14" class="mv-list-search-box" style="width: 300px;border: 1px solid white;color: white" required>
                    <input id="submitbtn" type="submit" class="enter-button" value="Sign In" onclick="displayMsgBox()">
                </form>
                </div>
                
            </div>
        </div>
        <footer style="background-color: black;color:white">&copy; Heart Referee Version 2.5.0 &nbsp; Design by N0iSyLuvie</footer>
    </body>
    
</html>