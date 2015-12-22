/**
 * 
 */
package com.io.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * 1.流的分类
 * 按照数据流向的不同：输入流 输出流
 * 按照处理数据的单位的不同：字节流 字符流（处理的文本文件）
 * 按照角色的不同，节点流（直接作用于文件的） 处理流
 * 
 * 2.Io的体系
 * 抽象基类				节点流 (文件流)				缓冲流（处理流的一种）
 * InputStream			FileInputStream			BufferedInputStream
 * OutputStream			FileOutputStream		BufferedOutputStream
 * Reader				FileReader				BufferedReader
 * Writer				FileWriter				BufferedWriter
 *
 */
public class TestFileInputOutputStream {

	@Test
	public void testFileInputStream1() throws Exception{
		//1.创建一个File类的对象
		File file = new File("hello.txt");
		//2.创建一个FileInputStream类的对象
		FileInputStream fis = new FileInputStream(file);
		//3.调用read() 读取文件
		int b;
		while((b=fis.read())!=-1){
			System.out.print((char)b);
		}
		fis.close();
	}
	/*
	 * 输入流：read
	 */
	@Test
	public void testFileInputStream2(){
		
		File file = new File("hello.txt");
		if(file.exists()){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[fis.available()];//读取到的数据要写入的数组
			int len;//每次读入到byte中的字节的长度
			while((len=fis.read(b))!=-1){
			/*	for(int i = 0;i<len;i++){
					System.out.print((char)b[i]);
				}*/
				String str = new String(b,0,len);
				System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			
		}
	}
	/**
	 * 输出流：write
	 */
	@Test
	public void testFileOutputStream(){
		//输出的这个物理文件可以不存在，当执行的过程中 会自动创建，若存在会覆盖原有的文件
		File file = new File("hello1.txt");
		FileOutputStream fos = null;;
		try {
			fos = new FileOutputStream(file);
			fos.write(new String("I Love China中国").getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	
	/*
	 * 文件的复制
	 */
	@Test
	public void testFileInputOutputStream(){
		//1.提供相应的文件
/*		File file1 = new File("hello.txt");
		File file2 = new File("hello1.txt");*/
		File file1 = new File("C:\\Users\\admin\\Desktop\\io流.jpg");
		File file2 = new File("io流.jpg");
		//2.提供相应的流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			byte [] b = new byte[fis.available()];
			int len;
			while((len=fis.read(b))!=-1){
				fos.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis!=null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos!=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
