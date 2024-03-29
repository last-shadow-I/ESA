package com.example.lab2.filter;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResettableServletInputStream extends ServletInputStream {

    public InputStream inputStream;

    private final ServletInputStream servletInputStream = new ServletInputStream(){
        boolean isFinished = false;
        boolean isReady = true;
        ReadListener readListener = null;
        public int read() throws IOException {
            int i = inputStream.read();
            isFinished = i == -1;
            isReady = !isFinished;
            return i;
        }

        @Override
        public boolean isFinished() {
            return isFinished;
        }

        @Override
        public boolean isReady() {
            return isReady;
        }

        @Override
        public void setReadListener(ReadListener readListener) {
            this.readListener = readListener;
        }
    };

    public int available() throws IOException {
        return inputStream.available();
    }

    public void close() throws IOException {
        inputStream.close();
    }

    public void mark(int readLimit){
        inputStream.mark(readLimit);
    }

    public boolean markSupported(){
        return inputStream.markSupported();
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return inputStream.read(b,off,len);
    }

    public void reset() throws IOException {
        inputStream.reset();
    }

    public long skip(long n) throws IOException {
        return inputStream.skip(n);
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public void setReadListener(ReadListener readListener){
        servletInputStream.setReadListener(readListener);
    }

    public boolean isReady() {
        return servletInputStream.isReady();
    }

    public boolean isFinished() {
        return servletInputStream.isFinished();
    }
}
