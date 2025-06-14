package org.gfg.collections;

public class BoxDemo {

    public static void main(String[] args) {
        Box box = new Box();
        box.put(1234);
        box.put("asdf");
        box.put(new Box());

        TypeSafeBox<String> typeSafeBox = new TypeSafeBox<>();
        typeSafeBox.put("qwert");


        TypeSafeBox<Integer> typeSafeBoxInt = new TypeSafeBox<>();
        typeSafeBoxInt.put(12345);

        TypeSafeBox<Object> objectTypeSafeBox = new TypeSafeBox<>();
        objectTypeSafeBox.put(1234);
        objectTypeSafeBox.put("1234");
        objectTypeSafeBox.put(new Box());
    }

}
