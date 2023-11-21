package top.stx.train.common.exception;

public class Book {
    private String title;
    private BookTypeEnum bookTypeEnum;

    public Book(String title, BookTypeEnum bookTypeEnum) {
        this.title = title;
        this.bookTypeEnum = bookTypeEnum;
    }
    public static void main(String[] args) {
        Book computerBook = new Book("计算机软件", BookTypeEnum.COMPUTER_SCIENCE);

        System.out.println("Book title: " + computerBook.getTitle());
        System.out.println("Book bookTypeEnum: " + computerBook.getBookTypeEnum());
    }

    public String getTitle() {
        return title;
    }

    public BookTypeEnum getBookTypeEnum() {
        return bookTypeEnum;
    }
}
