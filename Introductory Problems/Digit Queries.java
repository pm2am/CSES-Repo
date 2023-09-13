import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	// 1 2 3 4 5 6 7 8 9 10 11 12 13
	// 1 2 3 4 5 6 7 8 9 1  1   1  2
	
	// 1 2 3 4 
	// 1 1 1 2
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		FastScanner sc =  new FastScanner();

		int q = sc.ni();
		while(q-->0) {
			long n = sc.nl();
			long place = 1L;
			long num = 9L;
			if(n<=9) {
				pw.println(n);
				continue;
			}
			while(n > num * place) {
				n = n - num * place;
				place++;
				num = num*10L;
			}
			//  1 0 0 1 0 1 1 0 2 1  0  3  1  0  4  1  0  5  1  0  6  1  0  7  1  0  8  1  0  9  1  1  0
			//  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33
			long pos = n % place;
			long div;
			if(pos==0) {
				div = place*10L;
				n = (n % div);
				if(n==0) {
					n = div;
				}
				long ans = n / place -1L;
				pw.println(ans);
			} else {
				div = place;
				for(int i=0;i<place-pos+1;i++) {
					div = div * 10L;
				}
				n = (n % div);	
				div = div/10L;
				if(n==0) {
					n = div;
				}
				
				long ans = n / div;
				if (pos==1) {
					ans++;
				}
				pw.println(ans);
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
