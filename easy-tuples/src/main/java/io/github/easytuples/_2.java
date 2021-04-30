package io.github.easytuples;

/**
 * Tuple with 2 fields.
 */
public record _2<A, B>(A _1, B _2) {
    /**
     * The number of fields stored within the tuple.
     */
    public static final int SIZE = 2;

   /* ********************************************************************************
    * Factories
    *    Create instances of the tuple.
    * ********************************************************************************/

    /**
     * {@return 2-tuple instance containing the objects passed in as arguments. }
     */
    public static <A, B> _2<A, B> of(A _1, B _2) {
        return new _2<>(_1, _2);
    }

    /* ********************************************************************************
     * Setters
     *    Generate a new tuple with the element at the given index in the tuple replaced.
     * ********************************************************************************/ 
    /**
     * {@return New instance of a 2-tuple with the object at index 1 set to the given argument. }
     */
    public <T1> _2<T1, B> set1(T1 arg) {
        return new _2<>(arg, _2);
    }
 
    /**
     * {@return New instance of a 2-tuple with the object at index 2 set to the given argument. }
     */
    public <T2> _2<A, T2> set2(T2 arg) {
        return new _2<>(_1, arg);
    }

    /* ********************************************************************************
     * Appender
     *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.
     * ********************************************************************************/

    /**
     * {@return New instance of a 3-tuple with all fields the same and
     *          an additional field at the last index set to the argument. }
     */
    public <T> _3<A, B, T> append(T arg) {
        return new _3<>(_1, _2, arg);
    }
}
