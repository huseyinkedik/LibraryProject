import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="book")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;
    @Column(name="publication_year",nullable = false)
    private int publicationYear;
    @Column(name="stock",nullable = false)
    private int stock;

    //kitap ve yazar ilişkisi;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "publisher_id",referencedColumnName = "id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE})
    private List<BookBorrowing>bookBorrowings;

    //category bağlantısı
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category>categories;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationYear=" + publicationYear +
                ", stock=" + stock +
                ", author=" + author +
                ", publisher=" + publisher +
                ", bookBorrowings=" + bookBorrowings +
                ", categories=" + categories +
                '}';
    }
}
