package  MyWebApplicaation.MyFirstProjectDemo.todo;

 

import java.time.LocalDate;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class todosControllersJPA {
	//private TodoServer todos;
	private TodoRepository repsoitory;
	public todosControllersJPA(TodoRepository repsoitory) {
		super();
		
		this.repsoitory=repsoitory;
	}

	@RequestMapping(value="list-todos",method=RequestMethod.GET)
	public String findByUser(ModelMap model)
	{
	
		model.put("todos",repsoitory.findByUsername(getLoggedinUsername()));
		return "todos";
	}
//	@RequestMapping(value="add",method=RequestMethod.POST)
//	public String addm(@RequestParam String des,ModelMap model)
//	{
//		todos.AddTodo(4,(String)model.get("name"),des,LocalDate.now().plusDays(323),false);
//		return "redirect:list-todos";
//	}
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String Update(ModelMap model,@RequestParam int id)
	{
		//Todo todo=todos.getByid(id);
		Todo todo=repsoitory.findById(id).orElse(null);
		model.addAttribute("todo",todo);
		System.out.println(todo);
      return "update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String UpdateR(ModelMap model,@RequestParam int id,@Valid Todo tood,BindingResult result)
	{
		//Todo todo=todos.getByid(id);
	//	model.addAttribute("todo",todo);
		 if(result.hasErrors())
			 return "update";
		 System.out.println("Form her "+repsoitory.getById(id));
		// todos.updateBy(tood);
		 repsoitory.save(tood);
	//	 todo.setDescription(todo.getDescription());
      return "redirect:list-todos";
	}

	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String Delete(@RequestParam int id,ModelMap model)
	{
        repsoitory.delete(repsoitory.getById(id));
		//todos.findById(id);
		return "redirect:list-todos";
	}
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String Add(ModelMap model)
	{   
		//System.out.println(model.get("name"));
		Todo todo=new Todo(4,getLoggedinUsername(),"",LocalDate.now(),false);
		model.put("todo", todo);
		return "add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addm(ModelMap model,@Valid Todo todo,BindingResult result)
	{
		if(result.hasErrors())
		{
			
			return "add";
		}
	//	todo.setUsername("x");
	//	System.out.println(todo);
		repsoitory.save(todo);
//		System.out.println("his " +todo.getDescription());
//		todos.AddTodo(todo.getId(),(String)model.get("name"),todo.getDescription(),todo.getTargetdate(),todo.isDone());
		return "redirect:list-todos";
	}
	private String getLoggedinUsername()
 	{
 		Authentication auth=
 				SecurityContextHolder.getContext().getAuthentication();
 		return auth.getName();
 		
 	}
	
}
