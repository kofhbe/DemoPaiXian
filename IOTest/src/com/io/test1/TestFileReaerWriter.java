package com.io.test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * �ַ����Ĳ���
 * FileReder:������
 * FileWrite�������
 * ʹ�� FileReder FileWrite ����ʵ���ı��ļ��ĸ���
 * �����ڷ��ı��ļ�(��Ƶ�ļ�����Ƶ�ļ���ͼƬ)��ֻ��ʹ���ֽ���
 * @author admin
 *
 */
public class TestFileReaerWriter {

	@Test
	public void testFileReader(){
		File file = new File("hello.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			char [] c = new char[100];
			int len;
			while((len = fr.read(c))!=-1){
				String str = new String(c,0,len);
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testFileReaderFileWriter(){
		FileReader fr = null;
		FileWriter fw = null;
		try{
			File file1 = new File("hello.txt");
			File file2 = new File("hello1.txt");
			fr = new FileReader(file1);
			fw = new FileWriter(file2);
			char [] c = new char[100];
			int len;
			while((len=fr.read(c))!=-1){
				fw.write(c, 0, len);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}

