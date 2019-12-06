package classanalysis;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DynamicClassLoader extends ClassLoader {
	
	public enum Type{
		PROJECT,PRODUCT;
	}
	
	private Type type;
	
	private String basePath;
	
	public DynamicClassLoader(Type type) throws IOException {
		super();
		this.type = type;
		String path;
		if(this.type == Type.PRODUCT) {
			path = "product\\";
		}else {
			path = "project\\";
		}
		basePath = path;
	}
	
	private static byte[] loadBytesFromInputStream(InputStream in) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			int readed;
			while((readed = in.read()) != -1) {
				bos.write(readed);
			}
			return bos.toByteArray();
		}finally {
			bos.close();
		}
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String actual = name.replace(".", "\\").concat(".class");
		
		byte[] classBytes = getBytes(actual, "missiveEJB");
		if(null == classBytes)
			classBytes = getBytes(actual, "missive");
		if(null == classBytes)
			throw new ClassNotFoundException(name);
		Class<?> c = this.defineClass(name ,classBytes, 0, classBytes.length);
		
		return c;
	}
	
	public byte[] getBytes(String actualName,String packageName) {
		String fullPath = "E:\\workspace\\EclipseProjects\\gdszfbgt\\gdszf_project\\test\\resource\\" + basePath + packageName + "\\" + actualName;
		File f = new File(fullPath);
		if(!f.exists()) {
			return null;
		}else {
			InputStream in = null;
			try {
				in = new FileInputStream(f);
				return loadBytesFromInputStream(in);
			}catch(IOException e) {
				e.printStackTrace();
				return null;
			}finally {
				if(null != in)
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if(!name.startsWith("com.excellence.platform.missive"))
			return super.loadClass(name);
		return this.findClass(name);
	}

}
