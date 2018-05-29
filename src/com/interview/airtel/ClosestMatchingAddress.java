package com.interview.airtel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class ClosestMatchingAddress {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		List<String> masterList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			masterList.add(br.readLine());
		}
		/*
		 * System.out.println("master list of addresses is");
		 * masterList.forEach(System.out::println);
		 * System.out.println("--------");
		 */

		String n = br.readLine();
		System.out.println(solveClosestMatchingProblem(masterList, n));
	}

	private static String solveClosestMatchingProblem(List<String> masterList, String n) throws NumberFormatException, IOException {

		masterList = filterByOutermostArea(masterList, n);
		if (masterList.isEmpty()) {
			System.out.println("Sorry. There is no matching address.");
			return null;
		}
		n = n.substring(0, n.lastIndexOf(","));
		String[] nArray = n.split(",");
		// System.out.println(n);
		Set<String> filteredList = new HashSet<>();
		for (int i = 0; i < nArray.length; i++) {
			String subString = nArray[nArray.length - i - 1].trim();
			String sector = subString;
			if (subString.contains("-")) {
				subString = subString.replace("-", "");
				if (subString.contains("/")) {
					sector = subString.substring(0, subString.indexOf("/")).trim();
				} else {
					sector = subString.substring(subString.indexOf(" ")).trim();
				}

			} else {
				if (subString.contains(" ")) {
					sector = subString.substring(subString.indexOf(" ")).trim();
				}
			}
			for (String address : masterList) {
				String temp = address;
				String addressInOnlyAlphabetsAndNumbers = temp.replaceAll("[^a-zA-Z0-9]", "");
				if (addressInOnlyAlphabetsAndNumbers.equalsIgnoreCase(sector) || addressInOnlyAlphabetsAndNumbers.contains(sector)) {
					filteredList.add(address);
				}
			}
		}
		if (!filteredList.isEmpty()) {
			Iterator<String> itr = filteredList.iterator();
			String closestMatch = "";
			if (filteredList.size() == 1) {
				while (itr.hasNext()) {
					closestMatch = itr.next();
					break;
				}
			} else {
				closestMatch = findClosestMatch(filteredList, n);
			}

			return closestMatch;
		}
		return null;

	}

	private static String findClosestMatch(Set<String> filteredList, String n) {
		String houseNumber = getHouseNumber(n);
		int distance = Integer.MAX_VALUE;
		Iterator<String> itr = filteredList.iterator();
		String closestMatch = "";
		while (itr.hasNext()) {
			String address = itr.next();
			String houseNumberOfAddress = getHouseNumber(address);
			if (Math.abs(Integer.parseInt(houseNumberOfAddress) - Integer.parseInt(houseNumber)) < distance) {
				distance = Math.abs(Integer.parseInt(houseNumberOfAddress) - Integer.parseInt(houseNumber));
				closestMatch = address;
			}
		}
		return closestMatch;
	}

	private static String getHouseNumber(String n) {

		Matcher matcher = Pattern.compile("\\d+").matcher(n);
		matcher.find();
		int i = Integer.valueOf(matcher.group());
		return String.valueOf(i);

		/*
		 * String subString = n.substring(i); if(subString.contains("/")){
		 * subString =
		 * subString.substring(subString.indexOf("/"),subString.indexOf(","));
		 * }else{ subString = subString.substring(i,subString.indexOf(",")); }
		 */
		// return subString;
	}

	private static List<String> filterByOutermostArea(List<String> masterList, String n) {
		// masterList.stream().filter(address-> address !=
		// "abs").collect(Collectors.toList());
		String lastAreaOfInput = n.substring(n.lastIndexOf(","));
		lastAreaOfInput = lastAreaOfInput.replaceAll("[^a-zA-Z0-9]", "");
		// System.out.println("last area of input "+lastAreaOfInput);
		List<String> filteredList = new ArrayList<>();
		for (String address : masterList) {
			String temp = address;
			String addressInOnlyAlphabetsAndNumbers = temp.replaceAll("[^a-zA-Z0-9]", "");
			// System.out.println("after removing
			// "+addressInOnlyAlphabetsAndNumbers);;
			if (addressInOnlyAlphabetsAndNumbers.equalsIgnoreCase(lastAreaOfInput) || addressInOnlyAlphabetsAndNumbers.contains(lastAreaOfInput)) {
				filteredList.add(address);
			}
		}
		return filteredList;
	}

	@Test
	public void testClosestMatching() throws NumberFormatException, IOException {
		ClosestMatchingAddress cma = new ClosestMatchingAddress();
		Assert.assertEquals("6480, Sector C6, Vasant Kunj",
				ClosestMatchingAddress.solveClosestMatchingProblem(
						Arrays.asList("6480, Sector C6, Vasant Kunj", "Plot 16, Udyog Vihar Phase -4, Gurgaon", "8231, Sector C8, Vasant Kunj", "C-6/6280, Vasant Kunj"),
						"N=6279, Sector C6, Vasant Kunj"));
	}
}
