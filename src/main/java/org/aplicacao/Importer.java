package org.aplicacao;

import javax.swing.text.Document;
import java.io.File;
import java.io.IOException;

public interface Importer {
    Document importFIle(File file) throws IOException;
}
