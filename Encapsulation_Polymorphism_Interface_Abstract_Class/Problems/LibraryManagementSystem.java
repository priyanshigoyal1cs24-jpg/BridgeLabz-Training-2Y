interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrowerName;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrowerName = null;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected String getBorrowerName() {
        return borrowerName;
    }

    protected void setBorrowerName(String name) {
        this.borrowerName = name;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        if (borrowerName != null) {
            System.out.println("Reserved By: " + borrowerName);
        } else {
            System.out.println("Status: Available");
        }
    }
}

class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrowerName(borrowerName);
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrowerName() == null;
    }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrowerName(borrowerName);
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrowerName() == null;
    }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrowerName(borrowerName);
        }
    }

    @Override
    public boolean checkAvailability() {
        return getBorrowerName() == null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = new LibraryItem[3];
        items[0] = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald");
        items[1] = new Magazine("M101", "National Geographic", "Various");
        items[2] = new DVD("D202", "Inception", "Christopher Nolan");

        ((Reservable) items[0]).reserveItem("Alice");
        ((Reservable) items[2]).reserveItem("Bob");

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("---------------------------");
        }
    }
}
