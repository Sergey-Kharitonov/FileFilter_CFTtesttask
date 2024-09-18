package org.stats;


/*
Статистика должна поддерживаться двух видов: краткая и полная. Выбор статистики
производится опциями -s и -f соответственно.
 Краткая статистика содержит только
количество элементов записанных в исходящие файлы.

Полная статистика для чисел
дополнительно содержит минимальное и максимальное значения, сумма и среднее.
Полная статистика для строк, помимо их количества, содержит также размер самой
короткой строки и самой длинной
 */


public class Statistic {

    public static void showStatistic (boolean shortStatsArg, boolean fullStatsArg){
        if (shortStatsArg) {
            System.out.println("Краткая статистика:");
            System.out.println( IntegerStats.countInteger + " - Количество записанных целочисленных элементов");
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println( FloatStats.countFloat + " - Количество записанных элементов вещественных чисел" );
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println( StringStats.countString + " - Количество записанных строковых элементов");

        }
        if (fullStatsArg){
            System.out.println("Полная статистика:");
            System.out.println( IntegerStats.countInteger + " - Количество записанных целочисленных элементов");
            System.out.println( IntegerStats.minInteger + " - Минимальное целое число");
            System.out.println( IntegerStats.maxInteger + " - Максимальное целое число");
            System.out.println( IntegerStats.sumInteger + " - Сумма всех целых чисел");
            System.out.println( IntegerStats.avgInteger + " - Среднее значение для целых чисел");
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println( FloatStats.countFloat + " - Количество записанных элементов вещественных чисел" );
            System.out.println( FloatStats.minFloat+ " - Минимальное вещественное число");
            System.out.println( FloatStats.maxFloat + " - Максимальное вещественное число");
            System.out.println( FloatStats.sumFloat + " - Сумма всех вещественных чисел");
            System.out.println( FloatStats.avgFloat + " - Среднее значение для вещественных чисел");
            System.out.println("~~~~~~~~~~~~~~~~~~");
            System.out.println( StringStats.countString + "-Количество записанных строковых элементов");
            System.out.println( StringStats.minString + " - Строка с минимальным количеством символов (включая пробел)");
            System.out.println( StringStats.maxString + " - Строка с максимальнеым количеством символов (включая пробел)");
        }
    }
}
