package blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blog.repository.BlogPostRepository;

@Controller
public class GeneralController {
	@Autowired
	BlogPostRepository postRepo;
	
	@RequestMapping(value={"/","/posts"},method = RequestMethod.GET)
    public String index(Model model) {
		model.addAttribute("posts", postRepo.findByPostDeletedEqualsOrderByIdDesc(0));
        return "index";
        
    }
	
}
