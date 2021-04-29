package io.github.easytuples.codegen;


import org.apache.commons.io.FileUtils;
import io.github.easytuples.codegen.data.AppConfig;
import io.github.easytuples.codegen.template.TupleRecordTemplate;
import io.github.easytuples.codegen.data.TupleRecordCode;
import io.github.easytuples.codegen.data.TupleSize;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Tuples4JCodeGenerator {

    /**
     * Main logic to generate the tuple code files and write them to disk.
     * @throws IOException If there are any problems writing the files to disk.
     */
    public void run(AppConfig appConfig) throws IOException {
        TupleSize maxTupleSizeToGenerate = appConfig.maxTupleSizeToGenerate();

        // Create a tuple template for each size from 1 up to and
        // including the requested max tuple size.
        var tupleTemplates = new ArrayList<TupleRecordTemplate>();
        for(int i = 1; i < maxTupleSizeToGenerate.tupleSize() + 1; i++) {
            // Grab the tuple template for the current tuple size.
            var tupleTemplate = new TupleRecordTemplate(appConfig, new TupleSize(i));

            // Add it to the list of templates we want to generate.
            tupleTemplates.add(tupleTemplate);
        }

        // Generate the actual code for each template, and the filename for that Java record class.
        record CodeAndFileName(TupleRecordCode code, String fileName) {}
        List<CodeAndFileName> codeAndFileNames = tupleTemplates.stream()
                .map(template -> new CodeAndFileName(template.generateRecordCode(), template.generateFileName()))
                .toList();

        // Write out the code to the given file(s).
        for(CodeAndFileName codeAndFileName : codeAndFileNames) {
            var file = new File(codeAndFileName.fileName());
            var code = codeAndFileName.code().code();
            FileUtils.writeStringToFile(file, code, StandardCharsets.UTF_8);
        }
    }
}
