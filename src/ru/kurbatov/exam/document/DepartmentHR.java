package ru.kurbatov.exam.document;

import java.util.ArrayList;
import java.util.List;

public class DepartmentHR implements DocumentCheckable{

    private boolean freeVacancies;
    private DocumentCheckable nextDocumentCheckable;


    public DepartmentHR(boolean freeVacancies) {
        this.freeVacancies = freeVacancies;
    }

    public boolean isFreeVacancies() {
        return freeVacancies;
    }

    public void setFreeVacancies(boolean freeVacancies) {
        this.freeVacancies = freeVacancies;
    }

    @Override
    public boolean checkDocument(Document document) {
        if (!freeVacancies)
            return false;
        document.setNewSignature("Department HR");
        return nextDocumentCheckable == null || nextDocumentCheckable.checkDocument(document);
    }
    @Override
    public void setNextDocumentCheckable(DocumentCheckable nextDocumentCheckable) {
        this.nextDocumentCheckable = nextDocumentCheckable;
    }
}
