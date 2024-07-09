package model;

public class Email {
    private String value;

    public Email(String value) {
        if (!isValidEmail(value)) {
            throw new IllegalArgumentException("Email no válido");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.endsWith(".com");
    }

    @Override
    public String toString() {
        return value;
    }
}
