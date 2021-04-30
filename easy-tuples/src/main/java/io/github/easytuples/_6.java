package io.github.easytuples;

/**
 * Tuple with 6 fields.
 */
public record _6<A, B, C, D, E, F>(A _1, B _2, C _3, D _4, E _5, F _6) {
    /**
     * The number of fields stored within the tuple.
     */
    public static final int SIZE = 6;

   /* ********************************************************************************
    * Factories
    *    Create instances of the tuple.
    * ********************************************************************************/

    /**
     * {@return 6-tuple instance containing the objects passed in as arguments. }
     */
    public static <A, B, C, D, E, F> _6<A, B, C, D, E, F> of(A _1, B _2, C _3, D _4, E _5, F _6) {
        return new _6<>(_1, _2, _3, _4, _5, _6);
    }

    /* ********************************************************************************
     * Setters
     *    Generate a new tuple with the element at the given index in the tuple replaced.
     * ********************************************************************************/ 
    /**
     * {@return New instance of a 6-tuple with the object at index 1 set to the given argument. }
     */
    public <T1> _6<T1, B, C, D, E, F> set1(T1 arg) {
        return new _6<>(arg, _2, _3, _4, _5, _6);
    }
 
    /**
     * {@return New instance of a 6-tuple with the object at index 2 set to the given argument. }
     */
    public <T2> _6<A, T2, C, D, E, F> set2(T2 arg) {
        return new _6<>(_1, arg, _3, _4, _5, _6);
    }
 
    /**
     * {@return New instance of a 6-tuple with the object at index 3 set to the given argument. }
     */
    public <T3> _6<A, B, T3, D, E, F> set3(T3 arg) {
        return new _6<>(_1, _2, arg, _4, _5, _6);
    }
 
    /**
     * {@return New instance of a 6-tuple with the object at index 4 set to the given argument. }
     */
    public <T4> _6<A, B, C, T4, E, F> set4(T4 arg) {
        return new _6<>(_1, _2, _3, arg, _5, _6);
    }
 
    /**
     * {@return New instance of a 6-tuple with the object at index 5 set to the given argument. }
     */
    public <T5> _6<A, B, C, D, T5, F> set5(T5 arg) {
        return new _6<>(_1, _2, _3, _4, arg, _6);
    }
 
    /**
     * {@return New instance of a 6-tuple with the object at index 6 set to the given argument. }
     */
    public <T6> _6<A, B, C, D, E, T6> set6(T6 arg) {
        return new _6<>(_1, _2, _3, _4, _5, arg);
    }

    /* ********************************************************************************
     * Appender
     *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.
     * ********************************************************************************/

    /**
     * {@return New instance of a 7-tuple with all fields the same and
     *          an additional field at the last index set to the argument. }
     */
    public <T> _7<A, B, C, D, E, F, T> append(T arg) {
        return new _7<>(_1, _2, _3, _4, _5, _6, arg);
    }
}
