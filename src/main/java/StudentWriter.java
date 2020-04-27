import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;

public class StudentWriter extends Writer {
    private FileWriter fileWriter;
    private ObjectMapper mapper;
    private String str;

    public StudentWriter(Path directory, String filename, String type) throws IOException {
        if(type.trim().toLowerCase().equals("yaml")) this.str = "yaml";
        else this.str = "json";
        mapper = new ObjectMapper();
        if(Files.isDirectory(directory))
            fileWriter = new FileWriter(directory.toAbsolutePath().normalize().resolve(filename).toString() + "." + type);
        else throw new IOException("Error in the path");
    }

    public void writeJSONYAMLStudent(Student s) throws IOException {
        mapper.writeValue(fileWriter, s);
    }

    public String getEncoding() {
        return fileWriter.getEncoding();
    }

    @Override
    public void write(int c) throws IOException {
        fileWriter.write(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
    }

    @Override
    public void flush() throws IOException {
        fileWriter.flush();
    }

    @Override
    public void close() throws IOException {
        fileWriter.close();
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
    }

    @Override
    public void write(String str) throws IOException {
        fileWriter.write(str);
    }

    @Override
    public Writer append(CharSequence csq) throws IOException {
        return fileWriter.append(csq);
    }

    @Override
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        return fileWriter.append(csq, start, end);
    }

    @Override
    public Writer append(char c) throws IOException {
        return fileWriter.append(c);
    }
}
