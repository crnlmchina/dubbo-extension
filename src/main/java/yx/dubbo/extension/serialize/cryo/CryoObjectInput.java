package yx.dubbo.extension.serialize.cryo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

/**
 * @author yuxuan
 *
 */
public class CryoObjectInput implements ObjectInput {

	private Input input;

	private Kryo kryo;

	public CryoObjectInput(InputStream input) {
		super();
		this.input = new Input(input);
		this.kryo = KryoFactory.getInstance();
	}

	@Override
	public boolean readBool() throws IOException {
		return kryo.readObject(input, Boolean.class);
	}

	@Override
	public byte readByte() throws IOException {
		return kryo.readObject(input, Byte.class);
	}

	@Override
	public short readShort() throws IOException {
		return kryo.readObject(input, Short.class);
	}

	@Override
	public int readInt() throws IOException {
		return kryo.readObject(input, Integer.class);
	}

	@Override
	public long readLong() throws IOException {
		return kryo.readObject(input, Long.class);
	}

	@Override
	public float readFloat() throws IOException {
		return kryo.readObject(input, Float.class);
	}

	@Override
	public double readDouble() throws IOException {
		return kryo.readObject(input, Double.class);
	}

	@Override
	public String readUTF() throws IOException {
		return kryo.readObject(input, String.class);
	}

	@Override
	public byte[] readBytes() throws IOException {
		return kryo.readObject(input, byte[].class);
	}

	@Override
	public Object readObject() throws IOException, ClassNotFoundException {
		return kryo.readObject(input, Object.class);
	}

	@Override
	public <T> T readObject(Class<T> cls) throws IOException,
			ClassNotFoundException {
		return kryo.readObject(input, cls);
	}

	@Override
	public <T> T readObject(Class<T> cls, Type type) throws IOException,
			ClassNotFoundException {
		return readObject(cls);
	}

}
