package co.grandcircus.FinalProject.WorkoutsApi;

import java.util.List;

public class ExerciseInfo {
	private Integer count;
	private String next;
	private String previous;
	private List<Results> results;

	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<Results> getResults() {
		return results;
	}
	public void setResults(List<Results> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "ExerciseInfo [count=" + count + ", next=" + next + ", previous=" + previous + ", results=" + results
				+ "]";
	}
	
	
	
	
}
