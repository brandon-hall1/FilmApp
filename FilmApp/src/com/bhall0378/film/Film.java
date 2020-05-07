package com.bhall0378.film;

import java.time.LocalDate;

public class Film {
	private String type;
	private String name; //sort by
	private String genre; //sort by
	private LocalDate release; //sort by
	private int rating; //sort by
	
	public Film(String nameIn, String typeIn, String genreIn, int yearIn, int monthIn, int dayIn, int ratingIn) {
		name = nameIn;
		setType(typeIn);
		genre = genreIn;
		release = LocalDate.of(yearIn, monthIn, dayIn);
		setRating(ratingIn);
	}
	
	public void setType(String typeIn) {
		if(typeIn.equals("series") || typeIn.equals("movie")) {
			type = typeIn;
		} else {
			type = null;
		}
	}

	public void setRating(int ratingIn) {
		if(ratingIn >= 5) {
			rating = 5;
		} else if (ratingIn <= 1) {
			rating = 1;
		} else {
			rating = ratingIn;
		}
	}

	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public String getGenre() {
		return genre;
	}
	public LocalDate getRelease() {
		return release;
	}
	public int getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "Film [type=" + type + ", name=" + name + ", genre=" + genre + ", release=" + release + ", rating="
				+ rating + "]";
	}
}
