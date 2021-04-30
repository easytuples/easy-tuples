package io.github.easytuples;

/**
 * Tuple with 7 fields.
 */
public record _7<A, B, C, D, E, F, G>(A _1, B _2, C _3, D _4, E _5, F _6, G _7) {
    /**
     * The number of fields stored within the tuple.
     */
    public static final int SIZE = 7;

   /* ********************************************************************************
    * Factories
    *    Create instances of the tuple.
    * ********************************************************************************/

    /**
     * {@return 7-tuple instance containing the objects passed in as arguments. }
     */
    public static <A, B, C, D, E, F, G> _7<A, B, C, D, E, F, G> of(A _1, B _2, C _3, D _4, E _5, F _6, G _7) {
        return new _7<>(_1, _2, _3, _4, _5, _6, _7);
    }

    /* ********************************************************************************
     * Setters
     *    Generate a new tuple with the element at the given index in the tuple replaced.
     * ********************************************************************************/ 
    /**
     * {@return New instance of a 7-tuple with the object at index 1 set to the given argument. }
     */
    public <T1> _7<T1, B, C, D, E, F, G> set1(T1 arg) {
        return new _7<>(arg, _2, _3, _4, _5, _6, _7);
    }
 
    /**
     * {@return New instance of a 7-tuple with the object at index 2 set to the given argument. }
     */
    public <T2> _7<A, T2, C, D, E, F, G> set2(T2 arg) {
        return new _7<>(_1, arg, _3, _4, _5, _6, _7);
    }
 
    /**
     * {@return New instance of a 7-tuple with the object at index 3 set to the given argument. }
     */
    public <T3> _7<A, B, T3, D, E, F, G> set3(T3 arg) {
        return new _7<>(_1, _2, arg, _4, _5, _6, _7);
    }
 
    /**
     * {@return New instance of a 7-tuple with the object at index 4 set to the given argument. }
     */
    public <T4> _7<A, B, C, T4, E, F, G> set4(T4 arg) {
        return new _7<>(_1, _2, _3, arg, _5, _6, _7);
    }
 
    /**
     * {@return New instance of a 7-tuple with the object at index 5 set to the given argument. }
     */
    public <T5> _7<A, B, C, D, T5, F, G> set5(T5 arg) {
        return new _7<>(_1, _2, _3, _4, arg, _6, _7);
    }
 
    /**
     * {@return New instance of a 7-tuple with the object at index 6 set to the given argument. }
     */
    public <T6> _7<A, B, C, D, E, T6, G> set6(T6 arg) {
        return new _7<>(_1, _2, _3, _4, _5, arg, _7);
    }
 
    /**
     * {@return New instance of a 7-tuple with the object at index 7 set to the given argument. }
     */
    public <T7> _7<A, B, C, D, E, F, T7> set7(T7 arg) {
        return new _7<>(_1, _2, _3, _4, _5, _6, arg);
    }

    /* ********************************************************************************
     * Appender
     *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.
     * ********************************************************************************/

    /**
     * {@return New instance of a 8-tuple with all fields the same and
     *          an additional field at the last index set to the argument. }
     */
    public <T> _8<A, B, C, D, E, F, G, T> append(T arg) {
        return new _8<>(_1, _2, _3, _4, _5, _6, _7, arg);
    }
}
