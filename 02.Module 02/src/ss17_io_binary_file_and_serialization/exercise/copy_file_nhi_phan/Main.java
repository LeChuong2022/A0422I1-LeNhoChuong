package ss17_io_binary_file_and_serialization.exercise.copy_file_nhi_phan;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileException{
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter source file: ");
        String sourcePath = in.nextLine();
        System.out.printf("Enter destination file: ");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        if (destFile.exists())
            throw new FileException("Destination file already exists ");
        try {
            copyFileUsingStream(sourceFile, destFile);
            System.out.println("Copy completed");
            System.out.println("File size in bytes: " + sourcePath.length());
        } catch (IOException ioe) {
            System.out.printf("Source does not exist ");
            System.out.println(ioe.getMessage());
        }

    }

    public static void copyFileUsingStream(File source, File dest) throws IOException{
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            if (is != null)
                is.close();
            if (os != null)
                os.close();
        }
    }
}
