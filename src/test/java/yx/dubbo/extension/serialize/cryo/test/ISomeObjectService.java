package yx.dubbo.extension.serialize.cryo.test;

import java.util.List;

public interface ISomeObjectService {
	
	SomeObject find(long id);
	
	List<SomeObject> find(long[] ids);
	
}
