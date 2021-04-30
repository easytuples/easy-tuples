package io.github.easytuples;

/**
 * Tuple with 4 fields.
 */
public record _4<A, B, C, D>(A _1, B _2, C _3, D _4) {
    /**
     * The number of fields stored within the tuple.
     */
    public static final int SIZE = 4;

   /* ********************************************************************************
    * Factories
    *    Create instances of the tuple.
    * ********************************************************************************/

    /**
     * {@return 4-tuple instance containing the objects passed in as arguments. }
     */
    public static <A, B, C, D> _4<A, B, C, D> of(A _1, B _2, C _3, D _4) {
        return new _4<>(_1, _2, _3, _4);
    }

    /* ********************************************************************************
     * Setters
     *    Generate a new tuple with the element at the given index in the tuple replaced.
     * ********************************************************************************/ 
    /**
     * {@return New instance of a 4-tuple with the object at index 1 set to the given argument. }
     */
    public <T1> _4<T1, B, C, D> set1(T1 arg) {
        return new _4<>(arg, _2, _3, _4);
    }
 
    /**
     * {@return New instance of a 4-tuple with the object at index 2 set to the given argument. }
     */
    public <T2> _4<A, T2, C, D> set2(T2 arg) {
        return new _4<>(_1, arg, _3, _4);
    }
 
    /**
     * {@return New instance of a 4-tuple with the object at index 3 set to the given argument. }
     */
    public <T3> _4<A, B, T3, D> set3(T3 arg) {
        return new _4<>(_1, _2, arg, _4);
    }
 
    /**
     * {@return New instance of a 4-tuple with the object at index 4 set to the given argument. }
     */
    public <T4> _4<A, B, C, T4> set4(T4 arg) {
        return new _4<>(_1, _2, _3, arg);
    }

    /* ********************************************************************************
     * Appender
     *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.
     * ********************************************************************************/

    /**
     * {@return New instance of a 5-tuple with all fields the same and
     *          an additional field at the last index set to the argument. }
     */
    public <T> _5<A, B, C, D, T> append(T arg) {
        return new _5<>(_1, _2, _3, _4, arg);
    }
}
