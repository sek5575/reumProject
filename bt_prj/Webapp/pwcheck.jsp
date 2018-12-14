<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <!-- 헤더 css / jquery cdn -->
  <%@ include file="/include/header.jsp" %>
  
<script>
$(document).ready(function(){
	  //$("#btn").click(function(){	
    //});
});    
</script>
</head>

<body>

  <!-- 컨텐츠 영영 -->
  <div id="app">
    <section class="section">
      <div class="container mt-5">
        <div class="row">
          <div class="col-12 col-sm-8 offset-sm-2 col-md-6 offset-md-3 col-lg-6 offset-lg-3 col-xl-4 offset-xl-4">
            <div class="login-brand">
              Member Password Check
            </div>

            <div class="card card-primary">
              <div class="card-header"><h4>Member Password Check for Edit</h4></div>

              <div class="card-body">
                
                
                <!-- ------------비밀번호 체크 폼------------- -->
                <form method="POST" action="/pwcheck" class="needs-validation">
                <input type='hidden' name="mode" value="${param.mode}">
                  <div class="form-group">
                    <label for="password" class="d-block">Password
                      <div class="float-right">
                        <a href="forgot.jsp">
                          Forgot Password?
                        </a>
                      </div>
                    </label>
                    <input id="userpw" type="password" class="form-control" 
                    name="userpw" tabindex="2" required>
                    <div class="invalid-feedback">
                      	비밀번호를 입력하세요
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block" tabindex="4">
                      	비밀번호 확인
                    </button>
                  </div>
                </form>
                <!-- ------------비밀번호 체크 폼------------- -->
                
                
                
                
              </div>
            </div>
            <div class="mt-5 text-muted text-center">
            		아직 회원이 아니신가요?<a href="register.jsp">회원가입 바로가기</a>
            </div>
          </div>
        </div>
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