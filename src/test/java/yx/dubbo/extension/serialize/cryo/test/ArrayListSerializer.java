package yx.dubbo.extension.serialize.cryo.test;

import java.util.Collection;
import java.util.List;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.google.common.collect.Lists;

public class ArrayListSerializer extends CollectionSerializer {

	@Override
	protected List create(Kryo kryo, Input input, Class<Collection> type) {
		return Lists.newArrayList();
	}

}
