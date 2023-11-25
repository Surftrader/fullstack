package ua.com.poseal.jwt.backend.dtos;

import java.util.Arrays;
import java.util.Objects;

public record CredentialDto(String login, char[] password) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CredentialDto that = (CredentialDto) o;

        if (!Objects.equals(login, that.login)) return false;
        return Arrays.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(password);
        return result;
    }

    @Override
    public String toString() {
        return "CredentialDto{" +
                "login='" + login + '\'' +
                ", password=***}";
    }
}
