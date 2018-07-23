package DSA.TwoPointers.ReadCharactersFromFileMultipleCalls;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

/*
 * Call once: Assume you are always going to read from the start of the file/bufer.
 * Call multiple times: Start reading from where you left off. This means that you have to
 * store the last place (ptr) where you stopped and store the read but uncopied bytes to the buffer.
 * I think code wise it should be same for both the cases except that the pointer from where to start
 * reading the internal read4 buffer, the internal read4 buffer itself and the
 * number of bytes to be read from that buffer, need to be stored in the 2nd case.
 */

public class Solution extends Reader4 {
    /**
     * @param buf
     *            Destination buffer
     * @param n
     *            Maximum number of characters to read
     * @return The number of characters read
     */
    char[] buffer = new char[4];
    int    head   = 0;
    int    tail   = 0;

    // input buffer is the destination
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            // if queue is empty, or head and tail is pointing to 4
            if (head == tail) {
                head = 0;
                tail = read4(buffer); // enqueue 4 to buffer

                // if nothing left, exit
                if (tail == 0) {
                    break;
                }
            }
            // dequeue to destination buf
            while (i < n && head < tail) {
                buf[i++] = buffer[head++];
            }
        }
        return i;
    }
}