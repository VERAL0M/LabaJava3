package ru.makerov.main;

public class Student {
    private String name;
    private int[] marks;

    public Student(String name, int... marks) {
        this.name = name;
        setMarks(marks);
    }


    public String getName() {
        return name;
    }

    public int[] getMarks() {
        return marks.clone();
    }

    public void setMarks(int[] marks) {
        if (marks==null){
            throw new IllegalArgumentException("Список оценок не может быть null");
        }
        marks = marks.clone();
        for (int mark: marks){
            if (mark<2 || mark>5){

                throw new IllegalArgumentException("Оценка должна быть от 2 до 5");
            }
        }
        this.marks = marks;
    }


    public void setMark(int index, int value) {
        if (value <2 || value>5){
            throw new IllegalArgumentException("Оценка должна быть от 2 до 5");
        }

        marks[index] = value;
    }

    public double getAverageMark() {
        if (marks.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
    public boolean isExcellent(){
        if (marks.length==0){
            return false;
        }
        for (int mark : marks){
            if (mark!=5){
                return false;
            }

        }
        return true;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": [");
        for (int i = 0; i < marks.length; i++) {
            sb.append(marks[i]);
            if (i < marks.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
