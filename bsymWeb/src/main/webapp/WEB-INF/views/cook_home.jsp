<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>방송요리 페이지</title>
    <script src="/js/jquery.js"></script>
    <script src="/js/jquery.bxslider.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
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
            margin: 0;
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

        .cook_list_menu {
            margin: 0;
            padding: 0;
            width: 1200px;
        }

        .line_box {
            position: relative;
            font-size: 26px;
            color: #333;
            letter-spacing: -2px;
            text-align: center;
        }

        .line_font {
            background-color: #fff;
            padding: 0 10px;
            position: relative;
            z-index: 2;
        }

        .line_box::after {
            position: absolute;
            top: 15px;
            left: 0;
            content: "";
            display: block;
            width: 100%;
            height: 1px;
            background-color: #ed1c24;
        }

        .bold {
            font-weight: bold !important;
        }

        .sub_menu {
            text-align: center;
            padding: 35px 0 15px;
        }

        .sub_menu li {
            position: relative;
            display: inline-block;
            padding: 0 22px;
        }

        .sub_menu li:after {
            position: absolute;
            top: 3px;
            right: 0;
            content: "";
            display: block;
            width: 1px;
            height: 14px;
            background-color: #333;
        }

        .sub_menu li:last-child:after {
            display: none;
        }

        .sub_menu li a {
            font-size: 14px;
            color: #333;
            font-weight: 500;
        }

        .sub_menu li.on a {
            color: #e21b22;
        }

        .cook_list {
            margin: 0;
            padding: 0;
            display: grid;
            grid-template-columns: repeat(4 , 1fr);

        }

        .cook_board {
            margin-left: 25px;
            margin-right: 25px;
            margin-bottom: 30px;
            padding: 0;
            width: 250px;
            height: 300px;
            background-color: aquamarine;
        }

        .cook_board_image {
            margin: 0;
            padding: 0;
            width: 250px;
            height: 250px;
            background-color: bisque;
        }
        .cook_board_image img {
            margin: 0;
            padding: 0;
            width: 250px;
            height: 250px;
        }
        .cook_board_function_box {
            margin: 0;
            padding: 0;
            width: 250px;
            display: grid;
            grid-template-columns: repeat(3 , 1fr);
        }
        .cook_board_function {
            margin: 0;
            padding: 0;
            display: grid;
            grid-template-columns: auto auto;
            align-items: center;
            justify-content: center;
            font-size: 20px;
            
        }
        .material-icons {
            margin-top: 10px;
            padding: 0;
        }
        .cook_board_function_font {
            margin-top: 8px;
            padding: 0;
        }
    </style>
    <script>
        document.addEventListener('DOMContentLoaded', function () {
            var elems = document.querySelectorAll('.carousel');
            var instances = M.Carousel.init(elems, options);
        });

        // Or with jQuery

        $(document).ready(function () {
            $('.carousel').carousel();
        });
    </script>

</head>

<body>
    <nav>
        <div class="menu_bar_left">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li><a href="#">로그인</a></li>
                <li><a href="#">회원가입</a></li>
                <li><a href="collapsible.html">마이페이지</a></li>
            </ul>
        </div>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo center"><img src="/image/cook/bscook_main_image.png"></a>
        </div>
        <div class="menu_bar_right">
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li><a href="sass.html">방송맛집</a></li>
            </ul>
        </div>
    </nav>
    <div class="carousel" height="100%" width="100%">
        <a class="carousel-item" href="?broadcastName=수미네반찬"><img src="/image/cook/subimg1.png"></a>
        <a class="carousel-item" href="?broadcastName=알토란"><img src="/image/cook/subimg2.png"></a>
        <a class="carousel-item" href="?broadcastName=모두의주방"><img src="/image/cook/subimg3.png"></a>
        <a class="carousel-item" href="#four!"><img src="/image/cook/subimg4.png"></a>
        <a class="carousel-item" href="#five!"><img src="/image/cook/subimg5.png"></a>
        <a class="carousel-item" href="#five!"><img src="/image/cook/subimg6.png"></a>
        <a class="carousel-item" href="#five!"><img src="/image/cook/subimg7.png"></a>
        <a class="carousel-item" href="#five!"><img src="/image/cook/subimg8.png"></a>
        <a class="carousel-item" href="#five!"><img src="/image/cook/subimg9.png"></a>
        <a class="carousel-item" href="#five!"><img src="/image/cook/subimg10.png"></a>
        <a class="carousel-item" href="#five!"><img src="/image/cook/subimg11.png"></a>
    </div>
    <div class="cook_main">
        <div class="cook_list_menu">
            <h2 class="line_box">
                <span class="line_font">
                    <strong class="bold">Content</strong>
                </span>
            </h2>
        </div>
        <ul class="sub_menu">
            <li class="on"><a href="#">최신순</a></li>
            <li><a href="#">조회수순</a></li>
            <li><a href="#">좋아요순</a></li>
        </ul>
        
        <div class="cook_list">
        <c:forEach var="item" items="${blogs}">
            <div class="cook_board">
                <div class="cook_board_image">
                        <a href="blog/web/blogDetail/${itme.id}"><img src="${item.imglink}"></a>
                </div>
                <div class="cook_board_function_box">
                    <div class="cook_board_function">
                            <a href="#"><i class="material-icons">thumb_up</i><span class="cook_board_function_font">&nbsp;"${item.id}</span></a>
                    </div>
                    <div class="cook_board_function">
                            <i class="material-icons">visibility</i><span class="cook_board_function_font">&nbsp;"${item.readCount}</span></a>
                    </div>
                    <div class="cook_board_function">
                            <a href="#"><i class="material-icons">favorite_border</i></a>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>