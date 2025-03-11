package classes;

public abstract class AbstractContent {
    
    protected int id;
    protected String title;

    public AbstractContent(int id, String title){
    //Validazione id 
    if (id <= 0) {
        throw new IllegalArgumentException("L'ID deve essere maggiore di zero.");
    }
    this.id = id;
    //Validazione titolo
    if (title == null || title.trim().isEmpty()) {
        throw new IllegalArgumentException("Il titolo non può essere vuoto e non può contenere solo spazi.");
    }
    this.title = title;
    }

    //Getter e Setter id 
    public int getId(){
        return id;
    }

    public void setId(int id){
        if (id <= 0) {
            throw new IllegalArgumentException("L'ID deve essere maggiore di zero.");
        }
        this.id = id;
    }
    //Getter e Setter title
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto e non può contenere solo spazi.");
        }
        this.title = title;
    }
    //ToString
    @Override
    public String toString(){
        return String.format("Titolo : %S | Id : %i", title,id);
    }
}
