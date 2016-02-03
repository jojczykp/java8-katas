package pl.jojczykp.java8_katas.ch3_lambda_programming;

import java.lang.reflect.Field;
import java.util.Comparator;

public final class Exercise_3_9_YieldingComparator {

	public Comparator<Object> lexicographicComparator(String... fieldNames) {
		return (o1, o2) -> {
			for (String fieldName : fieldNames) {
				int cmpResult = stringVal(o1, fieldName).compareTo(stringVal(o2, fieldName));
				if (cmpResult != 0) {
					return cmpResult;
				}
			}
			return 0;
		};
	}

	private String stringVal(Object obj, String fieldName) {
		try {
			Field field = obj.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(obj).toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static class Person {
		private String firstname;
		private String middlename;
		private String lastname;

		public Person(String firstname, String middlename, String lastname) {
			this.firstname = firstname;
			this.middlename = middlename;
			this.lastname = lastname;
		}
	}

}
