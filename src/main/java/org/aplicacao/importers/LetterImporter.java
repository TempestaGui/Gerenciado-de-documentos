package org.aplicacao.importers;

import org.aplicacao.Importer;
import org.aplicacao.TextFile;
import org.aplicacao.entities.Document;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.aplicacao.Attributes.*;

public class LetterImporter implements Importer {

    @Override
    public Document importFIle(File file) throws IOException {
        final TextFile textFile = new TextFile(file);

        textFile.addLineSuffix(NAME_PREFIX, PATIENT);

        final int lineNumber = textFile.addLines(2, String::isEmpty, ADDRESS);
        textFile.addLines(lineNumber + 1, (line) -> line.startsWith("regards"), BODY);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "LETTER");
        return new Document(attributes);
    }
}
