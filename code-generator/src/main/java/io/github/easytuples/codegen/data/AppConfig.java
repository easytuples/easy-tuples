package io.github.easytuples.codegen.data;

import java.nio.file.Path;

/**
 * Application configuration.
 * @param maxTupleSizeToGenerate The maximum tuple size we should generate.
 * @param outputDirectory        Directory to output the generated code files to.
 * @param codePackageName        Name of package in which code will be placed into.
 */
public record AppConfig(
        TupleSize maxTupleSizeToGenerate,
        Path outputDirectory,
        String codePackageName) {
}
