package week10.enums.list;

import java.util.List;

public enum PhoneModel {
    NOKIA_1100(List.of()),
    NOKIA_3110(List.of("back camera")),
    GALAXY_S2(List.of("back camera", "front camera"));

    private List<String> descriptionOfCamera;

    PhoneModel(List<String> descriptionOfCamera) {
        this.descriptionOfCamera = descriptionOfCamera;
    }

    public List<String> cameraDescriptionList() {
        return descriptionOfCamera;
    }
}
