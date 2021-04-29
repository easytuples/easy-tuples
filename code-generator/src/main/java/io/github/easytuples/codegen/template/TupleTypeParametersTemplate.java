package io.github.easytuples.codegen.template;

import io.github.easytuples.codegen.data.TupleIndex;
import io.github.easytuples.codegen.data.TupleSize;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TupleTypeParametersTemplate implements CodeTemplate {
    private final TupleSize tupleSize;

    TupleTypeParametersTemplate(TupleSize tupleSize) {
        this.tupleSize = tupleSize;
    }

    List<String> generateTypeParams() {
        return IntStream.range(1, tupleSize.tupleSize() + 1)
                .mapToObj(index -> new TupleIndex(index).getTypeParameter())
                .collect(Collectors.toList());
    }

    /*
     * The type parameter list is a comma separated list of type parameters e.g.
     * `A, B, C`, where the number of type parameters is equal to the size of the
     * tuple.
     */
    @Override
    public String generateCode() {
        return StringUtils.join(generateTypeParams(), ", ");
    }
}
