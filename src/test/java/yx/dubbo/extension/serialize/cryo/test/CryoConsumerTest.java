package yx.dubbo.extension.serialize.cryo.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yx.dubbo.extension.serialize.cryo.custom.KryoCustom;
import yx.dubbo.extension.serialize.cryo.custom.KryoRegister;

import com.esotericsoftware.kryo.Kryo;

public class CryoConsumerTest {

	@Test
	public void testConsumer() {
		KryoRegister.register(new KryoCustom() {

			@Override
			public void custom(Kryo kryo) {
				kryo.register(Map.class, new HashMapSerializer());
				kryo.register(List.class, new ArrayListSerializer());
				kryo.register(Arrays.asList("").getClass(), new ArrayListSerializer());
			}
		});
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml")) {
			ISomeObjectService serviceBean = context.getBean(ISomeObjectService.class);

			SomeObject one = serviceBean.find(1);
			Assert.assertEquals(1, one.getId());
			Assert.assertEquals("name", one.getString());
			Assert.assertEquals(7758, one.getIntVal());
			Assert.assertArrayEquals(new byte[] { 1, 2, 3, 4 }, one.getBytes());
			List<String> list = one.getList();
			Assert.assertEquals(3, list.size());
			Assert.assertEquals("a", list.get(0));

			List<SomeObject> multi = serviceBean.find(new long[] { 1 });
			Assert.assertEquals(2, multi.size());
			SomeObject second = multi.get(1);
			Assert.assertEquals(2, second.getId());
			Assert.assertEquals("中文", second.getString());
			Assert.assertEquals(8577, second.getIntVal());
			Assert.assertArrayEquals(new byte[] { 4, 3, 2, 1 }, second.getBytes());
			List<String> secondlist = second.getList();
			Assert.assertEquals(3, secondlist.size());
			Assert.assertEquals("c", secondlist.get(0));
		}
	}

}
