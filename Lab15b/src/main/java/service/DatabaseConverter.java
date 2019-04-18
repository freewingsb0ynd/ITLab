package service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;

@Service
@Scope("singleton")
public class DatabaseConverter implements StandardlizeService {


    @Override
    public LinkedList convertInputToList() {
        return null;
    }

//    @Override
//    public void outputFile(LinkedList linkedList) {
//
//    }
}
