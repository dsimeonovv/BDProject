package com.libraries.domain;

public class Book {
	private String title;
	private int volume_sheets;
	private int releaseYear;
	private String type;

	public Book(String title,  int volume_sheets, int releaseYear, String type, int author_id) {
		this(type, title, releaseYear);
		this.volume_sheets = volume_sheets;
	}

	public Book(String title, String type) {
		this.title = title;
		this.type = type;
	}

	public Book(String title, String type, int release_year) {
		this(type, title);
		this.releaseYear = release_year;
	}

	public String getTitle() {
		return title;
	}

	public int getVolumeSheets() {
		return volume_sheets;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public String getType() {
		return type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setVolumeSheets(int volumeSheets) {
		this.volume_sheets = volumeSheets;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", volumeSheets=" + volume_sheets
				+ ", releaseYear=" + releaseYear + ", type=" + type + "]";
	}

}
