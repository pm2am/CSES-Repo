import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
 
public class Main {
		
	private static int N = 7;
	private static int G_SIZE = 9;
	private static int[] dx = {-1,0,1,0};
	private static int[] dy = {0,1,0,-1};
	private static int[] path;
	private static boolean[][] isGood;
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
		Reader s = new Reader();
		char[] ch = s.readLine().toCharArray();
		ans = 0;
		path = new int[48];
		isGood = new boolean[G_SIZE][G_SIZE];
		for(int i=0;i<48;i++) {
			if(ch[i]=='U') path[i] = 0;
			else if(ch[i]=='R') path[i] = 1;
			else if(ch[i]=='D') path[i] = 2;
			else if(ch[i]=='L') path[i] = 3;
			else path[i] = 4;
		}
		
		for(int i=0;i<9;i++) {
			isGood[i][0] = true;
			isGood[i][8] = true;
			isGood[0][i] = true;
			isGood[8][i] = true;
		}
		for(int i=1;i<8;i++) {
			for(int j=1;j<8;j++) {
				isGood[i][j] = false;
			}
		}
		
		dfs(0,1,1);
		pw.println(ans);
		
		pw.close();
	} 
	
	static void dfs(int index, int x, int y) {
		if(isGood[x][y-1] && isGood[x][y+1] && (!isGood[x-1][y]&&!isGood[x+1][y])) {
			return;
		}
		
		if(isGood[x-1][y] && isGood[x+1][y] && (!isGood[x][y-1] && !isGood[x][y+1])) {
			return;
		}
		
		if(x==7&&y==1) {
			if (index==48) {
				ans++;
			}
			return;
		}
		
		if(index == 48) return;
		
		isGood[x][y] = true;
		
		if(path[index]==4) {
			for(int i=0;i<4;i++) {
				int nextx = x + dx[i];
				int nexty = y + dy[i];
				if(!isGood[nextx][nexty]) {
					dfs(index+1, nextx, nexty);
				}
			}
			
		} else {
			int nextx = x + dx[path[index]];
			int nexty = y + dy[path[index]];
			if(!isGood[nextx][nexty]) {
				dfs(index+1, nextx, nexty);
			}
		}
		
		isGood[x][y] = false;
		
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