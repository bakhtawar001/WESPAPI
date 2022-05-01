package Pojo;

public class Results {
	
	private int Id;
	private String Name;
	private String Description;
	private String ImageURL;
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
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getImageURL() {
		return ImageURL;
	}
	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}
	@Override
	public String toString() {
		return "ProductResults [Id=" + Id + ", Name=" + Name + ", Description=" + Description + ", ImageURL=" + ImageURL
				+ "]";
	}
	
	

}
