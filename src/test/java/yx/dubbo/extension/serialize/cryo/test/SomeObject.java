package yx.dubbo.extension.serialize.cryo.test;

import java.io.Serializable;
import java.util.List;

public class SomeObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;

	private String string;

	private int intVal;

	private byte[] bytes;

	private List<String> list;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public int getIntVal() {
		return intVal;
	}

	public void setIntVal(int intVal) {
		this.intVal = intVal;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
