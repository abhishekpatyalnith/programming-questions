package com.learn.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class TriesContacts {

	public static void main(String[] args) throws NumberFormatException, IOException {
		TriesContacts obj = new TriesContacts();
		obj.performOperation();
	}

	private void performOperation() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		Trie root = new Trie();
		while (t > 0) {
			String[] input = br.readLine().split(" ");
			if (input[0].equals("add")) {
				root.addWord(input[1]);
			}else{
				root.
			}
		}
	}
}

class Trie {
	TrieNode root;

	protected void addWord(String word) {
		if (word != null && !word.isEmpty()) {
			char[] arr = word.toCharArray();
			TrieNode temp = root;
			for (int i = 0; i < arr.length; i++) {
				char c = arr[i];
				if (temp == null) {
					temp = new TrieNode();
					temp.character = c;
					root  = temp;

				} else {
					if (temp.children[c - '0'] == null) {
						temp.children[c - '0'] = new TrieNode();
						temp.children[c - '0'].character = c;
					}
				}
				if (i == arr.length - 1) {
					root.isEnd = true;
				}
			}
		}
	}
}

class TrieNode {
	char character;
	TrieNode[] children;
	boolean isEnd;
}
