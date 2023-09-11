import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

	static List<String> ans;
	
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		FastScanner sc =  new FastScanner();
		ans = new ArrayList<>();
		
		int n = sc.ni();
		towerOfHanoi(n,1,2,3);
		pw.println(ans.size());
		for(String st : ans) {
			pw.println(st);
		}
		
		pw.close();
	} 
	
	private static void towerOfHanoi(int n, int st, int mi, int en) {
		if(n==1) {
			ans.add(st + " " + en);
			return;
		} 
		
		towerOfHanoi(n-1,st,en,mi);
		ans.add(st + " " + en);
		towerOfHanoi(n-1,mi,st,en);
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
