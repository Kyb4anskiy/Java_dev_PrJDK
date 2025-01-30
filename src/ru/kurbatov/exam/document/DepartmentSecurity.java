package ru.kurbatov.exam.document;

import java.util.ArrayList;
import java.util.List;

public class DepartmentSecurity implements DocumentCheckable {

    private List<String> banList = new ArrayList<>();
    private DocumentCheckable nextDocumentCheckable;

    public DepartmentSecurity(List<String> banList) {
        this.banList = new ArrayList<>(banList);
    }

    public List<String> getBanList(){
        return new ArrayList<>(banList);
    }

    public void setBanList(List<String> banList) {
        this.banList = new ArrayList<>(banList);
    }

    public void addInBanList(String nameAuthor){
        this.banList.add(nameAuthor);
    }

    @Override
    public boolean checkDocument(Document document) {
        if (banList.contains(document.getNameAuthor()))
            return false;
        document.setNewSignature("Department Security");
        return nextDocumentCheckable == null || nextDocumentCheckable.checkDocument(document);
    }

    @Override
    public void setNextDocumentCheckable(DocumentCheckable nextDocumentCheckable) {
        this.nextDocumentCheckable = nextDocumentCheckable;
    }
}
