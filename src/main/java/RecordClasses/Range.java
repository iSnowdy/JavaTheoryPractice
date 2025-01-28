package RecordClasses;

public record Range(int a, int b) {
    public Range {
        if (a > b) {
            throw new IllegalArgumentException("a must be less than b");
        }

    }


}
