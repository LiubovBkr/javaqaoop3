import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void setCurrentStationTo0() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStationTo1() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        assertEquals(1, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStationTo8() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        assertEquals(8, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStationTo9() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_ValidStation5() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_ToLessThan0() {
        Radio radio = new Radio();
        radio.setCurrentStation(-5);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_MoreThan9() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testNextStationWithinRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.next();
        assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void testNextStationAtMaxRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationAtMaxLimit() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.prev();
        assertEquals(8, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationAtMaxRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationWithinRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void setVolume_ValidVolume_SetsVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void setVolume_InvalidVolume_DoesNotSetVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(150);
        assertEquals(0, radio.getCurrentVolume());
        radio.setVolume(-10);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void increaseVolume_VolumeNotMax_IncreasesVolumeBy1() {
        Radio radio = new Radio();
        radio.setVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void increaseVolume_VolumeIsMax_DoesNotIncreaseVolume() {
        Radio radio = new Radio();
        radio.setVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolume_VolumeNotMin_DecreasesVolumeBy1() {
        Radio radio = new Radio();
        radio.setVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void decreaseVolume_VolumeIsMin_DoesNotDecreaseVolume() {
        Radio radio = new Radio();
        radio.setVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void setCurrentStation_LessThan0_DoNotSetStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(-5);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_Between0And9_SetStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        assertEquals(3, radio.getCurrentStation());
    }

    @Test
    public void setCurrentStation_MoreThan9_SetToMax() {
        Radio radio = new Radio();
        radio.setCurrentStation(10);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void setVolume_LessThan0_DoesNotSetVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-10);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void setVolume_MoreThan100_DoesNotSetVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(150);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void setVolume_InvalidVolume_LessThan0_DoesNotSetVolume() {
        Radio radio = new Radio();
        radio.setVolume(-10);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void setVolume_InvalidVolume_MoreThan100_DoesNotSetVolume() {
        Radio radio = new Radio();
        radio.setVolume(150);
        assertEquals(0, radio.getCurrentVolume());
    }

    // Additional test cases for setVolume method
    @Test
    public void setVolume_AtLowerBound_SetsVolume() {
        Radio radio = new Radio();
        radio.setVolume(0);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void setVolume_AtUpperBound_SetsVolume() {
        Radio radio = new Radio();
        radio.setVolume(100);
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void setVolume_JustBelowLowerBound_DoesNotSetVolume() {
        Radio radio = new Radio();
        radio.setVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void setVolume_JustAboveUpperBound_DoesNotSetVolume() {
        Radio radio = new Radio();
        radio.setVolume(101);
        assertEquals(0, radio.getCurrentVolume());
    }


    @Test
    public void setCurrentStationSetToMax() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(20);
        int expected = 19;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setCurrentStationSetToMin() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(0);
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setCurrentStationSetToBelowMin() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(-1);
        int expected = 0;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setCurrentStationSetToAboveMax() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(21);
        int expected = 19;
        int actual = radio.getCurrentStation();
        Assertions.assertEquals(expected, actual);
    }

}