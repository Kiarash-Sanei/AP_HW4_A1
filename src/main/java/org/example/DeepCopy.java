package org.example;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class DeepCopy {
    public Object clone(Object object) {
        if (object == null)
            return null;
        if (object.getClass().isArray())
            return cloneArray(object);
        if (object instanceof ArrayList<?>)
            return cloneArrayList((ArrayList<?>) object);
        if (object instanceof String)
            return new String((String) object);
        Object clone;
        Class<?> klass = object.getClass();
        try {
            clone = klass.newInstance();
            while (klass != null) {
                for (Field field : klass.getDeclaredFields()) {
                    if (Modifier.isStatic(field.getModifiers()))
                        continue;
                    field.setAccessible(true);
                    Object value = field.get(object);
                    if (value != null) {
                        if (isPrimitiveOrWrapper(value.getClass())) {
                            field.set(clone, value);
                        } else {
                            field.set(clone, clone(value));
                        }
                    }
                    field.setAccessible(false);
                }
                klass = klass.getSuperclass();
            }
            return clone;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isPrimitiveOrWrapper(Class<?> type) {
        return type.isPrimitive() || type == Boolean.class || type == Byte.class ||
                type == Character.class || type == Double.class || type == Float.class ||
                type == Integer.class || type == Long.class || type == Short.class ||
                type == String.class;
    }

    private Object cloneArray(Object array) {
        int length = Array.getLength(array);
        Object clone = Array.newInstance(array.getClass().getComponentType(), length);
        for (int i = 0; i < length; i++)
            Array.set(clone, i, clone(Array.get(array, i)));
        return clone;
    }

    private ArrayList<?> cloneArrayList(ArrayList<?> list) {
        ArrayList<Object> clone = new ArrayList<>();
        for (Object item : list)
            clone.add(clone(item));
        return clone;
    }
}