package io.github.easytuples.codegen.template;

import io.github.easytuples.codegen.data.TupleIndex;
import io.github.easytuples.codegen.data.TupleSize;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TupleSettersTemplate implements CodeTemplate {

    private static final String TEMPLATE_HEADER = """    
    \s   /* ********************************************************************************
         * Setters
         *    Generate a new tuple with the element at the given index in the tuple replaced.
         * ********************************************************************************/""";

    /*
     * The template each setter follows.
     * Example setters which follow this template for a 2-tuple:
     * ```
     *   public <T1> _2<T1, B> set1(T1 arg) {
     *       return new _2<>(arg, _2);
     *   }
     *
     *   public <T2> _2<A, T2> set2(T2 arg) {
     *       return new _2<>(_1, arg);
     *   }
     * ```
     *
     * - The setters are named `setN` where N is the integer position of the field being set in the Tuple.
     * - The type parameter is a T followed by the integer position of the field being set in the Tuple.
     *
     */
    private static final String SETTER_TEMPLATE = """    
    \s
        /**
         * {@return New instance of a ${tuple_size}-tuple with the object at index ${field_position} set to the given argument. }
         */ 
        public <${type_param}> ${return_type} set${field_position}(${type_param} arg) {
            return new ${tuple_name}<>(${arguments});
        }""";


    /*
     * The size of the tuple.
     */
    private final TupleSize tupleSize;


    TupleSettersTemplate(TupleSize tupleSize) {
        this.tupleSize = tupleSize;
    }

    private Map<String, String> generateTemplateValues(TupleIndex fieldIndex) {
        var typeParam = "T" + fieldIndex.index();
        var tupleName = new TupleRecordName(tupleSize).generateCode();

        var map = new HashMap<String, String>();
        map.put("tuple_size", Integer.toString(tupleSize.tupleSize()));
        map.put("type_param", typeParam);
        map.put("return_type", generateReturnType(fieldIndex, typeParam));
        map.put("field_position", Integer.toString(fieldIndex.index()));
        map.put("tuple_name", tupleName);
        map.put("arguments", generateArgsToConstructorForSetter(fieldIndex));
        return map;
    }

    /*
     * Generates the arguments to be passed to the constructor for the setter.
     */
    private String generateArgsToConstructorForSetter(TupleIndex fieldIndex) {
        // The arguments are the same as that being given to the constructor in the factory
        // method except the argument at fieldIndex (1-indexed) is replaced with the
        // setter argument (which is always named 'arg').
        List<String> arguments = new TupleConstructorInvocationArguments(tupleSize).generateConstructorInvocationArguments();
        arguments.set(fieldIndex.toZeroIndex(), "arg");
        return StringUtils.join(arguments, ", ");
    }

    /*
     * Generates the return type for the setter at the given fieldIndex.
     */
    private String generateReturnType(TupleIndex fieldIndex, String typeParam) {
        var tupleName = new TupleRecordName(tupleSize).generateCode();

        // We need to replace the type param at the given field index (1-indexed) with the
        // one passed in as an argument.
        var typeParamsList = new TupleTypeParametersTemplate(tupleSize).generateTypeParams();
        typeParamsList.set(fieldIndex.toZeroIndex(), typeParam);
        var typeParams = StringUtils.join(typeParamsList, ", ");

        return tupleName + "<" + typeParams + ">";
    }

    @Override
    public String generateCode() {
        // We need a setter for each position in the tuple.
        // Remember - tuples are 1-indexed so we start looping from 1.
        List<String> codeForSetters = new ArrayList<>();
        for(int i = 1; i < tupleSize.tupleSize() + 1; i++) {
            var templateValues = generateTemplateValues(new TupleIndex(i));
            var substitutor = new StringSubstitutor(templateValues);
            codeForSetters.add(substitutor.replace(SETTER_TEMPLATE));
        }

        return TEMPLATE_HEADER + StringUtils.join(codeForSetters, "\n");
    }

}
