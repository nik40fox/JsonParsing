package com.placesOfHistory.JsonSample;

public class SearchObject {
		
	public int pageid;
    public int ns;
    public String title;
    public double lat;
    public double lon;
    public double dist;
    public String primary;
    
	@Override
	public String toString() {
		return "SearchObject [pageid=" + pageid + ", ns=" + ns + ", title=" + title + ", lat=" + lat + ", lon=" + lon
				+ ", dist=" + dist + ", primary=" + primary + "]";
	}
    
    
    
    
}
