<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
    $("#googleAuthBtn").click(function(){
    	var vargoogleAuth = gapi.auth2.getAuthInstance();
			//로드된 lib를 사용해 로그인
			if(!vargoogleAuth.isSignedIn.get()){
				vargoogleAuth.signIn().then(
					function(){
						
						console.log("1.signIn() ok");
						$("#googleAuthBtn").val("logout");
						
						
						//로드된 lib를 사용해 로그인한 사용자 정보 가져오기
						var vargoogleUser = vargoogleAuth.currentUser.get();
						console.log("user uniq.ID:"+vargoogleUser.getId());   //로그인할때마다 id가 바뀐다.  user랑 client는 다르다
						//googleUser.getHostedDomain()
						//googleUser.getGrantedScopes()
						
						var varbasicProfile = vargoogleUser.getBasicProfile();   //vo같은 정보를 가지고 있다.
						console.log("Profil uniq.ID:"+varbasicProfile.getId());
						console.log("Profil name:"+varbasicProfile.getName());
						console.log("Profil gname:"+varbasicProfile.getGivenName());
						console.log("Profil fname:"+varbasicProfile.getFamilyName());
						console.log("Profil img:"+varbasicProfile.getImageUrl());
						console.log("Profil email:"+varbasicProfile.getEmail());
						
						var authResponse = vargoogleUser.getAuthResponse();
						console.log("ID_TOKEN" + authResponse.id_token);
						console.log("ACCESS_TOKEN" + authResponse.access_token);
					
						
					},
					function(){
						console.log("google login faild");
					}
				);
			} else{
				vargoogleAuth.signOut().then(
						function(){
							console.log("2.signOut()");
							$("#googleAuthBtn").val("login");
						},
						
						function(){
							console.log("2.signOut() faild");
						}
					);
			}
			
       
    });
});
</script>
<script>
//openAPI : API KEY
//Auth    : site(company/homepage) : client_id
			//uid

			//위의 3개를 가지고 OAuth의 토큰을 가져오게한다.
//OAuth   : access_token  --> 동의 해준 개인정보 

function googleLibLoad() {
	//lib 로드
  gapi.load('auth2', googleAuth);
}
		  
function googleAuth() {
	//init
	  gapi.auth2.init(  //구글 규정에 맞는 업체?가 맞나 확인하는 작업
					{client_id: '277301311172-mb5l5nou6l6krsjvbsar0g8ttr59kpg5.apps.googleusercontent.com'}  //client는 bt_prj
					/* {scope: } */
						  //scope  //메일, 캘린더, 클라우드정보
				  ).then(
						function(){
							console.log("lib load");
						},
						function(){
							console.log("lib load faild");
						}
					);
	  
	  //-----------------------------위는 인증 전에 있는 (동의 화면)--------------------------------------------
	  	//	Auth  --> 인증만
	  	//  OAuth  --> 동의한 정보까지 권한을 획득해서 access token을 가진 단계
	  
				
	  			
	  			//로그아웃
	  			//googleAuth.signOut()
	  			
				
	  			
				//googleAuth.isSignedIn.get()  //로그인 유무 true/false
				//googleUser.isSignedIn()
	  			
	  			//googleAuth.disconnect()
	  			
	  			//googleAuth.grantOfflineAccess(options)
	  			
	  			
}

  


  </script>
</head>
<body>
Google singin Test <hr>
<input type="button" id = "googleAuthBtn" value = "로그인">
<div id="resdiv">  </div>


<script src="https://apis.google.com/js/platform.js?onload=googleLibLoad" async defer></script>
</body>
</html>