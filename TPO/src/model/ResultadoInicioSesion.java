package model;

public enum ResultadoInicioSesion {
    SUCCESS, // Usuario y contraseña coinciden
    INVALID_PASSWORD, // El nombre de usuario coincide pero la contraseña no
    USER_NOT_FOUND // No se encuentra el nombre de usuario
}
