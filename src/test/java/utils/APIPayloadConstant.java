package utils;

import org.json.JSONObject;

public class APIPayloadConstant {

    public static String jsonPayloadGenerateJWT() {
//        return "{\n" +
//                "  \"email\": \"miloud321@test.com\",\n" +
//                "  \"password\": \"Test@12345\"\n" +
//                "}";
        JSONObject obj = new JSONObject();
        obj.put("email", "miloud321@test.com");
        obj.put("password", "Test@12345");
        return obj.toString();
    }

    public static String jsonPayloadMoreDynamic(String employeeId, String emp_firstname, String emp_lastname, String emp_middle_name, String emp_gender,
            String emp_birthday, String emp_status, String emp_job_title){

        JSONObject obj = new JSONObject();

        if (employeeId != null && !employeeId.isEmpty()) {
            obj.put("employee_id", employeeId);
        }

        if (emp_firstname != null && !emp_firstname.isEmpty()) {
            obj.put("emp_firstname", emp_firstname);
        }

        if (emp_lastname != null && !emp_lastname.isEmpty()) {
            obj.put("emp_lastname", emp_lastname);
        }

        if (emp_middle_name != null && !emp_middle_name.isEmpty()) {
            obj.put("emp_middle_name", emp_middle_name);
        }

        if (emp_gender != null && !emp_gender.isEmpty()) {
            obj.put("emp_gender", emp_gender);
        }

        if (emp_birthday != null && !emp_birthday.isEmpty()) {
            obj.put("emp_birthday", emp_birthday);
        }

        if (emp_status != null && !emp_status.isEmpty()) {
            obj.put("emp_status", emp_status);
        }

        if (emp_job_title != null && !emp_job_title.isEmpty()) {
            obj.put("emp_job_title", emp_job_title);
        }

        return obj.toString();
    }



}
