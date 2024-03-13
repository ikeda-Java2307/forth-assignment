package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class StreamSample {

    public static void main(String[] args) {
        List<String> names = List.of("yamada", "tanaka", "yasuda", "suzuki", "iida");

        List<String> result = names.stream()
                .filter(name -> name.contains("i"))
                .collect(Collectors.toList());
        System.out.println(result);

        //resultのメソッド参照
        List<String> resultReference = names.stream()
                .filter(StreamSample::test)
                .collect(Collectors.toList());
        System.out.println(resultReference);

        //namesを大文字にする
        List<String> resultUppercase = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(resultUppercase);

        //namesを昇順に並べ替えてコンマ区切りで文字列にする
        String resultAscendingOrderCS = names.stream()
                .sorted()
                .collect(Collectors.joining(","));
        System.out.println(resultAscendingOrderCS);
    }


    //resultReference用のメソッド
    private static boolean test(String name) {
        return name.contains("i");
    }
}
