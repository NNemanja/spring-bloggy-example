package blog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import blog.model.BlogPost;

public interface BlogPostRepository extends CrudRepository<BlogPost, Integer> {

	BlogPost findByPostTitle(String postTitle);
    
	List<BlogPost> findByPostDeletedEqualsOrderByIdDesc(int deleted);
    
    
}