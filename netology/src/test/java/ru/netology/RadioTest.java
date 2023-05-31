package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    Radio radio;

    @BeforeEach
    void init() {
        radio = new Radio();
    }

    @Test
    void setCurrentRadioStation_correctCurrentRadioStation_newNumberRadioStationBetweenMinAndMax() {
        int numberRadioStation = 7;

        radio.setCurrentRadioStation(numberRadioStation);

        int expected = 7;
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @Test
    void setCurrentRadioStation_correctCurrentRadioStation_newNumberRadioStationLessMin() {
        int numberRadioStation = -1;

        radio.setCurrentRadioStation(numberRadioStation);

        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @Test
    void setCurrentRadioStation_correctCurrentRadioStation_newNumberRadioStationMoreMax() {
        int numberRadioStation = 12;

        radio.setCurrentRadioStation(numberRadioStation);

        int actual = radio.getCurrentRadioStation();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void getCurrentRadioStation() {
        int expected = 0;
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @Test
    void getCurrentVolume() {
        int expected = 0;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void increaseVolume_correctCurrentVolumeAfterIncrease_currentVolumeLessMax() {
        radio.increaseVolume();

        int expected = 1;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void increaseVolume_correctCurrentVolumeAfterIncrease_currentVolumeMoreMax() {
        radio.setCurrentVolume(radio.maxVolume);

        radio.increaseVolume();

        int expected = radio.maxVolume;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void decreaseVolume_correctCurrentVolumeAfterDecrease_currentVolumeMoreMin() {
        radio.setCurrentVolume(radio.maxVolume);
        radio.decreaseVolume();

        int expected = 99;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void decreaseVolume_correctCurrentVolumeAfterDecrease_currentVolumeLessMin() {
        radio.decreaseVolume();

        int expected = radio.minVolume;
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void increaseRadioStation_currentRadioStationEqualsMinRadioStations_currentStationEqualsMax() {
        radio.setCurrentRadioStation(radio.maxRadioStations);

        radio.increaseRadioStation();

        int expected = radio.minRadioStations;
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @Test
    void increaseRadioStation_correctCurrentRadioStation_currentStationLessMax() {
        radio.setCurrentRadioStation(5);

        radio.increaseRadioStation();

        int expected = 6;
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @Test
    void decreaseRadioStation_currentRadioStationEqualsMaxRadioStations_currentStationEqualsMin() {
        radio.setCurrentRadioStation(radio.minRadioStations);

        radio.decreaseRadioStation();

        int expected = radio.maxRadioStations;
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @Test
    void decreaseRadioStation_correctCurrentRadioStation_currentStationMoreMin() {
        radio.setCurrentRadioStation(5);

        radio.decreaseRadioStation();

        int expected = 4;
        int actual = radio.getCurrentRadioStation();

        assertEquals(expected, actual);
    }

    @Test
    void createRadio_currentMaxRadioStations_createWithCountRadioStations() {
        Radio test = new Radio(15);

        int expected = 14;
        int actual = test.maxRadioStations;

        assertEquals(expected, actual);
    }
}
