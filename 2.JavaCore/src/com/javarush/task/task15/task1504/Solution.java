package com.javarush.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    public static class MarkTwainBook extends Book{

        String title = "Tom Sawyer";
        public MarkTwainBook(String title) {
            super("Mark Twain");
            this.title = title;

        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

    public static class AgathaChristieBook extends Book{

        String title = "Hercule Poirot";
        public AgathaChristieBook(String tittle) {
            super("Agatha Christie");
            this.title = tittle;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = "";
            //Add your code here
            if (this instanceof AgathaChristieBook){
                output = agathaChristieOutput;
            } else if (this instanceof MarkTwainBook) {
                output = markTwainOutput;
            }

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }
    }
}
