package Pojo;

import java.util.ArrayList;
import java.util.List;

public class MyProject {
	
	
	
	private List<Projects> Projects;
	
	
	private  int Id;
	private  String Name;
	public List<Projects> getProjects() {
		return Projects;
	}
	public void setProjects(List<Projects> projects) {
		Projects = projects;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "MyProject [Projects=" + Projects + ", Id=" + Id + ", Name=" + Name + "]";
	}
	
	
	
	
	


}
