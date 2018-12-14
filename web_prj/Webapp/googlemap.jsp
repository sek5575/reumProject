<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
  <head>
    <title>New Renderer</title>
    <meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  </head>
  <body>
    <div id="map"></div>
    <script>
var map, marker, infoWindow;
var SYDNEY = {lat: -33.8798, lng: 151.2089};
var OPERA_HOUSE = {lat: 36.800664, lng: 127.104856};
function initMap() {
  // Create a map in the usual way.
  map = new google.maps.Map(
      document.getElementById('map'), {center: SYDNEY, zoom: 12});

  // Create a marker. Markers behave smoothly with the beta renderer.
  marker = new google.maps.Marker({position: OPERA_HOUSE, map: map});

  // Create info window content.
  var content = document.createElement('div');
  content.textContent = 'new renderer ';
  var zoomInButton = document.createElement('button');
  zoomInButton.textContent = 'zoom in';
  content.appendChild(zoomInButton);

  // Create open an info window attached to the marker.
  infoWindow = new google.maps.InfoWindow({content: content});
  infoWindow.open(map, marker);

  // When the zoom-in button is clicked, zoom in and pan to the Opera House.
  // The zoom and pan animations are smoother with the new renderer.
  zoomInButton.onclick = function() {
    map.setZoom(Math.max(15, map.getZoom() + 1));
    map.panTo(OPERA_HOUSE);
  };
}
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD_Hz_uYHAvh3-ETmGyNfPg3IykZ56ZAdY&callback=initMap">
    </script>
  </body>
</html>