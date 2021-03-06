package dstywho;

// package com.kupal.skypeCommand.util;

import java.lang.reflect.Field;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ClassUtil {

    public static <T> T getInstance(Class<T> clazz)
        {
            T t = null;
            try
                {
                    t = clazz.newInstance();
                }
            catch (InstantiationException e)
                {
                    e.printStackTrace();
                }
            catch (IllegalAccessException e)
                {
                    e.printStackTrace();
                }

            return t;
        }

    public static Field[] getDeclaredFields(Class clazz, boolean recursively)
        {
            List<Field> fields = new LinkedList<Field>();
            Field[] declaredFields = clazz.getDeclaredFields();
            Collections.addAll(fields, declaredFields);

            Class superClass = clazz.getSuperclass();

            if (superClass != null && recursively)
                {
                    Field[] declaredFieldsOfSuper = getDeclaredFields(superClass, recursively);
                    if (declaredFieldsOfSuper.length > 0)
                        Collections.addAll(fields, declaredFieldsOfSuper);
                }

            return fields.toArray(new Field[fields.size()]);
        }

    public static Field[] getAnnotatedDeclaredFields(Class clazz, Class<? extends Annotation> annotationClass, boolean recursively)
        {
            Field[] allFields = getDeclaredFields(clazz, recursively);
            List<Field> annotatedFields = new LinkedList<Field>();

            for (Field field : allFields)
                {
                    if (field.isAnnotationPresent(annotationClass))
                        annotatedFields.add(field);
                }

            return annotatedFields.toArray(new Field[annotatedFields.size()]);
        }
}
