/**
 * 
 */
package com.io.test1;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Java.io.File类
 * 1.凡是与输入 输出相关的类 接口等都定义在Java.io包下
 * 2.File是一个类 可以有构造器创建其对象
 * 3.File类对象是与平台无关的
 * 4.File中的方法 仅涉及到 文件的如何创建 删除 重命名等等。只要涉及文件内容的 File是不能做到的 必须要io流来完成
 * 5.File类的对象经常是作为io流的具体类的构造器的形参 
 */
public class TestFile {

	@Test
	public void test1(){
		File file1 = new File("E:/io/helloword.txt");
		File file2 = new File("hello.txt");
		/*System.out.println(file1.getName());//获取文件的名称
		System.out.println(file1.getPath());//获取文件的路径
		System.out.println(file1.getAbsoluteFile());//
		System.out.println(file1.getAbsolutePath());//获取文件的绝对路径
		System.out.println(file1.getParent());//获取文件的上级目录
*/		//重命名 移动
		boolean b = file1.renameTo(file2);
		System.out.println(b);	
	}
	
	@Test
	public void test2(){
		File file1 = new File("hello.txt");
		System.out.println(file1.exists());//文件是否存在
		System.out.println(file1.canWrite());//文件是否可写
		System.out.println(file1.canRead());//文件是否可读
		System.out.println(file1.isFile());//是否是一个文件
		System.out.println(file1.isDirectory());//是否是一个目录
		System.out.println(file1.lastModified());//最后的修改时间
		System.out.println(file1.length());//文件的长度
	}
	
	@Test
	public void test3() throws IOException{
		/*File file1 = new File("E:/io/helloword.txt");
		if(!file1.exists()){
			boolean b = file1.createNewFile();
			System.out.println("创建文件的执行为："+b);
		}else {
			boolean b1 = file1.delete();
			System.out.println("删除文件的执行为："+b1);
		}
		
		File file2 = new File("E:/io/io1");
		//File file3 = new File("E:/io1/io1");
		//mkDir(): 创建一个文件目录，只有在上层文件目录存在的情况下 才能返回true
		//mkDirs(): 创建一个文件目录，若上层文件目录不存在 则一并的创建
		if(!file2.exists()){
			boolean b = file2.mkdir();
			System.out.println("创建目录的执行为："+b);
		}else {
			boolean b1 = file2.delete();
			System.out.println("删除目录的执行为："+b1);
		}*/
		//以列表文字的方式查看目录里的文件信息
		File file3 =  new File("E:\\北大青鸟那些年");
		String [] strs = file3.list();
		for(int i = 0;i< strs.length;i++){
			System.out.println(strs[i]);
		}
		System.out.println("======================");
		//已文件的形式来查看
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
