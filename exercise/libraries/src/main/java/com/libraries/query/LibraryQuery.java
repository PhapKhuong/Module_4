package com.libraries.query;

public class LibraryQuery {
    private LibraryQuery() {
    }

    public static final String SELECT_ALL_BOOK =
            "SELECT * FROM book";

    public static final String SELECT_BOOK_BY_NAME =
            "SELECT * FROM book WHERE book_name LIKE :book_name";

    public static final String SELECT_ALL_STUDENT =
            "SELECT * FROM student";

    public static final String SELECT_STUDENT_BY_NAME =
            "SELECT * FROM student WHERE student_name LIKE :student_name";

    public static final String SELECT_ALL_CARD_PAGE =
            "SELECT c.* FROM ((card c INNER JOIN student s ON c.student_id = s.student_id) INNER JOIN book b ON c.book_id = b.book_id) WHERE b.book_name LIKE :b.book_name ORDER BY c.loan_date";

    public static final String SELECT_ALL_CARD_LIST =
            "SELECT c.* FROM (card c INNER JOIN student s ON c.student_id = s.student_id) INNER JOIN book b ON c.book_id = b.book_id ORDER BY c.loan_date";

    public static final String SELECT_CARD_BY_ID =
            "SELECT c.* FROM (card c INNER JOIN student s ON c.student_id = s.student_id) INNER JOIN book b ON c.book_id = b.book_id WHERE c.card_id = :c.card_id";
}
