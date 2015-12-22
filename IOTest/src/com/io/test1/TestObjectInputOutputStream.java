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

/** ��������ʹ��
 * @author admin
 *
 */
public class TestObjectInputOutputStream {

	//��������л����̣��ڴ�Ķ���ͨ��ObjectOutputStreamת��Ϊ�������� �洢��Ӳ���ļ���
	@Test
	public void testObjectOutputStream() {
		Person p1 = new Person("����",12);
		Person p2 = new Person("ĬĬ",12);
		
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
	
	//����ķ����л����̣���Ӳ���е��ļ�ͨ��ObjectInputStreamת��Ϊ��Ӧ�Ķ���
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
 * Ҫʵ�����л����ࣺ
 * Ҫ������¿����л��ģ���Ҫʵ�ֽӿ�
 * Ҫ���������ҲҪʵ�ֽӿ�
 */
class Person implements Serializable{
	
	
	/**
	 * ���л��汾��
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
