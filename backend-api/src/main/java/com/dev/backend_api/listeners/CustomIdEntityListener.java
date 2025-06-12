package com.dev.backend_api.listeners;

import com.dev.backend_api.entity.Auditable;

import jakarta.persistence.PrePersist;

public class CustomIdEntityListener {

    @PrePersist
    public void setIdBeforeInsert(Object entity) {
        if (entity instanceof Auditable auditable && auditable.getId() == null) {
            String prefix = auditable.getIdPrefix();
            String lastId = CustomIdGenerator.getLastId(entity.getClass(), prefix);
            int nextNumber = lastId != null
                    ? Integer.parseInt(lastId.substring(prefix.length()))
                    : 0;

            String newId = String.format("%s%04d", prefix, nextNumber + 1);
            auditable.setId(newId); // <== This line causes the "cannot find symbol" error
        }
    }

}

