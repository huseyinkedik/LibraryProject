import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="borrower_name",nullable = false)
    private String name;
    @Column(name="description",nullable = false)
    private String description;

    //bağlantı
    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Book>books;

    public Category() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
