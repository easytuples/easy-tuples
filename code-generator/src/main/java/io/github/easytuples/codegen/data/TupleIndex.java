package io.github.easytuples.codegen.data;

import static io.github.easytuples.codegen.data.Constants.INDEX_TO_TYPE_PARAM;
import static io.github.easytuples.codegen.data.Constants.MAX_TUPLE_SIZE;

/**
 * Int representing an index within a tuple.
 * TupleIndexes are 1-indexed (as opposed to 0-indexes).
 */
public record TupleIndex(int index) {

    /**
     * The index must be a value within the valid range.
     */
    public TupleIndex {
        if(index < 1 || index > MAX_TUPLE_SIZE) {
            String msg = "Unsupported index: %s. Allowed range: [1, %s]".formatted(index, MAX_TUPLE_SIZE);
            throw new IllegalStateException(msg);
        }
    }

    /**
     * {@return The default type parameter used for an item at the given index. }
     */
    public String getTypeParameter() {
        return INDEX_TO_TYPE_PARAM.get(this.index());
    }

    /**
     * Convert from 1-indexed position of a tuple index to zero indexed.
     */
    public int toZeroIndex() {
        return index - 1;
    }
}
