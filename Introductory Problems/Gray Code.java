import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		FastScanner sc =  new FastScanner();
		
		int n = sc.ni();
		List<String> ans = gray(n, "");
		for(String st: ans) {
			pw.println(st);
		}
		
		pw.close();
	} 
	
	private static List<String> gray(int n, String ch) {
		if(n == 0) {
			List<String> li = new ArrayList<>();
			li.add(""+ch);
			return li;
		} else {
			List<String> first = gray(n-1, "0");
			List<String> second = gray(n-1,"1");
			List<String> res = new ArrayList<>();
			for(String st: first) {
				res.add(ch+st);
			}
			for(int i=second.size()-1;i>=0;i--) {
				res.add(ch+second.get(i));
			}
			return res;
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
