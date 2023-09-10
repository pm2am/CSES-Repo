import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		FastScanner sc =  new FastScanner();
		
		int n = sc.ni();
		
		if (n==1) {
			pw.println("1");
		} else if(n<4) {
			pw.println("NO SOLUTION");
		} else if(n==4) {
			pw.println("2 4 1 3");
		} else {
			int[] a = new int[n];
			int num = 1;
			for(int i=0;i<n;i+=2) {
				a[i] = num++;
			}
			for(int i=1;i<n;i+=2) {
				a[i] = num++;
			}
			for(int i: a) {
				pw.print(i+" ");
			}
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
