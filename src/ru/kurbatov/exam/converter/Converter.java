package ru.kurbatov.exam.converter;

public class Converter {

    private final DocumentOpener opener;
    private final DocumentConverter converter;
    private final DocumentCloser closer;

    public Converter(DocumentOpener opener, DocumentConverter converter, DocumentCloser closer) {
        this.opener = opener;
        this.converter = converter;
        this.closer = closer;
    }

    public String convert(String name){
        String data = opener.open(name);
        data = converter.convert(data);
        return closer.close(data);
    }
}
