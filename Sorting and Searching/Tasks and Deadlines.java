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
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->{
        	if(a.x==b.x) return a.y - b.y;
        	return a.x -b.x;
        });
        int n = sc.nextInt();
        while(n-->0) {
        	int a = sc.nextInt();
        	int d = sc.nextInt();
        	pq.add(new Node(a,d));
        }
        long ans = 0;
        long f = 0;
        while(!pq.isEmpty()) {
        	Node node = pq.poll();
        	f = f + node.x;
        	ans = ans + node.y - f;
        }
        buffer.append(ans);
        
        
        
        
        pw.print(buffer);

        pw.close();
	} 

	private static int findMaxGCD(int max, int[] co) {
		for(int i = max; i>=1;i--) {
			int c = 0;
			int j = i;
			while(j<=max) {
				if(co[j]>0)
					c += co[j];
				j+=i;
				if(c>=2)
					return i;
			}
		}
		return 1;
	}
	
	private static int count(int n, int[] primes) {
		HashMap<Integer, Integer> mp = new HashMap<>();
		while(n>1) {
			int prime = primes[n];
			if(mp.containsKey(prime)) {
				mp.put(prime, mp.get(prime)+1);
			} else {
				mp.put(prime,1);
			}
			n = n/prime;
		}
		int res = 1;
		for(int i : mp.values()) {
			res = res * (i+1);
		}
		return res;
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