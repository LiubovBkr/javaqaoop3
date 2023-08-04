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
    public void testSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testSetValidVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void testSetInvalidVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(150);
        assertEquals(100, radio.getCurrentVolume());
        radio.setCurrentVolume(-10);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testNextStationWhenCurrentStationNot9() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.nextStation();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void testNextStationWhenCurrentStationIs9() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationWhenCurrentStationNot0() {
        Radio radio = new Radio();
        radio.setCurrentStation(7);
        radio.prevStation();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationWhenCurrentStationIs0() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolumeWhenVolumeNotMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void testIncreaseVolumeWhenVolumeIsMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeWhenVolumeNotMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeWhenVolumeIsMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void setCurrentStation_InvalidStationGreaterThan9_SetsStationTo9() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_ValidStation_SetsStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_InvalidStationLessThan0_DoesNotSetStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1); // Try to set station to -1, which is less than 0
        assertEquals(0, radio.getCurrentStation()); // Station should remain 0
    }

    @Test
    public void setCurrentStation_InvalidStationGreaterOrEqualMax_DoesNotSetStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(10); // Try to set station to 10, which is greater than max (9)
        assertEquals(0, radio.getCurrentStation()); // Station should remain 0
    }
}