package com.bhall0378.client;

import java.util.*;
import com.bhall0378.film.Film;
import com.bhall0378.film.FilmReader;
import com.bhall0378.film.sort.FilmSort;

public class FilmClient {
	private static Scanner scan = new Scanner(System.in);
	private static List<Film> films = FilmReader.getFilms("films.txt");
	public static void main(String[] args) {
		System.out.println("Welcome to the Film Database!");
		inputViewType();
		while(true) {
			System.out.println("Would you like to view the database another way?");
			System.out.println("Enter: \"yes\" or \"no\"");
			String input = scan.nextLine().toLowerCase();
			if(input.equals("yes")) {
				inputViewType();
			} else if (input.equals("no")) {
				break;
			} else {
				System.out.println(input + " isn't a valid input");
			}
		}
		scan.close();
		System.out.println("Thank you for using the Film Database!");
	}
	
	private static void inputViewType() {
		List<Film> filmsToDisplay = new ArrayList<>();
		System.out.println("How would you like to view the films?");
		System.out.println("Enter: \"search\", \"sort\", or \"viewall\"");
		while(true) {
			String input = scan.nextLine();
			try {
				if(input.toLowerCase().equals("search")) {
					filmsToDisplay = searchFilms();
					break;
				} else if(input.toLowerCase().equals("sort")) {
					filmsToDisplay = sortFilms();
					break;
				} else if(input.toLowerCase().equals("viewall")) {
					films.sort(FilmSort.SORT_BY_NAME);
					filmsToDisplay = films;
					break;
				} else {
					throw new IllegalArgumentException(input + " is not a valid input. \nPlease enter: \"search\", \"sort\", or \"viewall\"");
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		printFilmList(filmsToDisplay);
	}
	
	
	private static List<Film> searchFilms() {
		List<Film> searchedFilms = new ArrayList<>();
		System.out.println("How would you like to search?");
		System.out.println("Enter: \"genre\"");
		String searchType = scan.nextLine();
		try {
			if(searchType.toLowerCase().equals("genre")) {
				searchedFilms = searchByGenre();
			} else {
				throw new IllegalArgumentException(searchType + " is not a valid input. \nPlease enter: \"genre\"");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return searchedFilms;
	}
	
	private static List<Film> searchByGenre(){
		List<Film> filmsOfGenre = new ArrayList<>();
		Set<String> genres = new HashSet<>();
		StringBuilder genreString = new StringBuilder("Enter: ");
		for(Film f : films) {
			genres.add(f.getGenre());
		}
		for(String genre : genres) {
			genreString.append("\"" + genre + "\",");
		}
		while(true) {
			System.out.println("What genre would you like to search for?");
			System.out.println(genres);
			try {
				String input = null;
				input = scan.nextLine();
				for(String g : genres) {
					if(input.toLowerCase().equals(g.toLowerCase())) {
						for(Film f : films) {
							if(input.toLowerCase().equals(f.getGenre().toLowerCase())) {
								filmsOfGenre.add(f);
							}
						}
					}
				}
				if(filmsOfGenre.size() == 0) {
					throw new IllegalArgumentException(input + " isn't a valid genre.");
				}
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return filmsOfGenre;
	}
	
	private static void printFilmList(List<Film> filmsToPrint) {
		for(Film f : filmsToPrint) {
			System.out.println(f);
		}
	}
	
	private static List<Film> sortFilms() {
		System.out.println("What would you like to sort the films by?");
		while(true) {
			System.out.println("Enter: \"name\", \"genre\", \"rating\", or \"date\"");
			String input = scan.nextLine().toLowerCase();
			if(input.equals("name")) {
				films.sort(FilmSort.SORT_BY_NAME);
				break;
			} else if (input.equals("genre")){
				films.sort(FilmSort.SORT_BY_GENRE);
				break;
			} else if (input.equals("rating")) {
				films.sort(FilmSort.SORT_BY_RATING);
				break;
			} else if (input.equals("date")) {
				films.sort(FilmSort.SORT_BY_RELEASE);
				break;
			} else {
				System.out.println(input + " isn't a valid input.");
			}
		}
		return films;
	}
}