package yx.dubbo.extension.monitor.dangdang;

import java.util.List;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.monitor.MonitorService;

public class DDMonitorService implements MonitorService {

	@Override
	public void collect(URL statistics) {
		System.out.println("[collect] "+statistics);
	}

	@Override
	public List<URL> lookup(URL query) {
		System.out.println("[lookup] " + query);
		return null;
	}

}
