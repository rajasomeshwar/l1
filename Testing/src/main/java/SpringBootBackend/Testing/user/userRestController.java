package SpringBootBackend.Testing.user;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class userRestController {
   private userDaoSerivce serivce;
   private PostDaoSerivce postsrepo;
     userRestController(userDaoSerivce serivce,PostDaoSerivce postsreop)
     {
    	 this.postsrepo=postsreop;
    	 this.serivce=serivce;
     }
     @GetMapping("/users")
     public List<user> GetAllusers()
     {
    	 return serivce.findAll(); 
     }
    
	@GetMapping("/users/{id}")
     public user GetUser(@PathVariable int id)
     {
           if(!serivce.existsById(id))
        	   throw new UserNotFoundException("id not found id:"+id);
           
           return serivce.getById(id);
     }
	// with links
	@GetMapping("/usersLink/{id}")
    public EntityModel<user> GetUserAndLink(@PathVariable int id)
    {
          if(!serivce.existsById(id))
       	   throw new UserNotFoundException("id not found id:"+id);
         user userD= serivce.getById(id);
         EntityModel<user> entitymodel=EntityModel.of(userD);
         // adding links by reference of method 
         WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).GetAllusers());
         entitymodel.add(link.withRel("all_link"));
         return entitymodel;
    }
	@DeleteMapping("/users/{id}")
    public void DeleteUser(@PathVariable int id)
    {
          if(!serivce.existsById(id))
       	   throw new UserNotFoundException("id not found id:"+id);
          
          serivce.deleteById(id);
    }
	@GetMapping("/users/{id}/posts")
    public List<post> GetUsersPosts(@PathVariable int id)
    {
          if(!serivce.existsById(id))
       	   throw new UserNotFoundException("id not found id:"+id);
          
         return serivce.getById(id).getPosts();
    }
    @PostMapping("/users/{id}/posts")
    public EntityModel<@Valid post> CreatePostByuser(@PathVariable int id,@Valid @RequestBody post post)
    {
          if(!serivce.existsById(id))
       	   throw new UserNotFoundException("id not found id:"+id);
          post.setUserByp(serivce.getById(id));
         var s= postsrepo.save(post);
         EntityModel<SpringBootBackend.Testing.user.@Valid post> entitymodel=EntityModel.of(s);
         // adding links by reference of method 
         WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).GetUsersPosts(id));
         entitymodel.add(link.withRel("all_link"));
         return entitymodel;
      
    }
     @PostMapping("/users")
     public ResponseEntity<Object> createUser(@Valid @RequestBody user user)
     {
    	 user saveduser=serivce.save(user);
    	 
    	 var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
    	 return ResponseEntity.created(location).build();
     }
}
