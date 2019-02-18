package webapp.todos;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
	
	private static List<Todo> todos = new ArrayList<Todo>();
	static {
		todos.add(new Todo("Play pool on weekends","Fun"));
		todos.add(new Todo("Learn JQuery","Education"));
		todos.add(new Todo("Learn REST and SOAP","Education"));
	}
	
	public void addTodo(String name, String category) {
		todos.add(new Todo(name,category));
	}
	public List<Todo> getTodo() {
		return todos;
	}
	
	public void deleteTodo(String name, String category) {
		todos.remove(new Todo(name,category));
	}
	
	public int getTodoNum() {
		return todos.size();
	}
}
