package com.nhnacademy.client.event.subject;

import com.nhnacademy.client.event.observer.Observer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageSubject implements Subject {

    private final List<Observer> observers;

    public MessageSubject() {
        //TODO#1-1 Observer를 등록한 thread list를 생성 합니다. thread safety 해야 합니다.
        observers = null;
    }

    @Override
    public void register(EventType eventType, Observer observer) {
        //TODO#1-2 observers에 observer를 등록 합니다.

    }

    @Override
    public void remove(EventType eventType, Observer observer) {
        //TODO#1-3 observers 에서 observer를 삭제 합니다.

    }

    @Override
    public void notifyObservers(EventType eventType, String message) {
        /*
            TODO#1-4 모든 observer들에게  알림니다.
           - method type을 고려해야 합니다. SEND,RECV, observer.validate()를 사용하여 검증 합니다.
           - observer.updateMessage(message)를 호출 합니다.
        */
        for(Observer observer : observers){
            
        }
    }
}
