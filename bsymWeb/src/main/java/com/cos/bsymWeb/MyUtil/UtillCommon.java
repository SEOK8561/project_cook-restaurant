package com.cos.bsymWeb.MyUtil;

import java.io.BufferedReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import com.cos.bsymWeb.model.BoardDivision;
import com.cos.bsymWeb.model.BoardReplyCon;
import com.cos.bsymWeb.model.BroadCast;
import com.cos.bsymWeb.model.BsymBoard;
import com.cos.bsymWeb.model.Replys;
import com.cos.bsymWeb.model.Users;
import com.cos.bsymWeb.model.Blog;
import com.cos.bsymWeb.repository.BroadCastRepository;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class UtillCommon {
//	@Autowired
//	private static BroadCastRepository broadCastRepository;

	public static Users getUser() {
		Users user = Users.builder()
				.userName("smwoo")
				.name("송민우")
				.password("smw123123")
				.address("부산시 남구 수영로135 롯데캐슬레전드 124동")
				.phone("000-1111-2222")
				.gender("남")
				.createDate(LocalDate.now())
				.updataDate(LocalDate.now())
				.build();
		return user;
	}
	public static String BlogSearch(String blogName) {
		
		// 네이버 검색 API예제는 블로그를 비롯 전문자료까지 호출방법이 동일하므로 blog검색만 대표로 예제를 올렸습니다.
		// 네이버 검색 API 예제 - blog 검색
		String clientId = "f_74Q9mRqMegGoOl3yMn";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "JHVLN7Zny0";// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode(blogName, "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/blog.json?query=" + text+"&display=100"; // json 결과
			// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
			// // xml 결과
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();		
			return response.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public static List<BsymBoard> BlogCrawl(Blog blog, String broadcastName, String division, int checkDate) {
		List<BsymBoard> bsymBoardList = new ArrayList<>();
		for(int i =0; i<blog.getDisplay(); i++) {
			BsymBoard bsymBoard = blog.getItems().get(i);
			int postDate = Integer.parseInt(bsymBoard.getPostdate());
			if((checkDate>=postDate && checkDate-7<=postDate)||checkDate==1) {
				String url = bsymBoard.getLink();
				if(url.split("/")[2].equals("blog.naver.com")) {
					String endUrl="";
					String imglink="";
					try {
						Document doc = Jsoup.connect(url).get();
						endUrl = "https://blog.naver.com"+doc.select("#mainFrame").get(0).attr("src");
						Document endDoc = Jsoup.connect(endUrl).get();
						String postCheck = endDoc.select("#post_1").get(0).attr("data-post-editor-version");
						//System.out.println(postCheck);
						if(postCheck.equals("2")) {
							imglink = endDoc.select("#postViewArea p img").get(0).attr("src");
						}else if(postCheck.equals("4")) {
							imglink = endDoc.select(".se-image-resource").get(0).attr("data-lazy-src");
						}else {
							
						}
						bsymBoard = BsymBoard.builder()
								.title(bsymBoard.getTitle())
								.link(bsymBoard.getLink())
								.description(bsymBoard.getDescription())
								.postdate(bsymBoard.getPostdate())
								.broadcastName(broadcastName)
								.imglink(imglink)
								.createDate(LocalDate.now())
								.division(division)
								.build();
						bsymBoardList.add(bsymBoard);
					} catch (Exception e) {
						System.out.println(url);
						System.out.println(e);
					}
				}
			}
		}
		return bsymBoardList;
	}
  //---------------------------------아래는 테스트로만 쓴 함수 -------------------
	public static BsymBoard BlogCrawling(String broadCast, int start) {
		String url = "https://search.naver.com/search.naver?where=post&sm=tab_jum&query=" + broadCast + "&start="
				+ start;
		try {
			Document doc = Jsoup.connect(url).get();
			BsymBoard bsymBoard = BsymBoard.builder().broadcastName(broadCast)
					.title(doc.select(".sh_blog_top dl dt").get(0).text())
					.createDate(LocalDate.now())
					//.postdate(doc.select(".txt_inline").get(0).text())
					.boardDivision(BoardDivision.BSFOOD).build();

			return bsymBoard;
		} catch (Exception e) {

		}
		return null;
	}

	public static BroadCast broadCastCrawling(String broadcastName) {
		String url = "https://search.naver.com/search.naver?query=" + broadcastName;
		System.out.println("1방송이름:" + broadcastName);
		try {
			// for (int i = 0 ; i<broadCastName.length; i++) {
			// String url = "https://www.google.com/search?q="+broadCastName[i];

			// String url = "https://search.daum.net/search?w=tot&q="+broadCastName[i];
			Document doc = Jsoup.connect(url).get();
			System.out.println(doc.select(".inline").get(0).text().split("~")[0].split(" "));
			// String startDate=doc.select(".inline[20]").get(0).text().split("
			// ")[1].replace(".", "");
//				BroadCast broadcast = BroadCast.builder()
//						.broadcastName(broadcastName)
//						.broadcastStartDate(startDate)
//						.build();
//				System.out.println("방송이름:"+broadcastName);
//				System.out.println("방영시작날짜:"+startDate);
//				System.out.println(broadcast);
			return null;
//				broadCastRepository.save(broadcast);
//			}
		} catch (Exception e) {

		}
		return null;
	}


}
