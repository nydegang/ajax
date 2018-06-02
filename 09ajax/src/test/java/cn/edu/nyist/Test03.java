package cn.edu.nyist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.edu.nyist.ajax.vo.TypeVo;

public class Test03 {

	public static void main(String[] args) throws IOException {
		//����
		ObjectMapper objectMapper=new ObjectMapper();
		List<TypeVo>  ls=new ArrayList<>();
		ls.add(new TypeVo(1, "������"));
		ls.add(new TypeVo(2, "���"));
		String jsonStr=objectMapper.writeValueAsString(ls);
		System.out.println(jsonStr);
		//����:json����--->java����
	   TypeVo vo= objectMapper.readValue("{\"id\":1,\"name\":\"������\"}", TypeVo.class);
	   System.out.println(vo);
	   

	}

}
