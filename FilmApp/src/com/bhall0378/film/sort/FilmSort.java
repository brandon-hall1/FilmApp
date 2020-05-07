package com.bhall0378.film.sort;

import java.util.Comparator;
import com.bhall0378.film.Film;

public class FilmSort {
	
	public static final Comparator<Film> SORT_BY_GENRE = new Comparator<Film>() {
		public int compare(Film o1, Film o2) {
			if(o1.getGenre().compareTo(o2.getGenre()) != 0) {
				return o1.getGenre().compareTo(o2.getGenre());
			} else {
				return o1.getName().compareTo(o2.getName());
			}
		}
	};
	
	public static final Comparator<Film> SORT_BY_RELEASE = new Comparator<Film>() {
		public int compare(Film o1, Film o2) {
			if(o1.getRelease().compareTo(o2.getRelease()) != 0) {
				return o1.getRelease().compareTo(o2.getRelease());
			} else {
				return o1.getName().compareTo(o2.getName());
			}
		}
	};
	
	public static final Comparator<Film> SORT_BY_RATING = new Comparator<Film>() {
		public int compare(Film o1, Film o2) {
			if(o1.getRating() != o2.getRating()) {
				return o2.getRating() - o1.getRating();
			} else {
				return o1.getName().compareTo(o2.getName());
			}
		}
	};
	
	public static final Comparator<Film> SORT_BY_NAME = new Comparator<Film>() {
		public int compare(Film o1, Film o2) {
			if(o1.getName().compareTo(o2.getName()) != 0){
				return o1.getName().compareTo(o2.getName());
			} else {
				return o1.getRelease().compareTo(o2.getRelease());
			}
		}
	};

	
}
