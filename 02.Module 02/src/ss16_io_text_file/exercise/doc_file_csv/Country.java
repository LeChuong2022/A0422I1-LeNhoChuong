package ss16_io_text_file.exercise.doc_file_csv;

public class Country {
    private int id;
    private String code;
    private String country;

    public Country(){}

    public Country(int id, String code, String country){
        this.id = id;
        this.code = code;
        this.country = country;
    }

    @Override
    public String toString() {
        return "\nCountry{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                '}' ;
    }
}
/////////