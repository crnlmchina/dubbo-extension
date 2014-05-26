package yx.dubbo.extension.serialize.cryo.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.esotericsoftware.kryo.Kryo;

import yx.dubbo.extension.serialize.cryo.custom.KryoCustom;
import yx.dubbo.extension.serialize.cryo.custom.KryoRegister;

public class CryoProviderTest {

	@Test
	public void testProvider() {
		KryoRegister.register(new KryoCustom() {

			@Override
			public void custom(Kryo kryo) {
				kryo.register(Map.class, new HashMapSerializer());
				kryo.register(List.class, new ArrayListSerializer());
				kryo.register(Arrays.asList("").getClass(), new ArrayListSerializer());
			}
		});
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
