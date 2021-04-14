package zkt.spring.start;

public class Order {
	private NotifyService notifyservice;
	private Customer customer;
	private String orderno;

	/*
	 * notifyservice不是在内部new()出来的，而是通过指定方法传进来的，也就是我们说的注入。 这里是setter注入。
	 */
	public Order() {
		this.setCustomer(new Customer());
	}

	public Order(Customer customer, String orderno, NotifyService notifyservice) {
		this.setCustomer(customer);
		this.setOrderno(orderno);
		this.notifyservice = notifyservice;
	}

	/**
	 * 订单支付完成后发送通知。
	 */
	public void paySuccess() {
		notifyservice.sendMessage("客户" + customer.getName() + "的订单"
				+ orderno + "支付成功！");
	}

	public NotifyService getNotifyservice() {
		return notifyservice;
	}

	/**
	 * @Description: set后面跟的第一个字母大小写不限，
	 * 再后面则必须要和xml配置中的property name一致。
	 * @param notifyservice
	 */
	public void setNotifyservice(NotifyService notifyservice) {
		this.notifyservice = notifyservice;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the orderno
	 */
	public String getOrderno() {
		return orderno;
	}

	/**
	 * @param orderno
	 *            the orderno to set
	 */
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
}
