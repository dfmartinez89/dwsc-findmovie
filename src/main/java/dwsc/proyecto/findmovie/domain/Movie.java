package dwsc.proyecto.findmovie.domain;

import org.springframework.data.annotation.Id;

public class Movie {
	@Id
	private String id;

	private String title;
	private int year;
	private double scoreAverage;
	private String description;
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getAverageScore() {
		return scoreAverage;
	}

	public void setAverageScore(double averageScore) {
		this.scoreAverage = averageScore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
