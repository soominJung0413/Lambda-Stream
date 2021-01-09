package stream.basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args) {
        String[] strArr = {"/etc/apt/sources.list","/etc/network/interfaces","main/java/Map.class","File.txt","None",};

        List<String> collect = Arrays.stream(strArr).filter(s -> (s.lastIndexOf("/") != -1) || (s.lastIndexOf(".") != -1))
                .map(s -> {
                    if (s.lastIndexOf("/") != -1) {
                        s = s.substring(s.lastIndexOf("/") + 1);
                    }
                    return s;
                })
                .map(s -> {
                    if(s.lastIndexOf(".") != -1 ){
                        s = s.substring(0, s.lastIndexOf("."));
                    }
                    return s;
                })
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        //[File, Map, interfaces, sources]
        System.out.println(Arrays.toString(collect.toArray()));
    }
}
