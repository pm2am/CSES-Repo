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
		
		char[] ch = sc.ne(0).toCharArray();
		int[] hs = new int[26];
		for(int i=0;i<ch.length;i++) {
			hs[ch[i]-'A']++;
		}
		boolean flag, odd;
		int index = -1;
		flag = odd = true;
		
		for(int i=0;i<26;i++) {
			if(hs[i]%2==1 && !odd) {
				flag = false;
				break;
			} else if(hs[i]%2==1) {
				odd = false;
				index = i;
			}
		}
		
		if(!flag) {
			pw.println("NO SOLUTION");
		} else {
			if(index!=-1) {
				ch[ch.length/2] = (char) (index + 'A');
				hs[index]--;
			}
			index= 0;
			for(int i=0;i<26;i++) {
				while(hs[i]>0) {
					ch[index] = ch[ch.length-index-1] = (char)(i + 'A');
					hs[i] -=2;
					index++;
				}
			}
			pw.println(new String(ch));
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
