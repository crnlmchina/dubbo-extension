package yx.dubbo.extension.serialize.cryo.test;

public class SomeObjectWithoutNoArgConstructor {
	
	private String smile;

	public SomeObjectWithoutNoArgConstructor(String smile) {
		super();
		this.smile = smile;
	}

	public String getSmile() {
		return smile;
	}
	
}
