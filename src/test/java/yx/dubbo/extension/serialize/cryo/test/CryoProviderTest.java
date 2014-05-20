package yx.dubbo.extension.serialize.cryo.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CryoProviderTest {

	@Test
	public void testProvider() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider.xml");
		Object lock = new Object();
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
			}
		}

	}

}
