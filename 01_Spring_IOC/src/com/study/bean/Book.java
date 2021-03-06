package com.study.bean;

/**
 * @Author Liuyunda
 * @Date 2020/6/22 22:29
 * @Email man021436@163.com
 * @Description: DOTO
 */
public class Book {
    private String bookName;
    private String author;

    public Book() {
        System.out.println("书被创建");
    }

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public void myInit(){
        System.out.println("书的初始化方法");
    }
    public void myDestory(){
        System.out.println("书的销毁方法");
    }
    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
