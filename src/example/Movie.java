package example;

import java.io.Serializable;

public class Movie implements Serializable {
    public double lengthInHours;
    public String name;
    public String director;
    public int scoreOfFive;
    public boolean isInTheaters;
    public transient Song[] songs;
}
