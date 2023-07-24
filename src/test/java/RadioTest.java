import ru.netology.services.Radio;
import org.junit.jupiter.api.Test;
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
    public void setCurrentStation_InvalidStationGreaterThanMax_SetsStationToMax() {
        int maxStation = 30;
        Radio radio = new Radio(maxStation);
        radio.setCurrentStation(maxStation + 1);
        assertEquals(maxStation - 1, radio.getCurrentStation());
    }

    @Test
    public void nextStation_StationIsMax_SetsToMin() {
        int maxStation = 30;
        Radio radio = new Radio(maxStation);
        radio.setCurrentStation(maxStation - 1);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void prevStation_StationIsMin_SetsToMax() {
        int maxStation = 30;
        Radio radio = new Radio(maxStation);
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(maxStation - 1, radio.getCurrentStation());
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


    @Test
    public void setCurrentStation_InvalidStationGreaterThanNumberOfStations_SetsStationToMax() {
        int maxStation = 30; // Задайте здесь максимальное количество станций, например, 30
        Radio radio = new Radio(maxStation);
        radio.setCurrentStation(maxStation + 10);
        assertEquals(maxStation - 1, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_ValidStationWithinRange_SetsCurrentStation() {
        int maxStation = 30; // Задайте здесь максимальное количество станций, например, 30
        Radio radio = new Radio(maxStation);
        radio.setCurrentStation(15);
        assertEquals(15, radio.getCurrentStation());
    }
}
