import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
 
public class Main {
	
	static class Node {
		int x,y;
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		FastScanner sc = new FastScanner();
		
		final int max = 2000001;
		
		TreeSet<Node> pq = new TreeSet<>(new Comparator<>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.x == o2.x) {
					return o1.y - o2.y;
				}
				return o1.x - o2.x;
			}
			
		});
		
		int n = sc.ni();
		int m = sc.ni();
		for(int i = 0;i<n;i++) {
			int st = sc.ni();
			Node ne = pq.lower(new Node(st,max));
			if(ne!=null&&ne.x == st) {
				pq.add(new Node(st, ne.y+1));
			} else {
				pq.add(new Node(st, 0));
			}
		}
		
		while(m-->0) {
			int tt = sc.ni();
			Node ne = pq.lower(new Node(tt, max));
			if(ne==null) {
				pw.println(-1);
			} else {

				pw.println(ne.x);
				pq.remove(ne);
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