package org.aplicacao;

import java.util.List;
import java.util.Map;

public class TextFile {

    private final Map<String, String> attributes;
    private final List<String> lines;

    public TextFile(List<String> lines, Map<String, String> attributes){
        this.lines = lines;
        this.attributes = attributes;
    }

    public void addLineSuffix(final String prefix, final String attributeName){
        for(final String line: lines){
            if(line.startsWith(prefix)){
                attributes.put(attributeName, line.substring(prefix.length()));
                break;
            }
        }
    }
}
