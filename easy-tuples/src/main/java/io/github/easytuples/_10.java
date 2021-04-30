package io.github.easytuples;

/**
 * Tuple with 10 fields.
 */
public record _10<A, B, C, D, E, F, G, H, I, J>(A _1, B _2, C _3, D _4, E _5, F _6, G _7, H _8, I _9, J _10) {
    /**
     * The number of fields stored within the tuple.
     */
    public static final int SIZE = 10;

   /* ********************************************************************************
    * Factories
    *    Create instances of the tuple.
    * ********************************************************************************/

    /**
     * {@return 10-tuple instance containing the objects passed in as arguments. }
     */
    public static <A, B, C, D, E, F, G, H, I, J> _10<A, B, C, D, E, F, G, H, I, J> of(A _1, B _2, C _3, D _4, E _5, F _6, G _7, H _8, I _9, J _10) {
        return new _10<>(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10);
    }

    /* ********************************************************************************
     * Setters
     *    Generate a new tuple with the element at the given index in the tuple replaced.
     * ********************************************************************************/ 
    /**
     * {@return New instance of a 10-tuple with the object at index 1 set to the given argument. }
     */
    public <T1> _10<T1, B, C, D, E, F, G, H, I, J> set1(T1 arg) {
        return new _10<>(arg, _2, _3, _4, _5, _6, _7, _8, _9, _10);
    }
 
    /**
     * {@return New instance of a 10-tuple with the object at index 2 set to the given argument. }
     */
    public <T2> _10<A, T2, C, D, E, F, G, H, I, J> set2(T2 arg) {
        return new _10<>(_1, arg, _3, _4, _5, _6, _7, _8, _9, _10);
    }
 
    /**
     * {@return New instance of a 10-tuple with the object at index 3 set to the given argument. }
     */
    public <T3> _10<A, B, T3, D, E, F, G, H, I, J> set3(T3 arg) {
        return new _10<>(_1, _2, arg, _4, _5, _6, _7, _8, _9, _10);
    }
 
    /**
     * {@return New instance of a 10-tuple with the object at index 4 set to the given argument. }
     */
    public <T4> _10<A, B, C, T4, E, F, G, H, I, J> set4(T4 arg) {
        return new _10<>(_1, _2, _3, arg, _5, _6, _7, _8, _9, _10);
    }
 
    /**
     * {@return New instance of a 10-tuple with the object at index 5 set to the given argument. }
     */
    public <T5> _10<A, B, C, D, T5, F, G, H, I, J> set5(T5 arg) {
        return new _10<>(_1, _2, _3, _4, arg, _6, _7, _8, _9, _10);
    }
 
    /**
     * {@return New instance of a 10-tuple with the object at index 6 set to the given argument. }
     */
    public <T6> _10<A, B, C, D, E, T6, G, H, I, J> set6(T6 arg) {
        return new _10<>(_1, _2, _3, _4, _5, arg, _7, _8, _9, _10);
    }
 
    /**
     * {@return New instance of a 10-tuple with the object at index 7 set to the given argument. }
     */
    public <T7> _10<A, B, C, D, E, F, T7, H, I, J> set7(T7 arg) {
        return new _10<>(_1, _2, _3, _4, _5, _6, arg, _8, _9, _10);
    }
 
    /**
     * {@return New instance of a 10-tuple with the object at index 8 set to the given argument. }
     */
    public <T8> _10<A, B, C, D, E, F, G, T8, I, J> set8(T8 arg) {
        return new _10<>(_1, _2, _3, _4, _5, _6, _7, arg, _9, _10);
    }
 
    /**
     * {@return New instance of a 10-tuple with the object at index 9 set to the given argument. }
     */
    public <T9> _10<A, B, C, D, E, F, G, H, T9, J> set9(T9 arg) {
        return new _10<>(_1, _2, _3, _4, _5, _6, _7, _8, arg, _10);
    }
 
    /**
     * {@return New instance of a 10-tuple with the object at index 10 set to the given argument. }
     */
    public <T10> _10<A, B, C, D, E, F, G, H, I, T10> set10(T10 arg) {
        return new _10<>(_1, _2, _3, _4, _5, _6, _7, _8, _9, arg);
    }

    /* ********************************************************************************
     * Appender
     *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.
     * ********************************************************************************/

     //  No appender available for this tuple as this is the max tuple size.
}
