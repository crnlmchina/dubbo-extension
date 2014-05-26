package yx.dubbo.extension.serialize.cryo.custom;

import com.esotericsoftware.kryo.Kryo;

/**
 * 通过注册这个接口的实现定制Kryo行为
 * 
 * @author yuxuan
 *
 */
public interface KryoCustom {

	void custom(Kryo kryo);

}
