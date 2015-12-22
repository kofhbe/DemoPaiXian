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
 * 1.���ķ���
 * ������������Ĳ�ͬ�������� �����
 * ���մ������ݵĵ�λ�Ĳ�ͬ���ֽ��� �ַ�����������ı��ļ���
 * ���ս�ɫ�Ĳ�ͬ���ڵ�����ֱ���������ļ��ģ� ������
 * 
 * 2.Io����ϵ
 * �������				�ڵ��� (�ļ���)				����������������һ�֣�
 * InputStream			FileInputStream			BufferedInputStream
 * OutputStream			FileOutputStream		BufferedOutputStream
 * Reader				FileReader				BufferedReader
 * Writer				FileWriter				BufferedWriter
 *
 */
public class TestFileInputOutputStream {

	@Test
	public void testFileInputStream1() throws Exception{
		//1.����һ��File��Ķ���
		File file = new File("hello.txt");
		//2.����һ��FileInputStream��Ķ���
		FileInputStream fis = new FileInputStream(file);
		//3.����read() ��ȡ�ļ�
		int b;
		while((b=fis.read())!=-1){
			System.out.print((char)b);
		}
		fis.close();
	}
	/*
	 * ��������read
	 */
	@Test
	public void testFileInputStream2(){
		
		File file = new File("hello.txt");
		if(file.exists()){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			byte[] b = new byte[fis.available()];//��ȡ��������Ҫд�������
			int len;//ÿ�ζ��뵽byte�е��ֽڵĳ���
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
	 * �������write
	 */
	@Test
	public void testFileOutputStream(){
		//�������������ļ����Բ����ڣ���ִ�еĹ����� ���Զ������������ڻḲ��ԭ�е��ļ�
		File file = new File("hello1.txt");
		FileOutputStream fos = null;;
		try {
			fos = new FileOutputStream(file);
			fos.write(new String("I Love China�й�").getBytes());
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
	 * �ļ��ĸ���
	 */
	@Test
	public void testFileInputOutputStream(){
		//1.�ṩ��Ӧ���ļ�
/*		File file1 = new File("hello.txt");
		File file2 = new File("hello1.txt");*/
		File file1 = new File("C:\\Users\\admin\\Desktop\\io��.jpg");
		File file2 = new File("io��.jpg");
		//2.�ṩ��Ӧ����
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
