package ru.kurbatov.exam.macros;

import java.util.List;

public interface Action<P> {

    List<P> runAction(List<P> data);

}
