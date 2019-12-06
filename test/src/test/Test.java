package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;



public class Test {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, OgnlException {
		
		HashMap classMap = new HashMap();
		classMap.put("attachment", HashMap.class);
		classMap.put("main_doc", HashMap.class);
		classMap.put("opinions", HashMap.class);
		classMap.put("forms", HashMap.class);
		classMap.put("form_file", HashMap.class);
		classMap.put("handle_opinion", HashMap.class);
		//classMap.put("net.sf.json.JSONObject", "java.util.HashMap");
		
		JsonConfig jc = new JsonConfig();
		jc.setCollectionType(java.util.ArrayList.class);
		jc.setRootClass(HashMap.class);
		jc.setClassMap(classMap);
		
		
		String str = IOUtils.toString(new FileInputStream("E:\\OneDrive\\设计\\公文直报\\公文直报意见返回.code-workspace"),"utf8");
		JSONObject jobj = JSONObject.fromObject(str);
		
		Map m = (Map) JSONObject.toBean(jobj,jc);
		
		System.out.println(Ognl.getValue("forms", m));
		System.out.println(Ognl.getValue("title", m));
		System.out.println(Ognl.getValue("forms.{^ #this.form_type=='文件呈批表'}.(#this.size > 0 ? #this[0].emergency_degree : null)", m));
		System.out.println(Ognl.getValue("forms.{^ #this.form_type=='发文办理笺'}.(#this.size > 0 ? #this[0].emergency_degree : null)", m));
		System.out.println(Ognl.getValue("forms.{^ #this.form_type=='999'}.(#this.size > 0 ? #this[0].emergency_degree : null)", m));
		System.out.println(Ognl.getValue("title + ' ' + _timestamp", m));
		
		System.out.println("abc.doc".substring("abc.doc".lastIndexOf(".")+1));
		System.out.println("abc.".substring("abc.".lastIndexOf(".")+1));
		
		
	}

}
