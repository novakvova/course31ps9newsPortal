package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.post.AddPostDTO;
import dto.ListItemDTO;

@Controller
public class TextEditorController {
	
	@RequestMapping("/addPost")
	public String index(Model model) {
		AddPostDTO addModel = new AddPostDTO();
		
		List<ListItemDTO> categories = new ArrayList<ListItemDTO>();
		categories.add(new ListItemDTO("Плодові", "1"));
		categories.add(new ListItemDTO("Не плодові", "2"));
		
		addModel.setCategories(categories);
		model.addAttribute("add", addModel);
		return "addPost";
	}
	
	@GetMapping("/editor")
	public String editor() {
		return "elements/text_editor";
	}

	@RequestMapping(value = "/upload_image", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, String> process(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, String> responseData = new HashMap<>();

		// ObjectMapper objectMapper = new ObjectMapper();
		String linkName = "http://link";
		responseData.put("link", linkName);
		return responseData;
	}
}