public enum Localization {
    MONDAY("Lunes");

    private String spanish;
    private Localization(String s) {
        spanish = s;
    }

    private String getSpanish() {
        return spanish;
    }
}
