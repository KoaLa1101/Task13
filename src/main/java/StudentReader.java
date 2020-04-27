import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.CharBuffer;
import java.nio.file.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;

public class StudentReader extends Reader {
    FileReader reader;
    ObjectMapper mapper;

    public StudentReader(Path path) throws IOException {
        if(Files.exists(path) && !Files.isDirectory(path))
            reader = new FileReader(path.toAbsolutePath().normalize().toString());
        else throw new IOException("Error in the path");
        mapper = new ObjectMapper();
    }

    public Student readStudent() throws IOException {
        return mapper.readValue(reader, Student.class);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return reader.read(cbuf, off, len);
    }

    @Override
    public boolean ready() throws IOException {
        return reader.ready();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    @Override
    public int read(CharBuffer target) throws IOException {
        return reader.read(target);
    }

    @Override
    public int read(char[] cbuf) throws IOException {
        return reader.read(cbuf);
    }

    @Override
    public long skip(long n) throws IOException {
        return reader.skip(n);
    }

    @Override
    public boolean markSupported() {
        return reader.markSupported();
    }

    @Override
    public void mark(int readAheadLimit) throws IOException {
        reader.mark(readAheadLimit);
    }

    @Override
    public void reset() throws IOException {
        reader.reset();
    }

    public String getEncoding() {
        return reader.getEncoding();
    }

    @Override
    public int read() throws IOException {
        return reader.read();
    }
}
