package site.ilemon.springbootyaml;

import java.util.List;

public class Pet {
    private String name;
    private Integer age;
    private List<String> favoriteFoods;

    public Pet() {

    }

    public Pet(String name, Integer age, List<String> favoriteFoods) {
        this.name = name;
        this.age = age;
        this.favoriteFoods = favoriteFoods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(List<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favoriteFoods=" + favoriteFoods +
                '}';
    }
}
