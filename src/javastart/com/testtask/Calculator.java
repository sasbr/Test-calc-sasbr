package javastart.com.testtask;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    int num1;
    int num2;
    String result = "";
    boolean isRoma = false;


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


        return result;
    }


    private void fillNumbersOperationAndTypCalc(String line) throws Exception {

        if (line.contains(" ") || line.length() > 9)
            throw new Exception("Есть Пробел или число больше 10, так плохо");
        if (!(line.contains("+") || line.contains("-") || line.contains("*") || line.contains("/")))
            throw new Exception("нет оператора, - плохо");

        String[] values = line.split("\\+");
        if (values.length == 2) {
            if (isValidate(values)) {
                num1 = stringToInt.get(values[0]);
                num2 = stringToInt.get(values[1]);
                result = ConverterRoma.calculate(num1 + num2, isRoma);

            } else {
                throw new Exception("Сложение не сработало");
            }

        } else {
            values = line.split("-");
            if (values.length == 2) {
                if (isValidate(values)) {
                    num1 = stringToInt.get(values[0]);
                    num2 = stringToInt.get(values[1]);
                    result = ConverterRoma.calculate(num1 - num2, isRoma);
                } else {
                    throw new Exception("Вычитание не сработало");
                }
                //минус, проверка и заполнить значение

            } else {
                values = line.split("/");
                if (values.length == 2) {
                    if (isValidate(values)) {
                        num1 = stringToInt.get(values[0]);
                        num2 = stringToInt.get(values[1]);
                        result = ConverterRoma.calculate(num1 / num2, isRoma);
                    } else {
                        throw new Exception("Деление не сработало");
                    }
                    //деление, проверка и заполнить значение
                } else {
                    values = line.split("\\*");
                    if (values.length == 2) {
                        //Умножение, проверка и заполнение значения

                        if (isValidate(values)) {

                            num1 = stringToInt.get(values[0]);
                            num2 = stringToInt.get(values[1]);
                            result = ConverterRoma.calculate(num1 * num2, isRoma);
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

    private boolean isValidate(String[] values) {
        //Проверка на соответствие араб или рим. цифры
        boolean isRoma1 = (values[0].contains("I") || values[0].contains("V") || values[0].contains("X"));
        boolean isRoma2 = (values[1].contains("I") || values[1].contains("V") || values[1].contains("X"));
        if (isRoma1 == isRoma2) {
            isRoma = isRoma1;
            return stringToInt.containsKey(values[0]) && stringToInt.containsKey(values[1]);
        } else {
            return false;
        }


    }

}
