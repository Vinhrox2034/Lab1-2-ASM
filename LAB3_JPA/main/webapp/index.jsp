<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>PolyOE Video System</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap" rel="stylesheet">

    <style>
        * {
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }


        body {
            margin: 0;
            height: 100vh;
            background:
                    linear-gradient(rgba(0,0,0,0.45), rgba(0,0,0,0.45)),
                    url("https://www.kingdomhearts.com/img/characters/xiii/xiii.png")
                    center/cover no-repeat;

            display: flex;
            flex-direction: column;
            justify-content: space-between;
            color: white;
        }



        .menu-box {
            margin: 40px;
            padding: 35px 45px;
            width: 360px;

            background: rgba(255,255,255,0.08);
            border-radius: 20px;
            backdrop-filter: blur(10px);
            box-shadow: 0 20px 40px rgba(0,0,0,0.5);
        }


        .menu-btn {
            display: block;
            width: 100%;
            margin: 15px 0; /* ← NOT auto */
            padding: 14px 20px;

            font-size: 18px;
            font-weight: 600;
            color: white;
            text-decoration: none;
            border-radius: 12px;

            background: linear-gradient(135deg, #4facfe, #00f2fe);
            transition: all 0.3s ease;
        }


        .title-bar {
            padding: 30px 40px;
            font-size: 42px;
            font-weight: 700;
            letter-spacing: 1px;
            text-shadow: 0 8px 25px rgba(0,0,0,0.6);
        }


        .menu-btn:hover {
            transform: translateY(-4px) scale(1.03);
            box-shadow: 0 12px 30px rgba(0,0,0,0.4);
        }

        .emoji {
            margin-right: 8px;
        }
    </style>
</head>
<body>

<!-- TOP TITLE -->
<div class="title-bar">
    Manage Videos System
</div>

<!-- BOTTOM LEFT MENU -->
<div class="menu-box">
    <a class="menu-btn" href="favorite-list">
         Favorite Video Statistics
    </a>

    <a class="menu-btn" href="favorite-by-user">
         Favorites By User
    </a>

    <a class="menu-btn" href="search-video">
         Search Video
    </a>
</div>

</body>

</body>
</html>
