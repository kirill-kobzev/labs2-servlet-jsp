package servlets.pojo;

public class City {
    private int city_id;
    private String city_name;
    private int citizens;

    public City(int city_id, String name, int citizens) {
        this.city_id = city_id;
        this.city_name = name;
        this.citizens = citizens;
    }

    public int getId() {
        return city_id;
    }

    public void setId(int city_id) {
        this.city_id = city_id;
    }

    public String getCityName() {
        return city_name;
    }

    public void setName(String name) {
        this.city_name = name;
    }

    public int getCitizens() {
        return citizens;
    }

    public void setCitizens(int citizens) {
        this.citizens = citizens;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", name='" + city_name + '\'' +
                ", citizens=" + citizens +
                '}';
    }
}