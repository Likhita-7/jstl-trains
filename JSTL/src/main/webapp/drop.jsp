<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/mytaglib.tld" prefix="mytag" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Custom Tag Example</title>
</head>
<body>
    
<center>
<br>
<br>
    <mytag:drop  tableName="train_data" columnName="trn_start" />
    
    <mytag:drop tableName="train_data" columnName="trn_end" />
    <button onclick="doo()">Search</button>
    
    <mytag:train from="BZA" to="SC"/>
    <div id="tagContainer">
        <!-- The created custom tag will be added here -->
    </div>

   </center> 
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
    function doo(){
    	var from = document.getElementById("trn_start").value;
    	var to = document.getElementById("trn_end").value;
    	console.log(from+' '+to);
    	var customTag = document.createElement("mytag:train");

        // Set attributes for the custom tag
        customTag.setAttribute("from", from);
        customTag.setAttribute("to", to);

        document.getElementById("tagContainer").appendChild(customTag);
    }
    </script>
</body>
</html>
