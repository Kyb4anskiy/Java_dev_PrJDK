package ru.kurbatov.exam.document;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private String nameAuthor;
    private String text;
    private List<String> signatures = new ArrayList<>();
    private boolean status;

    public Document(String nameAuthor, String text) {
        this.nameAuthor = nameAuthor;
        this.text = text;
        this.status = true;
    }

    void setNewSignature(String signature){
        this.signatures.add(signature);
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public String getText() {
        return text;
    }

    public List<String> getSignatures() {
        return new ArrayList<>(signatures);
    }

    public boolean getStatus() {
        return status;
    }

    public void checkDocument(DocumentCheckable department){
        this.status = department.checkDocument(this);
    }

}
