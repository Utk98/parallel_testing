package com.digite.actions.drivercapabilities;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class CucumberBrowserScope implements Scope {

    private final Map<String, Object> scopedObjects = new HashMap<>();
    private final Map<String, Runnable> destructionCallbacks = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return scopedObjects.computeIfAbsent(name, k -> objectFactory.getObject());
    }

    @Override
    public Object remove(String name) {
        destructionCallbacks.remove(name);
        return scopedObjects.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        destructionCallbacks.put(name, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "cucumber-glue";
    }
}
