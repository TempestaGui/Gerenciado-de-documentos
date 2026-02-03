package org.aplicacao;

import org.aplicacao.entities.Document;
import org.aplicacao.importers.ImageImporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentManagementSystem {

    private final Map<String, Importer> extensionToImporter = new HashMap<>();
    private final List<Document> documents = new ArrayList<>();

    public DocumentManagementSystem(){
        extensionToImporter.put("jpg", new ImageImporter());
    }

   public void importFile(String path) throws IOException {
        final File file = new File(path);

        if(!file.exists()){
            throw new FileNotFoundException(path);
        }

        final int separatorIndex = path.lastIndexOf('.');
        if(separatorIndex != -1){
            if(separatorIndex == path.length()){
                throw new UnknownError("No extensions found for file: "+path);
            }
            final String extension = path.substring(separatorIndex + 1);
            final Importer importer = extensionToImporter.get(extension);

            if(importer == null){
                throw new UnknownError("for file: "+path);
            }

            final Document document = importer.importFIle(file);
            documents.add(document);
        } else {
            throw new UnknownError("no extendions found for file: "+path);
        }
    }

    public List<Document> contents(){
        return documents;
    }
}
