package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
   static Boolean val = true;
    public static void main(String[] args){
        Class<?> classType2 = val.getClass();
        System.out.println(classType2.getTypeName());

        Class<?> classType3 = Boolean.class;
        System.out.println(classType3.getTypeName());

        try {
            Class<?> classType4 = Class.forName("java.lang.Boolean");
            System.out.println(classType4.getTypeName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> classType5 = Boolean.TYPE;
        System.out.println(classType5.getTypeName());
        System.out.println(">>>>>>>>>>>>classType6.getFields()");
        Class<?> classType6 = ExtendType.class;
        for(Field field : classType6.getFields()){
            System.out.println("classType6.getFields()"+field);
        }

        try {
            System.out.println(".................................");
            Object inst = classType6.newInstance();
            Method method = classType6.getDeclaredMethod("Log", String.class);
            method.setAccessible(true);
            method.invoke(inst,"test");

            Field field = classType6.getField("pubIntExtendField");
            field.setInt(inst,4);

            int i  = field.getInt(inst);
            System.out.println("i == "+ i);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println(">>>>>>>>>>>>classType6.getMethods()");
        for (Method method : classType6.getMethods()){
            System.out.println("classType6.getMethods()"+method);
        }
        System.out.println(">>>>>>>>>>>>classType6.getConstructors()");
        for (Constructor<?> constructor :classType6.getConstructors()){
            System.out.println("classType6.getConstructors()"+constructor);
        }
        System.out.println(">>>>>>>>>>>>classType7.getDeclaredFields()");
        Class<?> classType7 = ExtendType.class;
        for(Field field : classType7.getDeclaredFields()){
            System.out.println("classType7.getDeclaredFields()"+field);
        }
        System.out.println(">>>>>>>>>>>>classType7.getDeclaredMethods()");
        for(Method method : classType7.getDeclaredMethods()){
            System.out.println("classType7.getDeclaredFields()"+method);
        }
        System.out.println(">>>>>>>>>>>>classType7.getDeclaredConstructors()");
        for (Constructor<?> constructor :classType7.getDeclaredConstructors()){
            System.out.println("classType7.getDeclaredConstructors()"+constructor);
        }

    }

}
