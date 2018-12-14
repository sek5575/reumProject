<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<!-- header css / jquery cdn -->
      <%@ include file="/include/header.jsp" %>

<script>
$(document).ready(function(){
	  //$("#btn").click(function(){	
    //});
});    
</script>
</head>

<body>
  <div id="app">
    <div class="main-wrapper">
      <div class="navbar-bg"></div>
      
      
      <!-- top 영역  -->
      <%@ include file="/include/top.jsp" %>
      
      
      
      <!-- sider 영역  -->
      <%@ include file="/include/left.jsp" %>
      
      
      
      <div class="main-content">
        <section class="section">
          <h1 class="section-header">
            <div>Simple Maps</div>
          </h1>

          <div class="section-body">
            <div class="row">
              <div class="col-12">
                <div class="card">
                  <div class="card-header">
                    <h4>Simple Maps</h4>
                  </div>
                  <div class="card-body">
                    <div class="alert alert-light">
                      Here is a simple example using the map, we use the plugin <code>gmaps.js</code> made by <a href="https://github.com/hpneo" target="_blank">@hpneo</a>. You can learn more about this plugin <a href="https://github.com/hpneo/gmaps" target="_blank">here</a>.
                    </div>
                    <div id="simple-map" style="height:400px;"></div>
                  </div>
                </div>
              </div>
              
              
              
            </div>
          </div>
        </section>
      </div>
      
      
      <!-- footer 영역  -->
      <%@ include file="/include/footer.jsp" %>
      
      
    </div>
  </div>

 		<!-- script 영역  -->
      <%@ include file="/include/script.jsp" %>
  
  <script src="http://maps.google.com/maps/api/js?key=AIzaSyD_Hz_uYHAvh3-ETmGyNfPg3IykZ56ZAdY&amp;sensor=true"></script>
  <script src="/modules/gmaps.js"></script>
  <script>
    // init map
    var simple_map = new GMaps({
      div: '#simple-map',
      lat: -6.5637928,
      lng: 106.7535061
    })
  </script>

</body>
</html>