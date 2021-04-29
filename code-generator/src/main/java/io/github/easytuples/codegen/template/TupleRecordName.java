package io.github.easytuples.codegen.template;

import io.github.easytuples.codegen.data.TupleSize;

public class TupleRecordName implements CodeTemplate {
    private final TupleSize tupleSize;

    TupleSize tupleSize() {
        return tupleSize;
    }

    TupleRecordName(TupleSize tupleSize) {
        this.tupleSize = tupleSize;
    }


    /*
     * The name of the record is simply an underscore and the size e.g. _1
     */
    @Override
    public String generateCode() {
        return "_" + tupleSize.tupleSize();
    }
}
