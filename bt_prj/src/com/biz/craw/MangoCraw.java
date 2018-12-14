package com.biz.craw;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class MangoCraw {
   
      public static void makeFakeCertAndSSLSetting() throws NoSuchAlgorithmException, KeyManagementException {
           
         TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
              
               public X509Certificate[] getAcceptedIssuers() {
                   return null;
               }
               public void checkClientTrusted(X509Certificate[] certs, String authType) {
               }
               public void checkServerTrusted(X509Certificate[] certs, String authType) {
               }
           } 
         };
         
           SSLContext sc = SSLContext.getInstance("SSL");
           sc.init(null, trustAllCerts, new SecureRandom());
           HttpsURLConnection.setDefaultHostnameVerifier(
               new HostnameVerifier() {
                   @Override
                   public boolean verify(String hostname, SSLSession session) {
                       return true;
                   }
               }
           );
           HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
}

      
      
   public ArrayList<MangoVO> MangoCrawling(String url, String selector, int topn) {
//   public int ytnCrawling(String url, String selector) {
      //Connection.class
      //public interface Connection
      
      //Connection$Response.class
      //
      //       interface Response extends Base
      
      
      if(url.indexOf("https://") >= 0){
            try {
				makeFakeCertAndSSLSetting();  //ssl
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
      
      
      //크롤링 하는 싸이트의 주소 구하기:http://www.naver.com:8088
      //http://www.naver.com:8088/aa/bb/index.html
      //https://www.naver.com/aa/bb/index.html
      //siteURl + /imgs/aa.jpg
      String siteURL = "";
      try {
      	siteURL += new URL(url).getProtocol() +"://"+ new URL(url).getHost();
      	if(new URL(url).getPort() != -1)
      		siteURL +=  ":"+ new URL(url).getPort();	
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

      
      Connection.Response response;
      
      ArrayList<MangoVO> list = new ArrayList<MangoVO>();
      try {
         response = Jsoup.connect(url)
               .method(Connection.Method.GET)
               .execute();

         System.out.println(response.statusMessage());
         System.out.println(response.statusCode());

         Document html = response.parse();

         Elements elms = html.select(selector);
         
         int loopCnt=0;  
         if(topn == -1) {
        	 loopCnt = elms.size();
         }else {
        	 loopCnt = topn;
         }

//         for(Element elm : elms) {
         for(int i=0; i<loopCnt; i++) {
        	Element elm = elms.get(i);
        	MangoVO vo  = new MangoVO();
        	 
            Elements AtagTitle = elm.select("div figure figcaption div span a");
//            Elements AtagTitle = elm.select("div.with-review figure.restaurant-item figcaption div.info span.title a");
            //System.out.println(AtagTitle.text());
            //System.out.println("https://www.mangoplate.com"+AtagTitle.attr("href"));
            vo.setUrl("https://www.mangoplate.com"+AtagTitle.attr("href"));
            vo.setTitle(AtagTitle.text());
            
            Elements photos = elm.select("div.with-review figure.restaurant-item a div.thumb img");
           // System.out.println(photos.attr("data-original"));
            vo.setPicsrc(photos.attr("data-original"));
            
            Elements info = elm.select("div.with-review div.review-content.no-bottom p.short_review");
            //System.out.println(info.text());
            vo.setInfo(info.text());
            
            Elements address = elm.select("div.with-review figcaption div.info p.etc");
            //System.out.println(address.text());
            vo.setAddress(address.text());
           
            //System.out.println();
            list.add(vo);
         }
         

      } catch (IOException e) {
         e.printStackTrace();
      }
      return list;
   }

   
   
}