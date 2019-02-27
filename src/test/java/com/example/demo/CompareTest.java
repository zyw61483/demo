package com.example.demo;

import java.io.*;
import java.util.*;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoyiwei 2019/1/17 18:42
 */
@Slf4j
public class CompareTest {
    @Test
    public void test() {
        List<String> list1 = getList(new File("D:\\1.txt"));
        List<String> list2 = getList(new File("D:\\2.txt"));
        for(String temp:list2){
            if(!list1.contains(temp)){
                log.warn("{}",temp);
            }
        }
    }

    private List<String> getList(File file){
        ArrayList<String> list = Lists.newArrayList();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                ArrayList<String> line = Lists.newArrayList(Splitter.on(",").trimResults().split(tempString));
                list.add(line.get(0));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}



