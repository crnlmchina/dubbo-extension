package yx.dubbo.extension.serialize.cryo.custom;

/**
 * 注册Kryo自定义行为
 * 
 * @author yuxuan
 *
 */
public class KryoRegister {

	private static KryoCustom KRYO_CUSTOM;

	public static void register(KryoCustom kryoCustom) {
		KRYO_CUSTOM = kryoCustom;
	}

	public static KryoCustom get() {
		return KRYO_CUSTOM;
	}

}
