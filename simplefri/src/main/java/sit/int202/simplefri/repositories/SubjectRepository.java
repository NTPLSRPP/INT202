package sit.int202.simplefri.repositories;

import sit.int202.simplefri.entities.Subject;

import java.util.*;

public class SubjectRepository {
    private static List<Subject> subjects;

    public List<Subject> findAll() {
        return subjects;
    }

    public SubjectRepository() {
        initialize();
    }

    private void initialize() {
        subjects = new ArrayList<Subject>();
        subjects.add(new Subject("INT100", "IT Fundamentals", 3));
        subjects.add(new Subject("INT101", "Programming I", 3));
        subjects.add(new Subject("INT103", "Programming II", 3));
        subjects.add(new Subject("INT201", "Frontend Dev I", 3));
        subjects.add(new Subject("INT202", "Backend Dev I", 3));
        subjects.add(new Subject("INT207","Network I",3));
    }
}
