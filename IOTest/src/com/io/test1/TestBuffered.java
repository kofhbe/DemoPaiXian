/**
 * 
 */
package com.io.test1;
import java.io.*;

import org.junit.Test;
/** ʹ�û�����
 * 	���������ļ�������Ч��
 * @author admin
 *
 */
public class TestBuffered {
	/*
	 * ʹ��BufferedInputStream  BufferedOutputStreamʵ�ַ��ı��ļ��ĸ���
	 */
	@Test
	public void testBufferedInputOutputStream(){
		//�����ļ�
		File file1 = new File("C:\\Users\\admin\\Desktop\\io����ϵ.jpg");
		File flie2 = new File("io����ϵ.jpg");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			//�����ڵ���
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(flie2);
			//���ڵ����Ķ�����Ϊ�βδ��ݸ��������Ĺ�����
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
			//�ر���Ӧ����
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
	 * ʹ��BufferedReader  BufferedWriterʵ�ַ��ı��ļ��ĸ���
	 */
	@Test
	public void testBufferedFileReaderFileWriter(){
		//�����ļ�
		File file1 = new File("hello.txt");
		File flie2 = new File("hello1.txt");
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			//�����ڵ���
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(flie2);
			//���ڵ����Ķ�����Ϊ�βδ��ݸ��������Ĺ�����
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
			//�ر���Ӧ����
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
