/**
 * 
 */
package com.io.test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

/** 对象流的使用
 * @author admin
 *
 */
public class TestObjectInputOutputStream {

	//对象的序列化过程：内存的对象通过ObjectOutputStream转换为二进制流 存储在硬盘文件中
	@Test
	public void testObjectOutputStream() {
		Person p1 = new Person("文文",12);
		Person p2 = new Person("默默",12);
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("hello.txt")));
			oos.writeObject(p1);
			oos.flush();
			oos.writeObject(p2);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (oos!=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//对象的反序列化过程：将硬盘中的文件通过ObjectInputStream转换为相应的对象
		@Test
		public void testObjectInputStream() {
			
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream(new File("hello.txt")));
				Person p1 = (Person) ois.readObject();
				System.out.println(p1);
				Person p2 = (Person) ois.readObject();
				System.out.println(p2);
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if (ois!=null) {
					try {
						ois.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	
}
/*
 * 要实现序列化的类：
 * 要求此类事可序列化的：需要实现接口
 * 要求类的属性也要实现接口
 */
class Person implements Serializable{
	
	
	/**
	 * 序列化版本号
	 */
	private static final long serialVersionUID = 11324124124L;
	private String name;
	private Integer age;
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
