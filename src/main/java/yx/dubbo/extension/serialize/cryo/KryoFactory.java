package yx.dubbo.extension.serialize.cryo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import yx.dubbo.extension.serialize.cryo.serializer.ArrayListSerializer;
import yx.dubbo.extension.serialize.cryo.serializer.HashMapSerializer;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author yuxuan
 *
 */
public final class KryoFactory {

	public static Kryo getInstance() {
		Kryo kryo = new Kryo();
		kryo.setRegistrationRequired(false);
		new KryoFactory().register(kryo);
		return kryo;
	}

	protected void register(Kryo kryo) {
		kryo.register(Map.class, new HashMapSerializer());
		kryo.register(Arrays.asList().getClass(), new ArrayListSerializer());
		kryo.register(List.class, new ArrayListSerializer());
	}

}
