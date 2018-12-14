<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <!-- 헤더 css / jquery cdn -->
  <%@ include file="/include/header.jsp" %>
  
<script>
	$(document).ready(function() {
		$("#files").change(function(){
			var plistStr = "";
			var input = document.getElementById("files");
			for (var i = 0; i < input.files.length; i++) {
				plistStr += input.files[i].name + "<br>";
			}
			$("#fileListDiv").html(plistStr);
		});
		//미리보기~
		
		
		
		
		
		$("#saveButton").click(function() {
			console.log($("#sinfo").val());
			//document.sfrom.submit();	            
			$("#sform").submit();

			
			
			// cos api에서 모든 exception을 다 걸러 주기 때문에 jquery에서 조건으로 진입못하게 막아준다.
			/* if ($("#pname").val() != "") {
				var ext = $('#pname').val().split('.').pop().toLowerCase();
				if ($.inArray(ext, [ 'gif', 'png', 'jpg', 'jpeg' ]) == -1) {
					alert('gif,png,jpg,jpeg 파일만 업로드 할수 있습니다.');
					return false;
				}
			} */

		});
	});
</script>

<style>
.pac-container{
  z-index: 1500 !important;
}
</style>
</head>

<body>
  <div id="app">
    <div class="main-wrapper">
      <div class="navbar-bg"></div>
      
      <!-- 상단 검색창 -->
      <%@ include file="/include/top.jsp" %>
      
      <!-- 레프트 메뉴 영역 -->
      <%@ include file="/include/left.jsp" %>
      
      <!-- 컨텐츠 영영 -->
      <div class="main-content">
        <section class="section">
          <h1 class="section-header">
            <div>맛집 등록하기 --- <a href="/shop_form.jsp">[글쓰기]</a></div>
          </h1>

          <div class="section-body">
            
             <div class="row">
             
              <div class="col-12 col-md-6 col-lg-6">
              
              
              <!--  ------------------------------------------------- -->
              <!--  ------------------등록폼--------------- -->
              <!--  ------------------------------------------------- -->
              <form method="post" action="/shop_insert" class="needs-validation" novalidate=""  name="sform" id="sform" enctype="multipart/form-data"><!-- String이 아니라 바이너리로 들어온다.  -->
              <!-- enctype="multipart/form-data" -->
                <div class="card">
                  <div class="card-header">
                    <h4>Shop Register Form</h4>
                  </div>
                  <div class="card-body">
	                  <div class="alert alert-primary">
	                      For maps, we use <a href="http://maps.google.com/" target="_blank">Google Map</a> created.
	                  </div>
                  
                    <div class="form-group">
                      <label>맛집 상호명</label>
                      <input type="text" name="snameqqqqqq" class="form-control" required>
                      <div class="invalid-feedback">
                        	상호명을 입력하세요.
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label>사진업로드</label>
                      <input type="file" name="files[]" id="files" Multiple class="form-control" required>
                      <div class="invalid-feedback">
                        	대표 사진 한장을 등록해주세요.
                      </div>
                      <div id="fileListDiv">
                        	
                       </div>
                    </div>
                    
                   
                    
                    <div class="form-group">
                      <label>※선택 : 맛집 지도위치 </label>
                      <a href="http://maps.google.com/" target="_blank">Google Map</a>
                      
                      
<div id="locationField">
  <input type="text" id="placename" name="placename" placeholder="검색할 상호명을 입력하세요" >
</div>	
<input type="text" class="field" name="lat" id="lat" />
<input type="text" class="field" name="lng" id="lng" />


                    </div>
                    <div class="form-group">
                      <label>맛집 소개글</label>
                      <textarea id="sinfo" name="sinfoqqqqq" class="summernote-simple"></textarea>
                    </div>
                  </div>
                  <div class="card-footer">
                    <button id="saveButton" class="btn btn-primary">Save Shop Info</button>
                  </div>
                </div>
              </form>
           
							<!--  ------------------------------------------------- -->
							<!--  ------------------등록폼--------------- -->
							<!--  ------------------------------------------------- -->
               </div>
               
               <div class="col-12 col-md-6 col-lg-6">
                <div class="card">
                  <div class="card-body">
               		<!--  -------  맵 지도   ----------- -->
	                   <div id="simple-map" style="height:450px;"></div>
	                  <!--  ------- 맵 지도    ----------- -->
                   
                  </div>
                </div>
               </div>
               
              
            </div>	<!-- end of rows -->
             
             
              
            
          </div>		<!-- end of section-body -->
          
        </section>
      </div>				<!-- end of main-content -->
      
    	<!-- 푸터 영역 -->
      <%@ include file="/include/footer.jsp" %>
      
    </div>
  </div>

  <!-- 스크립트 영역 -->
  <%@ include file="/include/script.jsp" %>
  
  <script src="/modules/summernote/summernote-lite.js"></script>
  <script src="http://maps.google.com/maps/api/js?key=AIzaSyD_Hz_uYHAvh3-ETmGyNfPg3IykZ56ZAdY&libraries=places&callback=initAutocomplete" async defer></script>
  <script src="/modules/gmaps.js"></script>
  <script>
  //https://fatc.club/2017/06/05/1949
  //https://developers.google.com/maps/documentation/javascript/examples/geocoding-simple?hl=ko

  var placename = document.getElementById('placename');
  var autocompleteResult;
  function initAutocomplete() {
    // Create the autocomplete object, restricting the search to geographical
    // location types.
    // type : address, establishment, geocode
    autocompleteResult = new google.maps.places.Autocomplete(placename, {type: ['establishment']});
					//setupClickListener('changetype-establishment', ['establishment']);

    autocompleteResult.addListener('place_changed', function(){
    	var choiceplace = autocompleteResult.getPlace();
    	var latVal = choiceplace.geometry.location.lat();
    	var lngVal = choiceplace.geometry.location.lng();
        document.getElementById("lat").value=latVal;
        document.getElementById("lng").value=lngVal;
        //${"#lat"}.value(place.geometry.location.lat());
        //${"#lng"}.value(place.geometry.location.lng());
        
        var locate = {lat:latVal, lng:lngVal};
        // The map, centered at Uluru
        var resultMap = new google.maps.Map(
            document.getElementById('simple-map'),
            {zoom: 18, center: locate});
        // The marker, center locate
        var marker = new google.maps.Marker({
      			   position: locate,
      			   map: resultMap
      			});
    });
    
    
  }
  
  
 
  </script>
  
  
</body>
</html>