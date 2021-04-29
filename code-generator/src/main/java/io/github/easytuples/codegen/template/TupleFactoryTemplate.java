package io.github.easytuples.codegen.template;

import io.github.easytuples.codegen.data.TupleSize;
import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;

public class TupleFactoryTemplate implements CodeTemplate {
    /* ********************************************************************************
     * Static fields/Constants
     * ********************************************************************************/

    /*
     * The template for the factory of the tuple.
     */
    private static final String TEMPLATE = """    
    \s  /* ********************************************************************************
        * Factories
        *    Create instances of the tuple.
        * ********************************************************************************/

        /**
         * {@return ${tuple_size}-tuple instance containing the objects passed in as arguments. } 
         */
        public static <${factory_type_parameters}> ${return_type} of(${factory_method_parameters}) {
            return new ${record_name}<>(${factory_method_arguments});             
        }""";

    /* ********************************************************************************
     * Fields
     * ********************************************************************************/

    private final TupleSize tupleSize;

    /* ********************************************************************************
     * Constructor(s)
     * ********************************************************************************/

    TupleFactoryTemplate(TupleSize tupleSize) {
        this.tupleSize = tupleSize;
    }

    /* ********************************************************************************
     * Methods
     * ********************************************************************************/

    @Override
    public String generateCode() {
        var recordName = new TupleRecordName(tupleSize).generateCode();
        var typeParameters = new TupleTypeParametersTemplate(tupleSize).generateCode();
        var returnType = recordName + "<" + typeParameters + ">";

        var templateValues = new HashMap<String, String>();
        templateValues.put("tuple_size", Integer.toString(tupleSize.tupleSize()));
        templateValues.put("factory_type_parameters", typeParameters);
        templateValues.put("return_type", returnType);
        templateValues.put("factory_method_parameters", new TupleConstructorParameters(tupleSize).generateCode());
        templateValues.put("record_name", recordName);
        templateValues.put("factory_method_arguments", new TupleConstructorInvocationArguments(tupleSize).generateCode());

        var substitutor = new StringSubstitutor(templateValues);
        return substitutor.replace(TEMPLATE);
    }
}
