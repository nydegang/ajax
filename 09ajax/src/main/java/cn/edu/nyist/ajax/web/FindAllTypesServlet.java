package cn.edu.nyist.ajax.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import cn.edu.nyist.ajax.biz.TypeBiz;
import cn.edu.nyist.ajax.biz.impl.TypeBizImpl;
import cn.edu.nyist.ajax.vo.TypeVo;


@WebServlet("/findAllTypes")
public class FindAllTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FindAllTypesServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1���ղ���
		String  cb=request.getParameter("cb");
		 if (cb==null||cb.equals("")) {//����ľ�д���
			cb="cb";
		}
		//2����ҵ���
		TypeBiz typeBiz=new TypeBizImpl();
		 List<TypeVo> vos=typeBiz.findAllTypes();
		 //3 ���ͻ��˷���js
		 response.setContentType("text/javascript;charset=utf-8");
		/* JSONArray jsonArray=new JSONArray(vos);
		 String jsArr=jsonArray.toString();*/
		 //��mapת��Ϊjson
		 Map<String,Object> map=new HashMap<>();
		 map.put("vos", vos);
		 JSONObject jsonObject=new JSONObject(map);
		 String jsObj=jsonObject.toString();
		 //json������亯������-----jsonp
		 //{"vos":[{"name":"������","id":1},{"name":"���","id":2},{"name":"���","id":3}]}-----json��ʽ
		 response.getWriter().write(cb+"("+jsObj+");");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
