package collegeproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Allcomponents {

    public Allcomponents() {
    }

    public List<Branch> getAllBranches() {
        List<Branch> list = new ArrayList<Branch>();
        ResultSet rs = DB.getTableResultSet("branch");
        try {
            while (rs.next()) {
                Branch branch = new Branch(rs.getLong("idbranch"), rs.getString("name"), rs.getString("details"));
                System.out.println(branch);
                list.add(branch);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<Course>();
        ResultSet rs = DB.getTableResultSet("course");
        try {
            while (rs.next()) {
                Course course = new Course(rs.getString("name"), rs.getString("details"));
                System.out.println(course);
                list.add(course);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Results> getAllTests() {
        List<Results> list = new ArrayList<Results>();
        ResultSet rs = DB.getTableResultSet("test");
        try {
            while (rs.next()) {
                Results test = new Results(rs.getLong("testid"), rs.getString("name"), rs.getInt("isExam") == 1, rs.getInt("isAssignment") == 1, rs.getString("testdetails"), rs.getInt("maxmarkalloted"));
                System.out.println(test);
                list.add(test);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean createTest(String testName, boolean assignment, boolean exam, String description, int maxMarksAlloted) {
        return DB.createTest(testName, assignment, exam, description, maxMarksAlloted);
    }

    public boolean createBranch(String branchName, String description) {
        return DB.createBranch(branchName, description);
    }

    public boolean createStudentResult(Long testId, Long studentid, int marks) {
        return DB.createStudentResult(testId, studentid, marks);
    }

    public boolean createFee(String feePurpose, Long studentId, int amount, String paidDate) {
        return DB.createFee(feePurpose, studentId, amount, paidDate);
    }

    public void addSuperAdmin(String firstName, String lastName, String password) {
        DB.registerSuperAdmin(firstName, lastName, password);
    }

    public void addFacultY(String firstName, String lastName, String password) {
        DB.registerFaculty(firstName, lastName, password);
    }

    public void addStudent(String firstName, String lastName, String password) {
        DB.registerStudent(firstName, lastName, password);
    }

    public UserF getUser(String username, String password) {
        if (DB.getAvailableRows("superadmin", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DB.getTableResultSet("superadmin", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new UserF(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), true, false, false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (DB.getAvailableRows("faculty", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DB.getTableResultSet("faculty", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new UserF(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), false, true, false);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (DB.getAvailableRows("student", "username = '" + username + "' and password = '" + password + "'") == 1) {
            ResultSet rs = DB.getTableResultSet("student", "username = '" + username + "' and password = '" + password + "'");
            try {
                while (rs.next()) {
                    try {
                        return new UserF(rs.getLong("id"), rs.getString("firstname"), rs.getString("lastname"), false, false, true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
