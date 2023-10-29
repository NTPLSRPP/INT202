package sit.int202.registerfri.models;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewSupport {
    public static Map<String, Boolean> getExistSubject(int semester, HttpSession session) {
        Map<String, Boolean> existSubjects = new HashMap<>();
        if (session != null && session.getAttribute("courseRegistered") != null) {
            List<Subject> subjects = ((CourseRegistered) session.getAttribute("courseRegistered")).getRegisteredCourse(semester);
            if (subjects != null) {
                for (Subject subject : subjects) {
                    existSubjects.put(subject.getSubjectId(), true);
                }
            }
        }
        return existSubjects;
    }
}
