import java.io.IOException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
 
public class Main {
	static final class Node {
		int x,y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		final PrintWriter pw = new PrintWriter(System.out);
        final Reader sc = new Reader();
        final StringBuffer buf = new StringBuffer();
        
        final int n = sc.nextInt();
        final int k = sc.nextInt();
        final TreeSet<Node> first = new TreeSet<>((a,b)-> {
        	if(a.x==b.x) return a.y-b.y;
        	return b.x-a.x;
        });
        final TreeSet<Node> second = new TreeSet<>((a,b)-> {
        	if(a.x==b.x) return a.y-b.y;
        	return a.x-b.x;
        });
        final Node[] a = new Node[n];
        int s1 = (k+1)/2;
        for(int i=0;i<n;i++) {
        	final Node ne = new Node(sc.nextInt(),i);
        	a[i] = ne;
        	if (i<k) {
            	if(i<s1) {
            		first.add(ne);
            	} else {
            		first.add(ne);
            		second.add(first.pollFirst());
            	}
            	if(i==k-1) {
            		buf.append(first.first().x+" ");
            	}
        	} else {
            	final Node rm = a[i-k];
            	if(first.contains(rm)) {
            		first.remove(rm);
            		second.add(ne);
            		first.add(second.pollFirst());
            	} else {
            		second.remove(rm);
            		first.add(ne);
            		second.add(first.pollFirst());
            	}
            	buf.append(first.first().x+" ");
        	}
        }
        pw.print(buf);
 
        pw.close();
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