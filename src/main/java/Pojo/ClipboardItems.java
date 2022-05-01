package Pojo;

import java.util.List;

public class ClipboardItems {
	
	private List<Integer> items;
	private String appCode;
	private String appVersion;
	
	public List<Integer> getItems() {
		return items;
	}
	public void setItems(List<Integer> items) {
		this.items = items;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	
	
	
	public ClipboardItems( String appCode, String appVersion) {
		
	
		this.appCode = appCode;
		this.appVersion = appVersion;
	}
	@Override
	public String toString() {
		return "ClipboardItems [items=" + items + ", appCode=" + appCode + ", appVersion=" + appVersion + "]";
	}
	
	
	
	

}
