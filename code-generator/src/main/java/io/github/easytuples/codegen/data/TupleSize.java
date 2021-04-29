package io.github.easytuples.codegen.data;

/**
 * Wrapper over an int which has been verified to be a valid tuple size.
 */
public record TupleSize(int tupleSize) {

    /**
     * The size must be a valid index.
     */
    public TupleSize {
        if(tupleSize < 1 || tupleSize > Constants.MAX_TUPLE_SIZE) {
            String msg = "Unsupported tuple size: %s. Allowed range: [1, %s]".formatted(tupleSize, Constants.MAX_TUPLE_SIZE);
            throw new IllegalStateException(msg);
        }
    }

    /**
     * { @return TupleSize instance one size up from the current one. }
     */
    public TupleSize increment() {
        return new TupleSize(tupleSize + 1);
    }
}
