package models.cours;

import java.util.ArrayList;

public class CoursController {

    CoursMySQL repository;

    public CoursController() {
        repository = new CoursMySQL();
    }

    public ArrayList<Cours> getCours() {
        return repository.findAllCourses();
    }

    public boolean updateCourseHours(String courseName, int hours){return repository.updateCourseHoursPrepared(courseName, hours);}

    public void closeDbConnection(){repository.close();}

}
