import java.util.Iterator;

import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



class Base{
	private void fun(){
		System.out.println("hello");
	}
}
public class AlibabaJsonLIbraryExample extends Base{
	
	 public void fun1(){
		System.out.println("hi");
	}
	
	public static void main(String[] args) {
		Base obj = new AlibabaJsonLIbraryExample();
		obj.fun();
	}

}
