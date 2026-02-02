package org.aplicacao;


import org.aplicacao.entities.Document;

import java.io.File;
import java.io.IOException;

public interface Importer {
    Document importFIle(File file) throws IOException;
}
