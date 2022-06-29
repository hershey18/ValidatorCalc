package com.calebpower.demo.wow;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Queries the Owen Wilson WOW API for random fun facts.
 * 
 * @author Caleb L. Power
 */
public class QueryHandler implements Runnable {
  
  private static final String URL = "https://owen-wilson-wow-api.herokuapp.com/wows/random";
  
  private final OkHttpClient httpClient = new OkHttpClient();
  private final Request request = new Request.Builder()
      .url(URL)
      .build();
  
  @Override public void run() {
    Fact fact = null;
    
    try(Response response = httpClient.newCall(request).execute()) {
      JSONObject result = new JSONArray(response.body().string()).getJSONObject(0);
      fact = new Fact(
          result.getString("full_line"),
          result.getString("movie"),
          result.getInt("year"),
          result.getString("character"),
          result.getString("timestamp"),
          result.getInt("current_wow_in_movie"),
          result.getInt("total_wows_in_movie"));
    } catch(JSONException e) {
      System.err.printf(
          "Unfortunately, the response could not be parsed: %1$s\n",
          e.getMessage());
    } catch(IOException e) {
      System.err.printf(
          "Unfortunately, we could not connect to the API: %1$s\n",
          e.getMessage());
    }
    
    if(fact != null) {
      System.out.printf("In the movie \"%1$s\" (%2$d), Owen Wilson's character "
          + "%3$s says \"%4$s\" at %5$s. This was wow number %6$d out of a "
          + "total of %7$d %8$s in the movie.\n",
          fact.getMovie(),
          fact.getYear(),
          fact.getCharacter(),
          fact.getQuote(),
          fact.getTimestamp(),
          fact.getCurrentWow(),
          fact.getTotalWows(),
          fact.getTotalWows() == 1 ? "wow" : "wows");
    }
  }
  
}
