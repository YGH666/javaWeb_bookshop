package pojo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import json.PersonListType;
import json.PersonMapType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Mr.Yang
 * @date 2020/03/10
 **/
public class PersonTest {
    /**
     * javaBean 和 Json
     */
    @Test
    public void test1(){
        Person person = new Person(1,"yangguohao");

        Gson gson = new Gson();
        //person对象转json字符串
        String personString = gson.toJson(person);
        System.out.println("personString = " + personString);

        //json字符串转person对象
        Person person1 = gson.fromJson(personString, Person.class);
        System.out.println(person1);

    }

    /**
     * list 和  Json
     */
    @Test
    public void test2(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"p1"));
        personList.add(new Person(2,"p2"));
        System.out.println("personList = " + personList);

        Gson gson =new Gson();
        String s = gson.toJson(personList);
        System.out.println("s = " + s);

        List<Person> list = gson.fromJson(s, new PersonListType().getType());
        System.out.println("list = " + list);
    }

    @Test
    public void test3(){
        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(1,new Person(1,"p1"));
        personMap.put(2,new Person(2,"p2"));
        for (Map.Entry<Integer, Person> entry : personMap.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        Gson gson = new Gson();
        String mapToJson = gson.toJson(personMap);
        System.out.println("mapToJson = " + mapToJson);

//        Map<Integer,Person> personMap1 = gson.fromJson(mapToJson, new PersonMapType().getType());
        Map<Integer,Person> personMap1 = gson.fromJson(mapToJson, new TypeToken<HashMap<Integer, Person>>() {}.getType());
        for (Map.Entry<Integer, Person> entry : personMap1.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}