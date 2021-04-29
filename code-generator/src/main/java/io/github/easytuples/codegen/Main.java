package io.github.easytuples.codegen;

import io.github.easytuples.codegen.data.AppConfig;
import io.github.easytuples.codegen.data.TupleSize;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        // Set (default) parameters for app config...
        // Amend these as needed
        var maxTupleSize = new TupleSize(10);
        var outputDirectory = Path.of("");
        var packageName = "io.github.easytuples";
        var appConfig = new AppConfig(maxTupleSize, outputDirectory, packageName);

        // Initialise the code generator and run it.
        var codeGenerator = new Tuples4JCodeGenerator();
        codeGenerator.run(appConfig);
    }
}
