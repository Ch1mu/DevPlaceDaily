package models;

public class Artist extends Person{
	private String musicStyle;
	private static int id ;
	private int ownId;
	
	
	public Artist(String firstname, String lastname, String dni, String musicStyle) {
		super(firstname, lastname, dni);
		this.musicStyle = musicStyle;
		id++;
		ownId = id;
	}
	

	public String getMusicStyle() {
		return musicStyle;
	}

	public void setMusicStyle(String musicStyle) {
		this.musicStyle = musicStyle;
	}
	public int getOwnId() {
		return ownId;
	}
	public void setOwnId(int ownId) {
		this.ownId = ownId;
	}
	@Override
	public String toString() {
		return "Artist [musicStyle=" + musicStyle + ", firstname=" + firstname + ", lastname=" + lastname + ", dni="
				+ dni + "]";
	}
	
	

}
