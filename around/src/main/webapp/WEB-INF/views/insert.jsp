<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<link rel="stylesheet" href="/css/my.css" />
<link rel="stylesheet" href="/css/my1.css" />
<link rel="stylesheet" href="/css/search.css" />
    <meta charset="UTF-8">
    <title>Insertpage</title>
    <style>
        *{
            padding: 0;
            margin: 0;
        }

    </style>
</head>
<body>
    <div class="container1">
        <div class="header1">
            <header>
                <span class="top-logo">
                    <a href="#"><img src="/image/app_logo_02.png" style="height: 30px; margin-top: 10px;"></a>
                </span>
                <span class="top-download">
                    <span class="store-mention">구글플레이나 애플 앱스토어에서 사람들의 진짜 이야기를 만나요.</span>
                    <a href="#" class="top-download-btn">앱 다운로드</a>
                    <span>
                        <button data-toggle="collapse" data-target="#demo"><img src="/image/search_icon.jpg" style="height: 30px"></button>
                    </span>
                </span>
                
            </header>
            
        </div>
        <div id="demo" class="collapse searchinput">
            <input type="input" class="form-control search-text-input" placeholder="해시태그를 검색하세요. (ex. 음성일기)">
        </div>
            <div class="menu1">
                <div class="container">
                    <ul >
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
        <div class="contentsWarp">
            <div class="contents">
                <div class="main">
                    <a href="#">
                        <section class="article-header" style="background: url('http://user-generated.around.so/pictures/YmZdXdvvZd') no-repeat center top #020403;background-size: 100%;">
                            <span class="article-logo">AROUND</span>
                            <h1 class="article-title">오늘은 자존감에 관한 글을 봐서 같이 나눠보아요 :) 공감팍팍 ! 그치만 좀 길어요 😝</h1>
                                <div class="article-header-buttons">
                                    <span class="article-status article-like-count" onclick="goMarketAfterConfirm('articleLikeSize');">
                                        <label class="z">공감</label>
                                        <span class="counts">370</span>
                                    </span>
                                    <span class="article-status article-comment-count" onclick="goMarketAfterConfirm('articleCommentSize');">
                                        <label class="z">댓글</label>
                                        <span class="counts">33</span>
                                    </span>
                                </div>
                        </section>
                    </a>
                    <section class="article-body">
                            <!-- 리슨(Listen - 설레는 보이스톡!) 배너 -->
                        <div class="listen-banner" style="background-color:#7433D4;">
                            <div><a href="http://abr.ge/nbclx"><img src="//common-contents.anna.sh/images/banner/640x100-min.jpg" alt="애나 - 인공지능 커플 매니저"></a></div>
                        </div>
                            <!-- // 리슨 배너 // -->
                        <div class="article-body-content">
                            <a href="javascript:subscribeFacebook();" id="top-subscription" style="display:none;color:#777;font-size:12px;">어라운드의 가장 인기있는 이야기를 받아 보세요.</a>
                            <p c lass="text">
                                오늘은 자존감에 관한 글을 봐서 <br>같이 나눠보아요 :) <br>공감팍팍 !  <br>그치만 좀 길어요 😝😅😂 <br> <br>자존감은  <br>부모님께 사랑 많이 받고 자라고 <br>타고난 외모에 재능을 가지고 있을 때 <br>생기는 거라고 생각합니다. <br> <br>천만의 말씀이에요 <br>자존감은 절대적으로 <br>나 자신과의 관계에서만 생깁니다. <br> <br> <br>자신을 냉철하게 바라보고 <br>문제점을 고치려 할 때, <br>좋은 점을 극대화하려고 할 때  <br>높아지는 것입니다. <br> <br>제가 생각하는  <br>자존감의 정의는 <br>'내가 좀 더 나은 사람이 되려는 실천' <br>이외에는 없습니다. <br> <br>즉, 일상 속에서의 <br>자발적 성실함만이  <br>진정한 자존감을 <br>차곡차곡 쌓아 나가게 해주는 것 같아요. <br> <br>자존감 높은 사람으로 만들어주는 것은 <br>일시적인 자뻑 혹은  <br>자학의 반복이 아닌 <br>차곡차곡 쌓인 성실함이 배경이 되어야 합니다. <br>_임경선작가 <br> <br>저부터 자존감이 소복소복 쌓일 수 있도록 <br>매일매일 조금씩 실천해봐야겠어요 :) <br>자존감 업업업 :D  <br>다들 소복소복 꾸준히 자존감을 쌓아가보아요 ✨ <br> <br>#캘리그라피 #손글씨 #달콤쪽지 #하루한줄 #감동배달부 #자존감높이기
                            </p>
                            <img src="http://user-generated.around.so/pictures/M9pJV8Qwpr">
                        </div>
                    </section>
                        <div class="cast-container" style="padding: 15px 0px;">
                            <div class="listen-banner" style="background-color:#7433D4;">
                                <div><a href="http://abr.ge/9yq2"><img src="//common-contents.anna.sh/images/banner/1200x627-min.jpg" alt="애나 - 인공지능 커플 매니저"></a></div>
                            </div>
                        </div>
                            <div class="cast-container">
                                <div class="series-list">
                                    <p class="title">이어지는 이야기</p>
                                    <ul>
                                        <li class="prev "><a href="?v=qYW1d6&amp;utm_campaign=o&amp;utm_medium=w&amp;utm_source=web" class="bindableUtm link-article ellipsis" data-position="content-bottom">To be kind to all, to like many and love a few, to be needed and wanted by those we love, is certainly the nearest we can come to happiness. - Mary</a></li>
                                        <li class="next "><a href="?v=3zJ3B4&amp;utm_campaign=o&amp;utm_medium=w&amp;utm_source=web" class="bindableUtm link-article ellipsis" data-position="content-bottom">어제보단 글이 길어요 😅 아들에게 어렵고 힘든 순간을 이겨내기위한 삶의 지혜와 살아갈 길을 알려주신 아버지 이야기 한편 들려드려요 :) 박동규 교수가 첫아기를 낳았을 무렵의 일입니다. 아기가 생겼는데도 아직 단칸방 신세라니... 그는 자신의 형편을 돌아보며,</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="cast-container">
                                <div class="picture-list">
                                    <p class="title">시선이 머무는 이야기</p>
                                    <ul>
                                        <li><a href="#" class="bindableUtm link-article ellipsis" data-position="content-bottom-image"><img src="http://user-generated.around.so/pictures/thumb-O9DLLx9rD7" onerror="this.src='assets/images/empty_pic.png'"><p>자존감도 요렇게 쉽게 충전이 되면 좋겠지 말입니다</p></a></li>
                                        <li><a href="#" class="bindableUtm link-article ellipsis" data-position="content-bottom-image"><img src="http://user-generated.around.so/pictures/thumb-lRZEgGaADQ" onerror="this.src='assets/images/empty_pic.png'"><p>제가 감당할 수 없을 만큼 너무 많은 사랑을 줬던 사</p></a></li>
                                        <li class="hideable"><a href="#" class="bindableUtm link-article ellipsis" data-position="content-bottom-image"><img src="http://user-generated.around.so/pictures/thumb-QOpjjKr9pb" onerror="this.src='assets/images/empty_pic.png'"><p>#공부일기 보람찬 하루😊 어제처럼 공부안되는 날이</p></a></li>
                                        <li class="hideable"><a href="#" class="bindableUtm link-article ellipsis" data-position="content-bottom-image"><img src="http://user-generated.around.so/pictures/thumb-3720GAP0ZK" onerror="this.src='assets/images/empty_pic.png'"><p>아 진짜 책읽다가 빵터졌다 ㅋㅋㅋㅋㅋ🤣🤣 #책 #</p></a></li>
                                    </ul>
                                </div>
                            </div>
                    <section class="article-share">
                        <a href="#" class="article-share-btn share-facebook"><span class="hidden_elem">페이스북 공유하기</span></a>
                        <a href="#" class="article-share-btn share-kakaotalk" id="share-kakaotalk1"><span class="hidden_elem">카카오톡 공유하기</span></a>
                        <a href="#" class="article-share-btn share-band"><span class="hidden_elem">밴드 공유하기</span></a>
                        <a href="#" class="article-share-btn share-url" data-clipboard-text="http://around.so/view?v=yXlJ2X&amp;utm_campaign=o&amp;utm_medium=w_o&amp;utm_source=link"><span class="hidden_elem">URL주소 복사하기</span></a>
                    </section>
                    <section class="article-comments">
                            <div class="article-comments-info">
                                <span class="comments-count">
                                    <label>댓글</label>
                                    <span class="value">33</span>
                                </span>
                            </div>
                            <div class="comments">
                                <ul>
                                    <li>
                                        <span class="idicon" style="background-color: #cc55aa">
                                            <div data-icon="" class="icon"></div>
                                        </span>
                                        <p class="comment">
                                            성실함  하나만  보고   결혼한 신랑과  17년째  옥신각신   살고 있어요.   성실함은 많은 걸 포함하는 듯해요..  양심.. 책임감.  주인의식..  애정 등등
        
                                        </p>
                                        <span class="comment-info">
                                            <span class="time" data-time="2016-03-24T22:33:35.000+09:00">3년 전</span> · 공감 10
                                        </span>
                                    </li>
                                    <li class="sub">
                                        <span class="idicon" style="background-color: #bbcc00">
                                            <div data-icon="" class="icon"></div>
                                        </span>
                                        <p class="comment">
                                            우와.... 인생 선배님이시네요 ^^ 17년이나 ... 대단해요 !! 성실함을 발견하는 눈을 저도 키워야겠어요 ㅎ
        
                                        </p>
                                        <span class="comment-info">
                                            글쓴이 · <span class="time" data-time="2016-03-24T23:49:40.000+09:00">3년 전</span> · 공감 0
                                        </span>
                                    </li>
                                </ul>
                            </div>
                            <div class="article-comments-morebtn">
                                <a href="#" class="morebtn hover" >어라운드 앱을 통해 댓글을 쓸 수 있습니다.</a>
                            </div>
                        </section>
                </div>
                <div class="others ">
                	<div class="sticky">
                    <section class="block cards over960">
                        <h6 class="title">더 인기 있는 이야기</h6>
                        <ul>
                            <li class="card" style="background: url('http://user-generated.around.so/pictures/372060bNpK') no-repeat center top #ccc;background-size: 100%;">
                                <a href="?v=gkW2Q4&amp;utm_campaign=o&amp;utm_medium=w&amp;utm_source=web" class="bindableUtm link-article" data-position="floating">
                                    <h4 class="card-title ellipsis">너무 행복하려고 애쓰지 않아도 괜찮아. 하지만 네가 어떤 것들에게서 진정한 행복을 느끼는지 스스로 발견하는 일에는 애써야 해. 세상의 행복이 아닌 나의 행복을 아는 일. 그런 일들을 사치라 생각하지 않아야 해. b.달의조각, 하현 🌿 이곳에 글을 올리는</h4>
                            <span class="card-info">
                                <span class="time-info">10:29 PM</span>
                                <span class="like-comment-info">공감 41 · 댓글  5</span>
                            </span>
                                </a>
                            </li>
                            <li class="card" style="background: url('http://user-generated.around.so/pictures/NY25y3lX2g') no-repeat center top #ccc;background-size: 100%;">
                                <a href="?v=WDw6ZG&amp;utm_campaign=o&amp;utm_medium=w&amp;utm_source=web" class="bindableUtm link-article" data-position="floating">
                                    <h4 class="card-title ellipsis">과거는 후회하는 것이 아니라 반성하는 것이며, 현재는 도피하는 것이 아니라 도전하는 것이며, 미래는 걱정하는 것이 아니라 계획하는 것이다. 😊 예전에 이문세아저씨 라디오에서 들었던 구절이랍니다. 과거도 현재도 미래도 다 결국 내 삶이고 내 시간들이잖아요. 이왕</h4>
                            <span class="card-info">
                                <span class="time-info">10:38 PM</span>
                                <span class="like-comment-info">공감 65 · 댓글  7</span>
                            </span>
                                </a>
                            </li>
                        </ul>
                    </section>
                    <section class="hashtags">
                        <h6 class="title">인기 해시태그</h6>
                        <ul>
                            <li><a href="#">#칠흑의기사</a></li>
                            <li><a href="#">#mnsta</a></li>
                            <li><a href="#">#별별이야기</a></li>
                            <li><a href="#">#사랑</a></li>
                            <li><a href="#">#부산</a></li>
                            <li><a href="#">#설렘</a></li>
                            <li><a href="#">#7일프로젝트</a></li>
                        </ul>
                    </section>
                    <section class="download">
                        <h6 class="title">어라운드 앱 다운로드 받기</h6>
                        <a href="#" class="down_banner"></a>
                    </section>
                    </div>
                </div>
                <section class="download-section over960">
                        <p class="top-description">어라운드에는 이름이 없습니다.<br>그래서 솔직 담백한 이야기와 따뜻함으로 가득합니다.</p>
                        <p class="bottom-description">지금 구글 플레이스토어와 애플 앱스토어에서<br>어라운드 앱을 다운로드 받으실 수 있습니다.</p>
                        <div class="buttons">
                            <a href="javascript:goMarket('copyright_banner');" class="store-download">AROUND Download</a>
                        </div>
                        <p class="copyright">© 어라운드</p>
                </section>
                <section class="download-section">
                    <div class="infinity-container inf-pictures">
                        <div class="infinity-list">
                            <p class="title">일상 그대로, 어라운드의 이야기</p>
                            <ul>
                                <li class="inf-item typeb col2" style="">
                                    <img src="http://user-generated.around.so/pictures/thumb-0g2ayXJK2Q" hidden-src="http://user-generated.around.so/pictures/thumb-0g2ayXJK2Q" onerror="this.src='assets/images/empty_pic.png'">
                                    <a href="?v=VEdmEB&amp;utm_campaign=o&amp;utm_medium=w&amp;utm_source=web" class="bindableUtm link-article ellipsis" data-position="content-bottom-image"><span></span><p>은근 귀여운 카툰 마지막 괭이 사진은 덤! 매력있어 은근 중독성있네 표정이 ㅎ #해피먼</p></a>
                                </li>
                                <li class="inf-item typeb col2" style="">
                                    <img src="http://user-generated.around.so/pictures/thumb-E3ZPkG6dpw" hidden-src="http://user-generated.around.so/pictures/thumb-E3ZPkG6dpw" onerror="this.src='assets/images/empty_pic.png'">
                                    <a href="?v=0vDNwm&amp;utm_campaign=o&amp;utm_medium=w&amp;utm_source=web" class="bindableUtm link-article ellipsis" data-position="content-bottom-image"><span></span><p>엄마표 김치손만두 😍 크으아 ㅠㅠ #하남원숭이</p></a>
                                </li>
                                <li class="inf-item typeb col2" style="">
                                    <img src="http://user-generated.around.so/pictures/thumb-YL2GQ04opO" hidden-src="http://user-generated.around.so/pictures/thumb-YL2GQ04opO" onerror="this.src='assets/images/empty_pic.png'">
                                    <a href="?v=65DwDN&amp;utm_campaign=o&amp;utm_medium=w&amp;utm_source=web" class="bindableUtm link-article ellipsis" data-position="content-bottom-image"><span></span><p>ㅡ 정말 맑았던 날, 아쉬우니 한장 더. 💕 #백말띠직딩녀</p></a>
                                </li>
                                <li class="inf-item typeb col2" style="">
                                    <img src="http://user-generated.around.so/pictures/thumb-lqDkBjXG2N" hidden-src="http://user-generated.around.so/pictures/thumb-lqDkBjXG2N" onerror="this.src='assets/images/empty_pic.png'">
                                    <a href="?v=zWQVqW&amp;utm_campaign=o&amp;utm_medium=w&amp;utm_source=web" class="bindableUtm link-article ellipsis" data-position="content-bottom-image"><span></span><p>2019.5.27 #하루사진 1149 오늘은 오늘의 디저트를. 하루 잘 보내셨나요? :</p></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
    <div class="footerWrap">
        <footer>
            <div class="footer-download"><a href="#" class="footer-download-btn">앱 다운로드</a></div>
            <div class="footer-share">
                <a href="#" class="footer-share-btn share-facebook"><span class="hidden_elem">페이스북 공유하기</span></a>
                <a href="#" class="footer-share-btn share-kakaotalk" id="share-kakaotalk2"><span class="hidden_elem">카카오톡 공유하기</span></a>
                <a href="#" class="footer-share-btn share-band"><span class="hidden_elem">밴드 공유하기</span></a>
                <a href="#" class="footer-share-btn share-url" data-clipboard-text="http://around.so/view?v=yXlJ2X&amp;utm_campaign=o&amp;utm_medium=w_o&amp;utm_source=link"><span class="hidden_elem">URL주소 복사하기</span></a>
            </div>
        </footer>
    </div>
</body>
</html>