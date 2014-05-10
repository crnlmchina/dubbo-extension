package yx.dubbo.extension.serialize.cryo;

import java.io.IOException;
import java.io.OutputStream;

import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

/**
 * @author yuxuan
 *
 */
public class CryoObjectOutput implements ObjectOutput {
	
	private Output output;
	
	private Kryo kryo;

	public CryoObjectOutput(OutputStream output) {
		super();
		this.output = new Output(output);
		kryo = KryoFactory.getInstance();
	}

	@Override
	public void writeBool(boolean v) throws IOException {
		kryo.writeObject(output, v);
	}

	@Override
	public void writeByte(byte v) throws IOException {
		kryo.writeObject(output, v);
	}

	@Override
	public void writeShort(short v) throws IOException {
		kryo.writeObject(output, v);
	}

	@Override
	public void writeInt(int v) throws IOException {
		kryo.writeObject(output, v);
	}

	@Override
	public void writeLong(long v) throws IOException {
		kryo.writeObject(output, v);
	}

	@Override
	public void writeFloat(float v) throws IOException {
		kryo.writeObject(output, v);
	}

	@Override
	public void writeDouble(double v) throws IOException {
		kryo.writeObject(output, v);
	}

	@Override
	public void writeUTF(String v) throws IOException {
		kryo.writeObject(output, v);
	}

	@Override
	public void writeBytes(byte[] v) throws IOException {
		kryo.writeObject(output, v);
	}

	@Override
	public void writeBytes(byte[] v, int off, int len) throws IOException {
		kryo.writeObject(output, v);
	}

	@Override
	public void flushBuffer() throws IOException {
		output.flush();
	}

	@Override
	public void writeObject(Object obj) throws IOException {
		kryo.writeObject(output, obj);
	}

}
