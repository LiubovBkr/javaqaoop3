package ru.netology.services;
public class Radio {
    private int currentStation;
    private int currentVolume;
    private int maxStation;

    public Radio() {
        this(10);
    }

    public Radio(int maxStation) {
        this.maxStation = maxStation;
        currentStation = 0;
        currentVolume = 0;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int station) {
        if (station >= 0 && station < maxStation) {
            currentStation = station;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            currentVolume = volume;
        } else if (volume < 0) {
            currentVolume = 0;
        } else {
            currentVolume = 100;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public void nextStation() {
        currentStation = (currentStation + 1) % maxStation;
    }

    public void prevStation() {
        currentStation = (currentStation - 1 + maxStation) % maxStation;
    }
}