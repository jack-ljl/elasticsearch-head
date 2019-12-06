package test;

import java.util.HashMap;

import com.lowagie.tools.handout_pdf;

public class HashMapTest {
	
		static class KeyObject{
			String value;
			KeyObject(String value){
				this.value = value;
			}
			@Override
			public boolean equals(Object obj) {
				if(obj == null || !(obj instanceof String))
					return false;
				return this.value.equals(obj);
			}
			@Override
			public int hashCode() {
				return 1;
			}
			@Override
			public String toString() {
				return this.value.toString();
			}
		}
		
		public static void main(String[] args) {
			HashMap<KeyObject, Boolean> map = new HashMap<HashMapTest.KeyObject, Boolean>();
			for(int i = 0;i<=64;i++) {
				map.put(new KeyObject(String.valueOf(i)), true);
			}
			System.out.println(map);
			System.out.println();
			
		}
	

}
