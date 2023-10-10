package com.example.apiloginproject;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {

        @SerializedName("respose")
        private List<ResponseItem> responseList;
        @SerializedName("responseMsg")
        private String responseMessage;

        public List<ResponseItem> getResponseList() {
            return responseList;
        }

        public String getResponseMessage() {
            return responseMessage;
        }

        public static class ResponseItem {
            @SerializedName("layout_no")
            private String layoutNumber;
            @SerializedName("san_scheme")
            private int sanScheme;
            @SerializedName("ben_id")
            private String beneficiaryId;
            @SerializedName("m_uid")
            private String mUid;
            @SerializedName("dist_name")
            private String districtName;
            @SerializedName("mandal_name")
            private String mandalName;
            @SerializedName("caste_name")
            private String casteName;
            @SerializedName("phase_status")
            private String phaseStatus;
            @SerializedName("ben_name")
            private String beneficiaryName;
            @SerializedName("mandal_code")
            private int mandalCode;
            @SerializedName("layout_name")
            private String layoutName;
            @SerializedName("scheme_name")
            private String schemeName;
            @SerializedName("dist_code")
            private int districtCode;

            public void setLayoutNumber(String layoutNumber) {
                this.layoutNumber = layoutNumber;
            }

            public void setSanScheme(int sanScheme) {
                this.sanScheme = sanScheme;
            }

            public void setBeneficiaryId(String beneficiaryId) {
                this.beneficiaryId = beneficiaryId;
            }

            public void setmUid(String mUid) {
                this.mUid = mUid;
            }

            public void setDistrictName(String districtName) {
                this.districtName = districtName;
            }

            public void setMandalName(String mandalName) {
                this.mandalName = mandalName;
            }

            public void setCasteName(String casteName) {
                this.casteName = casteName;
            }

            public void setPhaseStatus(String phaseStatus) {
                this.phaseStatus = phaseStatus;
            }

            public void setBeneficiaryName(String beneficiaryName) {
                this.beneficiaryName = beneficiaryName;
            }

            public void setMandalCode(int mandalCode) {
                this.mandalCode = mandalCode;
            }

            public void setLayoutName(String layoutName) {
                this.layoutName = layoutName;
            }

            public void setSchemeName(String schemeName) {
                this.schemeName = schemeName;
            }

            public void setDistrictCode(int districtCode) {
                this.districtCode = districtCode;
            }
        }
}

