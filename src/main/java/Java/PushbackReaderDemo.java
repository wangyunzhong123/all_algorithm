package Java;

/**
 * Created by yzwang on 2019/8/5.
 */
import java.io.*;

public class PushbackReaderDemo {

    public static void main(String[] args) {

        String s = "Hello 1234567";

        // create a new StringReader
        StringReader sr = new StringReader(s);

        // create a new PushBack reader based on our string reader
        PushbackReader pr = new PushbackReader(sr, 20);

        try {
            // read the first five chars
            for (int i = 0; i < 8; i++) {
                char c = (char) pr.read();
                System.out.print("" + c);
            }

            // change line
            System.out.println();

            // create a new array to unread
            char cbuf[] = {'w', 'o', 'r', 'l', 'd'};

            // unread into cbuf
            pr.unread(97);

            // read five chars, which is what we unread from cbuf
            for (int i = 0; i < 8; i++) {
                char c = (char) pr.read();
                System.out.print("" + c);
            }

            // close the stream
            pr.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}