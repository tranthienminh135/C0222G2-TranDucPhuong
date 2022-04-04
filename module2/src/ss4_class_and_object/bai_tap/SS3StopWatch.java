package ss4_class_and_object.bai_tap;

public class SS3StopWatch {
    private long startTime;
    private long endTime;

    public SS3StopWatch() {
    }

    public SS3StopWatch(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }
    public void end() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

    public static void main(String[] args) {
        int a;
        SS3StopWatch st = new SS3StopWatch();
        st.setStartTime(System.currentTimeMillis());
        long start = st.getStartTime();
        System.out.println(start);
        for (int i = 0; i < 1000000000; i++) {
            a = 1 + 1;
            a = 1 + 2;
            a = 0;
        }
        st.setEndTime(System.currentTimeMillis());
        long end = st.getEndTime();
        System.out.println(end);
        System.out.println("Elapsed time: " + st.getElapsedTime());
        st.start();
        st.end();
    }
}
