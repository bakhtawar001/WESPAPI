package Pojo;

public class Projects {
	private  int Id;
	private  String Name;
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
		return "Projects [Id=" + Id + ", Name=" + Name + "]";
	}

	
	

}
