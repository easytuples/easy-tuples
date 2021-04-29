package io.github.easytuples.codegen.template;

import io.github.easytuples.codegen.data.Constants;
import io.github.easytuples.codegen.data.TupleIndex;
import io.github.easytuples.codegen.data.TupleSize;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;
import io.github.easytuples.codegen.data.AppConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TupleAppenderTemplate implements CodeTemplate {

    /*
     * The template each appender follows.
     * Example adder for a 2-tuple:
     * ```
     *    public <T> _3<A, B, T> add(T arg) {
     *       return new _3<>(_1, _2, arg);
     *    }
     * ```
     *
     * - We return a tuple of which is 1 larger in size with the argument added to the end.
     *
     */
    private static final String TEMPLATE = """    
    \s   /* ********************************************************************************
         * Appender
         *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.
         * ********************************************************************************/
    
        /**
         * {@return New instance of a ${tuple_size_plus_1}-tuple with all fields the same and 
         *          an additional field at the last index set to the argument. }
         */
        public <${type_param}> ${return_type} append(${type_param} arg) {
            return new ${size_one_up_tuple_name}<>(${arguments});
        }""";

    private static final String NO_APPENDER_TEMPLATE = """    
    \s   /* ********************************************************************************
         * Appender
         *    Generate a new tuple of size = (current size + 1) with an additional item at the last index.                
         * ********************************************************************************/
         
         //  No appender available for this tuple as this is the max tuple size.""";


    private final AppConfig appConfig;
    private final TupleSize tupleSize;

    TupleAppenderTemplate(AppConfig appConfig, TupleSize tupleSize) {
        this.appConfig = appConfig;
        this.tupleSize = tupleSize;
    }

    @Override
    public String generateCode() {
        // We don't want to generate an adder if:
        // - we have reached the maximum requested tuple size to generate
        // - we have reached the upper bound of MAX_TUPLE_SIZE
        if(appConfig.maxTupleSizeToGenerate().tupleSize() == tupleSize.tupleSize() || Constants.MAX_TUPLE_SIZE == tupleSize.tupleSize()) {
            return NO_APPENDER_TEMPLATE;
        }

        // Otherwise generate the adder function and return it.
        var templateValues = generateTemplateValues();
        var substitutor = new StringSubstitutor(templateValues);
        return substitutor.replace(TEMPLATE);
    }

    private Map<String, String> generateTemplateValues() {
        var typeParam = "T";
        var returnTupleSize = generateReturnTupleSize();
        var returnTupleName = new TupleRecordName(returnTupleSize);
        var map = new HashMap<String, String>();
        map.put("tuple_size_plus_1", Integer.toString(tupleSize.increment().tupleSize()));
        map.put("type_param", typeParam);
        map.put("return_type", generateReturnType(returnTupleName, typeParam));
        map.put("size_one_up_tuple_name", returnTupleName.generateCode());
        map.put("arguments", generateArgsToConstructorForAppender());
        return map;
    }

    private String generateReturnType(TupleRecordName returnTupleName, String adderTypeParam) {
        // Return type is the next tuple size up.
        var returnTupleRecordName = returnTupleName.generateCode();

        // The type params to the return type are all as they would be for the constructor
        // except the last item in the list of type params which should match
        // `adderTypeParam`.
        var typeParamsList = new TupleTypeParametersTemplate(returnTupleName.tupleSize()).generateTypeParams();
        typeParamsList.set(typeParamsList.size() - 1, adderTypeParam);
        var typeParams = StringUtils.join(typeParamsList, ", ");

        return returnTupleRecordName + "<" + typeParams + ">";
    }

    /*
     * Generates the arguments to be passed to the constructor called in the appender.
     */
    private String generateArgsToConstructorForAppender() {
        // The arguments are the same as that being given to the constructor in the factory
        // method except the argument at the last index of the tuple is replaced with the
        // appender argument name (which is always named 'arg').
        var returnTupleSize = generateReturnTupleSize();
        List<String> arguments = new TupleConstructorInvocationArguments(returnTupleSize).generateConstructorInvocationArguments();
        arguments.set(new TupleIndex(returnTupleSize.tupleSize()).toZeroIndex(), "arg");
        return StringUtils.join(arguments, ", ");
    }

    private TupleSize generateReturnTupleSize() {
        return new TupleSize(tupleSize.tupleSize() + 1);
    }
}
