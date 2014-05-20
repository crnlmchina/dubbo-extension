package yx.dubbo.extension.serialize.cryo.test;

import java.util.Arrays;
import java.util.List;

public class SomeObjectService implements ISomeObjectService {

	@Override
	public SomeObject find(long id) {
		SomeObject someObject = new SomeObject();
		someObject.setId(1);
		someObject.setString("name");
		someObject.setIntVal(7758);
		someObject.setBytes(new byte[] { 1, 2, 3, 4 });
		someObject.setList(Arrays.asList("a", "b", "c"));
		return someObject;
	}

	@Override
	public List<SomeObject> find(long[] ids) {
		SomeObject someObject1 = new SomeObject();
		someObject1.setId(1);
		someObject1.setString("name");
		someObject1.setIntVal(7758);
		someObject1.setBytes(new byte[] { 1, 2, 3, 4 });
		someObject1.setList(Arrays.asList("a", "b", "c"));

		SomeObject someObject2 = new SomeObject();
		someObject2.setId(2);
		someObject2.setString("中文");
		someObject2.setIntVal(8577);
		someObject2.setBytes(new byte[] { 4, 3, 2, 1 });
		someObject2.setList(Arrays.asList("c", "b", "a"));

		return Arrays.asList(someObject1, someObject2);
	}

	@Override
	public SomeObjectWithoutNoArgConstructor findNoArg(long id) {
		return new SomeObjectWithoutNoArgConstructor("Ha ha ha~");
	}

}
