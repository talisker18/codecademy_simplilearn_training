package AAD_java8.streams.training.flatMap.findAllBooks;

import java.util.HashSet;
import java.util.Set;

public class Developer {

    private Integer id;
    private String name;
    private Set<String> books;
    
    public void addBook(String book) {
        if (this.books == null) {
            this.books = new HashSet<>();
        }
        this.books.add(book);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getBooks() {
		return books;
	}

	public void setBooks(Set<String> book) {
		this.books = book;
	}

	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", book=" + books + "]";
	}
}
