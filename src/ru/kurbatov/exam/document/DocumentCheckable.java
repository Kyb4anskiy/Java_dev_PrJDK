package ru.kurbatov.exam.document;

public interface DocumentCheckable {

    boolean checkDocument(Document document);
    void setNextDocumentCheckable(DocumentCheckable nextDocumentCheckable);

}