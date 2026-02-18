package org.aplicacao;

import org.aplicacao.entities.Document;
import org.testng.annotations.Test;

import java.io.File;

import static org.aplicacao.Attributes.*;

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

    @Test
    public void shouldImportLetterAttributes() throws Exception {
        system.importFile(LETTER);

        final Document document = onlyDocument();

        assertAttributesEquals(document, PATIENT, JOE_BLOGGS);
        assertAttributesEquals(document, ADDRESS,
                    "123 Fake Street\n" +
                     "Westminster\n" +
                     "London\n" +
                     "United Kingdom");
        assertAttributeEquals(document, BODY,
                "We are writing to you to confirm the re-scheduling of your appointment\n"+
                "with Dr. Avaj from 29th December 2016 to 5th January 2017.");
        assertTypeIs("LETTER", document);
    }
}
