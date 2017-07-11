package com.xhs.crawler;

import java.util.Scanner;

/**
 * @author XHS_12302
 * @version  1.0
 * @date  2017_07_11
 * 
 * 
 * @description 这是我的第一个爬虫，比较简单，没有队列，广度优先算法等，用list集合代替了队列。
 *              而且只爬取一个网址上面的图片，并不是将网址中的链接<href>加入队列，然后下载一个网址一个网址下载其中的图片。
 *              不过，这是前期的，处于摸索阶段，后期学完队列和广算后，在涉及一点多线程，肯定会比想象中的更高大尚
 */
public class Start_Crawler {
	public static void main(String[] args) {
		System.out.println("请输入网址：");
		
		//获取用户要爬取的网址
		Scanner in=new Scanner(System.in);
		String url=in.next();
		
		//通过用户的输入建立一个Get_Html的一个g对象
		Get_Html g=new Get_Html(url);
		//调用g中的get()方法模拟请求网站服务器，返回回应的字符串
		String htmlstr=g.get();
		
		//建立一个Html_analyze对象ha用来分析服务器返回来的字符串
		Html_analyze ha=new Html_analyze(htmlstr);
		
		/*for (String href :ha.analyzeHtmlHref()) {
			System.out.println(href);
		}*/
		
		//调用ha.analyzeHtmlImage()方法将分析出来的图片地址放进list里面，传回来一个图片地址集合，
		//然后新建下载。
		new Download_pic().Download(ha.analyzeHtmlImage());
		
		System.out.println("program has done!");
		in.close();
	}
}
