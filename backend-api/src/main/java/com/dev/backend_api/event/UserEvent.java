package com.dev.backend_api.event;

import java.util.Map;

import com.dev.backend_api.entity.UserEntity;
import com.dev.backend_api.enumeration.EventType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class UserEvent {

    private UserEntity user;
    private EventType eventType;
    private Map<?,?> data;

    public UserEntity getUser() {
        return user;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Map<?, ?> getData() {
        return data;
    }


}
