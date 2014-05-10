package yx.dubbo.extension.serialize.cryo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.Serialization;

/**
 * @author yuxuan
 *
 */
public class CryoSerialization implements Serialization {

	@Override
	public byte getContentTypeId() {
		return 7;
	}

	@Override
	public String getContentType() {
		return "x-application/cryo";
	}

	@Override
	public ObjectOutput serialize(URL url, OutputStream output)
			throws IOException {
		return new CryoObjectOutput(output);
	}

	@Override
	public ObjectInput deserialize(URL url, InputStream input)
			throws IOException {
		return new CryoObjectInput(input);
	}

}
