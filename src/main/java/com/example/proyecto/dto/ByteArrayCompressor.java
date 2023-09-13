package com.example.proyecto.dto;
import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;

public class ByteArrayCompressor {
	public static byte[] compressByteArray(byte[] bytes) {
        Deflater deflater = new Deflater();
        deflater.setInput(bytes);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(bytes.length);

        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }

        deflater.end();
        byte[] compressedBytes = outputStream.toByteArray();

        return compressedBytes;
    }
}
