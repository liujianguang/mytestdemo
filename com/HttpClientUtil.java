/**   
 * @Title: HttpClientUtil.java 
 * @Package com.base.util 
 * @Description: TODO
 * @author Jeckey.Liu   
 * @date 2014年8月20日 上午10:58:43 
 * @version V1  
 */
package com;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

/**
 * @ClassName: HttpClientUtil
 * @Description: 网络辅助工具类
 * @author Jeckey.Liu
 * @date 2014年8月20日 上午10:58:43
 * 
 */
public class HttpClientUtil {
	private static final Log logger = LogFactory.getLog(HttpClientUtil.class);

	public static String doGet(String url) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		// 创建Get方法实例
		HttpGet httpgets = new HttpGet(url);
		System.setProperty("sun.net.client.defaultConnectTimeout", String   
                .valueOf(10000));// （单位：毫秒）
		Properties properties = System.getProperties();
		Enumeration<Object> keys = properties.keys();
		Object nextElement2 = keys.nextElement();
		for (; nextElement2 != null;) {
			System.out.println(nextElement2 + "=" + properties.get(nextElement2));
			if (keys.hasMoreElements()) {
				nextElement2 = keys.nextElement();
			}else {
				nextElement2 = null;
			}
		}
		System.out.println();
		HttpResponse response = httpclient.execute(httpgets);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			InputStream instreams = entity.getContent();
			String str = convertStreamToString(instreams);
			return str;
		}
		return null;
	}

	public static String doPost(String url, Map<String, String> map) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		// 创建POST方法实例
		HttpPost post = new HttpPost(url);
		if (map != null) {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				nvps.add(new BasicNameValuePair(key, map.get(key)));
			}
			post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
		}
		HttpResponse response = httpclient.execute(post);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			InputStream instreams = entity.getContent();
			String str = convertStreamToString(instreams);
			return str;
		}
		return null;
	}

	public static String convertStreamToString(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			logger.error(e);
		} finally {
			try {
				if(is != null){
					is.close();
				}
			} catch (IOException e) {
				logger.error(e);
			}
		}
		return sb.toString();
	}

	public static void saveURLFile(String url, String path, HttpClientFileType type) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		// 创建Get方法实例
		HttpGet httpgets = new HttpGet(url);
		HttpResponse response = httpclient.execute(httpgets);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			File file = new File(path);
			FileDoUtil.mkDirs(file);
			FileOutputStream out = new FileOutputStream(file);
			InputStream instreams = entity.getContent();
			// FileInputStream fIn =( FileInputStream)instreams;
			switch (type) {
			case IMAGE:
				BufferedImage image = ImageIO.read(instreams);
				ImageIO.write(image, "jpg", out);
				instreams.close();
				out.close();
				break;
			case MP3:
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = instreams.read(buffer)) != -1) {
					outStream.write(buffer, 0, len);
				}
				byte[] fileData = outStream.toByteArray();
				out.write(fileData);
				instreams.close();
				out.close();
				break;
			default:
				break;
			}
		}
	}
}
