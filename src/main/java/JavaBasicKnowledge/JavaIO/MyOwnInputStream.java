package JavaBasicKnowledge.JavaIO;

import java.io.*;

/**
 * Created by kevin on 16-8-11.
 */
public class MyOwnInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected MyOwnInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = 0;
        if ((c = super.read()) != -1) {
            if (Character.isLowerCase((char) c)) {
                return Character.toUpperCase((char) c);
            } else if (Character.isUpperCase((char) c)) {
                return Character.toLowerCase((char) c);
            } else {
                return c;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int c;
        try {
            InputStream is = new MyOwnInputStream(new BufferedInputStream(new FileInputStream("daemon.txt")));
            while ((c = is.read()) >= 0) {
                System.out.print((char) c);
            }
            is.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println(1 + 2 + "");
        System.out.println("" + 1 + 2);
    }
}
