package blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import blog.model.BlogPost;
import blog.repository.BlogPostRepository;

@SpringBootApplication
public class BlogApplication extends SpringBootServletInitializer{

private static final Logger log = LoggerFactory.getLogger(BlogApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
    @Override 
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	return application.sources(BlogApplication.class);
    } 
    
    @Bean
    CommandLineRunner populate(BlogPostRepository repo)
    {
    	return (args) -> {
    		log.info("populating table with dummy values");
    		
			repo.save(new BlogPost("Test post please ignore", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris convallis dui finibus volutpat pretium. Ut tristique efficitur eleifend. Curabitur dignissim dolor sit amet felis consequat feugiat. Vestibulum eleifend quis erat id imperdiet. Nam consequat mauris elit, eget malesuada elit rhoncus non. Suspendisse vehicula venenatis diam porta gravida. Sed tempus ante volutpat, auctor metus sed, pellentesque lorem. Pellentesque lectus nisl, egestas nec purus nec, lobortis aliquet neque. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cras sed quam metus. Pellentesque auctor risus eu lacus molestie, ac ullamcorper erat tempus. Sed ligula orci, tincidunt ut porta dapibus, vehicula nec nisi.", 0));
    		repo.save(new BlogPost("Another post for fun", "Fusce volutpat elementum ultricies. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed venenatis dui eu mollis scelerisque. Curabitur justo turpis, blandit id lectus vel, commodo facilisis libero. Nunc porttitor ultrices euismod. Maecenas a augue commodo erat viverra sollicitudin. Nunc odio magna, mollis at arcu ac, imperdiet ornare ipsum. Nulla non nibh et neque ornare pellentesque. Fusce luctus quis risus at vehicula.", 0));
    		repo.save(new BlogPost("My dummy information", "Etiam congue orci id eros volutpat, et egestas ipsum luctus. Integer quis ligula ut augue venenatis mollis viverra et massa. Fusce erat urna, congue non justo id, gravida posuere est. Curabitur eget molestie ante. In lacinia non erat vitae pulvinar. Nunc id elementum urna. Phasellus vulputate fermentum velit non porttitor. Maecenas finibus convallis mauris et condimentum. Nulla volutpat dui euismod, fringilla neque ut, ultricies neque. Etiam accumsan libero in lacus cursus blandit. Fusce eu sem mauris.", 0));
    		
    		log.info("dummy values populated");
    	};
    }
}
