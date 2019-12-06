package test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;

public class FileUrlTest {
	
	public static void main(String[] args) throws IOException {
		URLConnection conn = new File("E:\\Desktop\\Daniel\\nohup.20190917.02.log").toURL().openConnection();
		conn.connect();
		System.out.println(conn.getContentEncoding());
		System.out.println(conn.getContentLength());
	}

}
