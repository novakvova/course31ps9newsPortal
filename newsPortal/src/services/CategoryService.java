package services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dto.CategoryDTO;
import entities.Category;

public class CategoryService {
	
	private Session session;

	private CategoryService(SessionFactory sessionFactory) {
		this.session = sessionFactory.openSession();
	}
	
	public Category Add(CategoryDTO catDTO) {
		session.beginTransaction();
		Category cat = new Category();
		cat.setName(catDTO.getName());
		cat.setDescription(catDTO.getDescription());
		cat.setUrlSlug(catDTO.getUrlSlug());
		//Long id = (Long)session.save(cat);
		session.save(cat);
		session.getTransaction().commit();
		return cat;
	}
	
	public Category GetById(long id) {
		session.beginTransaction();
		Category cat = (Category)session.get(Category.class, id);
		session.getTransaction().commit();
		return cat;
	}
	
	public void Delete(long id) {
		Category cat =  this.GetById(id);
		session.beginTransaction();
		session.delete(cat);
		session.getTransaction().commit();
	}
	
	public void Update(long id, String name, String urlSlug, String description) {
		Category cat =  this.GetById(id);
		session.beginTransaction();
		cat.setName(name);
		cat.setUrlSlug(urlSlug);
		cat.setDescription(description);
		session.update(cat);
		session.getTransaction().commit();
	}
	
	public List<Category> GetAll() {
		session.beginTransaction();
		List<Category> categories = session.createQuery("FROM Category").list();
		session.getTransaction().commit();
//		for (Category category : categories) {
//			System.out.println(category.toString());
//		}
		//System.out.println(categories.forEach(arg0););
		return categories;
	}
}
