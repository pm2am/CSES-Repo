import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

	static TreeSet<String> set;
	static char[] ch;
	static boolean[] vis;
	
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		FastScanner sc =  new FastScanner();
		
		set = new TreeSet<>();
		ch = sc.ne(0).toCharArray();
		vis = new boolean[ch.length];
		permutation("");
		pw.println(set.size());
		for(String st: set) {
			pw.println(st);
		}
		pw.close();
	} 
	
	static void permutation(String pe) {
		if(pe.length() == ch.length) {
			set.add(pe);
			return;
		}
		for(int i=0;i<ch.length;i++) {
			if(vis[i]) continue;
			vis[i] = true;
			permutation(pe+ch[i]);
			vis[i] = false;
		}
	}
	
	   static class FastScanner {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer("");
			
			public String ne() {
				while (!st.hasMoreElements())
					try {
						st=new StringTokenizer(br.readLine());
					} catch (IOException e) {
						e.printStackTrace();
					}
				return st.nextToken();
			}
			public String ne(int k) {
				try {
					return br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "Not able to read";
			}
			
			int ni() {
				return Integer.parseInt(ne());
			}
			
			long nl() {
				return Long.parseLong(ne());
			}
			
			double nd() {
				return Double.parseDouble(ne());
			}
			
		    
		}

}
