package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    Random random = new Random();
    HashMap<String, ArrayList<String>> menu = new HashMap<>();
    ArrayList<String> dishesTypeList = new ArrayList<>();

    public void addDishNames(String dishType, String dishName) {
        if (!menu.containsKey(dishType)) {
            ArrayList<String> dishNameList = new ArrayList<>();
            dishNameList.add(dishName);
            menu.put(dishType, dishNameList);
        } else {
            menu.get(dishType).add(dishName);
        }
    }

    public void enterDishesTypes(String dishesType) {
        if (menu.containsKey(dishesType) || dishesType.isEmpty()) {
            dishesTypeList.add(dishesType);
        }
        else {
            System.out.println("Такого типа блюд нет. Пожалуйста, введите другой тип");
        }
    }

    public void generateCombo(int numberOfCombos) {
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбо " + (i + 1));
            ArrayList<String> dishList = new ArrayList<>();
            for (String typeNameFromOrder : dishesTypeList) {
                for (String dishType : menu.keySet()) {
                    if (dishType.equals(typeNameFromOrder)) {
                        ArrayList<String> dishName = menu.get(dishType);
                        dishList.add(dishName.get(random.nextInt(dishName.size())));
                    }
                }
            }
            System.out.println(dishList);
        }
        dishesTypeList.clear(); // очистка списка типов для повторной генерации блюд в текущем сеансе программы
    }

    public void printMenuOfCafe(){
        System.out.println(menu);
    }

}
