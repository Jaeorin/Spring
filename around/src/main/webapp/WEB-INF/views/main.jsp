<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/my.css" />
<link rel="stylesheet" href="/css/my1.css" />
<meta charset="UTF-8">
<title>Demasia</title>
<style>
* {
	padding: 0;
	margin: 0;
}

.footer {
	background-color: blueviolet;
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
		<!-- header start  -->
		<div class="header1">
			<header>
				<span class="top-logo"> 
					<a href="#">
						<img src="/image/app_logo_02.png"style="height: 30px">
					</a>
				</span> 
				<span class="top-download">
					<span class="store-mention">구글플레이나 애플 앱스토어에서 사람들의 진짜 이야기를 만나요.</span> 
					<a href="#" class="top-download-btn">앱 다운로드</a>
				</span>
			</header>
		</div>
		<!-- header end  -->
		<!-- serch start -->
		<div class="serch">
			<form>
				<div class="searchinput">
					<input type="text" class="search-text-input" placeholder="해시태그를 검색하세요. (ex. 음성일기)">
				</div>
				<div class="suggestTags">
					<span>
						<a href="#">#연애상담</a>
					</span> 
					<span>
						<a href="#">#이별</a>
					</span>
					<span>
						<a href="#">#고민</a>
					</span> 
					<span>
						<a href="#">#오늘내마음을읽었습니다</a>
					</span>
				</div>
			</form>
		</div>
		<!-- serch end -->
	</div>
	<!-- container 1 end -->
	<!-- menu1 start -->
	<div class="menu1">
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
	<!-- menu1 end -->
	<!-- container 3 start -->
	<div class="container">
		<div class="photo">
			<div>
				<div class="col-10" style="margin: 0 auto">
					<div class="row">
						<div class="list-group-item-topic col-8">
							<a href="#">
								<span>
									<img src="/image/bg271_thumbnail.jpg" alt="X" width="595px" height="347px">
								</span>
								<span class="m-4 text-center">
									<span>좋은사람 알아보는법${boards.get(0).boardContent}</span>
								</span>
							</a>
						</div>
						<!-- col-4 start  -->
						<div class="col-4">
							<div class="row">
								<div class="list-group-item col-12 p-1 ">
									<a href="#">
										<span>
											<img src="/image/bg189_thumbnail.jpg" alt="X" width="297" height="173">
										</span>
										<span class="m-1">
											<span>개짜증남${boards.get(1).boardContent}</span>
										</span>
									</a>
								</div>
							</div>
							<div class="row">
								<div class="list-group-item col-12 p-1 ">
									<a href="#">
										<span>
											<img src="/image/bg285_thumbnail.jpg" alt="X" width="297" height="173">
										</span>
										<span class="m-1">
											<span>띠발${boards.get(2).boardContent}</span>
										</span>
									</a>
								</div>
							</div>
						</div>
						<!-- col-4 end  -->
					</div>
				</div>
			</div>
		</div>
		<div class="footer">5</div>
	</div>
	<!-- container 3 end -->
</body>
</html>