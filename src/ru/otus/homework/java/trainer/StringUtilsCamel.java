/*Дана строка. Реализуйте метод который бы приводил полученную строку к camel case нотации.
Если встречаются знаки препинания, иные специальные символы или цифры - они должны быть удалены.
Пример: входная строка - my camel * case string 1, результат - myCamelCaseString*/
package ru.otus.homework.java.trainer;

public class StringUtilsCamel {
    public static String toCamelCase(String input) {
        String result = "";
        boolean prNew = false;
        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                prNew = true;
            } else if (Character.isLetter(c)) {
                if (prNew) {
                    if (result.equals("")) result += c;
                    else result += Character.toUpperCase(c);
                    prNew = false;
                } else result += c;
            }
        }
        return result;
    }

    private StringUtilsCamel() {

    }

    public static void main(String[] args) {
        System.out.println("Строка \"my camel * case string 1\" должна преобразоваться в myCamelCaseString - "
                + StringUtilsCamel.toCamelCase("- 9 4  755 32    my camel * case string 1"));
    }
}