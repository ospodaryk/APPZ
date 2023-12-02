package com.project.appz.dto;

import com.project.appz.entities.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class UserResponse {
    private String name;
    private List<Integer> myMarks = new ArrayList<>();

    public UserResponse(User user) {
        this();
        this.name = user.getName();
    }

    public UserResponse() {
        this.myMarks.addAll(Arrays.asList(0, 0, 0, 0, 0));

    }

    public void clean() {
        this.myMarks.clear();
        this.myMarks.addAll(Arrays.asList(0, 0, 0, 0, 0));
    }

    public void copyUser(User user) {
        this.name = user.getName();
    }

    public Integer sum() {
        int score = 0;
        for (int i = 0; i < this.myMarks.size(); i++) {
            score += this.myMarks.get(i);
        }
        return score;
    }

}
