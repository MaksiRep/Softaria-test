package ru.maksirep.softaria;

public class Main {

    public static void main(String[] args) {
        Report report = new Report();
        report.generateReport(TestValues.FIRST_DAY_MAP, TestValues.SECOND_DAY_MAP);
        report.generateReport(TestValues.SECOND_DAY_MAP, TestValues.THIRD_DAY_MAP);
        report.generateReport(TestValues.THIRD_DAY_MAP, TestValues.FOURTH_DAY_MAP);
        report.generateReport(TestValues.FOURTH_DAY_MAP, TestValues.EMPTY_MAP);
    }
}