package com.learn.sorocco;

import java.util.Arrays;

public class ArrayRangeCompacting {

	static String solution(int[] array) {
        Arrays.sort(array);
        String solution = String.valueOf(array[0]);
        int range = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i]-array[i-1]==1) {
                range++;
                continue;
            }
            else {
                if(range>2) {
                    solution += "-";
                    solution += String.valueOf(array[i-1]);
                    range=1;
                    solution += ",";
                    solution += String.valueOf(array[i]);
                }
                else if(range==2) {
                    solution += ",";
                    solution += String.valueOf(array[i-1]);
                    solution += ",";
                    solution += String.valueOf(array[i]);
                    range=1;
                }
                else {
                    solution += ",";
                    solution += String.valueOf(array[i]);
                }
            }
        }
        if(range==2) {
            solution += ",";
            solution += String.valueOf(array[array.length-1]);
        }
        else if(range>2) {
            solution += "-";
            solution += String.valueOf(array[array.length-1]);
        }
        return solution;
    }
	
	
}
