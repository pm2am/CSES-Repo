import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static char[][] ch;
	static boolean[] col,dia,idia;
	static int ans = 0;
	public static void main(String[] args) {
		PrintWriter pw = new PrintWriter(System.out);
		FastScanner sc =  new FastScanner();
		
		ch = new char[8][8];
		for(int i=0;i<8;i++) {
		
			ch[i] = sc.ne().toCharArray();
		}
		col = new boolean[8];
		dia = new boolean[15];
		idia = new boolean[15];
		backtrack(0);
		pw.print(ans);
		
		pw.close();
	} 
	
	static void backtrack(int y) {
		if (y==8) {
			ans++;
			return;
		}
		for(int x=0;x<8;x++) {
			if(ch[y][x] =='*'|| col[x] || dia[x+y] || idia[x-y+7]) continue;
			col[x] = dia[x+y] = idia[x-y+7] = true;
			backtrack(y+1);
			col[x] = dia[x+y] = idia[x-y+7] = false;
		}
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
