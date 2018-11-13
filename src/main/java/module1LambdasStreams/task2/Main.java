package module1LambdasStreams.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Author author1 = new Author();
        author1.setAge((short) 26);
        author1.setName("Lewis");

        Author author2 = new Author();
        author2.setAge((short) 40);
        author2.setName("Jonny");

        List<Author> multipleAuthors = new ArrayList<>();
        multipleAuthors.add(author1);
        multipleAuthors.add(author2);
        List<Author> singleAuthor = new ArrayList<>();
        singleAuthor.add(author1);

        Book book1 = new Book();
        book1.setTitle("title1");
        book1.setNumberOfPages(500);
        book1.setAuthors(multipleAuthors);

        Book book2 = new Book();
        book2.setTitle("title2");
        book2.setNumberOfPages(280);
        book2.setAuthors(multipleAuthors);

        Book book3 = new Book();
        book3.setTitle("title3");
        book3.setNumberOfPages(100);
        book3.setAuthors(singleAuthor);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        author1.setBooks(books);
        author2.setBooks(books);

        Author[] authorsArr = new Author[]{author1, author2};

        Book[] booksArr = new Book[]{book1, book2, book3};

        // a. check if some/all book(s) have more than 200 pages;
        System.out.println("a.Some book has more then 200 pages: " +
                Arrays.stream(booksArr)
                        .anyMatch(book -> book.getNumberOfPages() > 200));

        System.out.println("a.All books have more then 200 pages: " +
                Arrays.stream(booksArr)
                        .allMatch(book -> book.getNumberOfPages() > 200));

        //b. find the books with max and min number of pages;
        System.out.println("b.Book with max number of pages: " +
                Arrays.stream(booksArr)
                        .max(Comparator.comparing(Book::getNumberOfPages))
                        .get()
                        .getTitle());

        System.out.println("b.Book with min number of pages: " +
                Arrays.stream(booksArr)
                        .sorted(Comparator.comparing(Book::getNumberOfPages))
                        .findFirst()
                        .get()
                        .getTitle());

        //c. filter books with only single author;
        System.out.print("c.Books with single author: ");
                Arrays.stream(booksArr)
                        .filter(book -> book.getAuthors().size() == 1)
                        .forEach(book -> System.out.println(book.getTitle()));

        //d. sort the books by number of pages/title;
        System.out.println("d.Books sorted by number of pages: ");
                Arrays.stream(booksArr)
                        .sorted(Comparator.comparing(Book::getNumberOfPages))
                        .forEach(book -> System.out.println(book.getNumberOfPages()));

        System.out.println("d.Books sorted by title :");
                Arrays.stream(booksArr)
                        .sorted(Comparator.comparing(Book::getTitle))
                        .forEach(book -> System.out.println(book.getTitle()));

        //e. get list of all titles;
        System.out.println("e.List of titles: " +
                Arrays.stream(booksArr)
                        .map(Book::getTitle)
                        .collect(Collectors.toList()));

        //f. print them using forEach method;
        System.out.println("f.Print books: ");
                Arrays.stream(booksArr)
                        .forEach(System.out::println);

        //g. get distinct list of all authors
        System.out.println("Distinct list of all authors: ");
//        List<String> fullAuthorsList = Arrays.stream(booksArr)
//                .forEach(book -> book.getAuthors().stream()
//                                            .distinct());



    }
}
