<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <!-- 헤더 css / jquery cdn -->
  <%@ include file="/include/header.jsp" %>
  
<script>
$(document).ready(function(){
	
		//댓글 입력버튼 이벤트
	  $("#replybtn").click(function(){
		  		console.log("reply="+$("#reply").val()+"&sseq=${SVO.sseq}");
		  		
				  $.ajax({ 
							url:"/reply",
							type:"post",
							contentType: "application/x-www-form-urlencoded; charset=UTF-8",
							data:"reply="+$("#reply").val()+"&sseq=${SVO.sseq}",   
							success:function(gsonObj){
									console.log(gsonObj);		//[{"empno
									var htmlStr = "<ul>";
						 			$.map(gsonObj, function(vv, idx){
							  		htmlStr += "<li>" + vv.rseq + " " + vv.reply+ "</li>";
							  	});
							  	htmlStr += "</ul>";
							  	
							  	//div는 남겨두고 기존 댓글 내용만 지우기
							  	$("#reply_list_div").empty();
							  	$("#reply_list_div").html(htmlStr);
							}
				}); //end of ajax 
    });
	  
	  
	  
});    
</script>
</head>

<body>
  <div id="app">
    <div class="main-wrapper">
      <div class="navbar-bg"></div>
      
      <!-- 상단 검색창 -->
      <%@ include file="/include/top.jsp" %>
      
      <!-- 레프트 메뉴 영역 -->
      <%@ include file="/include/left.jsp" %>
      
      <!-- 컨텐츠 영역 -->
      <div class="main-content">
        <section class="section">
          <h1 class="section-header">
            <div>맛집 상세보기 --- <a href="/shop_form.jsp">[글쓰기]</a></div>
          </h1>

          <div class="section-body">
            <div class="jumbotron">
              <h1 class="display-5">
							${SVO.sname}
</h1>
              <p class="lead">
              ${SVO.sinfo}
              </p>
              <hr class="my-4">
              <p>adddr : tel:</p>
              <p class="lead">
            </p>
            </div>
            <h2 class="section-title">Shop Detail Info.</h2>
            
            <div class="row">
             
              <!--  ------------------------------------------------- -->
              <!--  ------------------이미지 슬라이딩 카드 영역--------------- -->
              <!--  ------------------------------------------------- -->
              <div class="col-12 col-md-6 col-lg-6">
                <div class="card">
                  <div class="card-header">
                    <div class="float-right">
                      <div class="btn-group">
                        <a href="#carousel-simple" data-tab="carousel" class="btn active">Simple</a>
                        <a href="#carousel-caption" data-tab="carousel" class="btn">With Caption</a>
                      </div>
                    </div>
                    <h4>Shop Gallery</h4> 
                  </div>
                  <div class="card-body">
                    
                    <!--  -------  with caption 이미지  ----------- -->
                    <div class="active" data-tab-group="carousel" id="carousel-simple">
                      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                        
<!-- 이미지 하단 이전다음 버튼 -->
                        <ol class="carousel-indicators">
                        		<c:forEach var="pp" 
                                     items="${SVO.pvolist}" 
                          					 varStatus="ststst">
                          			<li data-target="#carouselExampleIndicators" 
                          			data-slide-to="${ststst.index}" 
                          			<c:if test="${ststst.index == 0}"> class="active" </c:if>></li>
                            </c:forEach>
                        </ol>
                       <!--  이미지 하단 이전다음 버튼  -->
                        
                        <div class="carousel-inner">
<!-- shop_pic 리스트 출력 -->
                          <c:forEach var="pp" 
                                     items="${SVO.pvolist}" 
                          					 varStatus="ststst">
                              <div class="carousel-item 
                                  <c:if test="${ststst.index == 0}"> active </c:if>">
		                            <img class="d-block w-100" height="450" src="/cdir/${pp.pname}">
		                          </div>
                          </c:forEach>
                        </div>
                        
                        <!-- 이미지 좌우 이전다음 버튼  -->
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                          <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                          <span class="carousel-control-next-icon" aria-hidden="true"></span>
                          <span class="sr-only">Next</span>
                        </a>
                        <!-- 이미지 좌우 이전다음 버튼  -->
                      </div>
                                                    
                    </div>
                    <!--  -------  with caption 이미지  ----------- -->
                    
                    
                   
                    
                  </div>
                </div>
               </div>
               <!--  ------------------------------------------------- -->
							 <!--  ------------------이미지 슬라이딩 카드 영역--------------- -->
               <!--  ------------------------------------------------- -->
               
             
             
               
              <!--  ------------------------------------------------- -->
              <!--  ----------------------- 구글맵영역 ------------------ -->
              <!--  ------------------------------------------------- -->
              <div class="col-12 col-md-6 col-lg-6">
                <div class="card">
                  <div class="card-header">
                    <div class="float-right">
                      <div class="btn-group">
                        <!-- 
                        <a href="#carousel-simple" data-tab="carousel" class="btn active">Simple</a>
                        <a href="#carousel-caption" data-tab="carousel" class="btn">With Caption</a> 
                        -->
                      </div>
                    </div>
                    <h4>Shop Location</h4> 
                  </div>
                  <div class="card-body">
                     <!--  -------  맵 지도   ----------- -->
	                   <div id="simple-map" style="height:450px;"></div>
	                   <!--  ------- 맵 지도    ----------- -->
                  </div>
                </div>
              </div>
              <!--  ------------------------------------------------- -->
              <!--  ----------------------- 구글맵영역 ------------------ -->
              <!--  ------------------------------------------------- -->  
              
              
            </div> 	<!-- end of row -->
            
            
            
             <!--  ------------------------------------------------- -->
             <!--  댓글 목록
             <!--  ------------------------------------------------- -->
            <div class="row">
		            <div class="col-12">
		            		 <div class="card">
				                  <div class="card-header">
				                    <h4>Reply List & Register Form</h4>
				                  </div>
				                  <div class="card-body">
					                    <div class="alert alert-primary">댓글 목록</div>
					                    
										<div id="reply_list_div" class="col-12">
											<c:forEach var="rr" items="${SVO.rvolist}">
												<li>${rr.rseq}${rr.reply}</li>
											</c:forEach>
										</div>
										
									</div>
		                </div>
           			</div> 
            </div>
            
           <!--  ------------------------------------------------- -->
           <!--  댓글 입력폼
           <!--  ------------------------------------------------- -->
           <div class="row">
               <div class="form-group col-6">
                 <input name="reply" id="reply" type="text" class="form-control" required>
                 <div class="invalid-feedback">
                  	댓글을 입력하세요.
                </div> 
               </div>
               <div class="form-group col-6">
                 <button id="replybtn" class="btn btn-primary">Save Reply</button>
               </div>
						</div>
						
						
              
          </div>		<!-- end of section-body -->
          
        </section>
      </div>				<!-- end of main-content -->
      
    	<!-- 푸터 영역 -->
      <%@ include file="/include/footer.jsp" %>
      
    </div>
  </div>

  <!-- 스크립트 영역 -->
  <%@ include file="/include/script.jsp" %>
  
  <script src="http://maps.google.com/maps/api/js?key=AIzaSyC33QkGk8Ebmsb2SffvmOZG0LrIx-OeSuU&amp;sensor=true"></script>
  
  <!-- &callback=initMap -->
  <script src="/modules/gmaps.js"></script>
  <script>
    // 단순히 지도만 나오는 형태
    /* 
    var simple_map = new GMaps({
      div: '#simple-map',
      lat: ${SVO.lat},
      lng: ${SVO.lng} 
    }); 
    */ 	
    
	 //지도 + 마커     map.js?...&callback=initMap
	//function initMap() {
   var locate = {lat: ${SVO.lat}, lng: ${SVO.lng}};
	 //div 태그에 맵 그리기	
   var map = new google.maps.Map(
       document.getElementById('simple-map'), 
       {zoom: 18, center: locate
   });
   //marker, center locate 표시하기
   var marker = new google.maps.Marker({
	   		position: locate, 
   	    map: map,
			  title:'${SVO.sname}'
	 });
  
  </script>
  
  
</body>
</html>