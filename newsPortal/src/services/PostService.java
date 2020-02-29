package services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.PostDTO;
import entities.Category;
import entities.Post;

public class PostService {
	private Session session;

	public PostService(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}
	
	public Post Add(PostDTO postDTO) {
		session.beginTransaction();
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setShortDescription(postDTO.getShortDescription());
		post.setDescription(postDTO.getDescription());
		post.setMeta(postDTO.getMeta());
		post.setUrlSlug(postDTO.getUrlSlug());
		//post.setPostedOn(postDTO.getPostedOn());
		long id = Long.parseLong(postDTO.getCategory_id());
		Category cat = new Category();
		cat.setId(id);
		post.setCategory(cat);
		session.save(post);
		session.getTransaction().commit();
		return post;
	}
	
	public Post GetById(long id) {
		session.beginTransaction();
		Post post = (Post)session.get(Post.class, id);
		session.getTransaction().commit();
		return post;
	}
	
	public void Delete(long id) {
		Post post = this.GetById(id);
		session.beginTransaction();
		session.delete(post);
		session.getTransaction().commit();
	}
	
	public void Update(PostDTO postDTO) {
		Post post = this.GetById(postDTO.getId());
		session.beginTransaction();
		post.setTitle(postDTO.getTitle());
		post.setShortDescription(postDTO.getShortDescription());
		post.setDescription(postDTO.getDescription());
		post.setMeta(postDTO.getMeta());
		post.setUrlSlug(postDTO.getUrlSlug());
		post.setPostedOn(postDTO.getPostedOn());
		long id = Long.parseLong(postDTO.getCategory_id());
		Category cat = new Category();
		cat.setId(id);
		post.setCategory(cat);
		session.update(post);
		session.getTransaction().commit();
	}
	
	public List<Post> GetAll() {
		session.beginTransaction();
		List<Post> posts = session.createQuery("FROM Post").list();
		session.getTransaction().commit();
		return posts;
	}
}
