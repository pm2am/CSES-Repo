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
		long sum = n * (n+1)/2;
		Set<Long> set = new HashSet<>();
		
		
		if(sum%2!=0) {
			pw.println("NO");
		} else {
			pw.println("YES");
			for(long i=1;i<=n;i++) {
				set.add(i);
			}
			long temp = sum/2;
			List<Long> li = new ArrayList<>();
			long num = n;
			while(temp > 0) {
				li.add(num);
				set.remove(num);
				temp = temp - num;
				if(temp < num) {
					num = temp;
				} else  {
					num--;
				}
			}
			pw.println(li.size());
			for(long i: li) {
				pw.print(i+" ");
			}
			pw.println("\n"+set.size());
			for(long i: set) {
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
