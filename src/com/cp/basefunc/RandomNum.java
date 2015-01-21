package com.cp.basefunc;

import java.util.Random;

public class RandomNum {
	/**
	 * 生出固定位数的随机数
	 * @param strLength 随机数的位数
	 * @return 固定位数的随机数
	 */
	public static String getRandomNumber(int strLength) {
        
        Random rm = new Random();
         
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
 
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
 
        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }
		
}
