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


}
