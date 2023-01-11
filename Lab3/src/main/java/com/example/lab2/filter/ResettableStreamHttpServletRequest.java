package com.example.lab2.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import org.apache.commons.io.IOUtils;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import jakarta.servlet.ServletInputStream;

public class ResettableStreamHttpServletRequest extends HttpServletRequestWrapper{

    private byte[] rawData = {};
    private final HttpServletRequest request;
    private final ResettableServletInputStream servletStream;


    public ResettableStreamHttpServletRequest(HttpServletRequest request) throws IOException {
        super(request);
        this.request = request;
        this.servletStream = new ResettableServletInputStream();
    }

    private void initRawData() throws IOException {
        if ( rawData.length == 0 ) {
            byte[] b = IOUtils.toByteArray(this.request.getInputStream());
            if ( b != null )
                rawData = b;
        }
        servletStream.inputStream = new ByteArrayInputStream(rawData);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        initRawData();
        return servletStream;
    }

    public BufferedReader getReader() throws IOException {
        initRawData();
        String encoding = getCharacterEncoding();
        if ( encoding != null ) {
            return new BufferedReader(new InputStreamReader(servletStream, encoding));
        } else {
            return new BufferedReader(new InputStreamReader(servletStream));
        }
    }
}
