package org.gfg;

public class EnumDemo {

    public static void main(String[] args) {

        Lecture l0 = new Lecture("L00",LectureStatus.ARCHIVED);
        Lecture l1 = new Lecture("L01",LectureStatus.ARCHIVED);
        Lecture l2 = new Lecture("L02",LectureStatus.LIVE);
        Lecture l3 = new Lecture("L03",LectureStatus.UPCOMING);

        DayOfWeek dayOfWeek = DayOfWeek.SUNDAY;
        System.out.println(dayOfWeek.value);

        //Admin admin = new Admin();

        Admin admin = Admin.ADMIN;
        System.out.println(admin.getName());
    }
}
