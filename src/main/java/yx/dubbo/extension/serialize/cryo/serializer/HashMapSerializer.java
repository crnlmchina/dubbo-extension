package yx.dubbo.extension.serialize.cryo.serializer;

import java.util.HashMap;
import java.util.Map;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.serializers.MapSerializer;

public class HashMapSerializer extends MapSerializer {

	@Override
	protected Map create(Kryo kryo, Input input, Class<Map> type) {
		return new HashMap();
	}


}
