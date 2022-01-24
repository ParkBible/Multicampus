//연습코드

import java.util.Map;
import java.util.HashMap;

class Spark{
}

public class Test146{
	public static void main(String[] args){
		Map<String,Object> map = new HashMap<String, Object>();
		
		Object val = map.get("Spark"); // 키값은 Spark
		// 지금은 들어가있는게 없으므로 null이 나온다.
		if(val == null){
			val = new Spark();
			map.put("Spark", val);
		}
		System.out.println(val);
		
		
		Object val2 = map.get("Spark"); // 키값은 Spark
		if(val2 == null){    // 두번째는 null이 아니다.
			val2 = new Spark();
			map.put("Spark", val2);
		}
		System.out.println(val2);
	}
}