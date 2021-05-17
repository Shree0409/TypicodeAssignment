package resources;

public enum APIResources {
	
	postsAPI("/posts"),
	commentsAPI("/comments"),
	usersAPI("/users");
	
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
