package RestAssuredDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class Company {


    private String cName;
    private String cDomain;
    private  ArrayList<String> clients;

    public Company(String cName , String cDomain){

        this.cName = cName;
        this.cDomain= cDomain;
        this.clients = new ArrayList<>();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDomain() {
        return cDomain;
    }

    public void setcDomain(String cDomain) {
        this.cDomain = cDomain;
    }

    public ArrayList<String> getClients() {
        return clients;
    }

    public void setClients(ArrayList<String> clients) {
        this.clients = clients;
    }

    public  void setClients(String... clients){
        Arrays.stream(clients).forEach(e->this.clients.add(e));
    }
}
