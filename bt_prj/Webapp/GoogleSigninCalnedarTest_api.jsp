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

    $("#calendarBtn").click(function(){
    	gapi.client.calendar.events.list({
	          'calendarId': 'primary',
	          'timeMin': (new Date()).toISOString(),
	          'showDeleted': false,
	          'singleEvents': true,
	          'maxResults': 10,
	          'orderBy': 'startTime'
	        }).then(
	        	function(resObject) {
	        		var events = resObject.result.items;
	        		console.log("일정" + resObject);
	        		
	        		
	                 if (events.length > 0) {
	                    for (i = 0; i < events.length; i++) {
	                      var event = events[i];
	                      var when = event.start.dateTime;
	                      if (!when) {
	                        when = event.start.date;
	                      }
	                      console.log(event.summary + ' (' + when + ')')
	                    }
	                  } else {
	                	  console.log('No upcoming events found.');
	                  }
	                 
	                 
   		
	        },
	        	function(resObject){
      			console.log("일정보여주기 실패");
	        }
	       );
    });

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
  gapi.load('client:auth2', googleAuth);
}

		  
function googleAuth() {
	 var CLIENT_ID = '277301311172-mb5l5nou6l6krsjvbsar0g8ttr59kpg5.apps.googleusercontent.com';
     var SCOPES = "https://www.googleapis.com/auth/calendar.readonly";
     var API_KEY = 'AIzaSyD_Hz_uYHAvh3-ETmGyNfPg3IykZ56ZAdY';
     var DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"];

	  //gapi.auth2.init(  //구글 규정에 맞는 업체?가 맞나 확인하는 작업
		 gapi.client.init({
          clientId: CLIENT_ID,
          scope: SCOPES,
          apiKey: API_KEY,
          discoveryDocs: DISCOVERY_DOCS
        }).then(
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
<input type="button" id = "calendarBtn" value = "일정가져오기">

<div id="resdiv">  </div>


<script src="https://apis.google.com/js/api.js?onload=googleLibLoad" async defer></script>
</body>
</html>