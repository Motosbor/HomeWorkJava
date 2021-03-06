package Collections.Statistic;

public class Team implements Comparable<Team> {

    private String name;
    private String country;
    private int seazon;
    private int scores;

    public Team(String name, String country, int seazon, int skores) {
        this.name = name;
        this.country = country;
        this.seazon = seazon;
        this.scores = skores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSeazon() {
        return seazon;
    }

    public void setSeazon(int seazon) {
        this.seazon = seazon;
    }

    public int getScores() {
        return scores;
    }

    public void setSkores(int skores) {
        this.scores = skores;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return name == ((Team) obj).name &&
                country == ((Team) obj).country &&
                  seazon == ((Team) obj).seazon;
    }

    @Override
    public int compareTo(Team o) {
        int x = this.name.compareTo(o.name);
        return x;
    }
}
