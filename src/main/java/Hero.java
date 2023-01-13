public class Hero {
    private String superHeroName;
    private String fullName;
    private int gender;
    private int race;
    private String team;

    public Hero(String superHeroName, String fullName, int gender, int race, String team) {
        this.superHeroName = superHeroName;
        this.fullName = fullName;
        this.gender = gender;
        this.race = race;
        this.team = team;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getGender() {
        return gender;
    }

    public int getRace() {
        return race;
    }

    public String getTeam() {
        return team;
    }
}
