package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Movie extends AbstractContent implements Serializable {
    
    private ArrayList<String> actorsList;
    private String director;
    private String productionCompany;
    private int hours;
    private int minutes;

    public Movie(int id, String title, ArrayList<String> cast,String director, String productionCompany, int hours, int minutes){
        super(id, title);

        //Validazione compagnia di produzione
        if (productionCompany == null || productionCompany.trim().isEmpty()) {
            throw new IllegalArgumentException("Questo campo non può essere vuoto.");
        }
        this.productionCompany = productionCompany;

        //Validazione regista
        if (director == null || director.trim().isEmpty()) {
            throw new IllegalArgumentException("Questo campo non può essere vuoto.");
        }
        this.director = director;

        //Validazione durata
        if(hours < 0 || minutes < 0 || hours == 0 && minutes == 0){
            throw new IllegalArgumentException("Ore e minuti devono essere positivi, ed almeno uno dei due superiore a 0");
        }
        this.hours = hours;
        this.minutes = minutes;

        //Validazione cast / lista di attori
        if (cast == null || cast.isEmpty()) {
            throw new IllegalArgumentException("Il film deve avere almeno un attore.");
        }
        actorsList = new ArrayList<>(cast);

    }
    
    //Costruttore vuoto per rendere la classe JavaBean
    public Movie(){
        super(1,"Default");
        actorsList = new ArrayList<>();
        productionCompany = "Default";
        director = "Default";
        hours = 1;
        minutes = 1;
    }

    //Production Company
    public String getProductionCompany(){
        return productionCompany;
    }
    
    public void setProductionCompany(String newCompany){
        if (newCompany == null || newCompany.trim().isEmpty()) {
            throw new IllegalArgumentException("Questo campo non può essere vuoto.");
        }
        productionCompany = newCompany;
    }

    //Director
    public String getDirector(){
        return director;
    }
    public void setDirector(String newDirector){
        if (newDirector == null || newDirector.trim().isEmpty()) {
            throw new IllegalArgumentException("Questo campo non può essere vuoto.");
        }
        director = newDirector;
    }
    
    //Duration
    public String getFullDuration(){
        return String.format("%dh %dm", hours,minutes);
    }
    public void setFullDuration(int hours, int minutes){
        if(hours < 0 || minutes < 0 || hours == 0 && minutes == 0){
            throw new IllegalArgumentException("Ore e minuti devono essere positivi, ed almeno uno dei due superiore a 0");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    //Hours
    public int getHours(){
        return hours;
    }
    public void setHours(int hours){
        if(hours < 0){
            throw new IllegalArgumentException("Questo dato non può essere negativo");
        }
        if(hours == 0 && minutes == 0){
            throw new IllegalArgumentException("Se i minuti sono zero le ore devono essere maggiori di zero.");
        }
        this.hours = hours;
    }

    //Minutes
    public int getMinutes(){
        return minutes;
    }
    public void setMinutes(int minutes){
        if(minutes < 0){
            throw new IllegalArgumentException("Questo dato non può essere negativo");
        }
        if(hours == 0 && minutes == 0){
            throw new IllegalArgumentException("Se le ore sono zero i minuti devono essere maggiori di zero.");
        }
        this.minutes = minutes;
    }

    //ActorsList 
    public String getActorsList(){
        String output = "";
        for(int i=0; i < actorsList.size(); i++) {
            if(i == 0){
                output = actorsList.get(i);
            }else{
                output += " - " + actorsList.get(i);
            }
        }
        return output;
    }

    public void setActorsList(ArrayList<String> newList){
        if (newList == null || newList.isEmpty()) {
            throw new IllegalArgumentException("Il film deve avere almeno un attore.");
        }
        actorsList = new ArrayList<>(newList);
    }

    public void addActor(String actor){
        if (actor == null || actor.trim().isEmpty()) {
            throw new IllegalArgumentException("Questo campo non può essere vuoto.");
        }
        actorsList.add(actor);
    }

    //ToString
    @Override
    public String toString(){
        return String.format("Titolo : %s | Durata : %s | Regista : %s | Compagnia di produzione : %s | Attori : %s", title,getFullDuration(),director,productionCompany,getActorsList());
    }

}
