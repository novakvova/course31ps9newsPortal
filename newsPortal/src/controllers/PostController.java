package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import dto.ListItemDTO;
import dto.PostDTO;
import entities.Category;
import entities.Post;
import services.CategoryService;
import services.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private CategoryService catService;

	@RequestMapping(value = "/addPost", method = RequestMethod.GET)
	public String showAddPostForm(WebRequest request, Model model) {
		PostDTO postDTO = new PostDTO();
		System.out.println("-----------showAddPostForm------------");
		List<ListItemDTO> categories = new ArrayList<ListItemDTO>();
		List<Category> g = catService.GetAll();
		for (Category c : g) {
			String id=Long.toString(c.getId());
			categories.add(new ListItemDTO(c.getName(), id));
		}
		postDTO.setCategories(categories);
		model.addAttribute("postDTO", postDTO);
		return "addPost";
	}

	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("postDTO")PostDTO postDTO, 
		      BindingResult result, ModelMap model) {
		System.out.println("---addPost ----post----");
		Post post = new Post();
		System.out.println(postDTO.getUrlSlug());
		System.out.println(postDTO.getShortDescription());
		System.out.println(postDTO.getDescription());
		System.out.println(postDTO.getCategory_id());
		post = addNewPost(postDTO);
		List<ListItemDTO> categories = new ArrayList<ListItemDTO>();
		List<Category> g = catService.GetAll();
		for (Category c : g) {
			String id=Long.toString(c.getId());
			categories.add(new ListItemDTO(c.getName(), id));
		}
		
		postDTO.setCategories(categories);
		model.addAttribute("postDTO", postDTO);
		return "addPost";
	}

	private Post addNewPost(PostDTO postDTO) {
		Post post = null;
		try {
			post = postService.Add(postDTO);
		} catch (Exception e) {
			return null;
		}
		return post;
	}
	
	@RequestMapping(value = "/editPost/{id}", method = RequestMethod.GET)
	public String showEditPostForm(@PathVariable("id") String id, WebRequest request, Model model) {
		PostDTO postDTO = new PostDTO();
		System.out.println("edit method; id=" + id);
		Post post = postService.GetById(Long.parseLong(id));
		postDTO.setId(post.getId());
		postDTO.setTitle(post.getTitle());
		postDTO.setShortDescription(post.getShortDescription());
		postDTO.setDescription(post.getDescription());
		postDTO.setMeta(post.getMeta());
		postDTO.setUrlSlug(post.getUrlSlug());
		postDTO.setPostedOn(post.getPostedOn());
		postDTO.setPublished(post.getPublished());
		Long catId=post.getCategory().getId();
		postDTO.setCategory_id(catId.toString());
		List<ListItemDTO> categories = new ArrayList<ListItemDTO>();
		List<Category> g = catService.GetAll();
		for (Category c : g) {
			String idc=Long.toString(c.getId());
			categories.add(new ListItemDTO(c.getName(), idc));
		}
		postDTO.setCategories(categories);
		model.addAttribute("postEdit", postDTO);
		return "editPost";
	}

	@RequestMapping(value = "/editPost", method = RequestMethod.POST)
	public String editPost(@ModelAttribute("postDTO")PostDTO postDTO, 
		      BindingResult result, ModelMap model) {
		System.out.println("---editPost ----post----");
		Post post = new Post();
		System.out.println(postDTO.getUrlSlug());
		System.out.println(postDTO.getShortDescription());
		System.out.println(postDTO.getDescription());
		System.out.println(postDTO.getCategory_id());
		//post = editPost(postDTO);
		List<ListItemDTO> categories = new ArrayList<ListItemDTO>();
		List<Category> g = catService.GetAll();
		for (Category c : g) {
			String id=Long.toString(c.getId());
			categories.add(new ListItemDTO(c.getName(), id));
		}
		
		postDTO.setCategories(categories);
		model.addAttribute("postDTO", postDTO);
		return "editPost";
	}
	
	@RequestMapping("/post")
	public String post(Model model) {
		List<PostDTO> posts = new ArrayList<PostDTO>();
		List<Post> g = postService.GetAll();
		for (Post p : g) {
			PostDTO t = new PostDTO();
			t.setId(p.getId());
			t.setTitle(p.getTitle());
			t.setShortDescription(p.getShortDescription());
			
			posts.add(t);
		}
		model.addAttribute("posts", posts);
		return "post";
	}
}
