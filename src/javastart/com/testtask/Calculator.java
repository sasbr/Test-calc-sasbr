package javastart.com.testtask;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    int num1;
    int num2;
    String result = "";
    boolean isRoma = false;
    String operation = "";

    static Map<String, Integer> stringToInt = new HashMap<>();

    static {
        stringToInt.put("1", 1);
        stringToInt.put("2", 2);
        stringToInt.put("3", 3);
        stringToInt.put("4", 4);
        stringToInt.put("5", 5);
        stringToInt.put("6", 6);
        stringToInt.put("7", 7);
        stringToInt.put("8", 8);
        stringToInt.put("9", 9);
        stringToInt.put("10", 10);
        stringToInt.put("I", 1);
        stringToInt.put("II", 2);
        stringToInt.put("III", 3);
        stringToInt.put("IV", 4);
        stringToInt.put("V", 5);
        stringToInt.put("VI", 6);
        stringToInt.put("VII", 7);
        stringToInt.put("VIII", 8);
        stringToInt.put("IX", 9);
        stringToInt.put("X", 10);

    }

    public String getResult(String line) throws Exception {
        fillNumbersOperationAndTypCalc(line);
        calculate();

        return result;
    }

    private void calculate() throws Exception {

        if (isRoma) {

            //  throw new Exception("Чтото идет не так в рома кальке");

            result = convertToRoma(result);
        }
    }

    private String convertToRoma(String result) {
        // конверт
        return result + "римское число";
    }

    private void fillNumbersOperationAndTypCalc(String line) throws Exception {

        if (line.contains(" ") || line.length() > 9)
            throw new Exception("Есть Пробел или число больше 10, так плохо");
        if (!(line.contains("+") || line.contains("-") || line.contains("*") || line.contains("/")))
            throw new Exception("нет оператора, так плохо");
        isRoma = (line.contains("I") || line.contains("V") || line.contains("X"));
        String[] values = line.split("\\+");
        if (values.length == 2) {
            if (stringToInt.containsKey(values[0]) && stringToInt.containsKey(values[1])) {
                num1 = stringToInt.get(values[0]);
                num2 = stringToInt.get(values[1]);
                result = "" + (num1 + num2);
            } else {
                throw new Exception("Сложение не сработало");
            }
            // result = "" + addNumber(num1, num2);

        } else {
            values = line.split("-");
            if (values.length == 2) {
                if (stringToInt.containsKey(values[0]) && stringToInt.containsKey(values[1])) {
                    num1 = stringToInt.get(values[0]);
                    num2 = stringToInt.get(values[1]);
                    result = "" + (num1 - num2);
                } else {
                    throw new Exception("Вычитание не сработало");
                }
                //минус, проверка и заполнить значение

            } else {
                values = line.split("/");
                if (values.length == 2) {
                    if (stringToInt.containsKey(values[0]) && stringToInt.containsKey(values[1])) {
                        num1 = stringToInt.get(values[0]);
                        num2 = stringToInt.get(values[1]);
                        result = "" + num1 / num2;
                    } else {
                        throw new Exception("Деление не сработало");
                    }
                    //деление, проверка и заполнить значение
                } else {
                    values = line.split("\\*");
                    if (values.length == 2) {
                        //Умножение, проверка и заполнение значения

                        if (stringToInt.containsKey(values[0]) && stringToInt.containsKey(values[1])) {

                            num1 = stringToInt.get(values[0]);
                            num2 = stringToInt.get(values[1]);
                            result = "" + num1 * num2;
                        } else {
                            throw new Exception("Умножение не сработало");
                        }


                    } else {
                        throw new Exception("Что то пошло не так");

                    }


                }
            }
        }

    }

    private int addNumber(int num1, int num2) {
        return num1 + num2;
    }
}
