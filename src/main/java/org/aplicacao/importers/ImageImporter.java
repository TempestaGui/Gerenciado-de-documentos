package org.aplicacao.importers;

import org.aplicacao.Importer;
import org.aplicacao.entities.Document;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.aplicacao.Attributes.*;

public class ImageImporter implements Importer {

    @Override
    public Document importFIle(File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();

        attributes.put(PATH, file.getPath());

        final BufferedImage image = ImageIO.read(file);
        attributes.put(WIDTH, String.valueOf(image.getWidth()));
        attributes.put(HEIGHT, String.valueOf(image.getHeight()));
        attributes.put(TYPE, "Image");

        return new Document(attributes);
    }
}
