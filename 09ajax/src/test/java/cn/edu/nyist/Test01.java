package cn.edu.nyist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Test01 {

	public static void main(String[] args) {
		// 1 ���ɣ�Java����--->json������������ַ�
		// List---->json����
		// Set--->json����
		// ����--->json����
		// map--->json����
		List<String> ls = new ArrayList<String>();
		ls.add("xiaosb");
		ls.add("dasb");
		JSONArray jsonArray = new JSONArray(ls);
		System.out.println(jsonArray.toString());
		Map<String, Object> map = new HashMap<>();
		map.put("name", "zhangsan");
		map.put("pwd", "123");
		JSONObject jsonObject = new JSONObject(map);
		System.out.println(jsonObject.toString());

	}

}
