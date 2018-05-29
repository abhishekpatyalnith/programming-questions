
public class PrintInterleaving {

	public static void main(String[] args) {
		String str1 = "AB";
		String str2 = "XY";
		String result = "";
		System.out.println(str1.toCharArray());
	//	printInterleavingRecursive(str1,str2,result);
	}

	public static void printInterleavingRecursive(String str1, String str2, String result) {

		if(str1 == null){
			System.out.println(str2);
			return;
		}
		if(str2 == null){
			System.out.println(str1);
			return;
		}
		if(str1.length() == 0 && str2.length() == 0){
			System.out.println(result);
			return;
		}
		if(str1.length() != 0){
			printInterleavingRecursive(str1.substring(1), str2, result+str1.charAt(0));
		}
		if(str2.length() != 0){
			printInterleavingRecursive(str1, str2.substring(1), result+str2.charAt(0));
		}
	}
}
