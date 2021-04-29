package io.github.easytuples.codegen.template;

import io.github.easytuples.codegen.data.TupleIndex;
import io.github.easytuples.codegen.data.TupleSize;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.IntStream;

public class TupleConstructorParameters implements CodeTemplate {
    private final TupleSize tupleSize;

    TupleConstructorParameters(TupleSize tupleSize) {
        this.tupleSize = tupleSize;
    }

    /*
     * The constructor parameter list is a comma separated list of parameters which
     * will be used in the canonical constructor of the tuple Record (or in factories).
     * For example, `A _1, B _2, ...`. The types are generic types (A/B) and parameter names
     * are just the index of the parameter with an underscore in front e.g. _1/_2/etc.
     */
    @Override
    public String generateCode() {
        List<String> typeParameters = IntStream.range(1, tupleSize.tupleSize() + 1)
                .mapToObj(index -> new TupleIndex(index).getTypeParameter() + " " + "_" + index)
                .toList();

        return StringUtils.join(typeParameters, ", ");
    }

}
