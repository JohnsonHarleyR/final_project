package co.grandcircus.FinalProject.PaperQuotes;

import java.util.Arrays;

public class PaperQuoteResponse {
	
	private String next;
	private String previous;
	private Result[] results;
	
	//@return GET next
	public String getNext() {
		return next;
	}
	
	//@param SET next
	public void setNext(String next) {
		this.next = next;
	}
	
	//@return GET previous
	public String getPrevious() {
		return previous;
	}
	
	//@param SET previous
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	
	//@return GET results
	public Result[] getResults() {
		return results;
	}
	
	//@param SET results
	public void setResults(Result[] results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "PaperQuoteResponse [next=" + next + ", previous=" + previous + ", results=" + Arrays.toString(results)
				+ "]";
	}
	
	
	
	

}
