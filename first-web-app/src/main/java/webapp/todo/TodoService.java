package webapp.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo("Learn Web Application Devewlopment", "Study"));
		todos.add(new Todo("Learn Spring MVC", "Study"));
		todos.add(new Todo("Learn Spring Rest Services", "Study"));
	}
	public List<Todo> retreveTodos(){
		return todos;
	}
	public static void addTodos(Todo todo) {
		todos.add(todo);
	}
	
	public void deleteTodo(Todo	todo) {
		todos.remove(todo);
	}
}
