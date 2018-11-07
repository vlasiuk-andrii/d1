package module1LambdasStreams.task2;

import java.util.ArrayList;

public class BooksMain {

    public static void main(String[] args) {

        Author author1 = new Author();
        author1.setAge((short) 4);
        author1.setName("Lewis");
        author1.setBooks(new ArrayList<Book>());

        Book book1 = new Book();
        book1.setTitle("title1");
        book1.setNumberOfPages(500);
//        book1.setAuthors(new ArrayList<Author>(author1));
//
//
//
//
//        Author[] authors = new Author[]{new Author("Lewis", 42,  ),
//                                        new Author("Shekspeer", 88, )};
//
//        Book[] books = new Book[]{new Book("title1", authors, 655 )};


    }
}
