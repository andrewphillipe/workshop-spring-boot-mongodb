package br.com.company.workshopmongo.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8784572180802222657L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
