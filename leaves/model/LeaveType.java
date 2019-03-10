package com.slmanju.hrms.leaves.model;

public enum LeaveType {

    ANNUAL, CASUAL, MEDICAL, LIEUVE, NO_PAY;

    public static int getDefaultDays(LeaveType leaveType) {
        switch (leaveType) {
            case ANNUAL:
                return 14;
            case CASUAL:
                return 7;
            case MEDICAL:
                return 7;
        }
        return -1;
    }

}
