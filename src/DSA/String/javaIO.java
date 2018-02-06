package DSA.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class javaIO {
    /**
     * Read from a file
     *
     * @throws IOException
     */
    public String readFile(String path) throws IOException {
        File file = new File(path);
        FileInputStream stream = new FileInputStream(file); // use stream to read file
        InputStreamReader reader = new InputStreamReader(stream); // reader read from stream
        BufferedReader br = new BufferedReader(reader); // use buffer to improve reader's io efficiency


        StringBuilder result = new StringBuilder();
        String line = "";
        while (line != null) {
            line = br.readLine();
            result.append(line + "\n");
        }
        br.close(); // remember to release the buffer
        return result.toString();
    }

    /**
     * Write into a new file
     *
     * @throws IOException
     */
    public void writeFile(String s) throws IOException {

        File file = new File("newfile.md");
        file.createNewFile();
        FileOutputStream stream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(s);
        bw.flush(); // push content from buffer to the file
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        // pwd in java
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        javaIO test = new javaIO();
        String input = test.readFile("F:\\testlog.txt");
        test.writeFile(input);
    }
}