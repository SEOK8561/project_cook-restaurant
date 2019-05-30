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
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        nav {
            display: grid;
            grid-template-columns: 4fr 2fr 4fr;
            align-items: center;
            height: 120px;
            width: 100%;
            padding: 0;
            background-color: rgb(240, 114, 10);
        }

        .menu_bar_left {
            margin-top: 0;
            margin-left: 20px;
            display: grid;
            justify-content: left;
            position: relative;
        }

        .menu_bar_left ul li a {
            font-size: 2rem;
            font-weight: 1000;
        }

        .nav-wrapper a img {
            display: grid;
            justify-content: center;
            padding-top: 10px;
        }

        .menu_bar_right {
            margin-top: 0;
            margin-right: 20px;
            display: grid;
            justify-content: right;
            position: relative;
        }

        .menu_bar_right ul li a {
            font-size: 2rem;
            font-weight: 1000;
        }

        .cook_banner {
            margin: 0;
            padding: 0;
            display: grid;
            justify-content: center;
            align-items: center;
            height: 20vh;
            width: 100%;
        }

        .cook_main {
            display: grid;
            justify-content: center;
            align-items: center;
        }

        .bs_login_container {
            margin-top: 100px;
            padding: 0;
            width: 1200px;
        }
    </style>
</head>

<body>
    <nav>
        <div class="menu_bar_left">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li><a href="http://127.0.0.1:5500/Project/login.html?action=#">로그인</a></li>
                <li><a href="http://127.0.0.1:5500/Project/join.html?action=">회원가입</a></li>
                <li><a href="collapsible.html">마이페이지</a></li>
            </ul>
        </div>
        <div class="nav-wrapper">
            <a href="http://127.0.0.1:5500/Project/cook_home.html" class="brand-logo center"><img src="image/cook/bscook_main_image.png"></a>
        </div>
        <div class="menu_bar_right">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li><a href="sass.html">방송맛집</a></li>
            </ul>
        </div>
    </nav>
    <div class="cook_main">
       <iframe width="1000px" height="1000px" src="${blog.link}"></iframe>
    </div>
</body>

</html>