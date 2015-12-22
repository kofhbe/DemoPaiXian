/**
 * 
 */
package com.io.test1;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Java.io.File��
 * 1.���������� �����ص��� �ӿڵȶ�������Java.io����
 * 2.File��һ���� �����й��������������
 * 3.File���������ƽ̨�޹ص�
 * 4.File�еķ��� ���漰�� �ļ�����δ��� ɾ�� �������ȵȡ�ֻҪ�漰�ļ����ݵ� File�ǲ��������� ����Ҫio�������
 * 5.File��Ķ��󾭳�����Ϊio���ľ�����Ĺ��������β� 
 */
public class TestFile {

	@Test
	public void test1(){
		File file1 = new File("E:/io/helloword.txt");
		File file2 = new File("hello.txt");
		/*System.out.println(file1.getName());//��ȡ�ļ�������
		System.out.println(file1.getPath());//��ȡ�ļ���·��
		System.out.println(file1.getAbsoluteFile());//
		System.out.println(file1.getAbsolutePath());//��ȡ�ļ��ľ���·��
		System.out.println(file1.getParent());//��ȡ�ļ����ϼ�Ŀ¼
*/		//������ �ƶ�
		boolean b = file1.renameTo(file2);
		System.out.println(b);	
	}
	
	@Test
	public void test2(){
		File file1 = new File("hello.txt");
		System.out.println(file1.exists());//�ļ��Ƿ����
		System.out.println(file1.canWrite());//�ļ��Ƿ��д
		System.out.println(file1.canRead());//�ļ��Ƿ�ɶ�
		System.out.println(file1.isFile());//�Ƿ���һ���ļ�
		System.out.println(file1.isDirectory());//�Ƿ���һ��Ŀ¼
		System.out.println(file1.lastModified());//�����޸�ʱ��
		System.out.println(file1.length());//�ļ��ĳ���
	}
	
	@Test
	public void test3() throws IOException{
		/*File file1 = new File("E:/io/helloword.txt");
		if(!file1.exists()){
			boolean b = file1.createNewFile();
			System.out.println("�����ļ���ִ��Ϊ��"+b);
		}else {
			boolean b1 = file1.delete();
			System.out.println("ɾ���ļ���ִ��Ϊ��"+b1);
		}
		
		File file2 = new File("E:/io/io1");
		//File file3 = new File("E:/io1/io1");
		//mkDir(): ����һ���ļ�Ŀ¼��ֻ�����ϲ��ļ�Ŀ¼���ڵ������ ���ܷ���true
		//mkDirs(): ����һ���ļ�Ŀ¼�����ϲ��ļ�Ŀ¼������ ��һ���Ĵ���
		if(!file2.exists()){
			boolean b = file2.mkdir();
			System.out.println("����Ŀ¼��ִ��Ϊ��"+b);
		}else {
			boolean b1 = file2.delete();
			System.out.println("ɾ��Ŀ¼��ִ��Ϊ��"+b1);
		}*/
		//���б����ֵķ�ʽ�鿴Ŀ¼����ļ���Ϣ
		File file3 =  new File("E:\\����������Щ��");
		String [] strs = file3.list();
		for(int i = 0;i< strs.length;i++){
			System.out.println(strs[i]);
		}
		System.out.println("======================");
		//���ļ�����ʽ���鿴
		File [] files = file3.listFiles();
		for(int i = 0;i< files.length;i++){
			System.out.println(files[i].getName());
		}
	}
	@Test
	public void operation(){
		System.out.println(method(6));
	}
	
	public int method(int i){
		if (i<=1) {
			return 1;
		}else{
			return i*method(i-1);
		}
	}
	
}
