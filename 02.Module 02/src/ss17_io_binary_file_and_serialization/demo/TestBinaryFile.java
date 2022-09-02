package ss17_io_binary_file_and_serialization.demo;

import java.io.*;

public class TestBinaryFile {
    public static void main(String[] args) {
//        writeFile("sample.dat");
        readFileBinary("sample.dat");
    }

    public static void writeFile(String path) {
        try (FileOutputStream stream = new FileOutputStream(path);
             DataOutputStream dataOutputStream = new DataOutputStream(stream)) {
            dataOutputStream.writeInt(10);
            dataOutputStream.writeBytes("Hello");
            dataOutputStream.write(65);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFileBinary(String path) {
        try (FileInputStream stream = new FileInputStream(path);
        DataInputStream data = new DataInputStream(stream)) {
            int a = data.readInt();
            System.out.println(a);
            String str = data.readLine();
            System.out.println(str);
            int b = data.read();
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
