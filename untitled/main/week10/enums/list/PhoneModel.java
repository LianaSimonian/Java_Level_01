package week10.enums.list;

import java.util.List;

public enum PhoneModel {
    NOKIA_1100 {
        @Override
        public List<String> cameraDescriptionList() {
            return emptyList;
        }
    },
    NOKIA_3110 {
        @Override
        public List<String> cameraDescriptionList() {
            return listOf1items;
        }
    },
    GALAXY_S2 {
        @Override
        public List<String> cameraDescriptionList() {
            return listOf2items;
        }
    };
    private static final List<String> listOf2items = List.of("back camera", "front camera");
    private static final List<String> listOf1items = List.of("back camera");
    private static final List<String> emptyList = List.of();

    public abstract List<String> cameraDescriptionList();
}
