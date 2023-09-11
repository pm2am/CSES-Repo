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
		
		long n = sc.ni();
		pw.println(modExpo(2L,n));
		
		pw.close();
	} 
	
	static final long M = 1000000007L;
	
	private static long modExpo(long a,long b) {
		long res=1L;
		a = a%M;
		if(a==0)
			return 0;
		while(b>0) {
			if(b%2==1) {
				res = (res*a)%M;
			}
			a = (a *a)%M;
			b = b>>1;
		}
		return res;
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
