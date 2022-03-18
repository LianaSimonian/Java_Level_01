package week10.enums.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PhoneModelTest {
    @Test
    public void testNokia1100CameraDescriptionList() {
        Assertions.assertEquals(List.of(), PhoneModel.NOKIA_1100.cameraDescriptionList());
    }

    @Test
    public void testNokia3110CameraDescriptionList() {
        Assertions.assertEquals(List.of("back camera"), PhoneModel.NOKIA_3110.cameraDescriptionList());
    }

    @Test
    public void testGalaxyS2CameraDescriptionList() {
        Assertions.assertEquals(List.of("back camera", "front camera"), PhoneModel.GALAXY_S2.cameraDescriptionList());
    }
}