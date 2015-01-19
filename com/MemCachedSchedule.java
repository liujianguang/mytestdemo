package com;

import java.io.InputStream;
import java.net.URL;

import org.apache.http.entity.ContentType;
import org.springframework.web.util.HtmlUtils;

public class MemCachedSchedule {

	public static void main(String[] args)  throws Exception {
		System.out.println(ContentType.APPLICATION_JSON.getMimeType());
		test();
	}

	private static void test()  throws Exception {
		String url = "http://test.song-1.com/api/songs/v2/song/search?q=爱&page=1&pageSize=2";
		String url1 = "http://api.song-1.com/api/enjoy/v2/albums/banner";
		String url2 = "http://120.24.78.13:8580/song1-search/search/query?queryString=爱&currPage=1&pageSize=2&queryType=song";
		String url3 = "http://127.0.0.1:8180/song1_manager/api/songs/v2/song/search?q=爱&page=1&pageSize=2";
		testName();
//		url(url);
//		 url(url1);
		 url(url2);
		// url(url3);
	}

	private static void url(String url) {
		try {
			String doGet = new HttpClientUtil().doGet(url);
			// String htmlEscape = HtmlUtils.htmlEscape(doGet);
			// String htmlEscape = HtmlUtils.htmlEscapeDecimal(doGet);
			// String htmlEscape = HtmlUtils.htmlEscapeHex(doGet);
			// String htmlEscape = HtmlUtils.htmlUnescape(doGet);
			String htmlEscape = HtmlUtils.htmlUnescape(doGet);
			System.out.println(htmlEscape);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testName(){
		URL url = null;
		try {
			url = new URL("http://www.baidu.com/");
			InputStream in = url.openStream();
			System.out.println("连接正常");
			in.close();
		} catch (Exception e) {
			System.out.println("连接失败");
		}
	}

}
