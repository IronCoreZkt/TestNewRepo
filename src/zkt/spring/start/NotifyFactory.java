package zkt.spring.start;

public class NotifyFactory {
	// 静态工厂方法
	public static NotifyService getNotifyService() {
		return new NotifyServiceByWechatImpl();
	}
	// 普通实例工厂方法
	public NotifyService getNotifyService2(){
		return new NotifyServiceByWechatImpl();
	}

}
