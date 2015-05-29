package com.libraries.domain;

public class Magazine {
	private int number;
	private String title;
	private String type;
	private int authorId;
	
	public Magazine(int number, String title, String type){
		this.number = number;
		this.title = title;
		this.type = type;
	}

	public Magazine(int numberM, int authorId, String titleM, String typeM) {
		this.number = number;
		this.title = title;
		this.type = type;
		this.authorId = authorId;
	}

	public int getNumber() {
		return number;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
