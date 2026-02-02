package org.aplicacao;

import org.aplicacao.importers.ImageImporter;

import javax.swing.text.Document;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentManagementSystem {

    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem(){
        extensionToImporter.put("jpg", new ImageImporter());
    }

    void importFile(String path){}
    List<Document> contents(){
        return null;
    }
}
