package org;

import org.stats.Statistic;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


public class Main {

        public static void main(String[] args) {
            try {
                new Parser().parseArgs(args);  // Парсинг аргументов коммандной строки
                workFiles();                   // Работа с входными файлами
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        private static void workFiles(){
            try {
                ArrayList<BufferedReader> readers = new ArrayList<>();   //Список входных файлов
                for (String argument : Parser.arguments) {
                    readers.add(new BufferedReader(new InputStreamReader(new FileInputStream(argument))));
                }
                Filter filter = new Filter(Parser.filesAppendArg);
                while (!readers.isEmpty()) {
                    Iterator<BufferedReader> iterator = readers.iterator();
                    while (iterator.hasNext()) {
                        BufferedReader reader = iterator.next();
                        String line = reader.readLine();
                        if (line == null) {
                            iterator.remove();
                        } else
                            filter.filterString(line, Parser.pathOutputFiles, Parser.outFilePrefix ); //Фильтрация входных файлов
                    }
                }
                Statistic.showStatistic(Parser.shortStatsArg, Parser.fullStatsArg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

}