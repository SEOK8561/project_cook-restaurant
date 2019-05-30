<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<c:forEach var="item" items="${blogs}">
		<tr>
			<td>${item.id}</td>
			<td>${item.broadcastName}</td>
			<td>${item.description}</td>
			<td>${item.link}</td>
			<td>${item.imglink}</td>
			<td>${item.title}</td>
			<td>${item.postdate}</td>
			<td>${item.createDate}</td>
			<td>${item.division}</td>
			<td>${item.likeCount}</td>
			<td>${item.readCount}</td>
			<td>${item.shareCount}</td>	
		</tr>
	</c:forEach>
</table>
<img src = "https://postfiles.pstatic.net/MjAxOTA1MDVfMjQ4/MDAxNTU3MDE3MDM2MTQ2.lmorB9FCzz3ALYsP64m1DU_reZg5-HWjPbTi6wmpx0cg.j4SPFAZHVXe9SKQndNj4FzHhLdprvCFKYB1Ly2IKQnYg.JPEG.cagycagy/SE-b46a1214-b8f2-4c99-8dee-08a95a554db4.jpg?type=w966">
</body>
</html>