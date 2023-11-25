package ua.com.poseal.jwt.backend.dtos;

import java.util.Arrays;
import java.util.Objects;

public record SignUpDto(String firstName, String lastName, String login, char[] password) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SignUpDto signUpDto = (SignUpDto) o;

        if (!Objects.equals(firstName, signUpDto.firstName)) return false;
        if (!Objects.equals(lastName, signUpDto.lastName)) return false;
        if (!Objects.equals(login, signUpDto.login)) return false;
        return Arrays.equals(password, signUpDto.password);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @Override
    public String toString() {
        return "SignUpDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password=***}";
    }
}
