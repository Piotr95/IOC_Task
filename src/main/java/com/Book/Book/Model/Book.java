package com.Book.Book.Model;


import com.Book.User.Model.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String author;

    @NotNull
    private Boolean borrowed;
    @OneToOne
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date retDate;

    public Book(@NotNull String title, @NotNull String author) {
        this.title = title;
        this.author = author;
        this.borrowed = false;
    }
    public Book() {
        this.borrowed=false;
    }
    public boolean isBorrowed() {
        return Boolean.TRUE.equals(borrowed);
    }

    public void setBorrowed( Boolean borrowed) {
        this.borrowed = borrowed;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRetDate(Date retDate) {
        this.retDate = retDate;
    }

    public Date getRetDate() {
        return retDate;
    }

    public void setTitle( String title) {
        this.title = title;
    }

    public void setAuthor( String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }
}
