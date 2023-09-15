import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		FastScanner sc = new FastScanner();
		
		int n = sc.ni();
		int m = sc.ni();
		int k = sc.ni();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			pq.add(sc.ni()); 
		}
		for(int i=0;i<m;i++) {
			pq2.add(sc.ni());
		}
		
		int ans = 0;
		
		while(!pq.isEmpty()&&!pq2.isEmpty()) {
			int a = pq.peek();
			int b = pq2.peek();
			if(Math.abs(a-b)<=k) {
				ans++;
				pq.poll();
				pq2.poll();
			} else {
				if(a-b>k) {
					pq2.poll();
				} else {
					pq.poll();
				}
			}
		}
		
		pw.println(ans);
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