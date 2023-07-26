import org.junit.jupiter.api.Test;
import ru.netology.services.Radio;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void setCurrentStation_ValidStation_SetsCurrentStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_InvalidStationLessThan0_SetsStationTo0() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_InvalidStationGreaterThan9_SetsStationTo9() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void setVolume_ValidVolume_SetsVolume() {
        Radio radio = new Radio();
        radio.setVolume(50);
        assertEquals(50, radio.getVolume());
    }

    @Test
    public void setVolume_InvalidVolume_DoesNotSetVolume() {
        Radio radio = new Radio();
        radio.setVolume(150);
        assertEquals(0, radio.getVolume());
        radio.setVolume(-10);
        assertEquals(0, radio.getVolume());
    }

    @Test
    public void next_CurrentStationNot9_SetsNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.next();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void next_CurrentStationIs9_SetsStationTo0() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void prev_CurrentStationNot0_SetsPreviousStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(7);
        radio.prev();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void prev_CurrentStationIs0_SetsStationTo9() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void increaseVolume_VolumeNotMax_IncreasesVolumeBy1() {
        Radio radio = new Radio();
        radio.setVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getVolume());
    }

    @Test
    public void increaseVolume_VolumeIsMax_DoesNotIncreaseVolume() {
        Radio radio = new Radio();
        radio.setVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getVolume());
    }

    @Test
    public void decreaseVolume_VolumeNotMin_DecreasesVolumeBy1() {
        Radio radio = new Radio();
        radio.setVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getVolume());
    }

    @Test
    public void decreaseVolume_VolumeIsMin_DoesNotDecreaseVolume() {
        Radio radio = new Radio();
        radio.setVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getVolume());
    }
}