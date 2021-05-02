package model;

public enum Status {
SMALL(0,9),MEDIUM(10,19),LARGE(19,2147483647);
int min;
int max;

    private Status(int min, int max){
        this.min = min;
        this.max = max;
    }

    public static Status findByDbCode(int lenth) throws IllegalStateException {
        Status[] statuses = values();
        for (Status status : statuses) {
            if ( lenth>=status.min &&  lenth<= status.max ) {
                return status;
            }
        }
        throw new IllegalStateException(lenth + " out of range");
    }

}
