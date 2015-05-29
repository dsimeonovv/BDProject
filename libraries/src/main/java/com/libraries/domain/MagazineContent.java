package com.libraries.domain;

public class MagazineContent {
	private String content;
	
	public MagazineContent(String content){
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return content;
	}
	
	
}
