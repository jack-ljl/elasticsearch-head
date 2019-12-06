package classanalysis;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import classanalysis.DynamicClassLoader;
import classanalysis.DynamicClassLoader.Type;

public class ClassAnalysis {
	
	static final ClassLoader PRODUCT;
	
	static final ClassLoader PROJECT;
	
	static {
		try {
			PRODUCT = new DynamicClassLoader(Type.PRODUCT);
			PROJECT = new DynamicClassLoader(Type.PROJECT);
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		String className = "com.excellence.platform.missive.session.missiveprocessor.ejb.MissiveProcessorEJB";
		Class<?> productClass = PRODUCT.loadClass(className);
		Class<?> projectClass = PROJECT.loadClass(className);
		System.out.println("=============productClass - projectClass=============");
		printDifferenceSet(productClass, projectClass);
		System.out.println("=============projectClass - productClass=============");
		printDifferenceSet(projectClass, productClass);
	}
	
	
	public static void printDifferenceSet(Class c1,Class c2) {
		Method[] c1DeclaredMethods = c1.getDeclaredMethods();
		Method[] c2DeclaredMethods = c2.getDeclaredMethods();
		Set<String> c1MethodSet = methodArrayToSet(c1DeclaredMethods);
		Set<String> c2MethodSet = methodArrayToSet(c2DeclaredMethods);
		c1MethodSet.removeAll(c2MethodSet);
		for(String method : c1MethodSet) {
			System.out.println(method);
		}
	}
	
	public static Set<String> methodArrayToSet(Method[] methods){
		Set<String> hashSet = new HashSet<String>();
		for(Method method:methods) {
			hashSet.add(method.toString());
		}
		return hashSet;
	}
	
}
