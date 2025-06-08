package org.gfg;

public class Lecture {

    private String title;
    private LectureStatus status;

    public Lecture(String title, LectureStatus status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LectureStatus getStatus() {
        return status;
    }

    public void setStatus(LectureStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
