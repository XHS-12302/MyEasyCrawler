package com.xhs.crawler;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Get_Html {
	private String url_path;
	private String htmlstr;
	StringBuffer contentBuffer = new StringBuffer();
	Get_Html(String url){
		this.url_path=url;
	}

	public String get(){
		   FileWriter fw=null;
		try {
			fw=new FileWriter("C:\\Users\\Administrator\\Desktop\\crawler.txt");
			URL url=new URL(url_path);
			URLConnection hc=url.openConnection();
			hc.setConnectTimeout(5000);
			hc.setDoInput(true);
			((HttpURLConnection) hc).setRequestMethod("GET");
			int returnCode=((HttpURLConnection) hc).getResponseCode();
			if(returnCode==200){
				InputStream input=hc.getInputStream();
				
				 InputStreamReader istreamReader = new InputStreamReader(input, "utf-8");  
		         BufferedReader buffStr = new BufferedReader(istreamReader);  
		  
		        String str = null;  
		       while ((str = buffStr.readLine()) != null) 
		          contentBuffer.append(str);
		          htmlstr=contentBuffer.toString();
                  fw.write(htmlstr);
			   input.close();
			   istreamReader.close();
			   buffStr.close();
			   fw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return htmlstr;
		
	}
	
	
}
