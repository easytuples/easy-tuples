package io.github.easytuples;

/**
 * Tuple with 8 fields.
 */
public record _8<A, B, C, D, E, F, G, H>(A _1, B _2, C _3, D _4, E _5, F _6, G _7, H _8) {
    /**
     * The number of fields stored within the tuple.
     */
    public static final int SIZE = 8;

   /* ********************************************************************************
    * Factories
    *    Create instances of the tuple.
    * ********************************************************************************/

    /**
     * {@return 8-tuple instance containing the objects passed in as arguments. }
     */
    public static <A, B, C, D, E, F, G, H> _8<A, B, C, D, E, F, G, H> of(A _1, B _2, C _3, D _4, E _5, F _6, G _7, H _8) {
        return new _8<>(_1, _2, _3, _4, _5, _6, _7, _8);
    }

    /* ********************************************************************************
     * Setters
     *    Generate a new tuple with the element at the given index in the tuple replaced.
     * ********************************************************************************/ 
    /**
     * {@return New instance of a 8-tuple with the object at index 1 set to the given argument. }
     */
    public <T1> _8<T1, B, C, D, E, F, G, H> set1(T1 arg) {
        return new _8<>(arg, _2, _3, _4, _5, _6, _7, _8);
    }
 
    /**
     * {@return New instance of a 8-tuple with the object at index 2 set to the given argument. }
     */
    public <T2> _8<A, T2, C, D, E, F, G, H> set2(T2 arg) {
        return new _8<>(_1, arg, _3, _4, _5, _6, _7, _8);
    }
 
    /**
     * {@return New instance of a 8-tuple with the object at index 3 set to the given argument. }
     */
    public <T3> _8<A, B, T3, D, E, F, G, H> set3(T3 arg) {
        return new _8<>(_1, _2, arg, _4, _5, _6, _7, _8);
    }
 
    /**
     * {@return New instance of a 8-tuple with the object at index 4 set to the given argument. }
     */
    public <T4> _8<A, B, C, T4, E, F, G, H> set4(T4 arg) {
        return new _8<>(_1, _2, _3, arg, _5, _6, _7, _8);
    }
 
    /**
     * {@return New instance of a 8-tuple with the object at index 5 set to the given argument. }
     */
    public <T5> _8<A, B, C, D, T5, F, G, H> set5(T5 arg) {
        return new _8<>(_1, _2, _3, _4, arg, _6, _7, _8);
    }
 
    /**
     * {@return New instance of a 8-tuple with the object at index 6 set to the given argument. }
     */
    public <T6> _8<A, B, C, D, E, T6, G, H> set6(T6 arg) {
        return new _8<>(_1, _2, _3, _4, _5, arg, _7, _8);
    }
 
    /**
     * {@return New instance of a 8-tuple with the object at index 7 set to the given argument. }
     */
    public <T7> _8<A, B, C, D, E, F, T7, H> set7(T7 arg) {
        return new _8<>(_1, _2, _3, _4, _5, _6, arg, _8);
    }
 
    /**
     * {@return New instance of a 8-tuple with the object at index 8 set to the given argument. }
     */
    public <T8> _8<A, B, C, D, E, F, G, T8> set8(T8 arg) {
        return new _8<>(_1, _2, _3, _4, _5, _6, _7, arg);
    }

    /* ********************************************************************************
     * Appender
     *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.
     * ********************************************************************************/

    /**
     * {@return New instance of a 9-tuple with all fields the same and
     *          an additional field at the last index set to the argument. }
     */
    public <T> _9<A, B, C, D, E, F, G, H, T> append(T arg) {
        return new _9<>(_1, _2, _3, _4, _5, _6, _7, _8, arg);
    }
}
