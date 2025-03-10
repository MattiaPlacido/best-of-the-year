package classes;
import java.io.Serializable;
import java.util.ArrayList;

public class Song extends AbstractContent implements Serializable{
    
    private ArrayList<String> artistsList;
    private String musicLabel;
    private int durationInSeconds;
    
public Song(int id,String title,ArrayList<String> artists,String label,int duration){
    //Chiamata al costruttore della superclasse
    super(id, title);

    //Validazione etichetta discografica
    if (label == null || label.trim().isEmpty()) {
        throw new IllegalArgumentException("Questo campo non può essere vuoto.");
    }
    musicLabel = label;

    //Validazione durata
    if(duration <= 0){
        throw new IllegalArgumentException("La durata deve essere maggiore di zero.");
    }
    durationInSeconds = duration;

    //Validazione artisti
    if (artists == null || artists.isEmpty()) {
        throw new IllegalArgumentException("La canzone deve avere almeno un artista.");
    }
    artistsList = new ArrayList<>(artists);
}

//Costruttore vuoto per rendere la classe JavaBean
public Song(){
    super(1,"Default");
    artistsList = new ArrayList<>();
    musicLabel = "Default";
    durationInSeconds = 10;
}

//Getter e Setter MusicLabel
public String getMusicLabel(){
    return musicLabel;
}

public void setMusicLabel(String label){
    if (label == null || label.trim().isEmpty()) {
        throw new IllegalArgumentException("Questo campo non può essere vuoto.");
    }
    musicLabel = label;
}

//Getter e Setter Duration
public int getDurationInSeconds(){
    return durationInSeconds;
}

public void setDurationInSeconds(int duration){
    durationInSeconds = duration;
}

//Getter e Setter ArtistList
public String getArtistsList(){
    String output = "";
    for(int i=0; i < artistsList.size(); i++) {
        if(i == 0){
            output = artistsList.get(i);
        }else{
            output += " - " + artistsList.get(i);
        }
    }
    return output;
}


public void setArtistsList(ArrayList<String> newList){
    if (newList == null || newList.isEmpty()) {
        throw new IllegalArgumentException("La canzone deve avere almeno un artista.");
    }
    artistsList = new ArrayList<>(newList);
}

//Metodi ArtistList
public void addArtist(String artist){
    if (artist == null || artist.trim().isEmpty()) {
        throw new IllegalArgumentException("Questo campo non può essere vuoto.");
    }
    artistsList.add(artist);
}

//ToString
@Override
public String toString(){
    return String.format("Titolo : %s | Durata : %d secondi | Etichetta Discografica : %s | Artisti : %s ", title,durationInSeconds,musicLabel,getArtistsList());
}


}
