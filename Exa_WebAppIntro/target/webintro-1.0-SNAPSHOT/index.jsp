<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script type="text/javascript" src="guestbook.js"></script>
</head>
<body>
<h2>Welcome</h2>
<h1>Guestbook</h1>
<br/>
<form action="hello-servlet" method="get">
    nickname: <input name="nickname" value="nickname">
    email: <input name="email" value="sf@htl-kaindorf.at">
    comment: <input name="comment" value="comment...">
    <input type="submit" value="submit">
    <input type="reset" value="reset">
    <input type="button" value="button" onclick="onButtonClick();">
    <input type="checkbox" name="cb" value="AUT"> AUSTRIA</input>
    <input type="checkbox" name="cb" value="SUI"> Suisse</input>
    <input type="checkbox" name="cb" value="GER"> GERMANY4</input>
    <input type="radio" name="language" value="ger"> german</input>
    <input type="radio" name="language" value="eng"> english</input>
    <select name="season" id="x">
        <option value="Spring"> Spring</option>
        <option value="Summer"> Summer</option>
        <option value="Fall" selected> Fall</option>
        <option value="Winter"> Winter</option>
    </select>


</form>
</body>
</html>