package com.xhs.crawler;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Html_analyze {
	private String src;
	Html_analyze(String src){
		this.src=src;
	}
	public List<String> analyzeHtmlImage(){
		String regex="http[s]{0,1}://[^\\s]*\\.(jpg|bmp|png)";
		//String sr="http://img5.imgtn.bdimg.com/it/u=1380084653,2448555822&fm=26&gp=0.jpg";
		List<String> listImgUrl=new ArrayList<>();
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(src);
		while(m.find()){
			System.out.println(m.group());
			listImgUrl.add(m.group());
		}
		System.out.println("\n\n总共找到记录："+listImgUrl.size()+"\n");
		return listImgUrl;
	}
	public List<String>  analyzeHtmlHref(){
		//分析href标签   并且加入listHref
		String regex="<a.*?href=\"(.*?)\">";
		List<String> listHref=new ArrayList<>();
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(src);
		while(m.find()){
			listHref.add(m.group());
		}
		return listHref;
	}
}
