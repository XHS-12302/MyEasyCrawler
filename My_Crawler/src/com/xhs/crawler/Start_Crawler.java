package com.xhs.crawler;

import java.util.Scanner;

/**
 * @author XHS_12302
 * @version  1.0
 * @date  2017_07_11
 * 
 * 
 * @description �����ҵĵ�һ�����棬�Ƚϼ򵥣�û�ж��У���������㷨�ȣ���list���ϴ����˶��С�
 *              ����ֻ��ȡһ����ַ�����ͼƬ�������ǽ���ַ�е�����<href>������У�Ȼ������һ����ַһ����ַ�������е�ͼƬ��
 *              ����������ǰ�ڵģ����������׶Σ�����ѧ����к͹�������漰һ����̣߳��϶���������еĸ��ߴ���
 */
public class Start_Crawler {
	public static void main(String[] args) {
		System.out.println("��������ַ��");
		
		//��ȡ�û�Ҫ��ȡ����ַ
		Scanner in=new Scanner(System.in);
		String url=in.next();
		
		//ͨ���û������뽨��һ��Get_Html��һ��g����
		Get_Html g=new Get_Html(url);
		//����g�е�get()����ģ��������վ�����������ػ�Ӧ���ַ���
		String htmlstr=g.get();
		
		//����һ��Html_analyze����ha�����������������������ַ���
		Html_analyze ha=new Html_analyze(htmlstr);
		
		/*for (String href :ha.analyzeHtmlHref()) {
			System.out.println(href);
		}*/
		
		//����ha.analyzeHtmlImage()����������������ͼƬ��ַ�Ž�list���棬������һ��ͼƬ��ַ���ϣ�
		//Ȼ���½����ء�
		new Download_pic().Download(ha.analyzeHtmlImage());
		
		System.out.println("program has done!");
		in.close();
	}
}
