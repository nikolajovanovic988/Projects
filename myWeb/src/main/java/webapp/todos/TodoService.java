package webapp.todos;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
	private List<Todo> todo = new ArrayList<Todo>();

	private TodoService() {
		todo.add(new Todo("Play pool on weekends","Fun"));
		todo.add(new Todo("Learn JQuery","Education"));
		todo.add(new Todo("Learn REST and SOAP","Education"));
	}
	
	public void addTodo(String name, String category) {
		todo.add(new Todo("name","category"));
	}
	
	public int getTodoNum() {
		return todo.size();
	}
	
	public List<Todo> getTodo() {
		return todo;
	}
	
	public void deleteTodo(String name, String category) {
		todo.remove(new Todo("name","category"));
	}
}
