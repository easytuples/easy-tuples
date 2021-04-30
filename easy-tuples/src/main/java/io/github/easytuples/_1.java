package io.github.easytuples;

/**
 * Tuple with 1 fields.
 */
public record _1<A>(A _1) {
    /**
     * The number of fields stored within the tuple.
     */
    public static final int SIZE = 1;

   /* ********************************************************************************
    * Factories
    *    Create instances of the tuple.
    * ********************************************************************************/

    /**
     * {@return 1-tuple instance containing the objects passed in as arguments. }
     */
    public static <A> _1<A> of(A _1) {
        return new _1<>(_1);
    }

    /* ********************************************************************************
     * Setters
     *    Generate a new tuple with the element at the given index in the tuple replaced.
     * ********************************************************************************/ 
    /**
     * {@return New instance of a 1-tuple with the object at index 1 set to the given argument. }
     */
    public <T1> _1<T1> set1(T1 arg) {
        return new _1<>(arg);
    }

    /* ********************************************************************************
     * Appender
     *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.
     * ********************************************************************************/

    /**
     * {@return New instance of a 2-tuple with all fields the same and
     *          an additional field at the last index set to the argument. }
     */
    public <T> _2<A, T> append(T arg) {
        return new _2<>(_1, arg);
    }
}
