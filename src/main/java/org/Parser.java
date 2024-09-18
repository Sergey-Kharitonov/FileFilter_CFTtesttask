package org;


import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;


import java.util.ArrayList;
import java.util.List;



public class Parser {
    @Option(name = "-o",usage = "Path for result files (Укажите путь выходных файлов)" )
    private boolean pathArg ;
    static String pathOutputFiles = "" ;
    @Option(name = "-p",usage = "Prefix to output files (Укажите префикс к названию файла)" )
    private boolean outFilePrefixArg;
    static String outFilePrefix  = "";
    @Option(name = "-a",usage = "Appending in existing files (Укажите, если необходимо добавлять результат в существующие файлы )" )
    static boolean filesAppendArg ;
    @Option(name = "-s",usage = "Short statistics (Короткая статистика)" , forbids = {"-f"})
    static
    boolean shortStatsArg ;
    @Option(name = "-f",usage = "Full statistics (Полная статистика)" , forbids = {"-s"})
    static
    boolean fullStatsArg ;

    @Argument
    static List<String> arguments = new ArrayList<String>();

    public void parseArgs(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            //Проверяем задан ли относительный путь выходных файлов
            if (pathArg) {
                pathOutputFiles = arguments.get(0);
                arguments.remove(0);
                Parser.pathOutputFiles = checkPathArg(pathOutputFiles);
            }
            //Проверяем задан ли префикс имен выходных файлов
            if (outFilePrefixArg) {
                outFilePrefix = arguments.get(0); arguments.remove(0);
            }

            //Проверка на отсутствие вводных аргументов
            if (arguments.isEmpty() ) {
                System.err.println("Ошибка аргументов коммандной строки");
                parser.printUsage(System.err);
                System.err.println("\nПример: -s -a -p sample- in1.txt in2.txt");
                throw new IllegalArgumentException("");
            }

        } catch (CmdLineException | IndexOutOfBoundsException e ) {
            //обработка исключения, предусмотренного библиотекой
            System.err.println(e.getMessage());
            System.err.println("Ошибка аргументов коммандной строки");
            parser.printUsage(System.err);
            System.err.println("\nПример:-s -a -p sample- in1.txt in2.txt");
            throw new IllegalArgumentException("");
        }

    }

    private String checkPathArg(String pathOutputFiles){
        if (pathOutputFiles.startsWith("/")){
            pathOutputFiles = pathOutputFiles.substring(1);
        }
        if (!pathOutputFiles.endsWith("/")){
            pathOutputFiles = pathOutputFiles+"/";
        }
      return  pathOutputFiles;
    }




}
