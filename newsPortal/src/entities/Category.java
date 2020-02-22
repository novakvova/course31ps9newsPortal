package entities;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblCategories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private long id;
	
	@Column(name = "name", length = 100, nullable = false)
    private String name;
	
	@Column(name = "urlSlug", length = 50, nullable = false)
    private String urlSlug;
	
	@Column(name = "description", length = 4000)
    private String description;
	
	@OneToMany
    @JoinColumn(name = "category_id") // we need to duplicate the physical information
    private Set<Post> posts;
	

	public Category() {
	}

	public Category(String name, String urlSlug, String description) {
		this.name = name;
		this.urlSlug = urlSlug;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlSlug() {
		return urlSlug;
	}

	public void setUrlSlug(String urlSlug) {
		this.urlSlug = urlSlug;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
}