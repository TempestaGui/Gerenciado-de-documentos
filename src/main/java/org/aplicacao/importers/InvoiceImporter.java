package org.aplicacao.importers;

import org.aplicacao.Importer;
import org.aplicacao.TextFile;
import org.aplicacao.entities.Document;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.aplicacao.Attributes.*;

public class InvoiceImporter implements Importer {

    @Override
    public Document importFIle(File file) throws IOException {
        final TextFile textFile = new TextFile(file);

        textFile.addLineSuffix(NAME_PREFIX, PATIENT);
        textFile.addLineSuffix(AMOUNT_PREFIX, AMOUNT);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(TYPE, "INVOICE");
        return new Document(attributes);
    }
}
