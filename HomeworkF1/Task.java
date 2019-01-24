/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskcalendar;

/**
 *
 * @author Student
 */
public class Task {

    //int startDay;//0:sunday 1:mon ...,6:dat
    private int startDate;
    private String startMonth;//3-char months: jan, Feb
    private int startYear;
    private int startHour;
    //int startMinute;

    private int endDate;
    private String endMonth;//3-char months: jan, Feb
    private int endYear;
    private int endHour;
    //int endMinute;
    private String title;
    private String detail;
    //task size is 4+3+4+4+4+3+4+4+40+100=170
    static final int TITLE_SIZE=40;
    static final int DETAIL_SIZE=100;

    public Task(int startDate, String startMonth, int startYear, int startHour, int endDate, String endMonth, int endYear, int endHour, String title, String detail) {
        this.startDate = startDate;
        this.startMonth = monthValidate(startMonth);
        this.startYear = startYear;
        this.startHour = startHour;
        this.endDate = endDate;
        this.endMonth = monthValidate(endMonth);
        this.endYear = endYear;
        this.endHour = endHour;
        this.title = title;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public int getStartDate() {
        return startDate;
    }
    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }
    public String getStartMonth() {
        return startMonth;
    }
    public void setStartMonth(String startMonth) {
        this.startMonth = monthValidate(startMonth);
    }
    public int getStartYear() {
        return startYear;
    }
    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    public int getStartHour() {
        return startHour;
    }
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }
    public int getEndDate() {
        return endDate;
    }
    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
    public String getEndMonth() {
        return endMonth;
    }
    public void setEndMonth(String endMonth) {
        this.endMonth = monthValidate(endMonth);
    }
    public int getEndYear() {
        return endYear;
    }
    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    public int getEndHour() {
        return endHour;
    }
    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String monthValidate(String m) {
        String[] months = {"jan", "feb", "mar", "apr", "may", "jun",
            "jul", "aug", "sep", "oct", "nov", "dec"};
        for(String s: months){
            if(m.equalsIgnoreCase(s)){
                return m;
            }
        }
        System.out.println("This is not a valid month. We set to Jan.");
        return "Jan";
    }

    @Override
    public String toString() {
        return "Task{" + "Start " + startDate + "/" + startMonth + "/" + startYear + " at " + startHour + ", End " + endDate + "/" + endMonth + "/" + endYear + " at " + endHour + ", title=" + title + ", detail=" + detail + '}';
    }
    
}
