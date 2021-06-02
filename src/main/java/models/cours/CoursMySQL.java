package models.cours;

import database.MySqlConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class CoursMySQL {

    private MySqlConnection sqlCon;

    public CoursMySQL() {
        if(sqlCon == null){
            System.out.println("set new con");
            this.sqlCon = new MySqlConnection(
                    "jdbc:mysql://192.168.1.80:3306/ecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "distantAdmin",
                    "olivier");
        }
    }

    public ArrayList<Cours> findAllCourses(){
        ArrayList<Cours> cours = new ArrayList();

        var resultSetOptional = sqlCon.ExecuteReq("Select * from COURS");
        if(resultSetOptional.isPresent()){
            var res = resultSetOptional.get();
            try{
                while (res.next())
                {
                    cours.add(new Cours(res.getInt("NUM_COURS"),
                            res.getString("NOM"),
                            res.getString("NBHEURES"),
                            res.getString("ANNEE")));
                }

            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            System.out.println("Empty");
        }
        return cours;
    }

    public boolean updateCourseHours(String courseName, int hours){
        String req = "update COURS set NBHEURES = NBHEURES + " + hours + " where NOM = '" + courseName + "'";

        int lines = sqlCon.ExecuteReqDataManip(req);

        return lines > 0;
    }

    public boolean updateCourseHoursPrepared(String courseName, int hours){
        Connection con = sqlCon.getCon();
        String preparedReq = "update COURS set NBHEURES = NBHEURES + ? where NOM = ?";

        try{
            PreparedStatement preparedStmt = con.prepareStatement(preparedReq);
            preparedStmt.setInt(1, hours);
            preparedStmt.setString(2, courseName);

            int lines = sqlCon.ExecutePreparedReqDataManip(preparedStmt);

            return lines > 0;

        }catch (Exception e){
            System.out.println(e);
            return false;
        }


    }

    public void close(){
        sqlCon.closeConnection();
    }
}