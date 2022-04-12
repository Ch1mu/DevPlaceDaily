package models;

public class Song {
private String title;
private double duration;
private static int id ;
private int ownId;
public Song(String title, double duration) {

	this.title = title;
	this.duration = duration;
	id++;
	ownId = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public double getDuration() {
	return duration;
}
public void setDuration(double duration) {
	this.duration = duration;
}

public int getOwnId() {
	return ownId;
}
public void setOwnId(int ownId) {
	this.ownId = ownId;
}

}
