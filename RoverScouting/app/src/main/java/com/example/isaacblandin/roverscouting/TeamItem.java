package com.example.isaacblandin.roverscouting;

/**
 * Created by isaac.blandin on 5/30/19.
 */

import java.io.Serializable;

/**
 * An Object Representing the Scouting Stats of a Team
 */
public class TeamItem implements Serializable {
    public final String id;
    public final String content;

    private boolean lands;
    private boolean samples;
    private boolean claims;
    private boolean parks;

    private int landerMinerals;

    private boolean endPark;
    private boolean latch;

    private int scoutAuto;
    private int scoutTele;
    private int scoutEnd;
    private int scoutTotal;

    public TeamItem(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public void setLands(boolean lands){
        this.lands = lands;
    }

    public void setSamples(boolean samples){
        this.samples = samples;
    }

    public void setClaims(boolean claims) {
        this.claims = claims;
    }

    public void setParks(boolean parks) {
        this.parks = parks;
    }

    public void setLanderMinerals(int landerMinerals) {
        this.landerMinerals = landerMinerals;
    }

    public void setEndPark(boolean endPark) {
        this.endPark = endPark;
    }

    public void setLatch(boolean latch) {
        this.latch = latch;
    }

    public void setScoutAuto(int scoutAuto) {
        this.scoutAuto = scoutAuto;
    }

    public void setScoutTele(int scoutTele) {
        this.scoutTele = scoutTele;
    }

    public void setScoutEnd(int scoutEnd) {
        this.scoutEnd = scoutEnd;
    }

    public void setScoutTotal(int scoutTotal) {
        this.scoutTotal = scoutTotal;
    }

    public int getScoutTotal(){return scoutTotal;}

    public int getScoutAuto() {
        return scoutAuto;
    }

    public int getScoutTele() {
        return scoutTele;
    }

    public int getScoutEnd() {
        return scoutEnd;
    }

    public int getLanderMinerals(){
        return landerMinerals;
    }

    public String getId(){
        return id;
    }

    public String getContent(){
        return content;
    }

    public boolean isLands(){
        return lands;
    }

    public boolean isSamples() {
        return samples;
    }

    public boolean isClaims() {
        return claims;
    }

    public boolean isParks() {
        return parks;
    }

    public boolean isEndPark() {
        return endPark;
    }

    public boolean isLatch() {
        return latch;
    }

    @Override
    public String toString() {
        return content;
    }
}
