package org.aplicacao;

import org.aplicacao.entities.Document;
import org.testng.annotations.Test;

import java.io.File;

public class DocumentManagementSystemTest {

    private static final String RESOURCES = "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";

    private DocumentManagementSystem system = new DocumentManagementSystem();

    @Test
    public void shouldImportFile() throws Exception {
        system.importFile(LETTER);

        final Document document = OnlyDocument();

        assertAttributeEquals(document, Attributes.PATH, LETTER);
    }
}
