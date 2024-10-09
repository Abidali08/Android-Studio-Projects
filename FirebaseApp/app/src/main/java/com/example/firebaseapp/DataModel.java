package com.example.firebaseapp;

public class DataModel {
    private String id;
    private String name;  // Example field

    public DataModel() {
        // Default constructor required for calls to DataSnapshot.getValue(DataModel.class)
    }

    public DataModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
