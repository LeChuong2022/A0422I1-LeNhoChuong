package chung;

import java.io.*;
import java.util.Collection;
import java.util.List;

public class DocVaViet {
    public static String docFile(String duongDanFile) {
        String chuoiFile = "";
        try {
            File file = new File(duongDanFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                chuoiFile = chuoiFile.concat(line + "\n");
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File does not exist");
        }
        return chuoiFile;
    }



    public static void vietFile(String duongDanFile, String str) {
        try {
            FileWriter writer = new FileWriter(duongDanFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
