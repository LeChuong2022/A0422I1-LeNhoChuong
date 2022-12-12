package picture_day.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PictureRate {
    @Id
    //tự động tăng
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rate;
    private String author;
    private String feedback;
    private Long likeNumber;
    private Date day;

    public PictureRate() {
    }

    public PictureRate(int rate, String author, String feedback, Long likeNumber, Date day) {
        this.rate = rate;
        this.author = author;
        this.feedback = feedback;
        this.likeNumber = likeNumber;
        this.day = day;
    }

    public PictureRate(Long id, int rate, String author, String feedback, Long likeNumber, Date day) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.feedback = feedback;
        this.likeNumber = likeNumber;
        this.day = day;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Long likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
