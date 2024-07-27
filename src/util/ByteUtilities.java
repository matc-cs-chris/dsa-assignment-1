package util;

public class ByteUtilities {
    public static Byte[] toObjectArray(byte[] primitiveArray) {
        Byte[] result = new Byte[primitiveArray.length];

        for(int i = 0; i < primitiveArray.length;i++) {
            //example of auto-boxing
            result[i] = primitiveArray[i];
        }

        return result;
    }

    public static byte[] toPrimitiveArray(Byte[] boxedArray) {
        byte[] result = new byte[boxedArray.length];

        for(int i = 0; i < boxedArray.length;i++) {
            //example of auto-unboxing
            result[i] = boxedArray[i];
        }

        return result;
    }
}
