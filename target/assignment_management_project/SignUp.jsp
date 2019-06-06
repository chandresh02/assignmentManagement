<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp Page</title>
</head>
<body bgcolor="red" >
<h2>SignUp</h2>
<br>
<form action="signUp.ams"   method="post">
First Name:<input type="text" name="firstName" />
Last Name:<input type="text"  name="lastName">
Email Id:<input type="text"   name="emailId">
Country Code:<select   name="countryCode">

<option value="+91">+91</option>
<option value="+92">+92</option>
<option value="+93">+93</option>
<option value="+94">+94</option>
<option value="+95">+95</option>
</select>
Mobile No:<input type="text"  name="mobileNo">
<input type = "submit" name = "submit" value = "Submit" />
         <input type = "reset" name = "reset"  value = "Reset" />
 
</form>
</body>
</html>