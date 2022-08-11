package RestAssuredDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class User {

    private String name;
    private String job;
    private ArrayList<Integer> numbers;
    private Address address;
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User(String name , String job, int flat , String building, String cName , String CDomain){
        this.name = name;
        this.job = job;
        this.numbers = new ArrayList<>();
        this.address = new Address(flat,building);
        this.company = new Company(cName,CDomain);

    }


    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setNumbers(int... num){
        Arrays.stream(num).forEach(e->this.numbers.add(e));
    }





}
