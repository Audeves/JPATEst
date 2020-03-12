/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lv1013
 */
@Entity
@Table(name = "videogame")
public class Videogame extends EntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int rating;

    @OneToMany(mappedBy = "videogame", cascade = CascadeType.PERSIST)
    private Collection<Achievement> achievements;

    @ManyToMany(mappedBy = "videogames")
    private Collection<Player> players;

    public Collection<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Player> players) {
        this.players = players;
    }

    public Videogame() {
        this.achievements = new HashSet();
        this.players = new HashSet();
    }

    public void addAchievement(Achievement a) {
        a.setVideogame(this);
        this.achievements.add(a);
    }

    public Collection<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Collection<Achievement> achievements) {
        this.achievements = achievements;
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
