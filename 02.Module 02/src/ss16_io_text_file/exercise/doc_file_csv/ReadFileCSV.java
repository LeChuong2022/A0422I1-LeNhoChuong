package ss16_io_text_file.exercise.doc_file_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    public void readFile(String pathFile, List<Country> countries) {
        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(pathFile));
            String line = "";
            String[] arrOfStr = new String[3];
            while ((line = br.readLine()) != null) {
                arrOfStr = line.split(",", 3);
                Country country = new Country(Integer.parseInt(arrOfStr[0]), arrOfStr[1], arrOfStr[2]);
                countries.add(country);
            }
            System.out.println(countries.toString()) ;
            br.close();
        } catch (Exception e) {
            System.err.println("File does not exist");
        }
    }

    public static void main(String[] args) {
        ReadFileCSV readFileCSV = new ReadFileCSV();
        List<Country> countries = new ArrayList<>();
        readFileCSV.readFile("readFile.csv", countries);
    }
}

//////////////////