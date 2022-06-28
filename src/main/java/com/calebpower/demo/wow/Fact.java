package com.calebpower.demo.wow;

/**
 * Represents a fact obtained from the API.
 * 
 * @author Caleb L. Power
 */
public class Fact {
  
  private String movie = null;
  private String character = null;
  private String timestamp = null;
  private String quote = null;
  private int year;
  private int currentWow;
  private int totalWows;
  
  /**
   * Encapsulates fact metadata.
   * 
   * @param quote the line that Owen Wilson spoke in which he uttered his Wow
   * @param movie the title of the movie in which the Wow occurred
   * @param year the year the movie came out
   * @param character the character Owen Wilson played whilst issuing his Wow
   * @param timestamp time time in the movie at which the Wow was issued
   * @param currentWow the number of Wows issued up to this point in the movie (by Owen Wilson)
   * @param totalWows the total number of Wows issued in the movie (by Owen Wilson)
   */
  public Fact(String quote, String movie, int year, String character, String timestamp, int currentWow, int totalWows) {
    this.quote = quote;
    this.movie = movie;
    this.year = year;
    this.character = character;
    this.timestamp = timestamp;
    this.currentWow = currentWow;
    this.totalWows = totalWows;
  }
  
  /**
   * Retrieves the line that Owen Wilson spoke in which he uttered his Wow.
   * 
   * @return a quote from a movie, presumably one in which Owen Wilson says
   *         something to the effect of "Wow!"
   */
  public String getQuote() {
    return quote;
  }
  
  /**
   * Retrieves the title of the movie in which the Wow occurred.
   * 
   * @return a movie title
   */
  public String getMovie() {
    return movie;
  }
  
  /**
   * Retrieves the year during which the movie in question was released.
   * 
   * @return a movie release year
   */
  public int getYear() {
    return year;
  }
  
  /**
   * Retrieves the character Owen Wilson played whilst issuing the Wow in
   * question.
   * 
   * @return a character's name
   */
  public String getCharacter() {
    return character;
  }
  
  /**
   * Retrieves the timestamp during which the Wow in question was uttered.
   * 
   * @return a timestamp corresponding to a Wow
   */
  public String getTimestamp() {
    return timestamp;
  }
  
  /**
   * Retrieves the number of Wows, including the one in question, uttered up to
   * this particular point in the associated movie. Such Wows are assumed to
   * have been spoken by Owen Wilson.
   * 
   * @return an integer indicating the number of Wows up to this point in the
   *         movie
   */
  public int getCurrentWow() {
    return currentWow;
  }
  
  /**
   * Retrieves the total number of Wows spoken by Owen Wilson in the associated
   * film production.
   * 
   * @return an integer corresponding to the number of Wows uttered in total
   */
  public int getTotalWows() {
    return totalWows;
  }
  
}
