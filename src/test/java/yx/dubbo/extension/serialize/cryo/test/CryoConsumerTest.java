package yx.dubbo.extension.serialize.cryo.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CryoConsumerTest {

	@Test
	public void testConsumer() {
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
	
	@Test
	public void testConsumerNoArg() {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml")) {
			ISomeObjectService serviceBean = context.getBean(ISomeObjectService.class);
			
			SomeObjectWithoutNoArgConstructor findNoArg = serviceBean.findNoArg(0);
			Assert.assertEquals("Ha ha ha~", findNoArg.getSmile());
		}
	}

}
