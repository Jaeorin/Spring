<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link rel="stylesheet" href="/css/my.css" />
    <link rel="stylesheet" href="/css/my1.css" />
    <link rel="stylesheet" href="/css/search.css" />
    <meta charset="UTF-8">
    <title>Searchpage</title>
    <style>
        * {
            padding: 0;
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="container-top">
        <div class="headerWrap">
            <header>
                <span class="top-logo">
                    <a href="#"><img src="/image/app_logo_02.png"></a>
                </span>
                <div class="top-search">
                    <form role="search" class="ng-pristine ng-valid">
                        <input type="text" class="search-box" placeholder="#태그를 검색하세요." value="40대싱글녀">
                        <button type="submit" class="top-search-btn">검색</button>
                    </form>
                </div>
                <span class="top-download">
                    <a href="#" class="top-download-btn">앱 다운로드</a>
                </span>
            </header>
        </div>
        <div class="menuWrap">
            <div class="swiper-container swiper-container-horizontal">
                <ul class="swiper-wrapper" id="categoryList">
                    <li class="category swiper-slide selected swiper-slide-active"><a href="javascript:;">#40대싱글녀</a>
                    </li>
                    <li class="category swiper-slide swiper-slide-next"><a href="/?t=0">인기</a></li>
                    <li class="category swiper-slide" data-name="라디오"><a href="/?t=1">음성</a></li>
                    <li class="category swiper-slide" data-name="유머"><a href="/?t=2">유머</a></li>
                    <li class="category swiper-slide" data-name="설렘"><a href="/?t=3">설렘</a></li>
                    <li class="category swiper-slide" data-name="고민"><a href="/?t=4">고민</a></li>
                    <li class="category swiper-slide" data-name="명언"><a href="/?t=5">명언</a></li>
                    <li class="category swiper-slide" data-name="여행"><a href="/?t=6">여행</a></li>
                    <li class="category swiper-slide" data-name="선곡"><a href="/?t=7">선곡</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="contentsWrap">
        <div class="mainContentsWrap">
        <h5>인기 있는 이야기</h5>
            <div class="infinity-list">
                <ul>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in popularArticles">
                        <img src="http://user-generated.around.so/pictures/thumb-bd2rnavO2B">
                        <a ng-href="http://around.so/view?v=GrY7pB" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=GrY7pB">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>그나마 오늘은 좀 시원하다
                        못해<br>싸늘하니 참을만 하다만<br>더운 날은 증말...😭<br>한겨울 핫팩보다 더 뜨끈한 개님!</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in popularArticles">
                        <img src="http://user-generated.around.so/pictures/thumb-MBZeBaAW2W">
                        <a ng-href="http://around.so/view?v=mKMnNp" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=mKMnNp">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>제목은 알라딘인데<br>알라딘만 빼고 다
                        멋지다.<br>지니 완전 짱!!!<br>쟈스민 쵝오!!!</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in popularArticles">
                        <img src="http://user-generated.around.so/pictures/thumb-q7ZWXayE2g">
                        <a ng-href="http://around.so/view?v=zWQGMA" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=zWQGMA">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>지난 불금의 흔적들...<br>알아야 할
                        것들은<br>모두 알려줬다.<br>한 개만 빼고!!!! 🤭</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in popularArticles">
                        <img src="http://common-contents.around.so/bg-fixed/bg211_thumbnail.jpg">
                        <a ng-href="http://around.so/view?v=5bDEQR" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=5bDEQR">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>술 마시러 간다고
                        전화하면서<br>꼬박꼬박 전화도 하고<br>대단하지 않냐며 뿌듯해 하는데<br>이 시간에 술 마시러 간다는 전화에<br>즐겁게 마시라고 해주는 내가 <br>더
                        대단한 거 같진 않니???<br><br>어차피 마실 거 즐겁게 드시길!</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in popularArticles">
                        <img src="http://user-generated.around.so/pictures/thumb-lE21Vk0NDg">
                        <a ng-href="http://around.so/view?v=zWQX51" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=zWQX51">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>새로 했는데<br>뭐 낯 익은 것도
                        같은...<br>하지만 이 아인<br>엄연히 프렌치!!! 라는 거...</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in popularArticles">
                        <img src="http://user-generated.around.so/pictures/thumb-m12blYlxpj">
                        <a ng-href="http://around.so/view?v=gkm47k" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=gkm47k">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>쪼만한 가방을 들고 나오니<br>가볍긴
                        하네. <br>대신 짐 늘어나는 거 싫어<br>쇼핑을 패쓰하게 됨!!!! ☹️</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in popularArticles">
                        <img src="http://common-contents.around.so/bg-fixed/bg142_thumbnail.jpg">
                        <a ng-href="http://around.so/view?v=2qDQpk" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=2qDQpk">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>맨날맨날 바쁘다면서 하는
                        말은<br>다음달에 여행 갈려면<br>일을 좀 해놔야지 않겠냐고...<br>그 여행은 누구랑 갈라고?<br>내가 같이 간다고 했나?<br>자기 혼자 계획
                        세우고<br>혼자 바쁘심.<br>흠...🤔</p></a>
                    </li>
                </ul>
            </div>
        <h5>최근 써진 이야기</h5>
            <div class="infinity-list">
                <ul>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in articles">
                        <img src="http://user-generated.around.so/pictures/thumb-q7ZWXayE2g">
                        <a ng-href="http://around.so/view?v=zWQGMA" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=zWQGMA">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>지난 불금의 흔적들...<br>알아야 할
                        것들은<br>모두 알려줬다.<br>한 개만 빼고!!!! 🤭</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in articles">
                        <img src="http://user-generated.around.so/pictures/thumb-MBZeBaAW2W">
                        <a ng-href="http://around.so/view?v=mKMnNp" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=mKMnNp">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>제목은 알라딘인데<br>알라딘만 빼고 다
                        멋지다.<br>지니 완전 짱!!!<br>쟈스민 쵝오!!!</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in articles">
                        <img src="http://user-generated.around.so/pictures/thumb-lxpMqrEMp6">
                        <a ng-href="http://around.so/view?v=2qDzBd" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=2qDzBd">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>투자자 미팅 시간이 바뀐 건지<br>내가
                        알게뭐냐고 내내 투덜댔더니<br>가는 중이라고 하더니만 사무실 앞으로.<br>아무렇지 않아하면 또 서운해하면서~</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in articles">
                        <img src="http://user-generated.around.so/pictures/thumb-vOp3zw6xD6">
                        <a ng-href="http://around.so/view?v=2qDzkk" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=2qDzkk">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>어느날 들어가니 그냥 생겨있던
                        코인.<br>쭉 그냥 뒀었다가 오늘 이걸 보고 나니 혹~<br>결국 25만원에 매도 걸어놨는데<br>계속 떨어지기만 하고. 욕심이 과하면 안됨!</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in articles">
                        <img src="http://user-generated.around.so/pictures/thumb-6xZ7qrMdDB">
                        <a ng-href="http://around.so/view?v=yKy1Xw" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=yKy1Xw">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀
                        <br>예쁜데...<br>예쁘긴한데...<br>왜 핑크색은 안 나오지?<br>영수증 칼 같이 버려달라고 했는데...😭</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in articles">
                        <img src="http://user-generated.around.so/pictures/thumb-WRpOBNmGDq">
                        <a ng-href="http://around.so/view?v=lpK7gQ" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=lpK7gQ">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>올만에 문구류 쇼핑과 커피
                        한잔!<br>아무렇지 않을려고 했지만 <br>짜증은 났다는 거...<br>청구할테다!!!</p></a>
                    </li>
                    <li class="inf-item typec col2 ng-scope" ng-repeat="article in articles">
                        <img src="http://user-generated.around.so/pictures/thumb-lE21VrY8Dg">
                        <a ng-href="http://around.so/view?v=4kDaVE" class="bindableUtm link-article ellipsis"
                        data-position="search" href="http://around.so/view?v=4kDaVE">
                        <p ng-bind-html="nl2br(article.title)" class="ng-binding">#40대싱글녀 <br>6시 땡!!!하고 퇴근.<br>지하철도
                        바로바로 오는 걸 탔더니<br>7시 몇 분 전에 도착해서 개님 산책까지. <br>집에 너무 일찍 와서 다들 이상한 중~😳</p></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>