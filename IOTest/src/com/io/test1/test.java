/**
 * 
 */
package com.io.test1;

/**
 * @author admin
 *
 */
public class test {
	public static void main(String[] args) {       
		int months = 4;//�����Լ���        
		//test1(months);    
		//getNumOfEachMonth(4);
		//Math.pow(x,n)����,��ʾx��n���ݡ�
		System.out.println(Math.pow(2L,4));
		System.out.println(2L<<4);
	}   
	private static void test1(int months) {        
		for(int i=1;i<=months;i++){            
			int num = getNumOfEachMonth(i);            
			System.out.println(num);        
			}    
		}    
	private static int getNumOfEachMonth(int i) { 
		System.out.println(i);
		if(i==1){            
			return 1;//��һ����һ��        
		}
		else if(i==2){
			return 1;//�ڶ�����һ��        
		}        //��i���µ�=��i-1������+(i-2)���µģ����ϸ��º����ϸ��£��������Դӹ��ɿ�������       
			return getNumOfEachMonth(i-1)+getNumOfEachMonth(i-2);     
	}
	
	
}
