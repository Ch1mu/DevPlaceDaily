package models;

public class RecordCompany {
	
	private static RecordCompany myinstance;
	
	private GenArray<Album>albums;
	private RecordCompany()
	{
		albums = new GenArray<Album>();
	}
	
	public static RecordCompany getInstance()
	{
		if(myinstance == null)
			return myinstance = new RecordCompany();
		
		return myinstance;
	}
	
	public GenArray getAlbums()
	{
		return albums;
	}
}
