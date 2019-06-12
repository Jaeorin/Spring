<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/my.css" />
    <link rel="stylesheet" href="/css/my1.css" />
    <meta charset="UTF-8">
    <title>Homepage</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        .footer {
            background-color: beige;
            width: 100%;
            height: 10vh;
            padding: 0;
            margin: 0;
            display: inline-block;
        }
    </style>
</head>

<body>
    <div class="container">
        <div class="header1">
            <header>
                <span class="top-logo">
                    <a href="#"><img src="/image/app_logo_02.png" style="height: 30px"></a>
                </span>
                <span class="top-download">
                    <span class="store-mention">구글플레이나 애플 앱스토어에서 사람들의 진짜 이야기를 만나요.</span>
                    <a href="#" class="top-download-btn">앱 다운로드</a>
                </span>
            </header>
        </div>
        <div class="serch">
            <form>
                <div class="searchinput">
                    <input type="input" class="search-text-input" placeholder="해시태그를 검색하세요. (ex. 음성일기)">
                </div>
                <div class="suggestTags">
                    <span><a href="#">#연애상담</a></span>
                    <span><a href="#">#이별</a></span>
                    <span><a href="#">#고민</a></span>
                    <span><a href="#">#오늘내마음을읽었습니다</a></span>
                </div>
            </form>
        </div>
    </div>
    <div class="menu1 ">
        <div class="container">
            <ul>
                <li><a href="#">인기</a></li>
                <li><a href="#">음성</a></li>
                <li><a href="#">유머</a></li>
                <li><a href="#">설렘</a></li>
                <li><a href="#">고민</a></li>
                <li><a href="#">명언</a></li>
                <li><a href="#">여행</a></li>
                <li><a href="#">선곡</a></li>
                <li><a href="#">어라운드</a></li>
            </ul>
        </div>
    </div>


    <div class="container1">
        <div class="photo container">

            <ul class="col-10 container2">
                <div class="col-12" style=" margin: 0 auto">
                    <div class="row justify-content-center">
                        <li class="list-group-item-topic col-8">
                            <a href="/web/detail/1">
                                <div>
                                    <img src="/image/116.jpg" alt="X" width="595px" height="347px">
                                </div>
                                <div class="m-4 text-center">
                                    <p>
                                        좋은사람 알아보는법
                                    </p>
                                </div>
                            </a>
                        </li>
                        <div class="col-4">
                            <div class="row">
                                <li class="list-group-item col-12 p-1 ">
                                    <a href="#">
                                        <div>
                                            <img src="/image/bg08_thumbnail.jpg" alt="X" width="297"
                                                height="173">
                                        </div>
                                        <div class="m-1">
                                            <p>
                                                너무너무좋아요♥
                                            </p>
                                        </div>
                                    </a>
                                </li>
                            </div>
                            <div class="row">
                                <li class="list-group-item col-12 p-1 ">
                                    <a href="#">
                                        <div>
                                            <img src="/image/bg285_thumbnail.jpg" alt="X" width="297" height="173">
                                        </div>
                                        <div class="m-1">
                                            <p>
                                                사랑해요너무너무좋아요♥
                                            </p>
                                        </div>
                                    </a>
                                </li>
                            </div>
                        </div>
                    </div>
                </div>
            </ul>

        </div>
    </div>
        <div class="footerWrap">
            <footer>
                <div class="footer-download"><a href="#" class="footer-download-btn">앱 다운로드</a></div>
            </footer>
        </div>
</body>

</html>