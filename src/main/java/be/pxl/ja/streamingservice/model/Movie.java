package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Movie extends Content implements Playable{
    public static final int LONG_PLAYING_TIME = 2 * 60 * 15;
    private String title;
    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;
    private Rating maturityRating;

    public Movie(String title, Rating maturityRating) {
        super(title, maturityRating);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void play() {
        System.out.println("Playing" + this);
    }

    @Override
    public void pause() {
        System.out.println("Playing" + this);
    }

    public void setDuration(int duration) {
        this.duration = Math.abs(duration);
    }

    public boolean isLongPlayingTime(){
        return duration >= LONG_PLAYING_TIME;
    }

    public boolean isLongPlayingtime(){
        return duration > LONG_PLAYING_TIME;
    }

    public String getPlayingTime(){
        int duration = getDuration();
        StringBuilder builder = new StringBuilder();
        int amountOfHours = duration / 60;
        duration -=  amountOfHours * 60;
        int amountOfMinutes = duration % 60;

        if(amountOfHours == 0){
            if(amountOfMinutes == 0){
                builder.append("?");
            } else{
                builder.append(amountOfMinutes).append(" min");
            }
        } else{
            if(amountOfMinutes != 0){
                builder.append(amountOfHours).append(" h ").append(amountOfMinutes).append(" min");
            }
             else{
                builder.append(amountOfHours).append(" h");
            }
        }
        return builder.toString();
    }

    public void setGenre(Genre genre){
        this.genre = genre;
    }

    public Genre getGenre(){
        return genre;
    }

    public Rating getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(Rating maturityRating) {
        this.maturityRating = maturityRating;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        if(releaseDate != null){
            builder.append(" (").append(releaseDate.getYear()).append(")");
        }
        return builder.toString();
    }
}
