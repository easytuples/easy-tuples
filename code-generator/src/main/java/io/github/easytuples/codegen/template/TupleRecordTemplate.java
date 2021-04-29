package io.github.easytuples.codegen.template;

import io.github.easytuples.codegen.data.TupleRecordCode;
import io.github.easytuples.codegen.data.TupleSize;
import org.apache.commons.text.StringSubstitutor;
import io.github.easytuples.codegen.data.AppConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Template for a tuple record.
 */
public class TupleRecordTemplate implements CodeTemplate {

    /* ********************************************************************************
     * Static fields/Constants
     * ********************************************************************************/

    private static final String TEMPLATE = """
            package ${package_name};
            
            /**
             * Tuple with ${tuple_size} fields.
             */
            public record ${record_name}<${record_type_parameters}>(${record_constructor_parameters}) {
                /**
                 * The number of fields stored within the tuple.
                 */
                public static final int SIZE = ${tuple_size};
               
            ${factories}
            
            ${setters}
            
            ${appender}
            } 
            """;

    /* ********************************************************************************
     * Fields
     * ********************************************************************************/

    /**
     * Application configuration.
     */
    private final AppConfig appConfig;

    /**
     * The number of elements in the tuple we are generating.
     */
    private final TupleSize tupleSize;

    /* ********************************************************************************
     * Constructor(s)
     * ********************************************************************************/

    public TupleRecordTemplate(AppConfig appConfig, TupleSize tupleSize) {
        this.appConfig = appConfig;
        this.tupleSize = tupleSize;
    }

    /* ********************************************************************************
     * Methods
     * ********************************************************************************/
    Map<String, String> generateTemplateValues() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("package_name", appConfig.codePackageName());
        map.put("record_name", new TupleRecordName(tupleSize).generateCode());
        map.put("record_type_parameters", new TupleTypeParametersTemplate(tupleSize).generateCode());
        map.put("record_constructor_parameters", new TupleConstructorParameters(tupleSize).generateCode());
        map.put("tuple_size", Integer.toString(tupleSize.tupleSize()));
        map.put("factories", new TupleFactoryTemplate(tupleSize).generateCode());
        map.put("setters", new TupleSettersTemplate(tupleSize).generateCode());
        map.put("appender", new TupleAppenderTemplate(appConfig, tupleSize).generateCode());
        return map;
    }

    @Override
    public String generateCode() {
        var templateValues = generateTemplateValues();
        var substitutor = new StringSubstitutor(templateValues);
        return substitutor.replace(TEMPLATE);
    }

    /*
     * Generates the code by replacing the templated parameters with the actual values.
     */
    public TupleRecordCode generateRecordCode() {
        return new TupleRecordCode(generateCode());
    }

    /*
     * The name of the file containing the record.
     */
    public String generateFileName() {
        return new TupleRecordName(tupleSize).generateCode() + ".java";
    }

}
