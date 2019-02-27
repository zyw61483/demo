package com.example.demo;

import com.google.common.base.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author zhaoyiwei 2019/1/17 18:42
 */
@Slf4j
public class GuavaTest {
    @Test
    public void test() throws IOException {
        ArrayList<String> list = Lists.newArrayList("1", "A", "null","2", "B");
        HashMap<Object, Object> map = Maps.newHashMap();
        map.put("1","A");
        map.put("2","B");
        Joiner.MapJoiner no_value = Joiner.on("#").useForNull("no value").withKeyValueSeparator("=");
        String join = no_value.join(map);
        File file = new File("/guava.txt");
        FileWriter writer = new FileWriter(file);
        FileWriter writer1 = Joiner.on("*****").skipNulls().appendTo(writer, list);
        writer1.flush();
//        log.info(join1);
    }

    @Test
    public void splitter() {
        Iterable<String> split = Splitter.on("#").trimResults().split("1#A##   #2#B#3#C");
        split.forEach(s -> System.out.println(s));
        Iterator<String> iterator = split.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
        Map<String, String> map = mapSplitter.split("1=A#2=B#3=C");
        log.info("map:{}",map);
    }

    @Test
    public void strings(){
        System.out.println(Charsets.UTF_8);
        System.out.println(Strings.padEnd("aaa",2,'x'));
        System.out.println(Strings.padStart("bbb",6,'z'));
        System.out.println("sdfsd sdfsdf  ".length());
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.nullToEmpty("sdfsd sdfsdf  "));
        System.out.println();
    }


}
