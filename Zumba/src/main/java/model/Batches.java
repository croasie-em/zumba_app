package model;

import java.time.LocalDate;

public class Batches {
    private int batchID;
    private String name;
    private String day;
    private String timeOfDay;
    private int maxSize;
    private LocalDate startDate;
    private LocalDate endDate;

    public Batches() {}

    public Batches(int batchID, String name, String day, String timeOfDay, int maxSize, LocalDate startDate, LocalDate endDate) {
        this.batchID = batchID;
        this.name = name;
        this.day = day;
        this.timeOfDay = timeOfDay;
        this.maxSize = maxSize;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getBatchID() {
        return batchID;
    }

    public void setBatchID(int batchID) {
        this.batchID = batchID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Batches{" +
                "batchID=" + batchID +
                ", name='" + name + '\'' +
                ", day='" + day + '\'' +
                ", timeOfDay='" + timeOfDay + '\'' +
                ", maxSize=" + maxSize +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

