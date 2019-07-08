package com.example.demo;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class FileAccessTest {

    @Test
    public void readFile() throws IOException {
        @Cleanup
        RandomAccessFile randomAccessFile = new RandomAccessFile("/1.txt", "r");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(20);
        int read = channel.read(buffer);
        while (read != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            read = channel.read(buffer);
        }
//        randomAccessFile.close();
    }
}
