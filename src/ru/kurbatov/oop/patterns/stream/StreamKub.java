package ru.kurbatov.oop.patterns.stream;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamKub <T> {

    private Collection<T> collection;
    private List<Function<Collection<T>, Collection<T>>> functions;

    public StreamKub(Collection<T> collection) {
        this.collection = collection;
        functions = new ArrayList<>();
    }

    private StreamKub(Collection<T> collection, List<Function<Collection<T>, Collection<T>>> functions) {
        this.collection = collection;
        this.functions = functions;
    }

    public <P> StreamKub<P> function(Convertor<T,P> convertor){
        functions.add(x ->
        {
            Collection<P> res = new ArrayList<>();
            for (T val : x)
                res.add(convertor.apply(val));
            return (Collection<T>) res;
        });
        return (StreamKub<P>) this;
    }

    public StreamKub<T> filter(Tester<T> tester){
        functions.add(x ->
        {
            Collection<T> res = new ArrayList<>();
            for (T val : x)
                if (tester.test(val))
                    res.add(val);
            return res;
        });
        return this;
    }

    public T reduce(Reducer<T> reducer){
        collection = execute();
        boolean valNotNull = false;
        T res = null;
        for (T val : collection) {
            //System.out.println(val);
            if (!valNotNull) {
                valNotNull = true;
                res = val;
            } else res = reducer.reduce(res, val);
        }
        return res;
    }

    public <P extends Collection<?>> P collect(CreatorCollection<P> creator,
                                                  ConverterCollection<P,T> convertor){
        Collection<T> newCollection = execute();
        P res = creator.create();
        for (T val: newCollection)
            convertor.addTo(res,val);
        return res;
    }

    public Integer count(){
        Collection<T> newCollection = execute();
        return newCollection.size();
    }

    private Collection<T> execute(){
        Collection<T> res = new ArrayList<>();
        for(T val: collection){
            Collection<T> valRes = List.of(val);
            for(Function<Collection<T>, Collection<T>> function: functions){
                valRes = function.apply(valRes);
            }
            res.addAll(valRes);
        }
        return res;
    }


}
