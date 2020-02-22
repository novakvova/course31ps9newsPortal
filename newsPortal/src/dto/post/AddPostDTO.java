package dto.post;

import java.util.List;

import dto.ListItemDTO;

public class AddPostDTO {

	private List<ListItemDTO> categories;

	public List<ListItemDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<ListItemDTO> categories) {
		this.categories = categories;
	}
	
	
}
