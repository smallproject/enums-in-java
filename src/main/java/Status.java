public enum Status {
    NEW,
    IN_PROGRESS,
    COMPLETED,
    ON_HOLD,
    CANCELED;

    public Status next() {
        switch (this) {
            case NEW:
                return IN_PROGRESS;
            case IN_PROGRESS:
            case COMPLETED:
                return COMPLETED;
            case ON_HOLD:
            case CANCELED:
                return CANCELED;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public Status tryPutOnHold() {
        if (this.equals(Status.IN_PROGRESS)) {
            return ON_HOLD;
        }
        return this;
    }

    public Status tryReActivate() {
        if (this.equals(Status.ON_HOLD)) {
            return IN_PROGRESS;
        }
        return this;
    }
}
