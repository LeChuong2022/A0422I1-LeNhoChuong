package codegym.vn.bean;

public class Song {
    private String name;
    private String author;
    private String type;
    private String accessLink;

    public Song() {
    }

    public Song(String name, String author, String type, String accessLink) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.accessLink = accessLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccessLink() {
        return accessLink;
    }

    public void setAccessLink(String accessLink) {
        this.accessLink = accessLink;
    }

}
