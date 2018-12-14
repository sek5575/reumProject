<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <!-- 헤더 css / jquery cdn -->
  <%@ include file="/include/header.jsp" %>
  
  
<script>
$(document).ready(function(){
	
		//jQuery 지원 : 첨부파일 미리보기 ---------------------
		$("#pname").on("change", myFilePreviewFunc);
		//$("#pname").change(function(){
		function myFilePreviewFunc(e) {
				$("#prev-img-div").empty();
				var files = e.target.files;  			//[object FileList]
				//FileList into an array 
				//var fileArr = Array.prototype.slice.call(files);			
				var fileArr = Array.from(files); //[object File],[object File],[object File]
					
				if(fileArr.length > 3) {  //files.length
						alert("이미지 첨부는 최대 3개만 가능합니다.");
						$("#pname").val("");
						return false;
				}
				
				var fileSize = 0;
				fileArr.forEach(function(f) {
						fileSize += f.size;
				});
				if(fileSize > 10*1024*1024) {
						alert("이미지 첨부는 최대 10MB만 가능합니다.");
						$("#pname").val("");
						return false;
				}
				
				fileArr.forEach(function(f) {
						if(!f.type.match("image.*")) {
								alert("이미지 첨부만 가능합니다.");
								$("#pname").val("");
								return false;
						} 
						
						var reader = new FileReader();
						var htmlStr = "";
						reader.onload = function(e) {
								htmlStr += "<img src='"+e.target.result+"' style='height:80px;width:80px;'> ";
								$("#prev-img-div").append(htmlStr);
								//alert(htmlStr)
						}
						//reader.onload = function(e) { 
						//	$("#prev-img").attr("src", e.target.result); 
						//} 
						reader.readAsDataURL(f); 
				}); //end of forEach
		}

		
		//회원정보 수정폼 입력값 유효성(validation) 체크 ---------------------
	  $("#editButton").click(function(){
		  	var id =$("#user_id").val();
			  var pw =$("#user_pw").val();
			  var pw2 =$("#user_pw2").val();
			  var agree = $("[id='agree']:checked").val();
			  if(id == "") {
				  	alert("아이디를 입력하세요")
		    		$("#user_id").focus();
		    		return false;
			  } else if(pw == "") {
				  	alert("비밀번호를 입력하세요")
		    		$("#user_pw").focus();
		    		return false;
			  } else if(pw != pw2) {
		    		alert("비밀번호가 다릅니다.")
		    		$("#user_pw").focus();
		    		return false;
	    	} 
			  
			  $("#regForm").attr("action" , "/edit");
			  $("#regForm").attr("method" , "post");
			  $("#regForm").submit();
	  });
		
	//회원정보 삭제 ---------------------
	  $("#delButton").click(function(){
			  var result = confirm('정말 탈퇴하시겠습니까?'); 
			  if(result) { //yes  
			  		$(location).attr('href', '/pwcheck.jsp?mode=del');
			  }
			 /*  
			  $("#regForm").attr("action" , "/del");
			  $("#regForm").attr("method" , "get");  //post
		  	$("#regForm").submit(); 
		   */
	  });
});    
</script>
</head>

<body>
  <div id="app">
    <section class="section">
      <div class="container mt-5">
        <div class="row">
          <div class="col-12 col-sm-10 offset-sm-1 col-md-8 offset-md-2 col-lg-8 offset-lg-2 col-xl-8 offset-xl-2">
            <div class="login-brand">
              Member Profile edit
            </div>

            <div class="card card-primary">
              <div class="card-header"><h4>Register</h4>
              <br>
              <font color="red">** : 필수 입력</font>
              </div>

              <div class="card-body">
								<!-- ----------- 회원정보수정/탈퇴 폼------------- -->
                <form id="regForm" class="needs-validation"
                enctype="multipart/form-data">
                <input type="hidden" name="old_pname" value="${KEY_MVO.pname}">
                <input type="hidden" name="old_ppath" value="${KEY_MVO.ppath}">
                <input type="hidden" name="old_sysname" value="${KEY_MVO.sysname}">
                
                  <div class="row">
                    <div class="form-group col-6">
                      <label for="frist_name"><font color="red">**</font>아이디</label>
                      <font size="4"><b>${KEY_MVO.userId}</b></font>
                    </div>
                    <div class="form-group col-6">
                      <label for="last_name">이름</label>
                      <input id="user_name" type="text" class="form-control" 
                      name="user_name" value="${KEY_MVO.userName}">
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="email">이메일</label>
                    <input id="user_email" type="email" class="form-control" name="user_email"
                     value="${KEY_MVO.userEmail}">
                    <div class="invalid-feedback">
                    		올바른 이메일 형식을 입력하세요
                    </div>
                  </div>

                  <div class="row">
                    <div class="form-group col-6">
                      <label for="password" class="d-block"><font color="red">**</font>비밀번호</label>
                      <input id="user_pw" type="password" class="form-control" name="user_pw">
                    </div>
                    <div class="form-group col-6">
                      <label for="password2" class="d-block">비밀번호 확인</label>
                      <input id="user_pw2" type="password" class="form-control" name="user_pw2">
                    </div>
                  </div>
									
									<div class="row">
											<div class="form-group col-6">
		                    <label for="pname">프로필사진</label>
		                    <input id="pname" type="file" class="form-control" name="pname"> <!--  multiple -->
		                    <div class="invalid-feedback">
		                    		사진 등록은 필수 입니다.
		                    </div>
		                  </div>
		                  <div id="prev-img-div" class="form-group col-6">
		                   		<img src="/cdir/profile/${KEY_MVO.sysname}" style="height:100px;width:100px;">
		                   		<!-- <img id="prev-img" style="height:100px;width:100px;"> -->
		                  </div>
									</div>
									
                  <!-- 
                  <div class="form-divider">
                    Your Home
                  </div>
                  <div class="row">
                    <div class="form-group col-6">
                      <label>Country</label>
                      <select class="form-control">
                        <option>Indonesia</option>
                        <option>Palestine</option>
                        <option>Syria</option>
                        <option>Malaysia</option>
                        <option>Thailand</option>
                      </select>
                    </div>
                    <div class="form-group col-6">
                      <label>Province</label>
                      <select class="form-control">
                        <option>West Java</option>
                        <option>East Java</option>
                      </select>
                    </div>
                  </div>
                  <div class="row">
                    <div class="form-group col-6">
                      <label>City</label>
                      <input type="text" class="form-control">
                    </div>
                    <div class="form-group col-6">
                      <label>Postal Code</label>
                      <input type="text" class="form-control">
                    </div>
                  </div> 
                  -->

									<div class="row">
											<div class="form-group col-6">
		                   <button type="button" id="editButton" class="btn btn-primary btn-block">
                 			     회원정보수정
                    </button>
		                  </div>
		                  <div class="form-group col-6">
		                    <button type="button" id="delButton" class="btn btn-primary btn-block">
                   			   회원탈퇴
                    </button>
		                  </div>
									</div>

                </form>
                <!-- ------------회원정보수정/탈퇴 폼------------- -->
                
              </div>
             </div>
             
           
          </div> <!-- end of col-12 -->
        </div>	<!-- end of row -->
      </div>
    </section>
  </div>
	<!-- end of contents -->
	
	
	<!-- 푸터 영역 -->
  <%@ include file="/include/footer.jsp" %>
      
  <!-- 스크립트 영역 -->
  <%@ include file="/include/script.jsp" %>
  
</body>
</html>