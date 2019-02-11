package practise;

import java.util.ArrayList;
import java.util.List;

public class P_Service {
	
	private List<P_Data> data = new ArrayList<P_Data>();

	public P_Service() {
		super();
	}
	
	public void addNewPhonebook(String name, String num) {
		P_Data newData = new P_Data();
		newData.setName(name);
		newData.setNum(num);
		data.add(newData);
	}

	@Override
	public String toString() {
		return String.format("P_Service [data=%s]", data);
	}

	public List<P_Data> getData() {
		return data;
	}
	
	public void deleteData(P_Data data) {
		this.data.remove(data);
		
	}
}
