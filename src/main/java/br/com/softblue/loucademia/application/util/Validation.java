package br.com.softblue.loucademia.application.util;

public class Validation {
	
	public static void assertNotEmpty(Object obj) throws ValidationException {
		if(obj instanceof String) {
			String s = (String) obj;
			if(StringUtils.isEmpty(s)) {
				throw new ValidationException("Otexto não pode ser nulo");
			}
		}
		if(obj ==null) {
		 throw new ValidationException("Valor não pode ser nulo");
		}
		}

}
