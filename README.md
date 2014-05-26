dubbo-extension
===============

Dubbo extension points implementation


Simple tutorial:

<dubbo:provider serialization="cryo" />


Custom Kryo instance:
KryoRegister.register(new KryoCustom() {

	@Override
	public void custom(Kryo kryo) {
		kryo.register(Map.class, new HashMapSerializer());
		kryo.register(List.class, new ArrayListSerializer());
	}
});
