package dto;

import java.time.LocalDate;
import java.util.List;

public class PostDTO {

	private long id;
    private String title;
    private String shortDescription;
    private String description;
    private String meta;
    private String urlSlug;
    private Boolean published;
    private LocalDate postedOn;
    private LocalDate modified;
    private String category_id;
    private List<ListItemDTO> categories;
    
	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostDTO(long id, String title, String shortDescription, String description, String meta, String urlSlug,
			Boolean published, LocalDate postedOn, LocalDate modified, String category_id) {
		super();
		this.id = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.description = description;
		this.meta = meta;
		this.urlSlug = urlSlug;
		this.published = published;
		this.postedOn = postedOn;
		this.modified = modified;
		this.category_id = category_id;
	}
	public List<ListItemDTO> getCategories() {
		return categories;
	}
	public void setCategories(List<ListItemDTO> categories) {
		this.categories = categories;
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
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
//	public List<ListItemDTO> getCategories() {
//		return categories;
//	}
//	public void setCategories(List<ListItemDTO> categories) {
//		this.categories = categories;
//	}

}
