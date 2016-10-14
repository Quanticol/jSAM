/**
 * 
 */
package org.cmg.ml.sam.klaim.core;

/**
 * @author loreti
 *
 */
public abstract class KType implements Comparable<KType> {

	public static enum TypeCode {

		KVOID(-1),
		KBOOL(0),
		KINT(1),
		KDOUBLE(2),
		KLOCALITY(3),
		KSTRING(4),
		KVECTOR(5),
		KMATRIX(6),
		KLIST(7),
		KPROCESS(8);
		
		
		private final int code;

		TypeCode( int code ) {
			this.code = code;
		}
		
		int code() {
			return code;
		}
		
	}

	public static KType booleanType = new KBoolean();
	public static KType integerType = new KInteger();
	public static KType doubleType = new KDouble();
	public static KType localityType = new KLocality();
	public static KType stringType = new KString();
	
	public abstract TypeCode getCode();
	
	@Override
	public int compareTo(KType arg0) {			
		return getCode().code-arg0.getCode().code;
	}
	
	public static class KBoolean extends KType {

		@Override
		public TypeCode getCode() {
			return TypeCode.KBOOL;
		}
		 
	}

	public static class KInteger extends KType {
	
		@Override
		public TypeCode getCode() {
			return TypeCode.KINT;
		}
		 
	}

	public static class KDouble extends KType {
	
		@Override
		public TypeCode getCode() {
			return TypeCode.KDOUBLE;
		}
		 
	}

	public static class KLocality extends KType {
	
		@Override
		public TypeCode getCode() {
			return TypeCode.KLOCALITY;
		}
		 
	}

	public static class KString extends KType {
	
		@Override
		public TypeCode getCode() {
			return TypeCode.KSTRING;
		}
		 
	}

	public static class KVector extends KType {
	
		private KType arrayType;
		
		public KVector( KType arrayType ) {
			this.arrayType = arrayType;
		}
		
		
		@Override
		public int compareTo(KType arg0) {
			if (arg0 instanceof KVector) {
				KVector a = (KVector) arg0;
				int foo = arrayType.compareTo(a.arrayType);
				return foo;
			}
			return super.compareTo(arg0);
		}

		@Override
		public TypeCode getCode() {
			return TypeCode.KVECTOR;
		}
		
		public KType getArrayType() {
			return arrayType;
		}
		 
	}
	
	public static class KMatrix extends KType {
		
		private KType matrixType;
		private int rows;
		private int cols;
		
		public KMatrix( KType arrayType , int rows , int cols ) {
			this.matrixType = arrayType;
			this.rows = rows;
			this.cols = cols;
		}
		
		
		@Override
		public int compareTo(KType arg0) {
			if (arg0 instanceof KVector) {
				KMatrix a = (KMatrix) arg0;
				int foo = matrixType.compareTo(a.matrixType);
				if (foo != 0) {
					return foo;
				}
				foo = rows-a.rows;
				if (foo != 0) {
					return foo;
				}
				return cols-a.cols;
			}
			return super.compareTo(arg0);
		}

		@Override
		public TypeCode getCode() {
			return TypeCode.KVECTOR;
		}
		
		public KType getMatrixType() {
			return matrixType;
		}
		 
	}
	public static class KList extends KType {
		
		public KType listType;
		
		public KList( KType listType ) {
			this.listType = listType;
		}
		
		@Override
		public TypeCode getCode() {
			return TypeCode.KLIST;
		}
		
		@Override
		public int compareTo(KType arg0) {
			if (arg0 instanceof KList) {
				KList l = (KList) arg0;
				return listType.compareTo(l.listType);
			}
			return super.compareTo(arg0);
		}

		public KType getListType() {
			return listType;
		}
		 
	}
}
