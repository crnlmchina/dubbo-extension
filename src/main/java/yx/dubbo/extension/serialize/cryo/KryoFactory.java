package yx.dubbo.extension.serialize.cryo;

import yx.dubbo.extension.serialize.cryo.custom.KryoCustom;
import yx.dubbo.extension.serialize.cryo.custom.KryoRegister;

import com.esotericsoftware.kryo.Kryo;

/**
 * @author yuxuan
 *
 */
public final class KryoFactory {

	public static Kryo getInstance() {
		Kryo kryo = new Kryo();
		kryo.setRegistrationRequired(false);
		customerBehavior(kryo);
		return kryo;
	}

	private static void customerBehavior(Kryo kryo) {
		KryoCustom kryoCustom = KryoRegister.get();
		if (kryoCustom != null) {
			kryoCustom.custom(kryo);
		}
	}

}
