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
		int months = 4;//月数自己定        
		//test1(months);    
		//getNumOfEachMonth(4);
		//Math.pow(x,n)方法,表示x的n次幂。
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
			return 1;//第一个月一对        
		}
		else if(i==2){
			return 1;//第二个月一对        
		}        //第i个月的=（i-1）个月+(i-2)个月的（既上个月和上上个月，这个你可以从规律看出来）       
			return getNumOfEachMonth(i-1)+getNumOfEachMonth(i-2);     
	}
	
	
}
