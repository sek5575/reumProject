package com.biz.craw;
import java.io.IOException;
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




public class YTNCraw {
   
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

      
      
   public ArrayList<YTNVO> ytnCrawling(String url, String selector) {
//   public int ytnCrawling(String url, String selector) {
      //Connection.class
      //public interface Connection
      
      //Connection$Response.class
      //
      //       interface Response extends Base
      
      
      if(url.indexOf("https://") >= 0){
            try {
				makeFakeCertAndSSLSetting();
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

      
      Connection.Response response;
      
      ArrayList<YTNVO> list = new ArrayList<YTNVO>();
      try {
         response = Jsoup.connect(url)
               .method(Connection.Method.GET)
               .execute();

         System.out.println(response.statusMessage());
         System.out.println(response.statusCode());

         Document html = response.parse();
         //System.out.println(doc.html());

         Elements elms = html.select(selector);
         

         //conn = db.dbConn();
         for(Element elm : elms) {
            YTNVO vo  = new YTNVO();
            Elements AtagTitle = elm.select("dt a");
            System.out.println("http://www.ytn.co.kr"+AtagTitle.attr("href"));
            System.out.println(AtagTitle.text());

            vo.setUrl("http://www.ytn.co.kr"+AtagTitle.attr("href"));
            vo.setTitle(AtagTitle.text());

            Elements Acontents = elm.select("dd.text a");
            System.out.println(Acontents.text());
            vo.setContent(Acontents.text());
            
            Elements photos = elm.select("dd.vertical p.ph a img");
            System.out.println(photos.attr("data-src"));
            vo.setImgsrc(photos.text());
            
//            for(Element elmCont : elmsContent) {
//               System.out.println(elmCont.text());
//               vo.setContent(elmCont.text());
//            }
            
            System.out.println();
            list.add(vo);


         }
         

      } catch (IOException e) {
         e.printStackTrace();
      }
      return list;
   }

//   public static void main(String[] args) {
//      JsoupTest soup = new JsoupTest();
//      String url = "https://www.ytn.co.kr/photo/sports_list_9903.html";
//      String selector="div#ytn_list_v2014 dl.photo_list";
////      int res = soup.ytnCrawling(url, selector);
//      ArrayList<YTNVO> list = soup.ytnCrawling(url, selector);
//      System.out.println(list.size() + "건 클롤링");
//
//   }

   
   
}