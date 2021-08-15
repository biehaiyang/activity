package com.ruoyi.common.utils;

import java.util.Random;

public class RandomStringGenerator {

	/**
	 * 获取一定长度的随机字符串
	 * 
	 * @param length
	 *            指定字符串长度
	 * @return 一定长度的字符串
	 */
	public static String getRandomStringByLength(int length) {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static String getRandomNumber4() {
		Integer number;// 定义两变量
		Random ne = new Random();// 实例化一个random的对象ne
		number = ne.nextInt(9999 - 1000 + 1) + 1000;// 为变量赋随机值1000-9999

		return number.toString();

	}

	public static String getRandomNumber6() {
		Integer number;// 定义两变量
		Random ne = new Random();// 实例化一个random的对象ne
		number = ne.nextInt(999999 - 100000 + 1) + 100000;// 为变量赋随机值1000-9999

		return number.toString();

	}

}
