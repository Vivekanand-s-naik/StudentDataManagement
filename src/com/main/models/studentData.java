package com.main.models;

import java.util.ArrayList;
import java.util.List;

public class studentData {
    private static List<stData> studentData = new ArrayList<>();

    public static List<stData> getStudentData() {
        return studentData;
    }

    public static void setStudentData(List<stData> studentData) {
        studentData = studentData;
    }
}
