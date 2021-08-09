package jp.gocurry.api.model;

public class Restaurant {

	private String name;
	private String nameJp;

	public Restaurant() {
	}

	public String getName() {
		return this.name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getNameJp() {
		return this.nameJp;
	}

	public void setnameJp(String nameInJapanese) {
		this.nameJp = nameInJapanese;
	}
}