<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/swiper.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/style.css" />

<title>관리자!</title>
</head>
<body onload="report()">
	<div class="jumbotron text-center">
		<h1>Around 관리자 페이지 입니다.</h1>
		<p>테스트용 화면 입니다.</p>
	</div>
	<div class="container">
		<div class="pb-5 row">


			<ul id="nav" class="sticky nav flex-column col-sm-3">
				<li class="nav-item">
					<button type="button" class="col-sm-12 btn btn-primary"
						data-toggle="collapse" data-target="#demo1">문의 관리</button>
					<div id="demo1" class="col-sm-12 collapse btn-group-vertical show">
						<button type="button" onclick="report()"
							class=" col-sm-12 btn btn-outline-primary">신고 게시글 관리</button>
						<button type="button" onclick="question()"
							class=" col-sm-12 btn btn-outline-primary">문의목록 관리</button>
					</div>
				</li>

				<li class="nav-item">
					<button type="button" class="col-sm-12 btn btn-danger"
						data-toggle="collapse" data-target="#demo2">어플관리</button>
					<div id="demo2" class="col-sm-12 collapse btn-group-vertical">
						<button type="button" onclick="notice()"
							class=" col-sm-12 btn btn-outline-danger">알림 발송</button>
					</div>
				</li>
				<li class="nav-item">
					<button type="button" class="col-sm-12 btn btn-success"
						data-toggle="collapse" data-target="#demo3">추천글 작성</button>
					<div id="demo3" class="col-sm-12 collapse btn-group-vertical">
						<button type="button" onclick="page()"
							class="col-sm-12 btn btn-outline-success">웹 메인페이지 관리</button>
					</div>
				</li>
			</ul>

			<div class="mb-5 content border text-align col-sm-9"></div>
		</div>
	</div>

	<!-- 신고 스크립트 -->
	<script type="text/javascript">
		function report(){
			let content = document.querySelector('.content');
			content.className = 'content border border-primary col-sm-9';
			content.innerHTML = '<div class="list"><h1 class="text-center text-primary">신고목록</h1><ul class="list-group"></ul><ul class="pagination m-5 justify-content-center"></ul></div>';
			let list = document.querySelector('.list-group');
			let paging = document.querySelector('.pagination');

			let item;
			<c:forEach var="item" items="${reportlist.list}">
				item = document.createElement("li");
				item.className = "list-group-item list-group-item-action";
				item.addEventListner("click", boardDetail(${item.boardNum}));
				item.innerHTML = '게시글 본문 : ${item.boardContent} 신고 카운트 : ${item.reportCount}';
				list.append(item);
			</c:forEach>
			
			<c:if test="${reportlist.maxPage eq 0}">
				item = document.createElement("h1");
				item.className = "text-center text-primary";
				item.innerHTML = '해당 하는 게시글이 없습니다.';
				list.append(item);
			</c:if>
			
			let prev = document.createElement("li");
			prev.className = "page-item disabled";
			prev.innerHTML = '<a class="page-link" href="#">Previous</a>'
			paging.append(prev);

			let page = document.createElement("li");
			page.className = "page-item active";
			page.innerHTML = '<a class="page-link " onclick="reportPaging(1)" href="#">1</a>'
			paging.append(page);
				
				for(i=2; i<${reportlist.maxPage}+1 ; i++){
					let page = document.createElement("li");
					page.className = "page-item";
					page.innerHTML = '<a class="page-link " onclick="reportPaging('+i+')" href="#">'+i+'</a>'
					paging.append(page);
				}
				let next = document.createElement("li");
				next.className = "page-item active";
				<c:if test="${reportlist.maxPage < 2 }">
				next.className = "page-item disabled";
				</c:if>
				next.innerHTML = '<a class="page-link" onclick="reportPaging(2)" href="#">Next</a>'
				paging.append(next);
			}
	</script>
	<!-- 신고 페이징 -->
	<script type="text/javascript">
		function reportPaging(page){
			let url = '/admin/report/findpage/'+page;
			fetch(url, {
				
					method:"GET",
					dataType: "json",
							
				})
				.then(function(res){					
					return res.json();
				}).then(function(result){
					console.log(result)
					reportPagePrint(result);					
				})	
		}
		function reportPagePrint(result){
			let content = document.querySelector('.content');
			content.className = 'content border border-danger col-sm-9';
			content.innerHTML = '<div class="list"><h1 class="text-center text-danger">알림목록</h1><ul class="list-group"></ul><ul class="pagination m-5 justify-content-center"></ul></div>';

			let create = document.createElement("div");
			create.className = 'report-write';
			create.innerHTML = '<input class="report-title form-control-inline" type="text" name="title" placeholder="제목" required/><input class="form-control-inline report-content" type="text" name="content" placeholder="본문" required/><button class="btn btn-outline-danger col-sm-8" onclick="reportWrite()">작성</button>';
			content.append(create);
			
			let list = document.querySelector('.list-group');
			let paging = document.querySelector('.pagination');
			
			
			for(f in result.list){
				item = document.createElement("li");
				item.className = "list-group-item list-group-item-action";
				item.innerHTML = '알림 번호 : '+result.list[f].id+' 알림 제목 : '+result.list[f].title+' 본문 : '+result.list[f].content;
				list.append(item);
			}
			
		
			if(result.maxPage === 0){
				item = document.createElement("h1");
				item.className = "text-center text-danger";
				item.innerHTML = '작성된 알림이 없습니다.';
				list.append(item);
			}
			
			let prev = document.createElement("li");
			
			if(result.page === 1){
				prev.className = "page-item disabled";
			}else{
				prev.className = "page-item ";
			}
			prev.innerHTML = '<a class="page-link" onclick="reportPaging('+(result.page-1)+')" href="#">Previous</a>'
			paging.append(prev);
	
			
				
			for(i=1; i<result.maxPage+1; i++){
				let page = document.createElement("li");
				page.className = "page-item";
				if(i === result.page){
					page.className = "page-item active";
				}
				page.innerHTML = '<a class="page-link " onclick="reportPaging('+i+')" href="#">'+i+'</a>'
				paging.append(page);
			}
			let next = document.createElement("li");
			next.className = "page-item active";
			
			if(result.maxPage < 2 || result.maxPage === result.page){
				next.className = "page-item disabled";
			}
			
			next.innerHTML = '<a class="page-link" onclick="reportPaging('+(result.page+1)+')" href="#">Next</a>'
			paging.append(next);
			
		}
		
	</script>

	<!-- 문의 스크립트 -->
	<script type="text/javascript">
		function question(){
			let content = document.querySelector('.content');
			content.className = 'content border border-primary col-sm-9';
			content.innerHTML = '<div class="list"><h1 class="text-center text-primary">문의목록</h1><ul class="list-group"></ul><ul class="pagination m-5 justify-content-center"></ul></div>';
			let list = document.querySelector('.list-group');
			let paging = document.querySelector('.pagination');
			let item;
			<c:forEach var="item" items="${questionlist.list}">
			item = document.createElement("li");
			item.className = "list-group-item list-group-item-action";
			item.innerHTML = '문의글 제목 : ${item.title} 본문 : ${item.content}';
			list.append(item);
			</c:forEach>
		
			<c:if test="${questionlist.maxPage eq 0}">
				item = document.createElement("h1");
				item.className = "text-center text-primary";
				item.innerHTML = '해당 하는 문의글이 없습니다.';
				list.append(item);
			</c:if>
		
			let prev = document.createElement("li");
			prev.className = "page-item disabled";
			prev.innerHTML = '<a class="page-link" href="#">Previous</a>'
			paging.append(prev);
	
			let page = document.createElement("li");
			page.className = "page-item active";
			page.innerHTML = '<a class="page-link " onclick="questionPaging(1)" href="#">1</a>'
			paging.append(page);
				
			for(i=2; i<${questionlist.maxPage}+1; i++){
				let page = document.createElement("li");
				page.className = "page-item";
				page.innerHTML = '<a class="page-link " onclick="questionPaging('+i+')" href="#">'+i+'</a>'
				paging.append(page);
			}
			let next = document.createElement("li");
			next.className = "page-item active";
			<c:if test="${reportlist.maxPage < 2 }">
				next.className = "page-item disabled";
			</c:if>
			next.innerHTML = '<a class="page-link" onclick="questionPaging(2)" href="#">Next</a>'
			paging.append(next);
		}
	</script>
	<!-- 문의 페이징 -->
	<script type="text/javascript">
		function questionPaging(page){
			let url = '/admin/question/findpage/'+page;
			fetch(url, {
				
					method:"GET",
					dataType: "json",
							
				})
				.then(function(res){					
					return res.json();
				}).then(function(result){
					console.log(result)
					questionPagePrint(result);					
				})	
		}
		function questionPagePrint(result){
			let content = document.querySelector('.content');
			content.className = 'content border border-danger col-sm-9';
			content.innerHTML = '<div class="list"><h1 class="text-center text-danger">알림목록</h1><ul class="list-group"></ul><ul class="pagination m-5 justify-content-center"></ul></div>';

			let create = document.createElement("div");
			create.className = 'question-write';
			create.innerHTML = '<input class="question-title form-control-inline" type="text" name="title" placeholder="제목" required/><input class="form-control-inline question-content" type="text" name="content" placeholder="본문" required/><button class="btn btn-outline-danger col-sm-8" onclick="questionWrite()">작성</button>';
			content.append(create);
			
			let list = document.querySelector('.list-group');
			let paging = document.querySelector('.pagination');
			
			
			for(f in result.list){
				item = document.createElement("li");
				item.className = "list-group-item list-group-item-action";
				item.innerHTML = '알림 번호 : '+result.list[f].id+' 알림 제목 : '+result.list[f].title+' 본문 : '+result.list[f].content;
				list.append(item);
			}
			
		
			if(result.maxPage === 0){
				item = document.createElement("h1");
				item.className = "text-center text-danger";
				item.innerHTML = '작성된 알림이 없습니다.';
				list.append(item);
			}
			
			let prev = document.createElement("li");
			
			if(result.page === 1){
				prev.className = "page-item disabled";
			}else{
				prev.className = "page-item ";
			}
			prev.innerHTML = '<a class="page-link" onclick="questionPaging('+(result.page-1)+')" href="#">Previous</a>'
			paging.append(prev);
	
			
				
			for(i=1; i<result.maxPage+1; i++){
				let page = document.createElement("li");
				page.className = "page-item";
				if(i === result.page){
					page.className = "page-item active";
				}
				page.innerHTML = '<a class="page-link " onclick="questionPaging('+i+')" href="#">'+i+'</a>'
				paging.append(page);
			}
			let next = document.createElement("li");
			next.className = "page-item active";
			
			if(result.maxPage < 2 || result.maxPage === result.page){
				next.className = "page-item disabled";
			}
			
			next.innerHTML = '<a class="page-link" onclick="questionPaging('+(result.page+1)+')" href="#">Next</a>'
			paging.append(next);
			
		}
		
	</script>
	<!-- 알람 스크립트 -->

	<script type="text/javascript">
		function notice(){
			let content = document.querySelector('.content');
			content.className = 'content border border-danger col-sm-9';
			content.innerHTML = '<div class="list"><h1 class="text-center text-danger">알림목록</h1><ul class="list-group"></ul><ul class="pagination m-5 justify-content-center"></ul></div>';

			let create = document.createElement("div");
			create.className = 'notice-write';
			create.innerHTML = '<input class="notice-title form-control-inline" type="text" name="title" placeholder="제목" required/><input class="form-control-inline notice-content" type="text" name="content" placeholder="본문" required/><button class="btn btn-outline-danger col-sm-8" onclick="noticeWrite()">작성</button>';
			content.append(create);
			
			let list = document.querySelector('.list-group');
			let paging = document.querySelector('.pagination');
			
			let item;
			<c:forEach var="item" items="${noticelist.list}">
			item = document.createElement("li");
			item.className = "list-group-item list-group-item-action";
			item.innerHTML = '알림 번호 : ${item.id} 알림글 제목 : ${item.title} 본문 : ${item.content}';
			list.append(item);
			</c:forEach>
		
			<c:if test="${noticelist.maxPage eq 0}">
				item = document.createElement("h1");
				item.className = "text-center text-danger";
				item.innerHTML = '작성된 알림이 없습니다.';
				list.append(item);
			</c:if>
		
			let prev = document.createElement("li");
			prev.className = "page-item disabled";
			prev.innerHTML = '<a class="page-link" href="#">Previous</a>'
			paging.append(prev);
	
			let page = document.createElement("li");
			page.className = "page-item active";
			page.innerHTML = '<a class="page-link " onclick="noticePaging(1)" href="#">1</a>'
			paging.append(page);
				
			for(i=2; i<${noticelist.maxPage}+1; i++){
				let page = document.createElement("li");
				page.className = "page-item";
				page.innerHTML = '<a class="page-link " onclick="noticePaging('+i+')" href="#">'+i+'</a>'
				paging.append(page);
			}
			let next = document.createElement("li");
			next.className = "page-item active";
			<c:if test="${reportlist.maxPage < 2 }">
				next.className = "page-item disabled";
			</c:if>
			next.innerHTML = '<a class="page-link" onclick="noticePaging(2) href="#">Next</a>'
			paging.append(next);
			
			}
		</script>
	<!-- 알림 작성 -->
	<script type="text/javascript">
		function noticeWrite(){
			let url = '/admin/notice/save';
			let title = document.querySelector('.notice-title');
			let titleValue = title.value;
			let content = document.querySelector('.notice-content');
			let contentValue = content.value;
			console.log(titleValue);
			console.log(contentValue);
			fetch(url, {
				method:"POST",
				dataType: "json",
				headers: { "Content-Type" : "application/json" },
				body: JSON.stringify({title : titleValue, content : contentValue}),
				
				}).then(function(res){
					
					
					notice();
					})
					
			}
	</script>
	<!-- 알림 페이징 -->
	<script type="text/javascript">
		function noticePaging(page){
			let url = '/admin/notice/findpage/'+page;
			fetch(url, {
				
					method:"GET",
					dataType: "json",
							
				})
				.then(function(res){					
					return res.json();
				}).then(function(result){
					console.log(result)
					noticePagePrint(result);					
				})	
		}
		function noticePagePrint(result){
			let content = document.querySelector('.content');
			content.className = 'content border border-danger col-sm-9';
			content.innerHTML = '<div class="list"><h1 class="text-center text-danger">알림목록</h1><ul class="list-group"></ul><ul class="pagination m-5 justify-content-center"></ul></div>';

			let create = document.createElement("div");
			create.className = 'notice-write';
			create.innerHTML = '<input class="notice-title form-control-inline" type="text" name="title" placeholder="제목" required/><input class="form-control-inline notice-content" type="text" name="content" placeholder="본문" required/><button class="btn btn-outline-danger col-sm-8" onclick="noticeWrite()">작성</button>';
			content.append(create);
			
			let list = document.querySelector('.list-group');
			let paging = document.querySelector('.pagination');
			
			
			for(f in result.list){
				item = document.createElement("li");
				item.className = "list-group-item list-group-item-action";
				item.innerHTML = '알림 번호 : '+result.list[f].id+' 알림 제목 : '+result.list[f].title+' 본문 : '+result.list[f].content;
				list.append(item);
			}
			
		
			if(result.maxPage === 0){
				item = document.createElement("h1");
				item.className = "text-center text-danger";
				item.innerHTML = '작성된 알림이 없습니다.';
				list.append(item);
			}
			
			let prev = document.createElement("li");
			
			if(result.page === 1){
				prev.className = "page-item disabled";
			}else{
				prev.className = "page-item ";
			}
			prev.innerHTML = '<a class="page-link" onclick="noticePaging('+(result.page-1)+')" href="#">Previous</a>'
			paging.append(prev);
	
			
				
			for(i=1; i<result.maxPage+1; i++){
				let page = document.createElement("li");
				page.className = "page-item";
				if(i === result.page){
					page.className = "page-item active";
				}
				page.innerHTML = '<a class="page-link " onclick="noticePaging('+i+')" href="#">'+i+'</a>'
				paging.append(page);
			}
			let next = document.createElement("li");
			next.className = "page-item active";
			
			if(result.maxPage < 2 || result.maxPage === result.page){
				next.className = "page-item disabled";
			}
			
			next.innerHTML = '<a class="page-link" onclick="noticePaging('+(result.page+1)+')" href="#">Next</a>'
			paging.append(next);
			
		}
		
	</script>

	<!-- 메인웹페이지 스크립트 -->
	<script type="text/javascript">
		function page() {
			let content = document.querySelector('.content');
			content.className = 'content border border-success col-sm-9';
			content.innerHTML = '<div class="swiper-paging"><div class="swiper-pagination"></div></div><div class="swiper-case"><div class="swiper-container"><div class="swiper-wrapper"><div class="swiper-slide slide-1"></div><div class="swiper-slide slide-2"></div><div class="swiper-slide slide-3"></div><div class="swiper-slide slide-4"></div><div class="swiper-slide slide-5"></div><div class="swiper-slide slide-6"></div><div class="swiper-slide slide-7"></div><div class="swiper-slide slide-8"></div><div class="swiper-slide slide-9"></div></div></div></div>'

			for (i = 1; i < 11; i++) {

				let slide = document.querySelectorAll(".slide-" + i);
				console.log(slide.length);

				for (f = 0; f < slide.length; f++) {

					slide.item(f).innerHTML = "";
					let cardcase = document.createElement("div");
					cardcase.className = "cardcase";
					slide.item(f).append(cardcase);
					console.log(cardcase);
					main(i, cardcase);
				}

			}
			let name = [ "인기", "음성", "유머", "설렘", "고민", "명언", "여행", "선곡", "어라운드" ]
			var swiper = new Swiper('.swiper-container', {
				slidesPerView : 1,
				spaceBetween : 30,
				loop : true,
				autoHeight : true,
				pagination : { // 페이징
					el : '.swiper-pagination',
					clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
					renderBullet : function(index, className) {
						return '<span class="' + className + '">'
								+ (name[index]) + '</span>';
					},
				},
			});
		}
		function main(num, cardcase) {
			let c = 0;
			<c:forEach var="item" items="${webpagelist}">

			if (c == 0) {

				let card = document.createElement("div");
				card.className = "card card-one";
				card.innerHTML = '<img class="card-img-top" src="/image/1.jpg" alt="Card image"><div class="card-body"><h4 class="card-title">${item.boardContent}</h4></div>';
				cardcase.append(card);
			} else if (c < 6) {
				let card = document.createElement("div");
				card.className = "card card-type";
				card.innerHTML = '<img class="card-img-top" src="/image/1.jpg" alt="Card image"><div class="card-body"><h4 class="card-title">${item.boardContent}</h4></div>';
				cardcase.append(card);
			} else {
				let card = document.createElement("div");
				card.className = "card card-img";
				card.innerHTML = '<img class="card-img-top" src="/image/1.jpg" alt="Card image"><div class="card-img-overlay"><p class="card-text">${item.boardContent}</p></div>';
				cardcase.append(card);

			}
			c += 1;
			</c:forEach>
		}
	</script>
	<!-- Swiper JS -->
	<script src="/js/swiper.min.js"></script>

</body>

</html>