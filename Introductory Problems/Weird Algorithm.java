import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		FastScanner sc =  new FastScanner();
		
		long n = sc.ni();
		while(n!=1) {
			pw.print(n+" ");
			if ((n & 1)==0) {
				n = (n>>1);
			} else {
				n= 3*n+1;
			}
		}
		pw.print(1);
		pw.close();
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
