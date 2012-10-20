
package tv.tipoff.services.pgep.dto;

import java.util.List;

public class Results<E> {
   	private Number itemsPerPage;
   	private List<E> results;
   	private String self;
   	private Number startIndex;
   	private Number totalResults;

 	public Number getItemsPerPage(){
		return this.itemsPerPage;
	}
	public void setItemsPerPage(Number itemsPerPage){
		this.itemsPerPage = itemsPerPage;
	}
 	public List<E> getResults(){
		return this.results;
	}
	public void setResults(List<E> results){
		this.results = results;
	}
 	public String getSelf(){
		return this.self;
	}
	public void setSelf(String self){
		this.self = self;
	}
 	public Number getStartIndex(){
		return this.startIndex;
	}
	public void setStartIndex(Number startIndex){
		this.startIndex = startIndex;
	}
 	public Number getTotalResults(){
		return this.totalResults;
	}
	public void setTotalResults(Number totalResults){
		this.totalResults = totalResults;
	}
}
