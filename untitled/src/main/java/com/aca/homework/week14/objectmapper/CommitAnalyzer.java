package com.aca.homework.week14.objectmapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class CommitAnalyzer {

    private final String file;

    public CommitAnalyzer(String file) {
        this.file = file;
    }

    public int count() {
        int count = 0;
        List<WeekCommitData> commitList = getListFromFile();
        for (WeekCommitData weekCommitData : commitList) {
            count += weekCommitData.getTotal();
        }

        return count;
    }

    private List<WeekCommitData> getListFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<WeekCommitData> commitList = null;
        try {
            commitList = objectMapper.readValue(new File(file), new TypeReference<List<WeekCommitData>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return commitList == null ? Collections.emptyList() : commitList;
    }
}