package models;

public class Album {
	
private String name;

private Artist artists;
private GenArray<Song>songs;

private static int id ;
private int ownId;

public Album(String name, Artist artists) {

	this.name = name;
	this.artists = artists;
	songs = new GenArray<Song>();
	id++;
	ownId = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public GenArray<Song> getSongs() {
	return songs;
}
public void setSongs(GenArray<Song> songs) {
	this.songs = songs;
}
public Artist getArtists() {
	return artists;
}



public int getOwnId() {
	return ownId;
}
public void setOwnId(int ownId) {
	this.ownId = ownId;
}
@Override
public String toString() {
	return "Album [name=" + name + ", artists=" + artists + ", songs=" + songs + " " + ownId +"]";
}


}
