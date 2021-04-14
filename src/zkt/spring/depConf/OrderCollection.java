package zkt.spring.depConf;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class OrderCollection {
	private Properties emailConfig;
	private List<String> productNames;
	private Map<String, String> purchaseList;
	private Set<String> setOthers;

	public String toString() {
		return  "OrderCollection:\n[Emailconfig=" + emailConfig + ",\n Productnames="
                + productNames + ",\n purchaseList=" + purchaseList
                + ",\n setOthers=" + setOthers + "]";
	}
	
	public void print(){
		System.out.println(this.toString());
	}

	// getter and setter methods
	public Properties getEmailConfig() {
		return emailConfig;
	}

	public void setEmailConfig(Properties emailConfig) {
		this.emailConfig = emailConfig;
	}

	public List<String> getProductNames() {
		return productNames;
	}

	public void setProductNames(List<String> productNames) {
		this.productNames = productNames;
	}

	public Map<String, String> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(Map<String, String> purchaseList) {
		this.purchaseList = purchaseList;
	}

	public Set<String> getSetOthers() {
		return setOthers;
	}

	public void setSetOthers(Set<String> setOthers) {
		this.setOthers = setOthers;
	}
}
