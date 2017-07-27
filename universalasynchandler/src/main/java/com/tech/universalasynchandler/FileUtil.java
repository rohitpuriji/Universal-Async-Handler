/*
 * FileUtil.java 
 */

package com.tech.universalasynchandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil
{
    private static final int BUFFER_SIZE = 1024; // 1kb

    public static byte[] toByteArray(InputStream in) throws IOException
    {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copyStream(in, out);
        return out.toByteArray();
    }

    private static long copyStream(InputStream from, OutputStream to) throws IOException
    {
        byte[] buf = new byte[BUFFER_SIZE];
        long total = 0;
        while (true)
        {
            int r = from.read(buf);
            if (r == -1)
            {
                break;
            }
            to.write(buf, 0, r);
            total += r;
        }
        return total;
    }

}
