package ru.kurbatov.exam.document;

import javax.print.Doc;

public class DepartmentAccounting implements DocumentCheckable {

    private DocumentCheckable nextDocumentCheckable;

    @Override
    public boolean checkDocument(Document document) {
        if (!Character.isUpperCase(document.getText().charAt(0))) return false;
        document.setNewSignature("Department Accounting");
        return nextDocumentCheckable == null || nextDocumentCheckable.checkDocument(document);
    }
    @Override
    public void setNextDocumentCheckable(DocumentCheckable nextDocumentCheckable) {
        this.nextDocumentCheckable = nextDocumentCheckable;
    }
}
