package ru.makerov.main;

import java.util.HashMap;
import java.util.Map;

public class YelowPages {

    private final HashMap<String, String> contacts;

    public YelowPages() {
        contacts = new HashMap<>();
    }


    public String add(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("Имя и телефон не могут быть null");
        }
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(number)
                    && !entry.getKey().equals(name)) {
                throw new IllegalArgumentException(
                        "Этот телефон уже закреплён за другим именем");
            }
        }

        return contacts.put(name, number);
    }

    public void delete(String name) {
        contacts.remove(name);
    }


    public String getNumber(String name) {
        return contacts.get(name);
    }

    public boolean checkName(String name) {
        return contacts.containsKey(name);
    }

    public boolean checkNumber(String number) {
        return contacts.containsValue(number);
    }

    public int sizeContacts() {
        return contacts.size();
    }

    public String[] allNumbers() {
        String[] numbers = new String[contacts.size()];
        int i = 0;
        for (String values: contacts.values()){
            numbers[i] =values;
            i++;
        }
        return numbers;
    }

    public String[] allNames() {
        String[] names = new String[contacts.size()];
        int i=0;
        for (String values: contacts.keySet()){
            names[i] = values;
            i++;
        }
        return names;
    }


    public String[] allPairs() {
        String[] pairs = new String[contacts.size()];
        int i = 0;

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            pairs[i] = entry.getValue() + " - " + entry.getKey();
            i++;
        }

        return pairs;
    }

    public String[] findNamesStartingWith(String prefix) {
        String[] result = new String[contacts.size()];
        int count = 0;

        for (String name : contacts.keySet()) {
            if (name.toLowerCase().startsWith(prefix.toLowerCase())) {
                result[count] = name;
                count++;
            }
        }


        String[] matchedNames = new String[count];
        System.arraycopy(result, 0, matchedNames, 0, count);
        return matchedNames;
    }

//    public void showArray(String[] arr){
//        for (String value: arr){
//            System.out.println(value);
//        }
//    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(entry.getValue())
                    .append(" - ")
                    .append(entry.getKey());
        }

        return result.toString();
    }
}