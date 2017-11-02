package DSA.Misc.ReadCharactersFromFileMultipleCalls;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class Solution extends Reader4 {
/**
* @param buf destination buffer
* @param n maximum number of characters to read
* @return the number of characters read
*/
char[] buffer = new char[4];
int head = 0, tail = 0;

public int read(char[] buf, int n) {
  // Write your code here
  int i = 0;
  while (i < n) {
      if (head == tail) {               // queue is empty
          head = 0;
          tail = read4(buffer);         // enqueue
          if (tail == 0) {
              break;
          }
      }
      while (i < n && head < tail) {
          buf[i++] = buffer[head++];    // dequeue
      }
  }
  return i;
}
}