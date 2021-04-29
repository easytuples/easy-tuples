package io.github.easytuples.codegen.template;

import io.github.easytuples.codegen.data.TupleSize;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TupleConstructorInvocationArguments implements CodeTemplate {
    private final TupleSize tupleSize;

    public TupleConstructorInvocationArguments(TupleSize tupleSize) {
        this.tupleSize = tupleSize;
    }

    List<String> generateConstructorInvocationArguments() {
        return IntStream.range(1, tupleSize.tupleSize() + 1)
                .mapToObj(index -> "_" + index)
                .collect(Collectors.toList());
    }

    /*
     * The constructor invocation argument list is a comma separated list of
     * arguments intended to be passed to a constructor.
     *
     * For example, for a 2 tuple: `_1, _2` which would be passed to new _2(`...`).
     */
    @Override
    public String generateCode() {
        return StringUtils.join(generateConstructorInvocationArguments(), ", ");
    }
}
