package com.bhall0378.film;

import java.io.*;
import java.util.*;

public class FilmReader {
	public static List<Film> getFilms(String fileName){
		List<Film> films = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String tempLine = null;
			while((tempLine = br.readLine()) != null) {
				if(tempLine.startsWith("#") || tempLine.startsWith("//") || (tempLine.trim().equals(""))) {
					continue;
				}
				String[] sa = tempLine.split(",");
				int year = Integer.parseInt(sa[3]);
				int month = Integer.parseInt(sa[4]);
				int day = Integer.parseInt(sa[5]);
				int rating = Integer.parseInt(sa[6]);
				Film tempFilm = new Film(sa[0],sa[1],sa[2],year,month,day,rating);
				films.add(tempFilm);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return films;
	}
}
