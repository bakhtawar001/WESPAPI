package Pojo;

import java.util.List;

public class Products {
	
	private List<Results> Results;
	private int ResultsPerPage;
	private int ResultsTotal;
	public List<Results> getResults() {
		return Results;
	}
	public void setResults(List<Results> results) {
		Results = results;
	}
	public int getResultsPerPage() {
		return ResultsPerPage;
	}
	public void setResultsPerPage(int resultsPerPage) {
		ResultsPerPage = resultsPerPage;
	}
	public int getResultsTotal() {
		return ResultsTotal;
	}
	public void setResultsTotal(int resultsTotal) {
		ResultsTotal = resultsTotal;
	}
	@Override
	public String toString() {
		return "Products [Results=" + Results + ", ResultsPerPage=" + ResultsPerPage + ", ResultsTotal=" + ResultsTotal
				+ "]";
	}
	
	

}
