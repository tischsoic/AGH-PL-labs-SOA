<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>car form</title>
</head>
<body>
<form method="post" action="">
    <fieldset>
        Type:<select name="type">
        <option value="sport">Sport</option>
        <option value="urban">Urban</option>
        <option value="luxury">Luxury</option>
    </select>
        Price range(pricelow-pricehigh):<input type="text" name="price_range" value="1-1000000"><br><br>
        <input type="submit" value="Submit">
    </fieldset>
</form>
</body>
</html>
