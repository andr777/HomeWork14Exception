import myException.WrongLoginException;
import myException.WrongPasswordException;

public class Main {
    public static void main(String[] args) throws WrongLoginException {
        System.out.println("Hello world!");


            boolean a = verifyLPP("1230000", "*D_1hWiKjjP_9", "D_1hWiKjjP_9");



        boolean b = verifyLPP("1234567890123456789", "qwe", "ads");

    }

    public static boolean verifyLPP(String login, String password, String confirmPassword) throws WrongLoginException {
        System.out.println("\n Login,pass,2pass");

        if (login.length() > 20) {
            throw new WrongLoginException("WrongLoginExceptionLogin логин больше 20 символов");
        }

        if (!password.matches("[a-z_A-Z0-9]+")) {
            throw new WrongLoginException(" пароль должен содержать символы a-z A-Z 0-9 _");
        }

        if (password.length() > 20) {
            try {
                throw new WrongPasswordException(" пароль больше 20 символов");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        }

        if (!password.equals(confirmPassword)) {
            try {
                throw new WrongPasswordException(" пароль1 не равен пароль2");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("login= " + login);
        System.out.println("password1= " + password);
        System.out.println("password2= " + confirmPassword);
        return true;

    }


}