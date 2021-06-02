
import models.cours.Cours;
import models.cours.CoursController;

public class Main {
    public static void main(String[] args) {

        var coursC= new CoursController();
        var res = coursC.getCours();

        for(Cours cours:res){
            System.out.println(cours.getNOM());
        }

        if(coursC.updateCourseHours("Sgbd' or TRUE", 3)){
            System.out.println("success");
        }else{
            System.out.println("failed");
        }

    }
}