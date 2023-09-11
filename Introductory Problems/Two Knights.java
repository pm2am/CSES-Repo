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
		for(long i=1;i<=n;i++) {
			if(i==1) {
				pw.println("0");
				continue;
			}
			long allPossibleCombinations = (i*i*i*i - i*i)/2;
			long numberof2x3 = (i-1) * (i-2) * 2;
			long ans = allPossibleCombinations - numberof2x3 * 2;
			pw.println(ans);
		}
		
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
