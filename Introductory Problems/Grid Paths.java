import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
 
public class Main {
 
	static int N = 7;
	static boolean[][] vis;
	static char[] chs;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
//		FastScanner sc =  new FastScanner();
		Reader sc = new Reader();
		ans = 0;
		vis = new boolean[N][N];
		chs = sc.readLine().toCharArray();
		dfs(0,0,-1,'e');
		pw.println(ans);
		
		pw.close();
	} 
	
	static void dfs(int x,int y, int pos, char ch) {
		if (pos>48 || vis[x][y])
			return;
		
		if(pos>0 && pos<48 && chs[pos]!='?' && chs[pos]!=ch) {
			return;
		}
		
		if(x==N-1&&y==0) {
			if(pos==47) {
				ans++;
			}
			return;
		}
		
		vis[x][y] = true;
		
		if(!isNotGood(x+1,y,ch)) {
			dfs(x+1,y,pos+1,'D');
		}
		
		if(!isNotGood(x,y+1,ch)) {
			dfs(x,y+1,pos+1,'R');
		}
		
		if(!isNotGood(x-1,y,ch)) {
			dfs(x-1,y,pos+1,'U');
		}
		
		if(!isNotGood(x,y-1,ch)) {
			dfs(x,y-1,pos+1,'L');
		}
		
		vis[x][y] = false;
		
		
	}
	
	static boolean isNotGood(int x,int y,char ch) {
		if(isNotValid(x,y)) {
			return true;
		}
		boolean check = false;
		if(ch=='U') {
			check = isNotValid(x-1,y) && !isNotValid(x,y+1) && !isNotValid(x,y-1);
		} else if(ch=='D') {
			check = isNotValid(x+1,y) && !isNotValid(x,y+1) && !isNotValid(x,y-1);
		} else if(ch=='L') {
			check = isNotValid(x,y-1) && !isNotValid(x+1,y) && !isNotValid(x-1,y);
		} else if(ch=='R') {
			check = isNotValid(x,y+1) && !isNotValid(x+1,y) && !isNotValid(x-1,y);
		}
		return check;
	}
	
	static boolean isNotValid(int x,int y) {
		return x<0||x>N-1||y<0||y>N-1||vis[x][y];
	}
	
	static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
  
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
  
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
  
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
  
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
  
            if (neg)
                return -ret;
            return ret;
        }
  
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
  
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
  
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
  
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
  
            if (neg)
                return -ret;
            return ret;
        }
  
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
  
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
  
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
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