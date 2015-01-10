package sk.mihalyi.research.modelMapper.util.helpers;

public class Mutator<T> {
	protected T mutatedInstance;
	protected Mutator(T mutatedInstance) {
		this.mutatedInstance = mutatedInstance;
	}
}
