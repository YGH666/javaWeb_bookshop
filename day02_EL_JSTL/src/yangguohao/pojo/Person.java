package yangguohao.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Yang
 * @date 2020/03/02
 **/
public class Person {
    private Integer id;
    private String[] phones;
    private List<String> cities;
    private Map<String,Object> map;

    public String getTest(){
        return "这是调用getTest()方法";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Person(Integer id, String[] phones, List<String> cities, Map<String, Object> map) {
        this.id = id;
        this.phones = phones;
        this.cities = cities;
        this.map = map;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", phones=" + Arrays.toString(phones) +
                ", cities=" + cities +
                ", map=" + map +
                '}';
    }
}
