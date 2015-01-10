package sk.mihalyi.research.modelMapper.tests.util.di;

import sk.mihalyi.research.modelMapper.util.di.Injector;

public class TestInjector {
	public static <T> T inject(Class<T> ofClass, Object receiver) {
		return Injector.inject(ofClass, receiver);
	}

}
