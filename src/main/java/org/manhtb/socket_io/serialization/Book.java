package socket.serialization;

import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private String author;
    private Boolean isActive;
    private Double price;

    public Book(String name, String author, Boolean isActive, Double price) {
        this.name = name;
        this.author = author;
        this.isActive = isActive;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isActive=" + isActive +
                ", price=" + price +
                '}';
    }
}
