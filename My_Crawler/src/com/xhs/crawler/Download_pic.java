package com.xhs.crawler;


import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;



public class Download_pic {
	public void Download(List<String> listImgSrc) {  
		int count=1;
        for (String url_path : listImgSrc) { 
			InputStream in=null;
			FileOutputStream fo=null;
			String imageName = url_path.substring(url_path.lastIndexOf("/") + 1, url_path.length()); 
			try {
				byte []data=new byte[500];//1024
				File f=new File("C:\\Users\\Administrator\\Desktop\\crawler\\");
				if(!f.exists()){
					f.mkdir();
				}
				fo=new FileOutputStream(new File(f.getAbsolutePath()+"\\"+imageName));
				URL url=new URL(url_path);
				HttpURLConnection con=(HttpURLConnection) url.openConnection();
				con.setConnectTimeout(5000);
				con.setDoInput(true);
				con.setRequestMethod("GET");
				//con.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
				//���ô���
				int numCode=con.getResponseCode();
				in=con.getInputStream();//int length
				int lengthZ=0;
				if(numCode==200){
					while((lengthZ=in.read(data))!=-1){
						fo.write(data,0,lengthZ);     //write(data,0,length);
						fo.flush();
					}
				}else{
					System.out.println("����ʧ�ܣ������벻��200");
				}
				
				System.out.println("���سɹ�:\t"+imageName+"\tʣ��:\t"+(listImgSrc.size()-count));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(imageName+"����ʧ��");
			}finally{
				try {
					if(in!=null)
						in.close();
					if(fo!=null)
						fo.close();
					count++;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("���������е�С���⡤��");
				}
			}
			
		}
        }
        
	
}
