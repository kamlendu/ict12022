/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class BookMaster1 implements Serializable {
    private static  final Long serialVersionUID = 1L;

    int bookid;
    String bookName;
    String authorName;
    String publisherName;
    String synopsis;

    public BookMaster1(int bookid, String bookName, String authorName, String publisherName, String synopsis) {
        this.bookid = bookid;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.synopsis = synopsis;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    
    
}
