package com.example.apiloginproject;

public class DataRequest {

        private String report_type;
        private String dist_code;
        private String mandal_code;
        private String layout_no;
        private String sec_code;


    public DataRequest(String report_type, String dist_code, String mandal_code, String layout_no, String sec_code) {
        this.report_type = report_type;
        this.dist_code = dist_code;
        this.mandal_code = mandal_code;
        this.layout_no = layout_no;
        this.sec_code = sec_code;
    }

    public String getReport_type() {
        return report_type;
    }

    public void setReport_type(String report_type) {
        this.report_type = report_type;
    }

    public String getDist_code() {
        return dist_code;
    }

    public void setDist_code(String dist_code) {
        this.dist_code = dist_code;
    }

    public String getMandal_code() {
        return mandal_code;
    }

    public void setMandal_code(String mandal_code) {
        this.mandal_code = mandal_code;
    }

    public String getLayout_no() {
        return layout_no;
    }

    public void setLayout_no(String layout_no) {
        this.layout_no = layout_no;
    }

    public String getSec_code() {
        return sec_code;
    }

    public void setSec_code(String sec_code) {
        this.sec_code = sec_code;
    }
}
