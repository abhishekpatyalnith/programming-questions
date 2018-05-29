import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class NaryTreeNode{
	int data;
	List<NaryTreeNode> children = null;
	
	public NaryTreeNode(int data){
		this.data= data;
		children = new ArrayList<>();
	}
	
	public void addChild(NaryTreeNode node){
		this.children.add(node);
	}
	
}
public class SerializeNaryTree {

	public static void main(String[] args) throws Exception {
		
		NaryTreeNode root = new NaryTreeNode(5);
		NaryTreeNode ch1 = new NaryTreeNode(8);
		NaryTreeNode ch2 = new NaryTreeNode(9);
		NaryTreeNode ch3 = new NaryTreeNode(11);
		NaryTreeNode ch4 = new NaryTreeNode(13);
		NaryTreeNode ch5 = new NaryTreeNode(17);
		NaryTreeNode ch6 = new NaryTreeNode(18);
		NaryTreeNode ch7 = new NaryTreeNode(20);
		NaryTreeNode ch8 = new NaryTreeNode(22);
		NaryTreeNode ch9 = new NaryTreeNode(23);
		NaryTreeNode ch10 = new NaryTreeNode(25);
		NaryTreeNode ch11 = new NaryTreeNode(27);
		NaryTreeNode ch12 = new NaryTreeNode(28);
		NaryTreeNode ch13 = new NaryTreeNode(32);
		NaryTreeNode ch14 = new NaryTreeNode(31);
		NaryTreeNode ch15 = new NaryTreeNode(33);
		NaryTreeNode ch16 = new NaryTreeNode(34);
		NaryTreeNode ch17 = new NaryTreeNode(29);
		
		root.addChild(ch1);  
        root.addChild(ch2);  
        root.addChild(ch3);  
        
        ch1.addChild(ch4);  
        ch1.addChild(ch5);  
        ch4.addChild(ch6);  
        ch6.addChild(ch7);  
        ch7.addChild(ch8);  
        
        ch5.addChild(ch9);  
        ch3.addChild(ch10);  
        ch3.addChild(ch11);  
        ch10.addChild(ch12);  
        ch10.addChild(ch14);  
        ch12.addChild(ch13);  
        ch14.addChild(ch15);  
        ch14.addChild(ch16);  
        ch14.addChild(ch17);  
        
        String serializedString = serialize(root);
		System.out.println(serializedString);
		NaryTreeNode resultRoot = deserialize(serializedString);
		System.out.println(serialize(resultRoot)); 
	}
	
	private static NaryTreeNode deserialize(String str) throws Exception{
		NaryTreeNode root = null;
		Stack<NaryTreeNode> stack = new Stack<>();
		for(int i=0;i<str.length();){
			char c = str.charAt(i);
			if(c == '.'){
				i++;
				StringBuilder num = new StringBuilder();
				while(isDigit(str.charAt(i))){
					num.append(str.charAt(i));
					i++;
				}
				NaryTreeNode node = new NaryTreeNode(Integer.valueOf(num.toString()));
				if(root == null){
					root = node;
				}else{
					NaryTreeNode temp = stack.peek();
					temp.children.add(node);
				}
				stack.push(node);
			}else if(c == ')'){
				stack.pop();
				i++;
			}else{
				throw new UnsupportedEncodingException();
			}
		}
		return root;
	}

	private static boolean isDigit(char c) {
		return (c-'0' >=0 && c-'0'<=9);
	}

	private static String serialize(NaryTreeNode root) {
		StringBuilder result = new StringBuilder();
		if(root != null){
			result.append(".");
			result.append(root.data);
			for(NaryTreeNode node : root.children){
				result.append(serialize(node));
			}
			result.append(")");
		}
		return result.toString();
	}
}
