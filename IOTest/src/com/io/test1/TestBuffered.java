/**
 * 
 */
package com.io.test1;
import java.io.*;

import org.junit.Test;
/** 使用缓冲流
 * 	可以提升文件操作的效率
 * @author admin
 *
 */
public class TestBuffered {
	/*
	 * 使用BufferedInputStream  BufferedOutputStream实现非文本文件的复制
	 */
	@Test
	public void testBufferedInputOutputStream(){
		//创建文件
		File file1 = new File("C:\\Users\\admin\\Desktop\\io流体系.jpg");
		File flie2 = new File("io流体系.jpg");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			//创建节点流
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(flie2);
			//将节点流的对象作为形参传递给缓冲流的构造器
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			byte [] b = new byte[bis.available()];
			int len;
			while((len = bis.read(b))!=-1){
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭相应的流
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bis!=null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}	
	}
	
	/*
	 * 使用BufferedReader  BufferedWriter实现非文本文件的复制
	 */
	@Test
	public void testBufferedFileReaderFileWriter(){
		//创建文件
		File file1 = new File("hello.txt");
		File flie2 = new File("hello1.txt");
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			//创建节点流
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(flie2);
			//将节点流的对象作为形参传递给缓冲流的构造器
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			
			String str;
			while((str = br.readLine())!=null){
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭相应的流
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}	
	}
}
