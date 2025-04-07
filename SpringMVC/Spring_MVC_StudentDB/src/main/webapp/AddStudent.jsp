<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Enter Student Details</h1>
	<form action="add-student" method="post">
	
		<input type = "number" placeholder="enter the StudentID" name = "studentId"><br>
		<input type = "text" placeholder="enter the StudentName" name = "studentName"><br>
		<input type = "text" placeholder="enter the StudentEmail" name = "studentEmail"><br>
		<input type = "number" placeholder="enter the StudentAge" name = "studentAge"><br>
		<input type = "text" placeholder="enter the StudentCourse" name = "studentCourse"><br>
		<input type ="submit" value ="ADD">
</form>
</body>
</html>