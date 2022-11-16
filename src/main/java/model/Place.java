package model;

public class Place {
	public String placeId;
	public String name;
	public String address;
	public String url;
	public Place(String placeId, String name, String address, String url) {
		super();
		this.placeId = placeId;
		this.name = name;
		this.address = address;
		this.url = url;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
