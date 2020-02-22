package entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "title", length = 500, nullable = false)
    private String title;
	
	@Column(name = "shortDescription", nullable = false)
    private String shortDescription;
	
	@Column(name = "description", nullable = false)
    private String description;
	
	@Column(name = "meta", nullable = false)
    private String meta;
	
	@Column(name = "urlSlug", length = 200, nullable = false)
    private String urlSlug;
	
	@Column(name = "published")
    private Boolean published;
	
	@Column(name = "postedOn")
    private LocalDate postedOn;
	
	@Column(name = "modified")
    private LocalDate modified;
	
	@ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
	
	public Post() {

	}

	public Post(String title, String shortDescription, String description, String meta, String urlSlug,
			Boolean published, LocalDate postedOn, LocalDate modified, long category_id) {
		this.title = title;
		this.shortDescription = shortDescription;
		this.description = description;
		this.meta = meta;
		this.urlSlug = urlSlug;
		this.published = published;
		this.postedOn = postedOn;
		this.modified = modified;
		Category category = new Category();
		category.setId(category_id);
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getUrlSlug() {
		return urlSlug;
	}

	public void setUrlSlug(String urlSlug) {
		this.urlSlug = urlSlug;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public LocalDate getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(LocalDate postedOn) {
		this.postedOn = postedOn;
	}

	public LocalDate getModified() {
		return modified;
	}

	public void setModified(LocalDate modified) {
		this.modified = modified;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
