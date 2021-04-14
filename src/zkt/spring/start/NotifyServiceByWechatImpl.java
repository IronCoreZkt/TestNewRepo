package zkt.spring.start;

public class NotifyServiceByWechatImpl implements NotifyService {

	@Override
	public void sendMessage(String message) {
		System.out.println("发送微信短信：" + message);
	}

}
