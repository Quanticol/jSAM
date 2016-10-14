/**
 * 
 */
package org.cmg.ml.sam.xtext.klaim.validation;

/**
 * @author loreti
 *
 */
public abstract class KlaimType {

	public static final String VOID_STRING = "void";
	public static final String ERROR_STRING = "error";
	public static final String BOOLEAN_STRING = "bool";
	public static final String INTEGER_STRING = "int";
	public static final String DOUBLE_STRING = "double";
	public static final String STRING_STRING = "string";
	public static final String TUPLE_STRING = "tuple";
	public static final String ANY_STRING = "any";
	public static final String COLLECTION_STRING = "collection";
	public static final String ARRAY_STRING = "array";
	public static final String LIST_STRING = "list";
	public static final String LOCALITY_STRING = "locality";
	public static final String PROCESS_STRING = "process";
	
	private Integer hash;
	
	@Override
	public boolean equals(Object arg0) {
		if (this==arg0) {
			return true;
		}
		if (!(arg0 instanceof KlaimType)) {
			return false;
		}
		return doEquals( (KlaimType) arg0 );
	}

	@Override
	public int hashCode() {
		if (hash == null) {
			hash = toString().hashCode();
		}
		return hash.intValue();
	}

	@Override
	public String toString() {
		return doToString();
	}

	public abstract boolean contains( KlaimType t );
	
	public abstract boolean doEquals( KlaimType t );
	
	public abstract String doToString();
	
	
	public static final KlaimType VOID = new KlaimVoidType();
	public static final KlaimType ERROR = new KlaimErrorType();
	public static final KlaimType BOOLEAN = new KlaimBooleanType();
	public static final KlaimType INTEGER = new KlaimIntegerType();
	public static final KlaimType DOUBLE = new KlaimDoubleType();
	public static final KlaimType STRING = new KlaimStringType();
	public static final KlaimType ANY = new KlaimAnyType();
	public static final KlaimType TUPLE = new KlaimTupleType();
	public static final KlaimType LOCALITY = new KlaimLocalityType();
	public static final KlaimType PROCESS = new KlaimProcessType();

	public static KlaimType getArray( KlaimType type ) {
		return new KlaimArrayType(type);
	}

	public static KlaimType getCollection( KlaimType type ) {
		return new KlaimCollectionType(type);
	}

	public static KlaimType getList( KlaimType type ) {
		return new KlaimListType(type);
	}

	
	private static class KlaimVoidType extends KlaimType {

		@Override
		public boolean contains(KlaimType t) {
			return equals(t);
		}

		@Override
		public boolean doEquals(KlaimType t) {
			return t==VOID;
		}

		@Override
		public String doToString() {
			return VOID_STRING;
		}
		
	}
	
	private static class KlaimErrorType extends KlaimType {

		@Override
		public boolean contains(KlaimType t) {
			return false;
		}

		@Override
		public boolean doEquals(KlaimType t) {
			return ERROR==t;
		}

		@Override
		public String doToString() {
			return ERROR_STRING;
		}
		
	}

	private static class KlaimBooleanType extends KlaimType {

		@Override
		public boolean contains(KlaimType t) {
			return equals(t);
		}

		@Override
		public boolean doEquals(KlaimType t) {
			return t==BOOLEAN;
		}

		@Override
		public String doToString() {
			return BOOLEAN_STRING;
		}
		
	}

	private static class KlaimIntegerType extends KlaimType {

		@Override
		public boolean contains(KlaimType t) {
			return equals(t);
		}

		@Override
		public boolean doEquals(KlaimType t) {
			return t==INTEGER;
		}

		@Override
		public String doToString() {
			return INTEGER_STRING;
		}
		
	}

	private static class KlaimDoubleType extends KlaimType {

		@Override
		public boolean contains(KlaimType t) {
			return (t==INTEGER)||(t==DOUBLE);
		}

		@Override
		public boolean doEquals(KlaimType t) {
			return t==DOUBLE;
		}

		@Override
		public String doToString() {
			return DOUBLE_STRING;
		}
		
	}

	private static class KlaimStringType extends KlaimType {

		@Override
		public boolean contains(KlaimType t) {
			return equals(t);
		}

		@Override
		public boolean doEquals(KlaimType t) {
			return t==STRING;
		}

		@Override
		public String doToString() {
			return STRING_STRING;
		}
		
	}

	private static class KlaimAnyType extends KlaimType {

		@Override
		public boolean contains(KlaimType t) {
			return false;
		}

		@Override
		public boolean doEquals(KlaimType t) {
			return t==ANY;
		}

		@Override
		public String doToString() {
			return ANY_STRING;
		}
		
	}

	private static class KlaimLocalityType extends KlaimType {

		@Override
		public boolean contains(KlaimType t) {
			return equals(t);
		}

		@Override
		public boolean doEquals(KlaimType t) {
			return t==LOCALITY;
		}

		@Override
		public String doToString() {
			return LOCALITY_STRING;
		}
		
	}
	
	private static class KlaimTupleType extends KlaimType {

		@Override
		public boolean contains(KlaimType t) {
			return equals(t);
		}

		@Override
		public boolean doEquals(KlaimType t) {
			return t==TUPLE;
		}

		@Override
		public String doToString() {
			return TUPLE_STRING;
		}
		
	}
	
	private static class KlaimArrayType extends KlaimType {
		
		private KlaimType type;
		
		public KlaimArrayType( KlaimType type ) {
			this.type = type;
		}

		@Override
		public boolean contains(KlaimType t) {
			return equals(t);
		}

		@Override
		public boolean doEquals(KlaimType t) {
			if (t instanceof KlaimArrayType) {
				return type.equals(((KlaimArrayType) t).type);
			}
			return false;
		}

		@Override
		public String doToString() {
			return type+" "+ARRAY_STRING;
		}
		
		
	}

	private static class KlaimListType extends KlaimType {
		
		private KlaimType type;
		
		public KlaimListType( KlaimType type ) {
			this.type = type;
		}
		
		@Override
		public boolean contains(KlaimType t) {
			return equals(t);
		}

		@Override
		public boolean doEquals(KlaimType t) {
			if (t instanceof KlaimListType) {
				return type.equals(((KlaimListType) t).type);
			}
			return false;
		}

		@Override
		public String doToString() {
			return type+" "+LIST_STRING;
		}
		
	}

	private static class KlaimCollectionType extends KlaimType {
		
		private KlaimType type;
		
		public KlaimCollectionType( KlaimType type ) {
			this.type = type;
		}
		
		@Override
		public boolean contains(KlaimType t) {
			return equals(t);
		}

		@Override
		public boolean doEquals(KlaimType t) {
			if (t instanceof KlaimCollectionType) {
				return type.equals(((KlaimCollectionType) t).type);
			}
			return false;
		}

		@Override
		public String doToString() {
			return type+" "+COLLECTION_STRING;
		}

	}

	private static class KlaimProcessType extends KlaimType {
	
		@Override
		public boolean contains(KlaimType t) {
			return equals(t);
		}
	
		@Override
		public boolean doEquals(KlaimType t) {
			return t==TUPLE;
		}
	
		@Override
		public String doToString() {
			return PROCESS_STRING;
		}
		
	}

}
