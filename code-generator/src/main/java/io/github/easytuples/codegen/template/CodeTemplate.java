package io.github.easytuples.codegen.template;

/**
 * Functionality supported by all code templates.
 */
public interface CodeTemplate {

    /**
     * Generate the actual code associated with the template i.e. with all
     * parameters populated.
     * { @return Code template with all template parameters populated. }
     */
    String generateCode();
}
