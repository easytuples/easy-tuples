package io.github.easytuples;

/**
 * Tuple with 5 fields.
 */
public record _5<A, B, C, D, E>(A _1, B _2, C _3, D _4, E _5) {
    /**
     * The number of fields stored within the tuple.
     */
    public static final int SIZE = 5;

   /* ********************************************************************************
    * Factories
    *    Create instances of the tuple.
    * ********************************************************************************/

    /**
     * {@return 5-tuple instance containing the objects passed in as arguments. }
     */
    public static <A, B, C, D, E> _5<A, B, C, D, E> of(A _1, B _2, C _3, D _4, E _5) {
        return new _5<>(_1, _2, _3, _4, _5);
    }

    /* ********************************************************************************
     * Setters
     *    Generate a new tuple with the element at the given index in the tuple replaced.
     * ********************************************************************************/ 
    /**
     * {@return New instance of a 5-tuple with the object at index 1 set to the given argument. }
     */
    public <T1> _5<T1, B, C, D, E> set1(T1 arg) {
        return new _5<>(arg, _2, _3, _4, _5);
    }
 
    /**
     * {@return New instance of a 5-tuple with the object at index 2 set to the given argument. }
     */
    public <T2> _5<A, T2, C, D, E> set2(T2 arg) {
        return new _5<>(_1, arg, _3, _4, _5);
    }
 
    /**
     * {@return New instance of a 5-tuple with the object at index 3 set to the given argument. }
     */
    public <T3> _5<A, B, T3, D, E> set3(T3 arg) {
        return new _5<>(_1, _2, arg, _4, _5);
    }
 
    /**
     * {@return New instance of a 5-tuple with the object at index 4 set to the given argument. }
     */
    public <T4> _5<A, B, C, T4, E> set4(T4 arg) {
        return new _5<>(_1, _2, _3, arg, _5);
    }
 
    /**
     * {@return New instance of a 5-tuple with the object at index 5 set to the given argument. }
     */
    public <T5> _5<A, B, C, D, T5> set5(T5 arg) {
        return new _5<>(_1, _2, _3, _4, arg);
    }

    /* ********************************************************************************
     * Appender
     *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.
     * ********************************************************************************/

    /**
     * {@return New instance of a 6-tuple with all fields the same and
     *          an additional field at the last index set to the argument. }
     */
    public <T> _6<A, B, C, D, E, T> append(T arg) {
        return new _6<>(_1, _2, _3, _4, _5, arg);
    }
}
