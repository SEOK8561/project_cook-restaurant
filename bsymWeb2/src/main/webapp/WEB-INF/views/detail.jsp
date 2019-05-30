<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글페이지</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="/css/style.css"/>
<link rel="stylesheet" href="/css/board/board.css"/>
</head>

<body>
    <nav>
        <div class="menu_bar_left">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li><a href="/bsym/web/login">로그인</a></li>
                <li><a href="회원가입 페이지">회원가입</a></li>
                <li><a href="마이 페이지">마이페이지</a></li>
            </ul>
        </div>
        <div class="nav-wrapper">
            <a href="/bsym/web/bloglistAll/${blog.division}?broadcastName=${blog.broadcastName}" class="brand-logo center"><img src="/image/cook/main_logo.png"></a>
        </div>
        <div class="menu_bar_right">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li><a href="sass.html">방송맛집</a></li>
            </ul>
        </div>
    </nav>
    <div class="cook_main">
       <iframe src="${blog.link}"></iframe>
    </div>
    <div class="sidevar">
    	 <a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons">add</i></a>
    </div>
</body>

</html>