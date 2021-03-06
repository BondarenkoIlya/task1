package com.epam.ilya.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class describe information about current event or affair
 *
 * @author Ilya_Bondarenko
 */
@Entity
@Table(name = "NEWS")
public class News extends BaseEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "\"date\"")
    @Convert(converter = DateTimeConverter.class)
    private DateTime date;

    @Column(name = "BRIEF")
    private String brief;

    @Column(name = "CONTENT")
    private String content;

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public News() {
        this.date = DateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + getId() + '\'' +
                "title='" + title + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", brief='" + brief + '\'' +
                '}';
    }
}
