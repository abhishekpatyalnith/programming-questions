package com.learn.sorocco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.models.auth.In;

/**
 * 
 * @author abhishek.patyal
 *
 */

/*
 * 
 */
public class StringDeDuplication {
	public static void main(String[] args) {
		String s = "";
		s = s + 'c';
		System.out.println(s);
	}

	static String dedup(String inputStr, int chunkSize) {
		char[] str = inputStr.toCharArray();
		chunkSize *= 1000;
		Map<String, Integer> map = new HashMap<>();
		Map<String, List<Integer>> map1 = new HashMap<>();
		for (int i = 0; i < str.length - chunkSize + 1; i += chunkSize) {
			char[] arr = new char[chunkSize];
			int k = 0;
			for (int j = i; j < chunkSize; j++) {
				arr[k] = str[j];
			}
			String result = arr.toString();
			Integer count = map.get(result);
			if (count == null) {
				map.put(result, count);
				List<Integer> index = new ArrayList<>();
				index.add(i);
				map1.put(result, index);
			} else {
				map.put(result, ++count);
				List<Integer> indices = map1.get(result);
				indices.add(i);
				map1.put(result, indices);
			}
		}
		for(Map.Entry<String, List<Integer>> entry : map1.entrySet()){
			String key = entry.getKey();
			List<Integer> indices = entry.getValue();
		}
	}
}
