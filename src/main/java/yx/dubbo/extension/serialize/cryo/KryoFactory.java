package yx.dubbo.extension.serialize.cryo;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author yuxuan
 *
 */
public final class KryoFactory {
	
	public static Kryo getInstance() {
		Kryo kryo = new Kryo();
		kryo.setRegistrationRequired(false);
		return kryo;
	}

}
