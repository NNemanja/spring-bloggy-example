package blog.controller;


import javax.validation.Valid;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.model.BlogPost;
import blog.repository.BlogPostRepository;

@Controller
public class PostController {

	@Autowired
	BlogPostRepository postRepo;

	/**
	 * Passes an empty {@link BlogPost} object for the form to fill out with data.
	 * @param model
	 * @return newPost
	 */
	@RequestMapping(value="/newPost", method = RequestMethod.GET)
    public String newPost(Model model) {
		model.addAttribute("blogPost", new BlogPost());
        return "newPost";
        
    }
	/**
	 * Triggered on form submit, resolves if the post is new and should be added, or old and should be updated.
	 * See also {@link #newPost(Model) new post method} and {@link #editPost(int, Model) edit post method}
	 * @param post 
	 * @param bindingResult used for validation
	 * @return index
	 */
	@RequestMapping(value = "/formPost", method = RequestMethod.POST)
	public String addOrUpdatePost(@ModelAttribute("blogPost") @Valid BlogPost post,  BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()){
			return "newPost";
		}
		BlogPost oldPost = null;
		if(post.getId()!=0){//update action
			 oldPost = postRepo.findOne(post.getId());
			 oldPost.setPostText(post.getPostText());
			 oldPost.setPostTitle(post.getPostTitle());
		}
		else{//insert action
			post.setPostTime(new DateTime());
			oldPost = post;
		}
		
		postRepo.save(oldPost);
	    return "redirect:/";
		
	}
	
	/**
	 * Simple show a single blog post controller
	 * @param id of the blogpost
	 * @param model
	 * @return posts
	 */
	@RequestMapping(value="/posts/{id}", method=RequestMethod.GET) 
	public String showPost(@PathVariable int id, Model model)
	{
		BlogPost post = postRepo.findOne(id);

		if(post==null  || (post!=null && post.getPostDeleted()==1))
			return "redirect:/";
		
		model.addAttribute("post",post);
		return "posts";
		
	}
	
	/**
	 * Our entry point to editing a blog post.
	 * Similarly to {@link #newPost(Model) new post method} we pass an object which already exists in our database.
	 * 
	 * @param id of the blog post. If a blog post with such id does not exist or is deleted, reroute to index 
	 * @param model
	 * @return newPost
	 */
	@RequestMapping(value="/editPost/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable int id, Model model) {
		BlogPost post = postRepo.findOne(id);
		
		if(post==null || (post!=null && post.getPostDeleted()==1))
			return "redirect:/";
		
		
		model.addAttribute("blogPost", post);
        return "newPost";
        
    }
	
	/**
	 * I am opting out of actually deleting the post from the database because i feel it is bad practice.
	 * Instead, I have a postDeleted(int) database field which we toggle to delete (also to bring back if needed).
	 * 
	 * If I were to simply delete the entity, this would suffice: 
	 * postRepo.delete(id);
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/deletePost/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable int id, Model model) {

		BlogPost post = postRepo.findOne(id);
		
		if(post==null)
			return "redirect:/";
		
		post.setPostDeleted(1);
		postRepo.save(post);
		
        return "redirect:/";
        
    }
	
}
