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
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter(System.out);
        Reader sc = new Reader();
        StringBuffer buffer = new StringBuffer();
        TreeSet<Node> pq = new TreeSet<>(new Comparator<>() {
			@Override
			public int compare(Main.Node o1, Main.Node o2) {
				return o1.x - o2.x;
			}
        });
        HashMap<Integer, Node> mp = new HashMap<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        long ans=0;
        int last=0;
        for(int i=0;i<n;i++) {
        	int t = sc.nextInt();
        	if (mp.containsKey(t)) {
        		Node no = mp.get(t);
        		pq.remove(no);
        		no.x = i;
        		pq.add(no);
        	} else {
        		if (pq.size()==k) {
        			Node no = pq.pollFirst();
        			mp.remove(no.y);
        			last = no.x+1;
        		}
        		Node no = new Node(i,t);
    			mp.put(t, no);
    			pq.add(no);
        	}
        	ans = ans+(i-last+1);
        }
        buffer.append(ans);
        
        pw.print(buffer);
 
        pw.close();
	} 
	
	private static int[] findPrimes(int M) {
		int[] primes = new int[M];
		primes[0] = primes[1] = 1;
		for(long i=2;i<M;i++) {
			primes[(int)i] = (int)i;
		}
		for(long i=2;i*i<M;i++) {
			int t = (int)i;
			if(primes[t]==t) {
				for(long j = i*i;j<M;j+=i) {
					int t1 = (int)j;
					if(primes[t1] == t1) {
						primes[t1] = t;
					}
				}
			}
		}
		return primes;
	}
	
	private static long modPow(long p, long q, long M) {
		if(q==0&&p==0) return 1;
		if(p==0) return 0;
		long p1 = 1L;
		while(q>0) {
			if((q&1L)==1) {
				p1 = (p1*p)%M;
			}
			p = (p*p)%M;
			q = (q>>1L);
		}
		return p1;
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
 
}