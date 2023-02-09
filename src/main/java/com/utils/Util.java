package com.utils;

import com.github.brianmmcclain.springbootapidemo.Item;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Util {
//    @Autowired
//    ResourceLoader resourceLoader;

    public File getResource(String filePath) {
        try {
            return ResourceUtils.getFile(
                    "classpath:" + filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Object> getItemsFromFile() {
//        Resource resource = getResource("data/items.json");
        ArrayList<Object> json = null;
        try {
            File file = getResource("data/items.json");
            JSONParser jsonParser = new JSONParser(new FileReader(file));
            json = jsonParser.parseArray();
            System.out.println(json);
            return json;
        } catch (IOException e) {
            return null;
        } catch (ParseException e) {
            return null;
        }

    }

}
