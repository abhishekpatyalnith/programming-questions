package com.learning.microsoft;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author abhishek.patyal
 *
 */
public class Reader {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String filename;
		filename = scan.nextLine();
		File fileObject = new File(filename);
		FileReader fileReaderObject = new FileReader(fileObject);

		BufferedReader bufferedReader = new BufferedReader(fileReaderObject);
		String lines = null;
		int result = 0;
		long sum = 0;
		while ((lines = bufferedReader.readLine()) != null) {
			String count = lines.substring(lines.lastIndexOf(" ")).trim();
			long number = Long.valueOf(count);
			if (number > 5000) {
				result++;
				sum += number;
			}
		}
		bufferedReader.close();
		fileObject = new File("bytes_" + filename);
		FileWriter fileWriter = new FileWriter(fileObject);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();
		bufferedWriter.write(String.valueOf(sum));
		bufferedWriter.close();
	}
}
