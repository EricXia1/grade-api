package use_case;
import api.GradeDB;
import api.MongoGradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        long gradesum = 0;
        String[] students = gradeDB.getMyTeam().getMembers();
        int enrolled = students.length;
        for (int i = 0; i < enrolled; i++) {
            String student = students[i];
            int studentGrade = gradeDB.getGrade(student, course).getGrade();
            gradesum += studentGrade;
        }
        return (float) gradesum / enrolled;
    }
}
