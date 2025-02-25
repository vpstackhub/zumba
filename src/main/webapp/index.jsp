<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zumba Class Enrollment</title>
</head>
<body>
    <h2>Register for Zumba Classes</h2>
    <form action="enroll" method="post">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        <input type="submit" value="Enroll">
    </form>
</body>
</html>