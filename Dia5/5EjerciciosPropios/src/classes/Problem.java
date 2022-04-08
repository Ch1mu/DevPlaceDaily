package classes;

public class Problem {
	
private static int code;

private String description;
private int level, ownCode;



public Problem(String description, int level) {
	super();
	this.description = description;
	this.level = level;
	ownCode = code+1;
	code++;
}

public static int getCode() {
	return code;
}

public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}

@Override
public String toString() {
	return "Problem [description=" + description + ", level=" + level + ", Code=" + ownCode + "]";
}


}
