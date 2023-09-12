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
		long[] a = new long[n];
		long sum = 0;
		for(int i=0;i<n;i++) {
			a[i] = sc.ni();
			sum += a[i];
		}
		pw.println(subset(a,n,0,sum,sum));
		
		
		pw.close();
	} 
	
	static long subset(long[] a, int n, long curSum, long sum, long min) {
		if(n==0) {
			return Math.min(min, Math.abs(curSum - (sum - curSum)));
		}
		long min1 = subset(a, n-1, curSum, sum, min);
		long min2 = subset(a, n-1, curSum + a[n-1], sum, min);
		
		return Math.min(min1, min2);
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
