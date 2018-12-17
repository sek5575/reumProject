<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<!-- header css / jquery cdn -->
      <%@ include file="/include/header.jsp" %>
      <!-- hihihi -->
      
      
 <script>     
 $(document).ready(function(){ 
	 
	 //-----------등록된 SHOP 맛집 정보 불러오기-------------------------
	 //console.log(${param.userid});
    	  if (navigator.geolocation) { // GPS를 지원하면
  			navigator.geolocation.getCurrentPosition(
  			function(position) {		
  				mylat = position.coords.latitude;
  			    mylng = position.coords.longitude;
  				console.log(JSON.stringify({"lat":mylat,"lng":mylng, "currentPage":1}));

  				
  				$.ajax({ 
  					url:"/shop",
  					type:"post",
  					data:"MYKEY="+JSON.stringify({"lat":mylat,"lng":mylng, "currentPage":1}),
  					//resultType:"application/json;"
  					success:function(resObj){
  							console.log(resObj);		//객체
  							
  							var htmlStr = "";
  							
  							var pagingstr = resObj.MAP_PAGING; //나중에 수정한거
  							var maplist = resObj.MAP_LIST;		//나중에 수정한거
  							
  						  	$.map(maplist, function(vv, idx){  	 //나중에 수정한거 maplist
  						  	htmlStr += "<li class='media'>";
  						  	htmlStr += "<img class='mr-3 rounded-circle' width='50' src=\"/cdir/"+vv.shopPicVO.pname+"\">";
  						 	htmlStr += "<div class='media-body'>";
  							htmlStr += "<div class='float-right'><small>'"+vv.distance+"'km</small></div>";
  							htmlStr += "<div class='media-title'><a href='/shop_detail?sseq="+vv.sseq+"'>'"+vv.sname+"'</a></div>";
  							htmlStr += "<small>'"+vv.sinfo+"'</small></div></li>";
  						  	});
  						  	
  						  	htmlStr += pagingstr;  //나중에 수정한거
  						  	
  						  	$(".list-unstyled.list-unstyled-border").html(htmlStr);	  	
  					 	}
  				});
  				
  			}, function(error) {
  				alert('GPS를 지원하지 않습니다.');
  			},
  			
  			{
  				enableHighAccuracy : false,
  				maximumAge : 0,
  				timeout : Infinity
  			});
  			
  			
  		} else {
  			alert('GPS를 지원하지 않습니다');
  		}
    	 
    	//크롤링 목록에서 버튼 클릭 시 새창으로 상세보기  //ajax(비동기)에서  버튼 이벤트를 작동시키기위한 .on문법
  		$(document).on("click",".btn.btn-primary.btn-action.mr-1",function(){
  				var openURL = $(this).attr("title");
  				window.open(openURL, '_blank', 'height=570,width=520,scrollbars=yes,status=yes');
  		});
    	  
    	  
    	 //-----------------망고 사이트 크롤링 시작-----------
    	 function craw(topn){
    	  $.ajax({
				url:"/mango",
				type:"post",
				data:"topn="+topn,
				resultType:"application/json;",
				success:function(resObj){
						console.log(resObj);		//객체
						var htmlStr = "";
					  	$.map(resObj, function(vv, idx){					 
	                    htmlStr += "<tr>";
	                   	htmlStr += "<td>"+vv.title;
	                   	htmlStr += "<div class='table-links'>";
	                   	htmlStr += "<a target='_blank' href='"+vv.url+"'>"+vv.info.substring(0, 10)+"...</a>";
		 				htmlStr += "</div>";           
		 				htmlStr += "</td>";
	                    htmlStr += "<td><a target='_blank' href="+vv.url+"><img src='"+vv.picsrc+"' width='30' class='rounded-circle mr-1'>"+vv.address+"</a></td>";
	                    htmlStr += "<td>";
	                    htmlStr += "<a class='btn btn-primary btn-action mr-1' data-toggle='tooltip' title='"+vv.url+"'><i class='ion ion-edit'></i></a>";
	                    //htmlStr += "<a class='btn btn-danger btn-action' data-toggle='tooltip' title='Delete'><i class='ion ion-trash-b'></i></a>";
	                    htmlStr += "</td>";
	                    htmlStr += "</tr>";
					  	});					 	
					  	$(".myfavorite").html(htmlStr);
					  		  	
				 	}
			});
    	 }
    	 
    	 var viewAll = false;
    	 craw(4);
    	 
    	 //TOGGLE
    	 $("#carwViewAll").click(function(){
    		 if(viewAll == false) {
	    		 craw(-1);
	    		 viewAll = true;	    			 
    			 $(this).val("VIEW(4)");
    		 } else {
    		 	 craw(4);
    		 	 viewAll = false;
    			 $(this).val("VIEW ALL");
    		 }
    		 
    		 
    	 });
    	 
    	 /* $("#carwView").click(function(){
    		 craw(4);
    	 }); */
  
	    	
});
 


</script>



</head>

<body>
  <div id="app">
    <div class="main-wrapper">
    
    
      <div class="navbar-bg"></div>
      
      
      
      <!-- 상단 검색창  -->
      <%@ include file="/include/top.jsp" %>
      
      
      <!-- 레프트 메뉴 영역  -->
      <%@ include file="/include/left.jsp" %>
      
      <!-- 컨텐츠 영역  -->
      <div class="main-content">
        <section class="section">
          <h1 class="section-header">
            <div>
            Dashboard<br>
            	이름:${sessionScope.SESS_NAME}<br>
			<%
			Cookie[] carr = request.getCookies();
            if(carr != null){
            	for(int i=0; i<carr.length; i++){
                	Cookie c = carr[i];
                	out.println(c.getName() + ", " + c.getValue()+ "<br>");
                }
            }
            
			%>
            
            </div>
          </h1>
          <div class="row">
            <div class="col-lg-3 col-md-6 col-12">
              <div class="card card-sm-3">
                <div class="card-icon bg-primary">
                  <i class="ion ion-person"></i>
                </div>
                <div class="card-wrap">
                  <div class="card-header">
                    <h4>Total Admin</h4>
                  </div>
                  <div class="card-body">
                    10
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-12">
              <div class="card card-sm-3">
                <div class="card-icon bg-danger">
                  <i class="ion ion-ios-paper-outline"></i>
                </div>
                <div class="card-wrap">
                  <div class="card-header">
                    <h4>News</h4>
                  </div>
                  <div class="card-body">
                    42
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-12">
              <div class="card card-sm-3">
                <div class="card-icon bg-warning">
                  <i class="ion ion-paper-airplane"></i>
                </div>
                <div class="card-wrap">
                  <div class="card-header">
                    <h4>Reports</h4>
                  </div>
                  <div class="card-body">
                    1,201
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-12">
              <div class="card card-sm-3">
                <div class="card-icon bg-success">
                  <i class="ion ion-record"></i>
                </div>
                <div class="card-wrap">
                  <div class="card-header">
                    <h4>Online Users</h4>
                  </div>
                  <div class="card-body">
                    47
                  </div>
                </div>
              </div>
            </div>                  
          </div>
          <div class="row">
            <div class="col-lg-8 col-md-12 col-12 col-sm-12">
              <div class="card">
                <div class="card-header">
                  <div class="float-right">
                    <div class="btn-group">
                      <a href="#" class="btn active">Week</a>
                      <a href="#" class="btn">Month</a>
                      <a href="#" class="btn">Year</a>
                    </div>
                  </div>
                  <h4>Statistics</h4>
                </div>
                <div class="card-body">
                  <canvas id="myChart" height="158"></canvas>
                  <div class="statistic-details mt-sm-4">
                    <div class="statistic-details-item">
                      <small class="text-muted"><span class="text-primary"><i class="ion-arrow-up-b"></i></span> 7%</small>
                      <div class="detail-value">$243</div>
                      <div class="detail-name">Today's Sales</div>
                    </div>
                    <div class="statistic-details-item">
                      <small class="text-muted"><span class="text-danger"><i class="ion-arrow-down-b"></i></span> 23%</small>
                      <div class="detail-value">$2,902</div>
                      <div class="detail-name">This Week's Sales</div>
                    </div>
                    <div class="statistic-details-item">
                      <small class="text-muted"><span class="text-primary"><i class="ion-arrow-up-b"></i></span>9%</small>
                      <div class="detail-value">$12,821</div>
                      <div class="detail-name">This Month's Sales</div>
                    </div>
                    <div class="statistic-details-item">
                      <small class="text-muted"><span class="text-primary"><i class="ion-arrow-up-b"></i></span> 19%</small>
                      <div class="detail-value">$92,142</div>
                      <div class="detail-name">This Year's Sales</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-12 col-12 col-sm-12">
              <div class="card">
                <div class="card-header">
                  <h4>Recent Activities</h4>
                </div>
                <div class="card-body">             
                  <ul class="list-unstyled list-unstyled-border">
                  
                  
                 <!-- ajax로 만든 사진들 삽입  -->				
                  </ul>               
                  <div class="text-center">
                   <a href="/shop_list.jsp" class="btn btn-primary btn-round">
                      View All
                    </a>
			   	  </div>
                  
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-lg-5 col-md-12 col-12 col-sm-12">
              <form method="post" class="needs-validation" novalidate="">
                <div class="card">
                  <div class="card-header">
                    <h4>Quick Draft</h4>
                  </div>
                  <div class="card-body">
                    <div class="form-group">
                      <label>Title</label>
                      <input type="text" name="title" class="form-control" required>
                      <div class="invalid-feedback">
                        Please fill in the title
                      </div>
                    </div>
                    <div class="form-group">
                      <label>Content</label>
                      <textarea class="summernote-simple"></textarea>
                    </div>
                  </div>
                  <div class="card-footer">
                    <button class="btn btn-primary">Save Draft</button>
                  </div>
                </div>
              </form>
            </div>
            
            
            <div class="col-lg-7 col-md-12 col-12 col-sm-12">
              <div class="card">
                <div class="card-header">
                  <div class="float-right">
                  
                   <input type="button" id="carwViewAll" class="btn btn-primary" value="View All">
                   <!-- <input type="button" id="carwView" class="btn btn-primary" value="View(4)"> -->
                   
                   
                    <!-- <a href="#" class="btn btn-primary">View All</a> -->
                  </div>
                  <h4>맛집 추천 TOP 5</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-striped">
                      <thead>
                        <tr>
                          <th>상호명</th>
                          <th>주소</th>
                          <th>새창보기</th>
                        </tr>
                      </thead>
                      
                      <tbody class="myfavorite">  
                                
                      <!-----------  여기가 맛집리스트 뿌려주는 공간 ------------ -->
                        
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
            
            
            
          </div>
        </section>
      </div>
      
      <!-- 푸터 영역  -->
      <%@ include file="/include/footer.jsp" %>
      
      
    </div>
  </div>


	<!-- script 영역  -->
      <%@ include file="/include/script.jsp" %>
      
  
  
  <script src="/modules/chart.min.js"></script>
  <script src="/modules/summernote/summernote-lite.js"></script>
  
  

  <script>
  var ctx = document.getElementById("myChart").getContext('2d');
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
      datasets: [{
        label: 'Statistics',
        data: [460, 458, 330, 502, 430, 610, 488],
        borderWidth: 2,
        backgroundColor: 'rgb(87,75,144)',
        borderColor: 'rgb(87,75,144)',
        borderWidth: 2.5,
        pointBackgroundColor: '#ffffff',
        pointRadius: 4
      }]
    },
    options: {
      legend: {
        display: false
      },
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: true,
            stepSize: 150
          }
        }],
        xAxes: [{
          gridLines: {
            display: false
          }
        }]
      },
    }
  });
  </script>
  
</body>
</html>