package yx.dubbo.extension.monitor.dangdang.test;

import org.junit.Test;

import yx.dubbo.extension.monitor.dangdang.DDMonitorService;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.monitor.MonitorService;

public class MonitorServiceTest {

	@Test
	public void testStartMonitor() {
		MonitorService monitorService = new DDMonitorService();
		ApplicationConfig applicationConfig = new ApplicationConfig("dd-dubbo-monitor");
		RegistryConfig registryConfig = new RegistryConfig("cart-zoo1.dangdang.com:2181,cart-zoo2.dangdang.com:2181,cart-zoo3.dangdang.com:21810");
		registryConfig.setProtocol("zookeeper");

		ProtocolConfig protocolConfig = new ProtocolConfig("dubbo");
		protocolConfig.setPort(8088);

		ServiceConfig<MonitorService> service = new ServiceConfig<MonitorService>();
		service.setApplication(applicationConfig);
		service.setRegistry(registryConfig);
		service.setProtocol(protocolConfig);
		service.setRef(monitorService);
		service.setInterface(MonitorService.class);

		service.export();
		
		Object lock = new Object();
		synchronized (lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
