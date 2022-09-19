import myException.WrongLoginException;
import myException.WrongPasswordException;

public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        System.out.println("Hello world!");

        String login = "1230000";
        String password = "gggD_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";


        try {
            boolean a = verifyLPP(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            throw new RuntimeException(e);
        } catch (WrongPasswordException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Проверка завершена");
        }

        System.out.println("login= " + login);
        System.out.println("password1= " + password);
        System.out.println("password2= " + confirmPassword);

    }

    public static boolean verifyLPP(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        System.out.println("\n Login,pass,2pass");

        if (login.length() > 20) {
            throw new WrongLoginException("WrongLoginExceptionLogin логин больше 20 символов");
        }

        if (!password.matches("[a-z_A-Z0-9]+")) {
            throw new WrongPasswordException("пароль должен содержать символы a-z A-Z 0-9 _");
        }

        if (password.length() > 20) {
            throw new WrongPasswordException("пароль больше 20 символов");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("пароль1 не равен пароль2");
        }


        return true;

    }


}