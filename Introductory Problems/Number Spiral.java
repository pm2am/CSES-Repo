import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		FastScanner sc =  new FastScanner();
		
		int T = sc.ni();
		while(T-->0) {
			long x,y;
			x = sc.ni();
			y = sc.ni();
			long max = (x>y)?x:y;
			long min = (x<y)?x:y;
			long dia = max * (max-1) + 1;
			if(max==min) {
				pw.println(dia);
			} else if (max%2==0) {
				if(x==min) {
					dia = dia - (max-min);
				} else {
					dia = dia + (max - min);
				}
				pw.println(dia);
			} else {
				if(x==min) {
					dia = dia + (max-min);
				} else {
					dia = dia - (max - min);
				}
				pw.println(dia);
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
