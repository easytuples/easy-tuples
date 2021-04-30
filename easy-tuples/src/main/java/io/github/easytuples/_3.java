package io.github.easytuples;

/**
 * Tuple with 3 fields.
 */
public record _3<A, B, C>(A _1, B _2, C _3) {
    /**
     * The number of fields stored within the tuple.
     */
    public static final int SIZE = 3;

   /* ********************************************************************************
    * Factories
    *    Create instances of the tuple.
    * ********************************************************************************/

    /**
     * {@return 3-tuple instance containing the objects passed in as arguments. }
     */
    public static <A, B, C> _3<A, B, C> of(A _1, B _2, C _3) {
        return new _3<>(_1, _2, _3);
    }

    /* ********************************************************************************
     * Setters
     *    Generate a new tuple with the element at the given index in the tuple replaced.
     * ********************************************************************************/ 
    /**
     * {@return New instance of a 3-tuple with the object at index 1 set to the given argument. }
     */
    public <T1> _3<T1, B, C> set1(T1 arg) {
        return new _3<>(arg, _2, _3);
    }
 
    /**
     * {@return New instance of a 3-tuple with the object at index 2 set to the given argument. }
     */
    public <T2> _3<A, T2, C> set2(T2 arg) {
        return new _3<>(_1, arg, _3);
    }
 
    /**
     * {@return New instance of a 3-tuple with the object at index 3 set to the given argument. }
     */
    public <T3> _3<A, B, T3> set3(T3 arg) {
        return new _3<>(_1, _2, arg);
    }

    /* ********************************************************************************
     * Appender
     *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.
     * ********************************************************************************/

    /**
     * {@return New instance of a 4-tuple with all fields the same and
     *          an additional field at the last index set to the argument. }
     */
    public <T> _4<A, B, C, T> append(T arg) {
        return new _4<>(_1, _2, _3, arg);
    }
}
